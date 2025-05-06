package com.tugasakhir.userdata.checkUserData;
import com.tugasakhir.userdata.checkData;
import com.tugasakhir.actionmethod.lcrAction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class lecturerChecker implements checkData{
    Scanner input = new Scanner(System.in);
    lcrAction action = new lcrAction();

    @Override
    public void checkCorrectUser() {
        System.out.println("== PAGE LOGIN DOSEN ==");
        System.out.print("Masukkan ID anda: ");String idLct = input.next();
        dataReader(idLct);
    }

    @Override
    public void dataReader(String idLct) {
        String file = "D:/ADIT/MAK AKU KULIAH/SMT 2/PBO/PBO_A_KHARISMA_200/TUGAS AKHIR_PBO_KHARISMA ADITYA_200/src/com/tugasakhir/userdata/lecturerData.txt";
        boolean found = false;

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;

            while ((line = reader.readLine()) != null){
                String[] data = line.split("_");
                if(data.length == 2){
                    String nama = data[0];
                    String id = data[1];
                    if(id.equalsIgnoreCase(idLct.trim())){
                        System.out.println("Selamat datang Pak " + nama);
                        found = true;

                        action.displayUser(id, nama);

                        break;
                    }
                }

            }
            if(!found){
                System.out.println("ID Dosen tidak ditemukan");
            }
        }catch (IOException e){
            System.out.println("Terjadi Kesalahan saat membaca file: " + e.getMessage());
        }
    }
}
