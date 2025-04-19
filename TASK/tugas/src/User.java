import java.util.Scanner;

public class User {
    private String userName;
    private String userPass;


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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public void login(){}
    public void displayInfo(){}
}
