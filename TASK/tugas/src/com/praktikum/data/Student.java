package com.praktikum.data;


public class Student{
    private String nama;
    private String NIM;

    public String getNama() {
        return nama;
    }
    public String getNIM() {
        return NIM;
    }

    public Student(String nama, String NIM){
        this.nama = nama;
        this.NIM = NIM;
    }
}
