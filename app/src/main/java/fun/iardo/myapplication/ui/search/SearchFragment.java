package fun.iardo.myapplication.ui.search;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import fun.iardo.myapplication.R;
import fun.iardo.myapplication.common.PresenterFragment;
import fun.iardo.myapplication.common.Refreshable;
import fun.iardo.myapplication.data.model.CurrentCondition;
import fun.iardo.myapplication.data.model.SearchLocationModel;

public class SearchFragment extends PresenterFragment<SearchPresenter>
        implements Refreshable,SearchView {
    private View mErrorView;
    private SearchPresenter mPresenter;
    private Button mButtonGetWeather;
    private TableLayout tl_data_about_weather;
    private SearchAutoCompleteAdapter mAutoAdapter;
    private SearchLocationModel mSearchLocationModel;

    private TextView tv_country,tv_city,tv_tempNow;
    private AutoCompleteTextView tv_autoCompleteSearchText;

    public static final String TEST_CITY_KEY = "335315";

    public static SearchFragment newInstance(){return new SearchFragment();}

    @Override
    protected SearchPresenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main_search,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mButtonGetWeather = view.findViewById(R.id.btn_get_weather);
        tl_data_about_weather = view.findViewById(R.id.tl_data_about_weather);
        tv_city = view.findViewById(R.id.tv_city);
        tv_country = view.findViewById(R.id.tv_country);
        tv_tempNow = view.findViewById(R.id.tv_tempNow);
        tv_autoCompleteSearchText = view.findViewById(R.id.tv_autoCompleteSearchText);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null){
            getActivity().setTitle("Weather");
        }
        mPresenter = new SearchPresenter(this);
        mButtonGetWeather.setOnClickListener(v -> mPresenter.GetWeather(mSearchLocationModel));
        tv_autoCompleteSearchText.setThreshold(2);
        mAutoAdapter = new SearchAutoCompleteAdapter(getContext());
        tv_autoCompleteSearchText.setAdapter(mAutoAdapter);

        tv_autoCompleteSearchText.setOnItemClickListener(
                (parent, view, position, id) -> {
                    mSearchLocationModel = (SearchLocationModel) parent.getAdapter().getItem(position);
                    mPresenter.GetWeather(mSearchLocationModel);
                    tv_autoCompleteSearchText.setText(mSearchLocationModel.getLocalizedName());
                });
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onRefreshData() {
        mPresenter.GetWeather(mSearchLocationModel);
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

    @Override
    public void showData() {
        //tl_data_about_weather.setVisibility(View.VISIBLE);
    }

    @Override
    public void bindData(@NonNull List<CurrentCondition> condition,@NonNull SearchLocationModel model) {
        tv_city.setText(model.getLocalizedName());
        tv_country.setText(model.getCountry().getLocalizedName());
        tv_tempNow.setText(condition.get(0).getTemperature().getMetric().getValue() +" "+ condition.get(0).getTemperature().getMetric().getUnit());
    }
}
