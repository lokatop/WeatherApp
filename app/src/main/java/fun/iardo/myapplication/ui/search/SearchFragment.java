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
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Objects;

import fun.iardo.myapplication.R;
import fun.iardo.myapplication.common.PresenterFragment;
import fun.iardo.myapplication.common.Refreshable;
import fun.iardo.myapplication.data.model.CurrentCondition;
import fun.iardo.myapplication.data.model.SearchLocationModel;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

import static fun.iardo.myapplication.ui.search.SearchPresenter.API_URL_IMAGE;

public class SearchFragment extends PresenterFragment
        implements Refreshable,SearchView {
    private View mErrorView;

    @InjectPresenter
    SearchPresenter mPresenter;
    @ProvidePresenter
    SearchPresenter providePresenter(){
        return new SearchPresenter(this);
    }

    private Button mButtonGetWeather;
    private TableLayout tl_data_about_weather;
    private SearchAutoCompleteAdapter mAutoAdapter;
    private SearchLocationModel mSearchLocationModel;

    private TextView tv_country,tv_city,tv_tempNow;
    private DelayAutoCompleteTextView tv_autoCompleteSearchText;
    private ImageView iv_weather_icon;
    private ProgressBar progressBar;

    private String mWheatherText="", mTemperature="", mMetric="";

    public static final String TEST_CITY_KEY = "335315";

    public SearchFragment() {
    }

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
        iv_weather_icon = view.findViewById(R.id.iv_weather_icon);
        progressBar = view.findViewById(R.id.progress_bar);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null){
            getActivity().setTitle("Weather");
        }
        //Кнопка будет реализована в будщем для вывода большей информации
        //mButtonGetWeather.setOnClickListener(v -> mPresenter.GetWeather(mSearchLocationModel));
        tv_autoCompleteSearchText.setThreshold(2);
        mAutoAdapter = new SearchAutoCompleteAdapter(getContext());
        tv_autoCompleteSearchText.setAdapter(mAutoAdapter);
        tv_autoCompleteSearchText.setLoadingIndicator(progressBar);

        tv_autoCompleteSearchText.setOnItemClickListener(
                (parent, view, position, id) -> {
                    mSearchLocationModel = (SearchLocationModel) parent.getAdapter().getItem(position);
                    mPresenter.GetWeatherData(mSearchLocationModel);
                    tv_autoCompleteSearchText.setText(mSearchLocationModel.getLocalizedName());
                });
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onRefreshData() {
        mPresenter.GetWeatherData(mSearchLocationModel);
    }

    @Override
    public void showRefresh() {

    }

    @Override
    public void hideRefresh() {

    }

    @Override
    public void showError() {
        tl_data_about_weather.setVisibility(View.GONE);
    }

    @Override
    public void showData() {
        tl_data_about_weather.setVisibility(View.VISIBLE);
    }

    @Override
    public void bindData(@NonNull CurrentCondition condition,@NonNull SearchLocationModel model) {
        tl_data_about_weather.setVisibility(View.VISIBLE);
        tv_city.setText(model.getLocalizedName());
        tv_country.setText(model.getCountry().getLocalizedName());

        mWheatherText = condition.getWeatherText();
        mMetric = condition.getTemperature().getMetric().getUnit();
        mTemperature = String.valueOf(condition.getTemperature().getMetric().getValue());
        String concatTemp = mTemperature+mMetric+", "+mWheatherText;
        tv_tempNow.setText(concatTemp);

        Glide.with(Objects.requireNonNull(this.getActivity()))
                .load(API_URL_IMAGE +
                        String.format("%02d", condition.getWeatherIcon()) +
                        "-s" + ".png")
                .into(iv_weather_icon);
    }

    @Override
    public void GetWeather() {
    }
}
