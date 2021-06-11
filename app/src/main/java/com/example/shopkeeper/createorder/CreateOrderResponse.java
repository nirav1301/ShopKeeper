package com.example.shopkeeper.createorder;

import com.example.shopkeeper.authentication.login.response.Setting;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreateOrderResponse {

    @SerializedName("settings")
    @Expose
    private Setting setting;
    @SerializedName("data")
    @Expose
    private List<CreateOrderModel> data;
    @SerializedName("totalCount")
    @Expose
    private int totalCount;

    public Setting getSetting() {
        return setting;
    }

    public void setSetting(Setting setting) {
        this.setting = setting;
    }

    public List<CreateOrderModel> getData() {
        return data;
    }

    public void setData(List<CreateOrderModel> data) {
        this.data = data;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

}
