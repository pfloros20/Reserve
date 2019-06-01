package com.example.reserve;

import java.util.ArrayList;

public class Store {
    public int ID;
    public String Name;
    public int Owner;
    public String Stars = "3";
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

    public Store(int ID, String Name, int Owner,
                 int Capacity, int CurrentAvailability, String Description,
                 boolean Visible, String Type){
        this.ID = ID;
        this.Name = Name;
        this.Owner = Owner;
        this.Capacity = Capacity;
        this.CurrentAvailability = CurrentAvailability;
        this.Description = Description;
        this.Visible = Visible;
        this.Type = Type;
    }

    public Store(int ID, String Name, int Owner, String Stars,
                 int Capacity, int CurrentAvailability, String Description,
                 boolean Visible, String Type, float X, float Y, ArrayList<Integer> Tables,
                 ArrayList<String> Events, ArrayList<Integer> Reviews, ArrayList<Integer> Reservations){
        this.ID = ID;
        this.Name = Name;
        this.Owner = Owner;
        this.Stars = Stars;
        this.Capacity = Capacity;
        this.CurrentAvailability = CurrentAvailability;
        this.Description = Description;
        this.Visible = Visible;
        this.Type = Type;
        this.X = X;
        this.Y = Y;
        if(Tables != null)
            for (int i=0; i<Tables.size();i++) {
                this.Tables.add(Tables.get(i));
            }
        if(Events != null)
            for (int i=0; i<Events.size();i++) {
                this.Events.add(Events.get(i));
            }
        if(Reviews != null)
            for (int i=0; i<Reviews.size();i++) {
                this.Reviews.add(Reviews.get(i));
            }
        if(Reservations != null)
            for (int i=0; i<Reservations.size();i++) {
                this.Reservations.add(Reservations.get(i));
            }
    }
}
