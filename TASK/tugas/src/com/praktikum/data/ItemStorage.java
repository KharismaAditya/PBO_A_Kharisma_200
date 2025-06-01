package com.praktikum.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ItemStorage {
    public static ArrayList<Student> stdList = new ArrayList<>();
    private static final ObservableList<Item> itemList = FXCollections.observableArrayList();

    public static ArrayList<Student> getStd(){
        return stdList;
    }

    public static ObservableList<Item> getItems() {
        return itemList;
    }

    public static void addItem(Item item) {
        itemList.add(item);
    }
}