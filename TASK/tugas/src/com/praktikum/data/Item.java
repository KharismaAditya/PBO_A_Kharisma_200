package com.praktikum.data;

public class Item {
    private String itemName;
    private String description;
    private String location;
    private String status;


    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String Status){
        this.status = Status;
    }

    public Item(String itemName, String description, String location){
        this.itemName = itemName;
        this.description = description;
        this.location = location;
        this.status = "Founded";
    }
}
