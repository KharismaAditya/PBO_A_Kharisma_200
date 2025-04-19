import java.util.Scanner;

public class Student extends User{
    private String correctUser = "Muhammad Kharisma Aditya Putra";
    private String correctPass = "202410370110200";

    public String getCorrectUser(){
        return  correctUser;
    }

    public String getCorrectPass(){
        return correctPass;
    }
    public Student(String userName, String userPass){
        super(userName, userPass);
    }

    int scan;
    @Override
    public void login(){
        scan = ((getUserName().equals(getCorrectUser())&& getUserPass().equals(getCorrectPass())) ? 0 : 1);
        displayInfo();
    }

    public void displayInfo(){
        if(scan == 1){
            System.out.println("LOGIN MAHASISWA BERHASIL");
            System.out.println("Nama: " + getUserName());
            System.out.println("NIM: " + getUserPass());
        }else {
            System.err.println("LOGIN MAHASISWA GAGAL!!");
        }
    }

}
