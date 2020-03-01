package fun.iardo.myapplication.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


@Entity(foreignKeys = @ForeignKey(
        entity = SearchLocationModel.class,
        parentColumns = "id",
        childColumns = "search_location_id"
),indices = @Index("search_location_id"))
public class Country  implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id2")
    @Expose
    private int mId2;

    @SerializedName("ID")
    @Expose
    private String id;

    @ColumnInfo(name = "search_location_id")
    private int mSearchLocationId;

    @SerializedName("LocalizedName")
    @Expose
    private String localizedName;

    public int getId2() {
        return mId2;
    }

    public void setId2(int mId2) {
        this.mId2 = mId2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSearchLocationId() {
        return mSearchLocationId;
    }

    public void setSearchLocationId(int mSearchLocationId) {
        this.mSearchLocationId = mSearchLocationId;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }
}