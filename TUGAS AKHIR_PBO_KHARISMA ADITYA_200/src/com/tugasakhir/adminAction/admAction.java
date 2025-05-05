package com.tugasakhir.adminAction;

import com.tugasakhir.bookdata.accessible.*;
import com.tugasakhir.userdata.checker;

import java.util.Scanner;

public class admAction {
    userAccessibleProgram perpus = new userAccessibleProgram();
    adminAccessibleProgram admin = new adminAccessibleProgram();
    Scanner input = new Scanner(System.in);

    public void display(){
        System.out.println("PILIHAN: ");
        System.out.println("1. TAMBAH BUKU\n2. HAPUS BUKU");
        System.out.print("Pilihan: "); String choice = input.next();
        switch (choice){
            case "1":
                System.out.println("-- TAMBAH BUKU --");
                perpus.displayBook();
                System.out.print("Masukkan Judul buku: "); String judul = input.next();
                System.out.print("Masukkan nama Penulis buku: "); String penulis = input.next();
                admin.addBook(judul, penulis);
                break;
            case "2":
                //hapus buku//
                break;
            default:
                System.err.println("Pilihan tidak valid");
        }
    }
}
