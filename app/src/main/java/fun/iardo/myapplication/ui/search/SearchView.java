package fun.iardo.myapplication.ui.search;


import androidx.annotation.NonNull;

import java.util.List;

import fun.iardo.myapplication.common.BaseView;
import fun.iardo.myapplication.data.model.CurrentCondition;

public interface SearchView extends BaseView {
    void showData();
    void bindData(@NonNull List<CurrentCondition> condition);
}
