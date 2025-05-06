package com.tugasakhir.userdata;
import com.tugasakhir.userdata.checkUserData.*;
import com.tugasakhir.adminAction.admAction;
import java.util.Scanner;

public class mainLogin {
    Scanner input = new Scanner(System.in);
    studentsChecker mhs = new studentsChecker();
    lecturerChecker lct = new lecturerChecker();
    admAction admin = new admAction();

    public void displayLogin(){
        System.out.println("LOGIN SEBAGAI: ");
        System.out.println("1. Mahasiswa");
        System.out.println("2. Dosen");
        System.out.print("PILIHAN: "); String choice = input.next();
        switch (choice){
            case "1":
                mhs.checkCorrectUser();
                break;
            case "2":
                lct.checkCorrectUser();
                break;
            case "Admin200":
                admin.display();
                break;

            default:
                System.out.println("INPUT TIDAK VALID");
        }
    }
}
