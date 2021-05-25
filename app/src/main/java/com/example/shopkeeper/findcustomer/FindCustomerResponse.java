package com.example.shopkeeper.findcustomer;

import com.example.shopkeeper.authentication.Login.Response.Setting;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FindCustomerResponse {

    @SerializedName("settings")
    @Expose
    private Setting setting;
    @SerializedName("data")
    @Expose
    private List<FindCustomerModel> data;
    @SerializedName("totalCount")
    @Expose
    private int totalCount;

    public Setting getSetting() {
        return setting;
    }

    public void setSettings(Setting setting) {
        this.setting = setting;
    }

    public List<FindCustomerModel> getData() {
        return data;
    }

    public void setData(List<FindCustomerModel> data) {
        this.data = data;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

}
