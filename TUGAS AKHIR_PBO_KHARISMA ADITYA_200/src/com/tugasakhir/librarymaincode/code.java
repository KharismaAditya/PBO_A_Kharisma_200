package com.tugasakhir.librarymaincode;
import com.tugasakhir.userdata.*;
import com.tugasakhir.bookdata.accessible.readBook.mySql;


public class code {
    public static void main(String[] args){
        System.out.println("-- SELAMAT DATANG DI PERPUSTAKAAN UMM --");
        mainLogin perpus = new mainLogin();

        perpus.displayLogin();
    }
}
