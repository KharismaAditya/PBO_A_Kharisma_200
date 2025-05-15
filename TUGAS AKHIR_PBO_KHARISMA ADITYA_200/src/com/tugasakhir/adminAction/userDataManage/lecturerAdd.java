package com.tugasakhir.adminAction.userDataManage;
import com.tugasakhir.adminAction.adminUserData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class lecturerAdd implements adminUserData {
    String file = "D:/ADIT/MAK AKU KULIAH/SMT 2/PBO/PBO_A_KHARISMA_200/TUGAS AKHIR_PBO_KHARISMA ADITYA_200/src/com/tugasakhir/userdata/asd.txt";
    @Override
    public void addUser(String id, String nama) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
            writer.newLine();
            writer.write(nama + "_" + id);
            writer.newLine();
        }catch (IOException e){
            System.out.println("Gagal Menulis File");
        }
    }

    @Override
    public void delUser(String id, String nama) {

    }
}
