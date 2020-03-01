package fun.iardo.myapplication.ui.search;

import fun.iardo.myapplication.BuildConfig;
import fun.iardo.myapplication.common.BasePresenter;
import fun.iardo.myapplication.data.Storage;
import fun.iardo.myapplication.data.model.CurrentCondition;
import fun.iardo.myapplication.data.model.SearchLocationModel;
import fun.iardo.myapplication.utils.ApiService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import moxy.InjectViewState;

@InjectViewState
public class SearchPresenter extends BasePresenter<SearchView> {

    public static final String API_URL = "https://dataservice.accuweather.com/";
    public static final String API_URL_IMAGE = "https://apidev.accuweather.com/developers/Media/Default/WeatherIcons/";
    public static final String LANGUAGE = "Ru-ru";

    private Storage mStorage;

    public SearchPresenter(Storage mStorage) {
        this.mStorage = mStorage;
    }

    public void GetWeatherData(SearchLocationModel searchLocationModel){
            int cityKey = Integer.valueOf(searchLocationModel.getKey());

            mCompositeDisposable.add(ApiService
                    .getApiService(API_URL)
                    .getData(searchLocationModel.getKey(), BuildConfig.API_KEY, LANGUAGE)
                    .doOnSuccess(response->mStorage.insertConditions(response,cityKey))
                    .onErrorReturn(throwable -> ApiService.NETWORK_EXCEPTIONS.contains(throwable.getClass())?mStorage.getConditions(cityKey):null)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(disposable -> getViewState().showRefresh())
                    .doFinally(getViewState()::hideRefresh)
                    .subscribe(
                            response -> {
                                getViewState().showData();
                                getViewState().bindData(response.get(0),searchLocationModel);
                            },
                            throwable -> getViewState().showError()
                    )
            );
    }



    public void setAdapterAutoText(){
        getViewState().setAdapterAutoText();
    }
}
