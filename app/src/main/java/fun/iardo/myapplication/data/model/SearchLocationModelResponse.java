package fun.iardo.myapplication.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SearchLocationModelResponse implements Serializable {

    @SerializedName("searchLocationModel")
    private List<SearchLocationModel> mLocationModels;

    public List<SearchLocationModel> getLocationModels() {
        return mLocationModels;
    }

    public void setLocationModels(List<SearchLocationModel> mLocationModels) {
        this.mLocationModels = mLocationModels;
    }
}
