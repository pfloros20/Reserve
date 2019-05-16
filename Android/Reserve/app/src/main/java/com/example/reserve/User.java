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

    public User(int ID, String Username, String Password, String[] Reviews, String[] Visited, String[] Reports, float X, float Y){
        this.ID = ID;
        this.Username = Username;
        this.Password = Password;
        this.X = X;
        this.Y = Y;
    }

    public void updateHistory(String newStore){

        this.Visited.add(0,newStore);
    }
}
