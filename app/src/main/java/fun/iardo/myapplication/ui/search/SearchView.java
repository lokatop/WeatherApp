package fun.iardo.myapplication.ui.search;


import androidx.annotation.NonNull;


import fun.iardo.myapplication.common.BaseView;
import fun.iardo.myapplication.data.model.CurrentCondition;
import fun.iardo.myapplication.data.model.SearchLocationModel;
import moxy.viewstate.strategy.alias.AddToEndSingle;
import moxy.viewstate.strategy.alias.Skip;

public interface SearchView extends BaseView {
    @Skip
    void showData();
    @AddToEndSingle
    void bindData(@NonNull CurrentCondition condition, @NonNull SearchLocationModel model);
}
