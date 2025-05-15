package com.tugasakhir.bookdata.accessible.manageBook;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import com.tugasakhir.bookdata.accessible.databaseConnect;
import com.tugasakhir.bookdata.accessible.readBook.mySql;
import com.tugasakhir.bookdata.accessible.queryManage.*;

public class adminMySql {
    databaseConnect db = new databaseConnect();
    Scanner input = new Scanner(System.in);
    mySql book = new mySql();
    displayQuery display = new displayQuery();
    addQuery add = new addQuery();
    deleteQuery delete = new deleteQuery();

    public void tambahBuku(){
        System.out.println("== TAMBAH BUKU ==");
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
        System.out.print("Masukkan judul buku : "); String judul = input.nextLine();
        System.out.print("Masukkan Nama Penulis: "); String penulis = input.nextLine();
        System.out.print("Masukkan jumlah stok Buku: "); int stok = input.nextInt();
        System.out.print("Masukkan nomor ID Buku: "); String idBuku = input.next();

        String sql = add.addConnect(choice - 1);
        try(Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, judul);
            stmt.setString(2, penulis);
            stmt.setInt(3, stok);
            stmt.setString(4, idBuku);
            int rowInserted = stmt.executeUpdate();

            if(rowInserted > 0){
                System.out.println("BUKU BERHASIL DITAMBAHKAN");
            }
        }catch (SQLException | IOException e){
            System.out.println("Terjadi kesalahan saat menyimpan data");
            e.printStackTrace();
        }
    }

    public void hapusBuku(){
        System.out.println("== HAPUS BUKU ==");
        boolean loop = true; int choice = 0;
        String sql = "";
        while (loop){
            System.out.println("JENIS BUKU: ");
            System.out.println("1. Informatika\n2.Teknik Mesin");
            System.out.print("Pilihan: ");choice = input.nextInt();
            if(choice <= display.displayLength()){
                loop = false;
            }else {
                System.err.println("PILIHAN ANDA TIDAK TERSEDIA");
            }
        }
        book.displayListBook(display.databaseDisplay(choice - 1));
        System.out.print("Masukkan idBuku yang ingin dihapus: ");String id = input.next();
        try(Connection conn = db.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(delete.deleteConnect(choice - 1));
            stmt.setString(1, id);
            int rowsAffected = stmt.executeUpdate();

            if(rowsAffected > 0){
                System.out.println("BUKU DENGAN ID "+ id + "BERHASIL DIHAPUS!!");
            }else {
                System.out.println("BUKU DENGAN ID "+ id + " GAGAL DIHAPUS!!");
            }

        }catch (SQLException | IOException e){
            System.out.println("GAGAL MENGHAPUS");
        }
    }
}
