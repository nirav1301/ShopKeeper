package com.example.shopkeeper.Authentication;

public class ForgotPassword {
    private String emailId;

    public ForgotPassword(String emailId) {
        this.emailId = emailId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
