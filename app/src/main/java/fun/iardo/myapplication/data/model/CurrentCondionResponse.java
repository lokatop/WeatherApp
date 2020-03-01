package fun.iardo.myapplication.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class CurrentCondionResponse implements Serializable {

    @SerializedName("currentCondition")
    private List<CurrentCondition> mCurrents;

    public List<CurrentCondition> getCurrents() {
        return mCurrents;
    }

    public void setCurrents(List<CurrentCondition> mCurrents) {
        this.mCurrents = mCurrents;
    }
}
