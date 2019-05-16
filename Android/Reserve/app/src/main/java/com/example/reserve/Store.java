package com.example.reserve;

import java.util.ArrayList;

public class Store {
    public int ID;
    public String Name;
    public int Owner;
    public int Capacity;
    public int CurrentAvailability;
    public String Description;
    public boolean Visible;
    public String Type;
    public float X;
    public float Y;
    ArrayList<Integer> Tables = new ArrayList<Integer>();
    ArrayList<String> Events = new ArrayList<String>();
    ArrayList<Integer> Reviews = new ArrayList<Integer>();
    ArrayList<Integer> Reservations = new ArrayList<Integer>();

    public Store(int ID, String Name, int Owner, int Capacity, int CurrentAvailability, String Description, boolean Visible, String Type, float X, float Y, ArrayList<Integer> Tables, ArrayList<String> Events, ArrayList<Integer> Reviews, ArrayList<Integer> Reservations){
        this.ID = ID;
        this.Name = Name;
        this.Owner = Owner;
        this.Capacity = Capacity;
        this.CurrentAvailability = CurrentAvailability;
        this.Description = Description;
        this.Visible = Visible;
        this.Type = Type;
        this.X = X;
        this.Y = Y;
    }
}
