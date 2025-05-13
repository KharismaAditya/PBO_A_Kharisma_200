package com.tugasakhir.adminAction;
import com.tugasakhir.adminAction.userDataManage.*;
import com.tugasakhir.bookdata.accessible.manageBook.adminMySql;
import java.util.Scanner;

public class admAction {
    Scanner input = new Scanner(System.in);
    adminMySql admin = new adminMySql();

    public void display(){
        System.out.println();
        System.out.println("== ADMIN PAGE ==");
        System.out.println("PILIHAN: ");
        System.out.println("1. TAMBAH BUKU\n2. HAPUS BUKU\n3. Tambah Data Mahasiswa\n4.Tambah Data Dosen");
        System.out.print("Pilihan: "); String choice = input.next();
        switch (choice){
            case "1":
                admin.tambahBuku();
                break;
            case "2":
                admin.hapusBuku();
                break;
            case "3":
                studentsAdd mhs = new studentsAdd();
                System.out.println("-- TAMBAH DATA MAHASISWA --");
                System.out.print("Masukkan id mahasiswa: "); String idMhs = input.next();
                System.out.print("Masukkan nama mahasiswa: "); String namaMhs = input.next();
                mhs.addUser(idMhs, namaMhs);
                break;
            case "4":
                lecturerAdd lct = new lecturerAdd();
                System.out.println("-- TAMBAH DATA DOSEN --");
                System.out.print("Masukkan id dosen: "); String idLct = input.next();
                System.out.print("Masukkan nama dosen: "); String namaLct = input.next();
                lct.addUser(idLct, namaLct);
                break;
            default:
                System.err.println("Pilihan tidak valid");
        }
    }
}
