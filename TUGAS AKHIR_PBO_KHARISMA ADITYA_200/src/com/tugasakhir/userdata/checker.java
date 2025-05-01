package com.tugasakhir.userdata;
import com.tugasakhir.actionmethod.*;

import java.util.Scanner;

public class checker implements dataCollected{
    @Override
    public void login() {
        Scanner input = new Scanner(System.in);
        mhsAction mahasiswa = new mhsAction();
        lcrAction dosen = new lcrAction();
        System.out.print("Masukkan ID anda: ");String idInput = input.next();

        boolean found = false;

        for(int i = 0; i < studentData.length; i++){
            if(idInput.equals(studentData[i]) || idInput.equals(lectureData[i])){
                if(idInput.equals(studentData[i])){
                    System.out.println("Selamat datang " + studentNama[i] + " ID: " + studentData[i]);
                    System.out.println();
                    mahasiswa.displayUser(studentData[i], studentNama[i]);
                }else if(idInput.equals(lectureData[i])){
                    System.out.println("Selamat datang Pak " + lectureNama[i] + " ID: " + lectureData[i]);
                    System.out.println();
                    dosen.displayUser(lectureData[i], lectureNama[i]);
                }
                found = true;
                break;
            }
        }

        if(!found){
            System.err.println("LOGIN GAGAL, ID TIDAK DITEMUKAN");
        }
    }
}
