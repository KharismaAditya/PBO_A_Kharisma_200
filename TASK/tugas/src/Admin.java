public class Admin {
    String nama;
    String password;

    Admin(String inama, String ipass){
        this.nama = inama;
        this.password = ipass;
    }

    void berhasil(){
        System.out.println("LOGIN ADMIN BERHASIL");
    }

    void gagal(){
        System.err.println("Login gagal, Username atau Password salah!!");
    }

    void login(){
        final String adminpass = "Admin200";
        final String passpass = "Password200";
        if(nama.equals(adminpass) && password.equals(passpass)){
            berhasil();
        }else{
            gagal();
        }
    }
}
