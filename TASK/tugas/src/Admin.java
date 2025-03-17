public class Admin extends User{
    private String correctUser = "Admin200";
    private String correctPass = "Password200";

    public String getCorrectUser() {
        return correctUser;
    }

    public String getCorrectPass(){
        return correctPass;
    }

    public Admin(String userName, String userPass){
        super(userName, userPass);
    }

    int scan;
    @Override
    public void login(){
        if(getUserName().equals(getCorrectUser()) && getUserPass().equals(getCorrectPass())){
            scan = 1;
            displayInfo();
        }else{
            scan = 0;
            displayInfo();
        }

    }

    public void displayInfo(){
        if(scan == 1){
            System.out.println("LOGIN ADMIN BERHASIL");
        }else {
            System.err.println("LOGIN ADMIN GAGAL!!");
        }
    }

}
