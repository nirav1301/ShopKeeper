package com.example.shopkeeper.sendinvoice;

import com.example.shopkeeper.sendorder.Setting;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SendInvoiceResponse {
    @SerializedName("settings")
    @Expose
    private Setting setting;
    @SerializedName("data")
    @Expose
    private List<SendInvoiceModel> data = null;
    @SerializedName("totalCount")
    @Expose
    private int totalCount;

    public Setting getSettings() {
        return setting;
    }

    public void setSettings(Setting setting) {
        this.setting = setting;
    }

    public List<SendInvoiceModel> getData() {
        return data;
    }

    public void setData(List<SendInvoiceModel> data) {
        this.data = data;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }


}
