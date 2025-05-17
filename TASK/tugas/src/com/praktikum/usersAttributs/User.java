package com.praktikum.usersAttributs;

public abstract class User {
    protected String userName;
    protected String userPass;


    public User(String userName, String userPass){
        this.userName = userName;
        this.userPass = userPass;
    }

    public String getUserName(){
        return userName;
    }
    public String getUserPass(){
        return userPass;
    }

    public abstract boolean login();
    public abstract void displayInfo();
    public abstract void displayAppMenu();
}
