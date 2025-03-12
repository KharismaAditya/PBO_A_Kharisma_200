public class Admin {
    String nama;
    String password;

    Admin(String iNama, String iPass){
        this.nama = iNama;
        this.password = iPass;
    }

    void berhasil(){
        System.out.println("LOGIN ADMIN BERHASIL");
    }

    void gagal(){
        System.err.println("Login gagal, Username atau Password salah!!");
    }

    void login(){
        final String adminPass = "Admin200";
        final String passPass = "Password200";
        if(nama.equals(adminPass) && password.equals(passPass)){
            berhasil();
        }else{
            gagal();
        }
    }
}
