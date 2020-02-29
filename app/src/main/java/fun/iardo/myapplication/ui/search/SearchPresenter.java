package fun.iardo.myapplication.ui.search;

import fun.iardo.myapplication.BuildConfig;
import fun.iardo.myapplication.common.BasePresenter;
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


    public void GetWeatherData(SearchLocationModel searchLocationModel){
            mCompositeDisposable.add(ApiService
                    .getApiService(API_URL)
                    .getData(searchLocationModel.getKey(), BuildConfig.API_KEY, LANGUAGE)
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
