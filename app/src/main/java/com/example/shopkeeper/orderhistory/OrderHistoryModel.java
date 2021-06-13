package com.example.shopkeeper.orderhistory;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OrderHistoryModel implements Serializable {

    @SerializedName("CompanyCustomerID")
    @Expose
    private int companyCustomerID;
    @SerializedName("InventoryOrderID")
    @Expose
    private int inventoryOrderID;
    @SerializedName("TotalOrderAmount")
    @Expose
    private int totalOrderAmount;
    @SerializedName("OrderStatus")
    @Expose
    private String orderStatus;
    @SerializedName("CompanyName")
    @Expose
    private String companyName;
    @SerializedName("OrderDateTime")
    @Expose
    private String orderDateTime;
    @SerializedName("OrderConfirmed")
    @Expose
    private String orderConfirmed;
    @SerializedName("OrderConfirmedDateTime")
    @Expose
    private String orderConfirmedDateTime;
    @SerializedName("InvoiceNo")
    @Expose
    private String invoiceNo;
    @SerializedName("Invoice")
    @Expose
    private String invoice;
    @SerializedName("PONo")
    @Expose
    private String pONo;
    @SerializedName("InvoiceSubId")
    @Expose
    private String invoiceSubId;
    @SerializedName("DateTimeOrder")
    @Expose
    private String dateTimeOrder;
    @SerializedName("PaymentStatus")
    @Expose
    private String paymentStatus;
    @SerializedName("InvoiceCreatedDate")
    @Expose
    private String invoiceCreatedDate;

    public int getCompanyCustomerID() {
        return companyCustomerID;
    }

    public void setCompanyCustomerID(int companyCustomerID) {
        this.companyCustomerID = companyCustomerID;
    }

    public int getInventoryOrderID() {
        return inventoryOrderID;
    }

    public void setInventoryOrderID(int inventoryOrderID) {
        this.inventoryOrderID = inventoryOrderID;
    }

    public int getTotalOrderAmount() {
        return totalOrderAmount;
    }

    public void setTotalOrderAmount(int totalOrderAmount) {
        this.totalOrderAmount = totalOrderAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(String orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public String getOrderConfirmed() {
        return orderConfirmed;
    }

    public void setOrderConfirmed(String orderConfirmed) {
        this.orderConfirmed = orderConfirmed;
    }

    public String getOrderConfirmedDateTime() {
        return orderConfirmedDateTime;
    }

    public void setOrderConfirmedDateTime(String orderConfirmedDateTime) {
        this.orderConfirmedDateTime = orderConfirmedDateTime;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getPONo() {
        return pONo;
    }

    public void setPONo(String pONo) {
        this.pONo = pONo;
    }

    public String getInvoiceSubId() {
        return invoiceSubId;
    }

    public void setInvoiceSubId(String invoiceSubId) {
        this.invoiceSubId = invoiceSubId;
    }

    public String getDateTimeOrder() {
        return dateTimeOrder;
    }

    public void setDateTimeOrder(String dateTimeOrder) {
        this.dateTimeOrder = dateTimeOrder;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getInvoiceCreatedDate() {
        return invoiceCreatedDate;
    }

    public void setInvoiceCreatedDate(String invoiceCreatedDate) {
        this.invoiceCreatedDate = invoiceCreatedDate;
    }

}