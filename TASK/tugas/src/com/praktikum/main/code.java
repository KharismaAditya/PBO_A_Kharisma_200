package com.praktikum.main;

import com.praktikum.users.*;
import java.util.Scanner;

public class code {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        boolean loop = true;

        while(loop){
            System.out.println("Pilih login: ");
            System.out.println("1. Admin\n2. Mahasiswa\n3. Keluar");
            System.out.print("Masukkan pilihan: ");String pilih = input.next();
            input.nextLine();
            switch (pilih){
                case "1":
                    loop = admininput(input);
                    break;
                case "2":
                    loop = studentinput(input);
                    break;
                case "3":
                    loop = false;
                    break;
                default:
                    System.out.println("INPUT YANG ANDA MASUKKAN TIDAK VALID, Harap masukkan Input yang benar!!");
                    System.out.print("\n");
            }
        }
        input.close();
    }

    private static boolean admininput(Scanner input){
        System.out.print("Masukkan Username: "); String userNama = input.nextLine();
        System.out.print("Masukkan Password: "); String userPass = input.nextLine();
        User user1 = new Admin(userNama, userPass, input);
        user1.login();
        return false;
    }

    private static boolean studentinput(Scanner input){
        System.out.print("Masukkan Nama: "); String userNama = input.nextLine();
        System.out.print("Masukkan NIM anda: "); String userPass = input.nextLine();
        User user2 = new Student(userNama, userPass, input);
        user2.login();
        return false;
    }
}
