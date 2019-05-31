package com.example.reserve;

import java.util.ArrayList;

public class User {

    int ID;
    String Username;
    String Password;
    ArrayList<String> Reviews = new ArrayList<String>();
    ArrayList<String> Visited = new ArrayList<String>();
    ArrayList<String> Reports = new ArrayList<String>();
    float X;
    float Y;

    public User(int ID, String Username, String Password, ArrayList<String> Reviews, ArrayList<String> Visited, ArrayList<String> Reports, float X, float Y){
        this.ID = ID;
        this.Username = Username;
        this.Password = Password;
        for (int i=0; i<Reviews.size();i++) {
            this.Reviews.add(Reviews.get(i));
        }
        for (int i=0; i<Visited.size();i++) {
            this.Visited.add(Visited.get(i));
        }
        for (int i=0; i<Reports.size();i++) {
            this.Reports.add(Reports.get(i));
        }
        this.X = X;
        this.Y = Y;
    }

    public void updateHistory(String newStore){

        this.Visited.add(0,newStore);
    }
}
