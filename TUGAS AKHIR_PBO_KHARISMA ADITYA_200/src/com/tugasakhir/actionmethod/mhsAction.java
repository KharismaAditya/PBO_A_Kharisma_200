package com.tugasakhir.actionmethod;
import com.tugasakhir.bookdata.accessible.readBook.userReadBook;
import java.util.Scanner;

public class mhsAction extends mainmethod{
    Scanner input = new Scanner(System.in);
    userReadBook perpus = new userReadBook();

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
        System.out.println(">>Fitur Pinjam Buku<<");
        perpus.listBook();
        System.out.println("Masukkan judul buku yang ingin dipinjam: "); String judul = input.next();
        perpus.pinjamBook(judul);

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
