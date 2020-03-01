package fun.iardo.myapplication.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class SearchLocationModel  implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int mId;

    @ColumnInfo(name = "Version")
    @SerializedName("Version")
    private int version;

    @ColumnInfo(name = "Key")
    @SerializedName("Key")
    private String key;

    @ColumnInfo(name = "Type")
    @SerializedName("Type")
    private String type;

    @ColumnInfo(name = "Rank")
    @SerializedName("Rank")
    private int Rank;

    @ColumnInfo(name = "LocalizedName")
    @SerializedName("LocalizedName")
    private String LocalizedName;

    @ColumnInfo(name = "Country")
    @SerializedName("Country")
    @Ignore
    private Country country;

    @ColumnInfo(name = "AdministrativeArea")
    @SerializedName("AdministrativeArea")
    @Ignore
    private AdministrativeArea administrativeArea;

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

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
}
