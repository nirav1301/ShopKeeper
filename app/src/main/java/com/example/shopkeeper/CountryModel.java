package com.example.shopkeeper;

public class CountryModel {
    String name;
    String isocode;

    public CountryModel(String name, String isocode) {
        this.name = name;
        this.isocode = isocode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsocode() {
        return isocode;
    }

    public void setIsocode(String isocode) {
        this.isocode = isocode;
    }
}
