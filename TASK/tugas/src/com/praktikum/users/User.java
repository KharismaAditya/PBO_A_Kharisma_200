package com.praktikum.users;

import java.util.Scanner;

public abstract class User {
    protected String userName;
    protected String userPass;
    protected Scanner input;


    public User(String userName, String userPass, Scanner input){
        this.userName = userName;
        this.userPass = userPass;
        this.input = input;
    }

    public String getUserName(){
        return userName;
    }
    public String getUserPass(){
        return userPass;
    }

    public abstract void login();
    public abstract void displayInfo();
    public abstract void displayAppMenu();
}
