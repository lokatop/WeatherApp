package fun.iardo.myapplication.data.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(foreignKeys = @ForeignKey(
        entity = CurrentCondition.class,
        parentColumns = "id",
        childColumns = "condition_id"
),indices = @Index("condition_id"))
public class Temperature implements Serializable{

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @Expose
    private int mId;

    @ColumnInfo(name = "condition_id")
    private int mConditionId;

    @SerializedName("Metric")
    @Ignore
    private Metric mMetric;


    @SerializedName("Imperial")
    @Ignore
    private Imperial imperial;

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public Metric getMetric() {
        return mMetric;
    }

    public void setMetric(Metric metric) {
        this.mMetric = metric;
    }

    public Imperial getImperial() {
        return imperial;
    }

    public void setImperial(Imperial imperial) {
        this.imperial = imperial;
    }

    public int getConditionId() {
        return mConditionId;
    }

    public void setConditionId(int mConditionId) {
        this.mConditionId = mConditionId;
    }
}