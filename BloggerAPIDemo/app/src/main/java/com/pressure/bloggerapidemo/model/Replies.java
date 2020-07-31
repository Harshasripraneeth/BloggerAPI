
package com.pressure.bloggerapidemo.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Replies implements Parcelable
{

    @SerializedName("totalItems")
    @Expose
    private String totalItems;
    @SerializedName("selfLink")
    @Expose
    private String selfLink;
    public final static Parcelable.Creator<Replies> CREATOR = new Creator<Replies>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Replies createFromParcel(Parcel in) {
            return new Replies(in);
        }

        public Replies[] newArray(int size) {
            return (new Replies[size]);
        }

    }
    ;

    protected Replies(Parcel in) {
        this.totalItems = ((String) in.readValue((String.class.getClassLoader())));
        this.selfLink = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Replies() {
    }

    public String getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(String totalItems) {
        this.totalItems = totalItems;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(totalItems);
        dest.writeValue(selfLink);
    }

    public int describeContents() {
        return  0;
    }

}
