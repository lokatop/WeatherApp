package fun.iardo.myapplication.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class CurrentCondition {
    @SerializedName("LocalObservationDateTime")
    @Expose
    private String localObservationDateTime;

    @SerializedName("EpochTime")
    @Expose
    private int epochTime;
    //Однако по идее можно и long ставить, потому что ограничение до 2 147 483 648, а там уже 1.5млрд

    @SerializedName("WeatherText")
    @Expose
    private String weatherText;

    @SerializedName("WeatherIcon")
    @Expose
    private int weatherIcon;

    @SerializedName("HasPrecipitation")
    @Expose
    private boolean hasPrecipitation;


    @SerializedName("PrecipitationType")
    @Expose
    private String precipitationType;

    @SerializedName("IsDayTime")
    @Expose
    private boolean isDayTime;


    @SerializedName("Temperature")
    @Expose
    private Temperature temperature;

    @SerializedName("MobileLink")
    @Expose
    private String mobileLink;

    @SerializedName("Link")
    @Expose
    private String link;

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

    public class Temperature {

        @SerializedName("Metric")
        @Expose
        private Metric metric;

        @SerializedName("Imperial")
        @Expose
        private Imperial imperial;

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

        public class Imperial {
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
        }
        public class Metric {
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
        }
    }
}
