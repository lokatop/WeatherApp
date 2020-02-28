package fun.iardo.myapplication.ui.search;

import fun.iardo.myapplication.common.BasePresenter;
import fun.iardo.myapplication.utils.ApiService;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SearchPresenter extends BasePresenter {

    private SearchView mView;

    public SearchPresenter(SearchView view){
        mView = view;
    }

    public void GetWeather(String cityKey){
        mCompositeDisposable.add(ApiService
                .getApiService()
                .getData(cityKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> mView.showRefresh())
                .doFinally(mView::hideRefresh)
                .subscribe(
                        response -> {
                            mView.showData();
                            mView.bindData(response);
                        },
                        throwable -> mView.showError()
                )

        );
    }

}
