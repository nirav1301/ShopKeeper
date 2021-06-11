package com.example.shopkeeper.orderhistory;

import com.example.shopkeeper.authentication.login.response.Setting;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderHistoryResponse {

    @SerializedName("settings")
    @Expose
    private Setting setting;
    @SerializedName("data")
    @Expose
    private List<OrderHistoryModel> data = null;
    @SerializedName("totalCount")
    @Expose
    private int totalCount;

    public Setting getSetting() {
        return setting;
    }

    public void setSettings(Setting setting) {
        this.setting = setting;
    }

    public List<OrderHistoryModel> getData() {
        return data;
    }

    public void setData(List<OrderHistoryModel> data) {
        this.data = data;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

}
