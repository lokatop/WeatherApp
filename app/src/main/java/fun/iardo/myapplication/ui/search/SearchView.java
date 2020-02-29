package fun.iardo.myapplication.ui.search;


import android.widget.Filter;

import androidx.annotation.NonNull;


import fun.iardo.myapplication.common.BaseView;
import fun.iardo.myapplication.data.model.CurrentCondition;
import fun.iardo.myapplication.data.model.SearchLocationModel;
import moxy.viewstate.strategy.StateStrategyType;
import moxy.viewstate.strategy.alias.AddToEnd;
import moxy.viewstate.strategy.alias.OneExecution;
import moxy.viewstate.strategy.alias.SingleState;
import moxy.viewstate.strategy.alias.Skip;

public interface SearchView extends BaseView {
    @OneExecution
    void showData();
    @SingleState
    void bindData(@NonNull CurrentCondition condition, @NonNull SearchLocationModel model);
    @OneExecution
    void setAdapterAutoText();
}
