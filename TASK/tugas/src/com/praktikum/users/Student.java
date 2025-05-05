package com.praktikum.users;
import com.praktikum.actions.*;

import java.util.Scanner;

public class Student extends User implements MahasiswaActions{
    protected String correctUser = "Muhammad Kharisma Aditya Putra";
    protected String correctPass = "202410370110200";
    String choice, namaBarang, desBarang, lokTerakhir;
    boolean loop = true;

    public String getCorrectUser(){
        return  correctUser;
    }

    public String getCorrectPass(){
        return correctPass;
    }
    public Student(String userName, String userPass, Scanner input){
        super(userName, userPass, input);
    }

    int scan;
    @Override
    public void login(){
        scan = ((getUserName().equals(getCorrectUser())&& getUserPass().equals(getCorrectPass())) ? 1 : 0);
        displayInfo();
    }

    public void displayInfo(){
        if(scan == 1){
            System.out.println("LOGIN MAHASISWA BERHASIL");
            System.out.println("Nama: " + getUserName());
            System.out.println("NIM: " + getUserPass());
            System.out.println();
            displayAppMenu();
        }else {
            System.err.println("LOGIN MAHASISWA GAGAL!!");
        }
    }

    @Override
    public void displayAppMenu() {
        System.out.println(" -- Menu Pilihan --");
        System.out.println("1. Laporkan barang temuan\n2. Lihat daftar laporan\n0. Logout");
        System.out.print("Masukkan Pilihan anda: ");
        choice = input.next();
        switch (choice) {
            case "1":
                reportItem();
                break;
            case "2":
                viewReportedItems();
                break;
            case "0":
                loop = false;
                break;
            default:
                System.err.println("Masukkan input yang benar");
        }
    }

    void tampilLaporan(){
        System.out.println("LAPORAN");
        System.out.println("Barang : " + namaBarang);
        System.out.println("Deskripsi barang : " + desBarang);
        System.out.println("Lokasi ditemukan : " + lokTerakhir);
    }

    @Override
    public void reportItem() {
        System.out.println("-- LAPORAN BARANG HILANG --");
        System.out.print("Masukkan Nama Barang: "); namaBarang = input.next();
        System.out.print("Masukkan Deskripsi Barang: "); desBarang = input.next();
        System.out.print("Lokasi ditemukan: "); lokTerakhir = input.next();

        System.out.println("-- LAPORAN TELAH DITERIMA --");
        tampilLaporan();
    }

    @Override
    public void viewReportedItems() {
        System.out.println(">> Fitur Lihat Laporan Belum tersedia");
        System.out.println();
    }
}
