package com.example.shopkeeper.createorder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductColorImageAPI {

    @SerializedName("ColorSmallImageUrl")
    @Expose
    private String colorSmallImageUrl;
    @SerializedName("ColorMediumImageUrl")
    @Expose
    private String colorMediumImageUrl;

    public String getColorSmallImageUrl() {
        return colorSmallImageUrl;
    }

    public void setColorSmallImageUrl(String colorSmallImageUrl) {
        this.colorSmallImageUrl = colorSmallImageUrl;
    }

    public String getColorMediumImageUrl() {
        return colorMediumImageUrl;
    }

    public void setColorMediumImageUrl(String colorMediumImageUrl) {
        this.colorMediumImageUrl = colorMediumImageUrl;
    }

}