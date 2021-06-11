package com.example.shopkeeper.forgotpassword;

import com.example.shopkeeper.authentication.login.response.Setting;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForgotPasswordResponse {
    @SerializedName("settings")
    @Expose
    private Setting setting;
    @SerializedName("data")
    @Expose
    private List<Object> data = null;
    @SerializedName("totalCount")
    @Expose
    private int totalCount;

    public Setting getSetting() {
        return setting;
    }

    public void setSetting(Setting setting) {
        this.setting = setting;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

}
