package fun.iardo.myapplication.data.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(foreignKeys = @ForeignKey(
        entity = CurrentCondition.class,
        parentColumns = "id",
        childColumns = "current_condition_id"
))
public class Temperature implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int mId;

    @ColumnInfo(name = "current_condition_id")
    private int mCurrentConditionId;

    @SerializedName("Metric")
    @Ignore
    private Metric metric;


    @SerializedName("Imperial")
    @Ignore
    private Imperial imperial;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public Metric getMetric() {
        return metric;
    }

    public void setMetric(Metric metric) {
        this.metric = metric;
    }

    public Imperial getImperial() {
        return imperial;
    }

    public void setImperial(Imperial imperial) {
        this.imperial = imperial;
    }

    public int getmCurrentConditionId() {
        return mCurrentConditionId;
    }

    public void setmCurrentConditionId(int mCurrentConditionId) {
        this.mCurrentConditionId = mCurrentConditionId;
    }
}