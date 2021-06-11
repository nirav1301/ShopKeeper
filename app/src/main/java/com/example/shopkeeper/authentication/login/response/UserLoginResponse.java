package com.example.shopkeeper.authentication.login.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UserLoginResponse {

    @SerializedName("settings")
    private Setting setting;

    @SerializedName("data")
    private ArrayList<User> data;

    public ArrayList<User> getData() {
        return data;
    }

    public void setData(ArrayList<User> data) {
        this.data = data;
    }

    public Setting getSetting() {
        return setting;
    }

    public void setSetting(Setting setting) {
        this.setting = setting;
    }
}
