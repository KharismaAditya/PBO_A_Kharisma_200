public class Admin {
    String nama;
    String password;

    void berhasil(){
        System.out.println("LOGIN ADMIN BERHASIL");
    }
    void gagal(){
        System.err.println("Login gagal, Username atau Password salah!!");
    }

    void login(){
        if(nama.equals("Admin200") && password.equals("Password200")){
            berhasil();
        }else{
            gagal();
        }
    }
}
