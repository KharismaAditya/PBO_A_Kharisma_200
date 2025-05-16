package com.praktikum.data;

import java.util.ArrayList;

public class dataCollected {
    public void dataItemDefault(ArrayList<Item> itemList){
        itemList.add(new Item("Pensil", "Ukuran 2B", "Nasgor Kantek Tengah"));
        itemList.add(new Item("Katsu Pedas Terlupakan", "Kentang goreng 3 dan Sambel 2", "Meja Depan Kasri Katsu"));
    }

    public void dataMahasiswaDefault(ArrayList<Student> stdList){
        stdList.add(new Student("Muhammad Kharisma Aditya Putra", "202410370110200"));
        stdList.add(new Student("Firdaus Firmansyah Emha", "202410370110039"));
        stdList.add(new Student("test", "1234"));
    }
}
