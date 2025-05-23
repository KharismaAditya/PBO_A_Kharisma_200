package com.praktikum.usersAttributs;

import com.praktikum.actions.AdminActions;
import com.praktikum.data.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class adminLogin extends User implements AdminActions {
    ArrayList<Student> stdList;
    ArrayList<Item> itemList;
    protected String correctAdmin = "Admin200";
    protected String correctPass = "Password200";

    private int scan;
    private boolean loop = true;
    private Scanner input = new Scanner(System.in);

    public adminLogin(String userName, String userPass, ArrayList<Student> stdList, ArrayList<Item> itemList){
        super(userName, userPass);
        this.stdList = stdList;
        this.itemList = itemList;

        dataCollected data = new dataCollected();
        data.dataMahasiswaDefault(stdList);

    }

    public boolean isLoggedIn(){
        return scan == 1;
    }

    @Override
    public boolean login() {
        scan = (((getUserName().equals(correctAdmin) && getUserPass().equals(correctPass)) ? 1 : 0));
        if(scan == 1){
            return true;
        }
        return false;
    }

    @Override
    public void displayInfo() {
        if(login()){
            System.out.println("LOGIN ADMIN BERHASIL");
            System.out.println();
        }else {
            System.err.println("LOGIN ADMIN GAGAL!!");
        }
    }

    @Override
    public void displayAppMenu() {
        while(loop){
            try{
                System.out.println(" -- Menu Pilihan --");
                System.out.println("1. Kelola Laporan Barang Hilang Mahasiswa\n2. Kelola Data Mahasiswa\n3. Lihat data Mahasiswa\n0. Logout");
                System.out.print("Masukkan Pilihan anda: "); int choice = input.nextInt();
                switch (choice){
                    case 1:
                        manageItems();
                        break;
                    case 2:
                        manageUsers();
                        break;
                    case 3:
                        tampilMahasiswa();
                        break;
                    case 0:
                        loop = false;
                        break;
                    default:
                        System.err.println("Masukkan input yang benar");
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }

    @Override
    public void manageItems() {
        if(itemList.isEmpty()){
            System.out.println("BELUM ADA BARANG DILAPORKAN");
            return;
        }
        tampilBarang();
        try{
            System.out.println("Masukkan index barang yang ingin diubah statusnya: ");int index = input.nextInt();
            if(index >= 0 && index < itemList.size()){
                Item item = itemList.get(index);
                if(item.getStatus().equalsIgnoreCase("Founded")){
                    item.setStatus("Reported");
                    System.out.println("STATUS barang berhasil diubah");
                    System.out.println();
                }else{
                    System.out.println("Barang sudah berstatus 'Reported'");
                }
            }else {
                System.out.println("index tidak valid");
            }
        }catch (InputMismatchException e){
            System.out.println("ERROR: " + e.getMessage());
        }


    }

    @Override
    public void manageUsers() {
        System.out.println("== TAMBAH MAHASISWA BARU ==");
        System.out.print("Masukkan nim mahasiswa: "); String newNIM = input.next();
        input.nextLine();
        System.out.print("Masukkan nama mahasiswa: "); String newUser = input.nextLine();
        for(Student s : stdList){
            if(s.getNIM().equals(newNIM)){
                System.out.println("GAGAL: NIM SUDAH TERDAFTAR");
                return;
            }
        }
        Student mhsBaru = new Student(newUser, newNIM);
        stdList.add(mhsBaru);

        System.out.println("SUKSES: Mahasiswa berhasil ditambahkan");
        System.out.println();
    }

    public void tampilMahasiswa(){
        System.out.println();
        System.out.println("DAFTAR MAHASISWA: ");
        for(int i = 0; i < stdList.size(); i++){
            Student mhs = stdList.get(i);
            System.out.println(i + ". Nama: " + mhs.getNama() + " | NIM: " + mhs.getNIM());
        }
        System.out.println();
    }

    public void tampilBarang(){
        System.out.println();
        System.out.println("Daftar barang hilang: ");
        boolean ada = false;
        for(int i = 0; i < itemList.size(); i++){
            Item it = itemList.get(i);
            System.out.println("NO " + i + "==========");
            System.out.println("Barang: " + it.getItemName());
            System.out.println("Deskripsi: " + it.getDescription());
            System.out.println("lokasi terakhir: " + it.getLocation());
            System.out.println("STATUS: " + it.getStatus());
            System.out.println("=======================\n");
        }
    }
}
