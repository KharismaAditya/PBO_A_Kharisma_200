package com.tugasakhir.actionmethod;

import java.util.Scanner;

public class lcrAction extends mainmethod {
    Scanner input = new Scanner(System.in);

    @Override
    public void displayUser(String ID, String nama) {
        System.out.println("NAMA : " + nama);
        System.out.println("FITUR PERPUSTAKAAN");
        System.out.println("1. Pinjam Buku\n2. Kembalikan Buku\n3. Ajukan Jurnal");
        System.out.print("PILIHAN: ");String choice = input.next();
        switch (choice){
            case "1":
                action1Buku(ID);
                break;
            case "2":
                action2Buku(ID);
                break;
            case "3":
                action3Buku(ID);
                break;
            default:
                System.err.println("INPUT SALAH");
                break;
        }
    }

    @Override
    public void action1Buku(String ID) {
        System.out.println(">>Fitur Pinjam Buku<<");
    }

    @Override
    public void action2Buku(String ID) {
        System.out.println(">>Fitur Kembalikan Buku<<");
    }

    @Override
    public void action3Buku(String ID) {
        System.out.println(">>Fitur Ajukan Jurnal<<");
    }
}
