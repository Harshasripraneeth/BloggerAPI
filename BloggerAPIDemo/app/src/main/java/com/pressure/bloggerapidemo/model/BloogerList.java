
package com.pressure.bloggerapidemo.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BloogerList implements Parcelable
{

    @SerializedName("nextPageToken")
    @Expose
    private String nextPageToken;
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("etag")
    @Expose
    private String etag;
    public final static Parcelable.Creator<BloogerList> CREATOR = new Creator<BloogerList>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BloogerList createFromParcel(Parcel in) {
            return new BloogerList(in);
        }

        public BloogerList[] newArray(int size) {
            return (new BloogerList[size]);
        }

    }
    ;

    protected BloogerList(Parcel in) {
        this.kind = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.items, (com.pressure.bloggerapidemo.model.Item.class.getClassLoader()));
        this.etag = ((String) in.readValue((String.class.getClassLoader())));
        this.nextPageToken = ((String) in.readValue((String.class.getClassLoader())));
    }

    public BloogerList() {
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }
    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(kind);
        dest.writeList(items);
        dest.writeValue(etag);
        dest.writeValue(nextPageToken);
    }

    public int describeContents() {
        return  0;
    }

}
