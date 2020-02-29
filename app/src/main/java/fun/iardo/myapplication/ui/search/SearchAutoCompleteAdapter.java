package fun.iardo.myapplication.ui.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fun.iardo.myapplication.BuildConfig;
import fun.iardo.myapplication.R;
import fun.iardo.myapplication.data.model.SearchLocationModel;
import fun.iardo.myapplication.utils.ApiService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static fun.iardo.myapplication.ui.search.SearchPresenter.API_URL;

public class SearchAutoCompleteAdapter extends BaseAdapter implements Filterable {
    private Context mContext;

    private List<SearchLocationModel> mResultList = new ArrayList<>();

    public SearchAutoCompleteAdapter(Context context){this.mContext = context;}

    @Override
    public int getCount() {
        return mResultList.size();
    }

    @Override
    public Object getItem(int position) {
        return mResultList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (inflater != null){
                view = inflater.inflate(R.layout.suggestion,parent,false);
            }
        }
        if (view != null){
            SearchLocationModel locationModel = mResultList.get(position);
            //String concatModel = locationModel.getLocalizedName()+" - "+locationModel.getCountry().getLocalizedName();
            ((TextView)view.findViewById(R.id.tv_city_suggestion)).setText(locationModel.getLocalizedName());
            ((TextView)view.findViewById(R.id.tv_country_suggestion)).setText(locationModel.getCountry().getLocalizedName());
        }

        return view;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();
                if (charSequence != null)
                {
                    CompositeDisposable mCompositeDisposable = new CompositeDisposable();
                    mCompositeDisposable.add(ApiService
                            .getApiService(API_URL)
                            .getCities( BuildConfig.API_KEY,charSequence.toString())
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(
                                    response ->{
                                            mResultList.clear();
                                            mResultList.addAll(response);
                                            filterResults.values = mResultList;
                                            filterResults.count = mResultList.size();
                                            publishResults(charSequence, filterResults);
                                    },throwable -> {
                                        mResultList.clear();
                                        publishResults(charSequence,filterResults);
                                    }
                            )

                    );
                }
                filterResults.values = mResultList;
                filterResults.count = mResultList.size();
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && results.count > 0) {
                    notifyDataSetChanged();
                } else
                    notifyDataSetInvalidated();
            }
        };

        return filter;
    }
}
