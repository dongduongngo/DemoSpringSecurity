package com.example.demosecu.model;

public class LoginRequest {
    private String userName;
    private String password;

    public LoginRequest() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassWord(String passWord) {
        this.password = passWord;
    }

    public LoginRequest(String userName, String passWord) {
        this.userName = userName;
        this.password = passWord;
    }
}
