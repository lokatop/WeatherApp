package fun.iardo.myapplication.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


@Entity(foreignKeys = @ForeignKey(
        entity = SearchLocationModel.class,
        parentColumns = "id",
        childColumns = "search_location_id"
))
public class Country  implements Serializable {

    @SerializedName("ID")
    @Expose
    private String id;

    @ColumnInfo(name = "search_location_id")
    private int mSearchLocationId;

    @SerializedName("LocalizedName")
    @Expose
    private String localizedName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getmSearchLocationId() {
        return mSearchLocationId;
    }

    public void setmSearchLocationId(int mSearchLocationId) {
        this.mSearchLocationId = mSearchLocationId;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }
}