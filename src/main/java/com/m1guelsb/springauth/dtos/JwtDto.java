package com.m1guelsb.springauth.dtos;

public class JwtDto {
    private String token;
    private String userName;



    private String subscriptionType;

    public JwtDto(String token, String userName,String subscriptionType) {
        this.token = token;
        this.userName = userName;
        this.subscriptionType=subscriptionType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }
}
