
package com.pressure.bloggerapidemo.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Blog implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    public final static Parcelable.Creator<Blog> CREATOR = new Creator<Blog>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Blog createFromParcel(Parcel in) {
            return new Blog(in);
        }

        public Blog[] newArray(int size) {
            return (new Blog[size]);
        }

    }
    ;

    protected Blog(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Blog() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
    }

    public int describeContents() {
        return  0;
    }

}
