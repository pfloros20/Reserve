package com.example.reserve;

public class Table {
    public int ID;
    public int Store;
    public int Capacity;
    public String Availability;

    public Table(int ID, int Store, int Capacity, String Availability){
        this.ID = ID;
        this.Store = Store;
        this.Capacity = Capacity;
        this.Availability = Availability;
    }

    public void updateAvailability(String newAvailability){
        this.Availability = newAvailability;
    }
}
