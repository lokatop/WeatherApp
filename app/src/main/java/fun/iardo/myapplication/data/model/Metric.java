package fun.iardo.myapplication.data.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(foreignKeys = @ForeignKey(
        entity = Temperature.class,
        parentColumns = "id",
        childColumns = "temperature_id"
))
public class Metric  implements Serializable {
    @ColumnInfo(name = "temperature_id")
    private int mTemperatureId;

    @SerializedName("Value")
    @Expose
    private double value;
    @SerializedName("Unit")
    @Expose
    private String unit;
    @SerializedName("UnitType")
    @Expose
    private int unitType;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getUnitType() {
        return unitType;
    }

    public void setUnitType(int unitType) {
        this.unitType = unitType;
    }

    public int getmTemperatureId() {
        return mTemperatureId;
    }

    public void setmTemperatureId(int mTemperatureId) {
        this.mTemperatureId = mTemperatureId;
    }
}