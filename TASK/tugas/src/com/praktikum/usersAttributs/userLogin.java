package com.praktikum.usersAttributs;

import com.praktikum.actions.MahasiswaActions;
import com.praktikum.data.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class userLogin extends User implements MahasiswaActions{
    private ArrayList<Student> stdList;
    private ArrayList<Item> itemList;
    private int scan;
    private boolean loop = true;
    private Scanner input = new Scanner(System.in);

    public userLogin(String userName, String userPass, ArrayList<Student> stdList, ArrayList<Item> itemList) {
        super(userName, userPass);
        this.stdList = stdList;
        this.itemList = itemList;

        dataCollected data = new dataCollected();
        data.dataMahasiswaDefault(stdList);
        data.dataItemDefault(itemList);
    }

    @Override
    public void login() {
        scan = 0;
        for (Student student : stdList) {
            if (student.getNama().equals(getUserName()) && student.getNIM().equals(getUserPass())) {
                scan = 1;
            }
        }
        displayInfo();
    }

    @Override
    public void displayInfo() {
        if (scan == 1) {
            System.out.println("LOGIN MAHASISWA BERHASIL");
            System.out.println("Nama: " + getUserName());
            System.out.println("NIM: " + getUserPass());
            System.out.println();
            displayAppMenu();
        } else {
            System.err.println("LOGIN MAHASISWA GAGAL!!");
        }
    }

    @Override
    public void displayAppMenu() {
        while (loop) {
            try {
                System.out.println(" -- Menu Pilihan --");
                System.out.println("1. Laporkan barang temuan\n2. Lihat daftar laporan\n0. Logout");
                System.out.print("Masukkan Pilihan anda: ");
                int choice = input.nextInt();
                input.nextLine(); // buang newline
                switch (choice) {
                    case 1:
                        reportItem();
                        break;
                    case 2:
                        viewReportedItems();
                        break;
                    case 0:
                        loop = false;
                        break;
                    default:
                        System.err.println("Masukkan input yang benar");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Input tidak valid. Harap masukkan angka.");
                input.nextLine();
            }
        }
    }

    @Override
    public void reportItem() {
        System.out.println("== LAPORAN BARANG HILANG ==");
        System.out.print("Nama barang: ");String nama = input.nextLine();
        System.out.print("Deskripsi barang: ");String desk = input.nextLine();
        System.out.print("Lokasi terakhir: ");String lokter = input.nextLine();
        itemList.add(new Item(nama, desk, lokter));
    }

    @Override
    public void viewReportedItems() {
        System.out.println();
        System.out.println("Daftar barang hilang: ");
        boolean ada = false;
        for(int i = 0; i < itemList.size(); i++){
            Item it = itemList.get(i);
            if(it.getStatus().equalsIgnoreCase("Founded")){
                System.out.println("NO " + i + "==========");
                System.out.println("Barang: " + it.getItemName());
                System.out.println("Deskripsi: " + it.getDescription());
                System.out.println("lokasi terakhir: " + it.getLocation());
                System.out.println("STATUS: " + it.getStatus());
                System.out.println("=======================\n");
                ada = true;
            }
        }
        if(!ada){
            System.out.println("Tidak ada barang hilang yang belum ditemukan");
        }
    }
}