package com.example.shopkeeper.createorder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class CreateOrderModel {

    @SerializedName("ProductID")
    @Expose
    private int productID;
    @SerializedName("CompanyID")
    @Expose
    private int companyID;
    @SerializedName("StyleNo")
    @Expose
    private String styleNo;
    @SerializedName("ProductName")
    @Expose
    private String productName;
    @SerializedName("UnitPrice")
    @Expose
    private int unitPrice;
    @SerializedName("ColorName")
    @Expose
    private String colorName;
    @SerializedName("ColorIDs")
    @Expose
    private String colorIDs;
    @SerializedName("Color")
    @Expose
    private String color;
    @SerializedName("ColorID")
    @Expose
    private int colorID;
    @SerializedName("Cat1Name")
    @Expose
    private String cat1Name;

    @SerializedName("SizeRatio")
    @Expose
    private String sizeRatio;

    @SerializedName("ExpectedDate")
    @Expose
    private String expectedDate;
    @SerializedName("NoticeToPurchasers")
    @Expose
    private String noticeToPurchasers;
    @SerializedName("ProductDescription")
    @Expose
    private String productDescription;
    @SerializedName("productColorImageAPIs")
    @Expose
    private List<ProductColorImageAPI> productColorImageAPIs = null;

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public String getStyleNo() {
        return styleNo;
    }

    public void setStyleNo(String styleNo) {
        this.styleNo = styleNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorIDs() {
        return colorIDs;
    }

    public void setColorIDs(String colorIDs) {
        this.colorIDs = colorIDs;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getColorID() {
        return colorID;
    }

    public void setColorID(int colorID) {
        this.colorID = colorID;
    }

    public String getCat1Name() {
        return cat1Name;
    }

    public void setCat1Name(String cat1Name) {
        this.cat1Name = cat1Name;
    }

    public String getSizeRatio() {
        return sizeRatio;
    }

    public void setSizeRatio(String sizeRatio) {
        this.sizeRatio = sizeRatio;
    }

    public String getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(String expectedDate) {
        this.expectedDate = expectedDate;
    }

    public String getNoticeToPurchasers() {
        return noticeToPurchasers;
    }

    public void setNoticeToPurchasers(String noticeToPurchasers) {
        this.noticeToPurchasers = noticeToPurchasers;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public List<ProductColorImageAPI> getProductColorImageAPIs() {
        return productColorImageAPIs;
    }

    public void setProductColorImageAPIs(List<ProductColorImageAPI> productColorImageAPIs) {
        this.productColorImageAPIs = productColorImageAPIs;
    }

}
