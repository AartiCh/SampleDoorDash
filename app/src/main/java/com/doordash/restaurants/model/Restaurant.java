package com.doordash.restaurants.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Restaurant implements Parcelable {

    @SerializedName("id")
    String id;
    @SerializedName("name")
    String name;
    @SerializedName("description")
    String description;
    @SerializedName("cover_img_url")
    String cover_img_url;
    @SerializedName("status")
    String status;
    @SerializedName("delivery_fee")
    long delivery_fee;

    public Restaurant() {

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCoverImgUrl(String cover_img_url) {
        this.cover_img_url = cover_img_url;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDeliveryFee(long delivery_fee) {
        this.delivery_fee = delivery_fee;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCoverImageUrl() {
        return cover_img_url;
    }

    public String getStatus() {
        return status;
    }

    public long getDeliveryFee() {
        return delivery_fee;
    }

    protected Restaurant(Parcel in) {
        id = in.readString();
        name = in.readString();
        description = in.readString();
        cover_img_url = in.readString();
        status = in.readString();
        delivery_fee = in.readLong();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(cover_img_url);
        dest.writeString(status);
        dest.writeLong(delivery_fee);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Restaurant> CREATOR = new Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Restaurant other = (Restaurant) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;

        return true;
    }
}
