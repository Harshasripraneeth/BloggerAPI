package com.pressure.bloggerapidemo.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Locale implements Parcelable
{

    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("variant")
    @Expose
    private String variant;
    public final static Parcelable.Creator<Locale> CREATOR = new Creator<Locale>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Locale createFromParcel(Parcel in) {
            return new Locale(in);
        }

        public Locale[] newArray(int size) {
            return (new Locale[size]);
        }

    }
            ;

    protected Locale(Parcel in) {
        this.language = ((String) in.readValue((String.class.getClassLoader())));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.variant = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Locale() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(language);
        dest.writeValue(country);
        dest.writeValue(variant);
    }

    public int describeContents() {
        return  0;
    }

}
