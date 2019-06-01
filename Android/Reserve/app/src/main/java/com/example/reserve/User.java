package com.example.reserve;

import java.util.ArrayList;

public class User {

    int ID;
    String Username;
    String Password;
    ArrayList<Integer> Reviews = new ArrayList<Integer>();
    ArrayList<Integer> Visited = new ArrayList<Integer>();
    ArrayList<Integer> Reports = new ArrayList<Integer>();
    float X;
    float Y;

    public User(int ID, String Username, String Password){
        this.ID = ID;
        this.Username = Username;
        this.Password = Password;

    }

    public User(int ID, String Username, String Password, ArrayList<Integer> Reviews,
                ArrayList<Integer> Visited, ArrayList<Integer> Reports, float X, float Y){
        this.ID = ID;
        this.Username = Username;
        this.Password = Password;
        if(Reviews != null)
            for (int i=0; i<Reviews.size();i++) {
                this.Reviews.add(Reviews.get(i));
            }
        if(Visited != null)
            for (int i=0; i<Visited.size();i++) {
                this.Visited.add(Visited.get(i));
            }
        if(Reports != null)
            for (int i=0; i<Reports.size();i++) {
                this.Reports.add(Reports.get(i));
            }
        this.X = X;
        this.Y = Y;
    }

    public void updateHistory(int Store_ID){

        this.Visited.add(0,Store_ID);
    }

}
