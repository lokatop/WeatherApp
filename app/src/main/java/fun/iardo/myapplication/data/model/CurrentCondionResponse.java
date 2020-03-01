package fun.iardo.myapplication.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class CurrentCondionResponse implements Serializable {

    @SerializedName("currentCondition")
    private List<CurrentCondition> mConditions;

    public List<CurrentCondition> getConditions() {
        return mConditions;
    }

    public void setConditions(List<CurrentCondition> conditions) {
        mConditions = conditions;
    }
}
