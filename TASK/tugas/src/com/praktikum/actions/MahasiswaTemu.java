package com.praktikum.actions;

import java.util.Scanner;

public class MahasiswaTemu implements MahasiswaActions{
    Scanner input = new Scanner(System.in);

    String namaBarang;
    String desBarang;
    String lokTerakhir;

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
    }
}
