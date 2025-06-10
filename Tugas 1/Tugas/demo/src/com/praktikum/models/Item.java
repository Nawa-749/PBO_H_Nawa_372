package com.praktikum.models;

public class Item {
    private String itemName;
    private String description;
    private String location;
    private String status;

    public Item(String itemName, String description, String location) {
        this.itemName = itemName;
        this.description = description;
        this.location = location;
        this.status = "Reported"; // Status default saat item dibuat
    }

    // Getter methods
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

    // Setter methods
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Item: " + itemName + " | Deskripsi: " + description +
                " | Lokasi: " + location + " | Status: " + status;
    }
}