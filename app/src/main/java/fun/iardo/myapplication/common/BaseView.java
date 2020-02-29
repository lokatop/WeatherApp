package fun.iardo.myapplication.common;

import moxy.MvpView;
import moxy.viewstate.strategy.alias.Skip;

public interface BaseView extends MvpView {
    @Skip
    void showRefresh();
    @Skip
    void hideRefresh();
    @Skip
    void showError();

}
