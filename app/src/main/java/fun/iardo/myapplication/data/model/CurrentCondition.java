package fun.iardo.myapplication.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class CurrentCondition {

    @PrimaryKey()
    @ColumnInfo(name = "id")
    private int mId;

    @ColumnInfo(name = "LocalObservationDateTime")
    @SerializedName("LocalObservationDateTime")
    @Expose
    private String localObservationDateTime;

    @ColumnInfo(name = "EpochTime")
    @SerializedName("EpochTime")
    @Expose
    private int epochTime;
    //Однако по идее можно и long ставить, потому что ограничение до 2 147 483 648, а там уже 1.5млрд

    @ColumnInfo(name = "WeatherText")
    @SerializedName("WeatherText")
    private String weatherText;

    @ColumnInfo(name = "WeatherIcon")
    @SerializedName("WeatherIcon")
    private int weatherIcon;

    @ColumnInfo(name = "HasPrecipitation")
    @SerializedName("HasPrecipitation")
    private boolean hasPrecipitation;


    @ColumnInfo(name = "PrecipitationType")
    @SerializedName("PrecipitationType")
    private String precipitationType;

    @ColumnInfo(name = "IsDayTime")
    @SerializedName("IsDayTime")
    private boolean isDayTime;


    @SerializedName("Temperature")
    @Ignore
    private Temperature temperature;

    @ColumnInfo(name = "MobileLink")
    @SerializedName("MobileLink")
    private String mobileLink;

    @ColumnInfo(name = "Link")
    @SerializedName("Link")
    private String link;

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getLocalObservationDateTime() {
        return localObservationDateTime;
    }

    public void setLocalObservationDateTime(String localObservationDateTime) {
        this.localObservationDateTime = localObservationDateTime;
    }

    public int getEpochTime() {
        return epochTime;
    }

    public void setEpochTime(int epochTime) {
        this.epochTime = epochTime;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    public int getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public boolean isHasPrecipitation() {
        return hasPrecipitation;
    }

    public void setHasPrecipitation(boolean hasPrecipitation) {
        this.hasPrecipitation = hasPrecipitation;
    }

    public String getPrecipitationType() {
        return precipitationType;
    }

    public void setPrecipitationType(String precipitationType) {
        this.precipitationType = precipitationType;
    }

    public boolean isDayTime() {
        return isDayTime;
    }

    public void setDayTime(boolean dayTime) {
        isDayTime = dayTime;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public String getMobileLink() {
        return mobileLink;
    }

    public void setMobileLink(String mobileLink) {
        this.mobileLink = mobileLink;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


}
