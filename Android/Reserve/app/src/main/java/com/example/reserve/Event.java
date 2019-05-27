package com.example.reserve;

public class Event {
    public int ID;
    public String Name;
    public int Store;
    public String StartDate;
    public String EndDate;
    public String Description;

    public Event(int ID, String Name, int Store, String StartDate, String EndDate, String Description){
        this.ID = ID;
        this.Name = Name;
        this.Store = Store;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.Description =Description;
    }
}
