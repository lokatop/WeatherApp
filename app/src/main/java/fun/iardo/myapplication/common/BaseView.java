package fun.iardo.myapplication.common;

import moxy.MvpView;
import moxy.viewstate.strategy.OneExecutionStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;
import moxy.viewstate.strategy.alias.Skip;

@StateStrategyType(value = OneExecutionStateStrategy.class)
public interface BaseView extends MvpView {
    void showRefresh();
    void hideRefresh();
    void showError();

}
