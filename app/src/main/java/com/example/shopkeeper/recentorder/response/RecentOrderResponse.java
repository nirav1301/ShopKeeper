package com.example.shopkeeper.recentorder.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class RecentOrderResponse {
    @SerializedName("settings")
    @Expose
    private Setting setting;
    @SerializedName("data")
    @Expose
    private List<RecentOrderModel> data = null;
    @SerializedName("totalCount")
    @Expose
    private int totalCount;

    public Setting getSetting() {
        return setting;
    }

    public void setSetting(Setting setting) {
        this.setting = setting;
    }

    public List<RecentOrderModel> getData() {
        return data;
    }

    public void setData(List<RecentOrderModel> data) {
        this.data = data;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

}
