package com.example.reserve;

import java.util.ArrayList;

public class Store {
    public int ID;
    public String Name;
    public int Owner;
    public float Stars;
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

    public Store(int ID, String Name, int Owner, float Stars,
                 int Capacity, int CurrentAvailability, String Description,
                 boolean Visible, String Type){
        this.ID = ID;
        this.Name = Name;
        this.Owner = Owner;
        this.Stars = Stars;
        this.Capacity = Capacity;
        this.CurrentAvailability = CurrentAvailability;
        this.Description = Description;
        this.Visible = Visible;
        this.Type = Type;
    }

    public Store(int ID, String Name, int Owner, float Stars,
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

    boolean isFull(){
        return CurrentAvailability == 0;
    }

    void makeVisible(){
        Visible = true;
    }

    void addReview(int Review_ID){
        Reviews.add(Review_ID);
    }

    public void updateRating(){
        int starsum = 0;
        int total_reviews = 0;
        for(int i=0;i<Reviews.size();i++){
            for(int j=0;j<Data.reviews.size();j++) {
                if (Data.reviews.get(j).ID == Reviews.get(i)){
                    starsum += Data.reviews.get(j).Stars;
                    total_reviews++;
                }
            }
        }
        Stars = starsum/total_reviews;
    }
}
