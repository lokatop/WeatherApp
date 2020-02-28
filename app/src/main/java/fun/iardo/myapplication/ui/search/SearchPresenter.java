package fun.iardo.myapplication.ui.search;

import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

import fun.iardo.myapplication.BuildConfig;
import fun.iardo.myapplication.common.BasePresenter;
import fun.iardo.myapplication.data.model.SearchLocationModel;
import fun.iardo.myapplication.utils.ApiService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SearchPresenter extends BasePresenter {

    private SearchView mView;

    public SearchPresenter(SearchView view){
        mView = view;
    }

    public static final String API_URL = "http://dataservice.accuweather.com/";
    //public static final String API_URL_CITY = "http://api.accuweather.com/";

    public void GetWeather(SearchLocationModel searchLocationModel){
        if (searchLocationModel != null){
            mCompositeDisposable.add(ApiService
                    .getApiService(API_URL)
                    .getData(searchLocationModel.getKey(), BuildConfig.API_KEY)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(disposable -> mView.showRefresh())
                    .doFinally(mView::hideRefresh)
                    .subscribe(
                            response -> {
                                mView.showData();
                                mView.bindData(response,searchLocationModel);
                            },
                            throwable -> mView.showError()
                    )

            );
        }

    }

}
