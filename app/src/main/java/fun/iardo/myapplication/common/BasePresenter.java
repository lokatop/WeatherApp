package fun.iardo.myapplication.common;


import io.reactivex.disposables.CompositeDisposable;
import moxy.MvpPresenter;

public abstract class BasePresenter<View extends BaseView> extends MvpPresenter<View> {

    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public void disposeAll() {
        mCompositeDisposable.clear();
    }
}
