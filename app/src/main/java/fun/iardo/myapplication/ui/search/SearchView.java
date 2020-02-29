package fun.iardo.myapplication.ui.search;


import androidx.annotation.NonNull;


import fun.iardo.myapplication.common.BaseView;
import fun.iardo.myapplication.data.model.CurrentCondition;
import fun.iardo.myapplication.data.model.SearchLocationModel;

public interface SearchView extends BaseView {
    void showData();
    void bindData(@NonNull CurrentCondition condition, @NonNull SearchLocationModel model);
}
