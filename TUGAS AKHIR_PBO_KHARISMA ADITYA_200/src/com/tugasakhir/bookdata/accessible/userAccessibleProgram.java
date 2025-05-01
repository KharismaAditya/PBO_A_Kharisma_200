package com.tugasakhir.bookdata.accessible;
import com.tugasakhir.bookdata.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class userAccessibleProgram implements lectureAndStudentAccess{
    @Override
    public void displayBook() {
        String file = "D:/ADIT/MAK AKU KULIAH/SMT 2/PBO/PBO_A_KHARISMA_200/TUGAS AKHIR_PBO_KHARISMA ADITYA_200/src/com/tugasakhir/bookdata/accessible/bookDataBase.txt/";
        int nomor = 1;

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            System.out.println();
            System.out.println("DAFTAR BUKU: ");
            while ((line = reader.readLine()) != null){
                String[] parts = line.split("_");
                if(parts.length == 2){
                    String judul = parts[0];
                    String penulis = parts[1];
                    System.out.println(nomor + ". " + judul + " Oleh " + penulis);
                    nomor++;
                }
            }
        } catch (IOException e){
            System.out.println("Gagal Membaca File: " + e.getMessage());
        }
    }

    @Override
    public void borrowBook(String searchBook) {
        String file = "D:/ADIT/MAK AKU KULIAH/SMT 2/PBO/PBO_A_KHARISMA_200/TUGAS AKHIR_PBO_KHARISMA ADITYA_200/src/com/tugasakhir/bookdata/accessible/bookDataBase.txt/";
        boolean found = false;

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;

            while((line = reader.readLine()) != null){
                String[] data = line.split("_");
                if(data.length == 2){
                    String judul = data[0];
                    String penulis = data[1];

                    if(judul.equalsIgnoreCase(searchBook.trim())){
                        System.out.println("Buku Ditemukan!!");
                        System.out.println("Judul: " + judul);
                        System.out.println("Penulis: " + penulis);
                        System.out.println("Buku berhasil dipinjam!!");
                        found = true;
                        break;
                    }
                }
            }
            if(!found){
                System.out.println("Buku dengan judul: " + searchBook + " tidak ditemukan");
            }
        }catch (IOException e){
            System.out.println("Terjadi Kesalahan saat membaca file: " + e.getMessage());
        }
    }

    @Override
    public void returnBook() {

    }

    @Override
    public void searchbook() {

    }
}
