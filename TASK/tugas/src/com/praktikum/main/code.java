package com.praktikum.main;

import com.praktikum.data.*;
import com.praktikum.usersAttributs.*;

import java.util.ArrayList;
import java.util.Scanner;

public class code {
    public static void main(String[] args){
        dataCollected data = new dataCollected();
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
        ArrayList<Student> stdList = new ArrayList<>();
        ArrayList<Item> itemList = new ArrayList<>();
        System.out.print("Masukkan Username: "); String userNama = input.next();
        System.out.print("Masukkan Password: "); String userPass = input.next();
        adminLogin admin = new adminLogin(userNama, userPass, stdList, itemList);
        admin.login();
        return false;
    }

    private static boolean studentinput(Scanner input){
        ArrayList<Student> stdList = new ArrayList<>();
        ArrayList<Item> itemList = new ArrayList<>();
        System.out.print("Masukkan Nama: "); String userNama = input.next();
        System.out.print("Masukkan NIM anda: "); String userPass = input.next();
        userLogin user = new userLogin(userNama, userPass, stdList, itemList);
        user.login();
        return false;
    }
}
