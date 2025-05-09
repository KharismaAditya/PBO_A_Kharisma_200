package com.praktikum.users;
import com.praktikum.actions.*;

import java.util.Scanner;

public class Admin extends User implements AdminActions{
    protected String correctUser = "Admin200";
    protected String correctPass = "Password200";
    String choice;
    boolean loop = true;

    public String getCorrectUser() {
        return correctUser;
    }

    public String getCorrectPass(){
        return correctPass;
    }

    public Admin(String userName, String userPass, Scanner input){
        super(userName, userPass, input);
    }

    int scan;
    @Override
    public void login(){
        scan = ((getUserName().equals(getCorrectUser()) && getUserPass().equals(getCorrectPass())) ? 1 : 0);
        displayInfo();
    }

    public void displayInfo(){
        if(scan == 1){
            System.out.println("LOGIN ADMIN BERHASIL");
            System.out.println();
            displayAppMenu();
        }else {
            System.err.println("LOGIN ADMIN GAGAL!!");
        }
    }

    @Override
    public void displayAppMenu() {
        while(loop){
            System.out.println(" -- Menu Pilihan --");
            System.out.println("1. Kelola Laporan Mahasiswa\n2. Kelola Data Mahasiswa\n0. Logout");
            System.out.print("Masukkan Pilihan anda: "); choice = input.next();
            switch (choice){
                case "1":
                    manageUsers();
                    break;
                case "2":
                    manageItems();
                    break;
                case "0":
                    loop = false;
                    break;
                default:
                    System.err.println("Masukkan input yang benar");
                    break;
            }
        }
    }

    @Override
    public void manageItems() {
        System.out.println(">> Fitur Kelola Barang Belum Tersedia <<");
        System.out.println();
    }

    @Override
    public void manageUsers() {
        System.out.println(">> Fitur Kelola Mahasiswa Belum Tersedia <<");
        System.out.println();
    }
}
