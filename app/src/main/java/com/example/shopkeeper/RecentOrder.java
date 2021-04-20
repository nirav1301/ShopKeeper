package com.example.shopkeeper;

public class RecentOrder {
    private String ordernumber;
    private String status;
    private String companyname;
    private String orderdate;
    private String orderinvoicenumber;
    private String orderamount;

    public RecentOrder() {
    }

    public RecentOrder(String ordernumber, String status, String companyname, String orderdate, String orderinvoicenumber, String orderamount) {
        this.ordernumber = ordernumber;
        this.status = status;
        this.companyname = companyname;
        this.orderdate = orderdate;
        this.orderinvoicenumber = orderinvoicenumber;
        this.orderamount = orderamount;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getOrderinvoicenumber() {
        return orderinvoicenumber;
    }

    public void setOrderinvoicenumber(String orderinvoicenumber) {
        this.orderinvoicenumber = orderinvoicenumber;
    }

    public String getOrderamount() {
        return orderamount;
    }

    public void setOrderamount(String orderamount) {
        this.orderamount = orderamount;
    }
}
