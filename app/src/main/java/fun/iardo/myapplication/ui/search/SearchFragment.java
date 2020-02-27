package fun.iardo.myapplication.ui.search;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;

import fun.iardo.myapplication.R;
import fun.iardo.myapplication.common.PresenterFragment;
import fun.iardo.myapplication.common.RefreshOwner;
import fun.iardo.myapplication.common.Refreshable;

public class SearchFragment extends PresenterFragment<SearchPresenter>
        implements Refreshable,SearchView {
    private RefreshOwner mRefreshOwner;
    private View mErrorView;
    private SearchPresenter mPresenter;


    public static SearchFragment newInstance(){return new SearchFragment();}

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof RefreshOwner){
            mRefreshOwner = ((RefreshOwner)context);
        }
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main_search,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null){
            getActivity().setTitle("Search City");
        }
        mPresenter = new SearchPresenter(this);
        //mMainAdapter = new MainAdapter(this);
        //mRecyclerView.setLayoutManager( new GridLayoutManager(getActivity(),2));
        //mRecyclerView.setAdapter(mMainAdapter);

        onRefreshData();
    }

    @Override
    protected SearchPresenter getPresenter() {
        return mPresenter;
    }



    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onRefreshData() {

    }

    @Override
    public void showRefresh() {

    }

    @Override
    public void hideRefresh() {

    }

    @Override
    public void showError() {

    }
}
