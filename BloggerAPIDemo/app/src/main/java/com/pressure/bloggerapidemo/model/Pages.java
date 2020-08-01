package com.pressure.bloggerapidemo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pages implements Parcelable
{

    @SerializedName("totalItems")
    @Expose
    private Integer totalItems;
    @SerializedName("selfLink")
    @Expose
    private String selfLink;
    public final static Parcelable.Creator<Pages> CREATOR = new Creator<Pages>() {



        public Pages createFromParcel(Parcel in) {
            return new Pages(in);
        }

        public Pages[] newArray(int size) {
            return (new Pages[size]);
        }

    }
            ;

    protected Pages(Parcel in) {
        this.totalItems = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.selfLink = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Pages() {
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
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

