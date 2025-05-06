package com.tugasakhir.bookdata.accessible.readBook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class userReadBook {
    Scanner input = new Scanner(System.in);
    String file = "D:/ADIT/MAK AKU KULIAH/SMT 2/PBO/PBO_A_KHARISMA_200/TUGAS AKHIR_PBO_KHARISMA ADITYA_200/src/com/tugasakhir/bookdata/accessible/bookDataBase.txt";

    public void listBook(){
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            int nomor = 1;
            while((line= reader.readLine()) != null){
                String[] data = line.split("_");
                if(data.length == 2){
                    System.out.println(nomor + ". " + data[0] + " - " + data[1]);
                    nomor++;
                }
            }
        }catch (IOException e){
            System.out.println("GAGAL MEMBUKA FILE");
        }
    }

    public void pinjamBook(String judul){
        boolean found = false;

        try(BufferedReader reader = new BufferedReader(new FileReader((file)))){
            String line;

            while((line = reader.readLine()) != null){
                String[] data = line.split("_");
                if(data.length == 2 && data[0].equalsIgnoreCase(judul.trim())){
                    System.out.println("BUKU DITEMUKAN");
                    System.out.println("Judul : " + data[0]);
                    System.out.println("Penulis : " + data[1]);
                    System.out.println("BUKU BERHASIL DIPINJAM");
                    found = true;
                    break;
                }
            }

            if(!found){
                System.out.println("Buku dengan judul " + judul + " tidak ditemukan!!");
            }
        }catch (IOException e){
            System.out.println("GAGAL MEMBACA FILE");
        }
    }
}
