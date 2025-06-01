package com.praktikum.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ItemStorage {
    private static final ObservableList<Item> itemList = FXCollections.observableArrayList();

    public static ObservableList<Item> getItems() {
        return itemList;
    }

    public static void addItem(Item item) {
        itemList.add(item);
    }
}