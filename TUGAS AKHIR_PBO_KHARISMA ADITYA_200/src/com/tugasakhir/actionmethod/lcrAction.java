package com.tugasakhir.actionmethod;
import com.tugasakhir.bookdata.accessible.queryManage.borrowQuery;
import com.tugasakhir.bookdata.accessible.queryManage.displayQuery;
import com.tugasakhir.bookdata.accessible.readBook.mySql;

import java.util.Scanner;

public class lcrAction extends mainmethod {
    Scanner input = new Scanner(System.in);
    mySql perpus = new mySql();
    displayQuery display = new displayQuery();
    borrowQuery borrow = new borrowQuery();

    @Override
    public void displayUser(String ID, String nama) {
        System.out.println();
        System.out.println("== PERPUSTAKAAN ==");
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
        boolean loop = true; int choice = 0;
        while (loop){
            System.out.println("JENIS BUKU: ");
            System.out.println("1. Informatika\n2.Teknik Mesin");
            System.out.print("Pilihan: ");choice = input.nextInt();
            if(choice <= display.displayLength()){
                loop = false;
                input.nextLine();
            }else {
                System.err.println("PILIHAN ANDA TIDAK TERSEDIA");
            }
        }
        String selectBorrow = borrow.borrowConnect(choice - 1);
        String queryBorrow = borrow.queryBorrow(choice - 1);
        perpus.displayListBook(display.databaseDisplay(choice - 1));
        System.out.println("Masukkan ID buku: "); String idBuku = input.next();
        perpus.pinjamBuku(idBuku, selectBorrow, queryBorrow);
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
