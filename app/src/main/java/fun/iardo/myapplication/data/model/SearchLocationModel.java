package fun.iardo.myapplication.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchLocationModel {

    @SerializedName("Version")
    @Expose
    private int version;

    @SerializedName("Key")
    @Expose
    private String key;

    @SerializedName("Type")
    @Expose
    private String type;

    @SerializedName("Rank")
    @Expose
    private int Rank;

    @SerializedName("LocalizedName")
    @Expose
    private String LocalizedName;

    @SerializedName("Country")
    @Expose
    private Country country;

    @SerializedName("AdministrativeArea")
    @Expose
    private AdministrativeArea administrativeArea;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRank() {
        return Rank;
    }

    public void setRank(int rank) {
        Rank = rank;
    }

    public String getLocalizedName() {
        return LocalizedName;
    }

    public void setLocalizedName(String localizedName) {
        LocalizedName = localizedName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public AdministrativeArea getAdministrativeArea() {
        return administrativeArea;
    }

    public void setAdministrativeArea(AdministrativeArea administrativeArea) {
        this.administrativeArea = administrativeArea;
    }

    private class AdministrativeArea {

        @SerializedName("ID")
        @Expose
        private String id;

        @SerializedName("LocalizedName")
        @Expose
        private String localizedName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLocalizedName() {
            return localizedName;
        }

        public void setLocalizedName(String localizedName) {
            this.localizedName = localizedName;
        }



    }

    private class Country {

        @SerializedName("ID")
        @Expose
        private String id;

        @SerializedName("LocalizedName")
        @Expose
        private String localizedName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLocalizedName() {
            return localizedName;
        }

        public void setLocalizedName(String localizedName) {
            this.localizedName = localizedName;
        }
    }

}
