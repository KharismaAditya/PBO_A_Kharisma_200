package com.tugasakhir.bookdata.accessible;
import com.tugasakhir.bookdata.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class adminAccessibleProgram implements adminAccess{

    String file = "D:/ADIT/MAK AKU KULIAH/SMT 2/PBO/PBO_A_KHARISMA_200/TUGAS AKHIR_PBO_KHARISMA ADITYA_200/src/com/tugasakhir/bookdata/accessible/bookDataBase.txt/";
    @Override
    public void addBook(String judul, String penulis) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.newLine();
            writer.write(judul + "_" + penulis);
            writer.newLine();
            System.out.println("Buku berhasil ditambahkan");
        }catch (IOException e){
            System.out.println("Gagal menulis file");
        }
    }

    @Override
    public void deleteBook(String judul, String penulis) {

    }
}
