package com.tugasakhir.actionmethod;
import com.tugasakhir.bookdata.accessible.readBook.mySql;
import com.tugasakhir.bookdata.accessible.queryManage.*;
import java.util.Scanner;

public class mhsAction extends mainmethod{
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
        System.out.println("1. Pinjam Buku\n2. Kembalikan Buku");
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
        String sql = "";
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
        perpus.displayListBook(display.databaseDisplay(choice - 1));
        System.out.print("Masukkan ID buku: "); String idBuku = input.next();
        perpus.pinjamBuku(idBuku, borrow.borrowConnect(choice - 1), borrow.queryBorrow(choice - 1));
    }

    @Override
    public void action2Buku(String ID) {
        System.out.println(">>Fitur Kembalikan Buku<<");
    }

    @Override
    public void action3Buku(String ID) {
        System.out.println(">>COMING SOON<<");
    }
}
