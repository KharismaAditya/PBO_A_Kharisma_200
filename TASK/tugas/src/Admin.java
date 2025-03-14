public class Admin extends User{
    public Admin(String userName, String userPass){
        super(userName, userPass);
    }

    int scan;
    @Override
    public void login(){
        final String correctUser = "Admin200";
        final String correctPass = "Password200";
        if(getUserName().equals(correctUser) && getUserPass().equals(correctPass)){
            scan = 1;
        }else{
            scan = 0;
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
