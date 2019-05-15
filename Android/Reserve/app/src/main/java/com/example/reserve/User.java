package com.example.reserve;

import java.util.ArrayList;

public class User {

    int ID;
    String Username;
    String Password;
    ArrayList<String> Reviews = new ArrayList<String>();
    ArrayList<String> Visited = new ArrayList<String>();
    ArrayList<String> Reports = new ArrayList<String>();
    String CurrentLocation;

    public User(int ID, String Username, String Password, String[] Reviews, String[] Visited, String[] Reports, String CurrentLocation){
        this.ID = ID;
        this.Username = Username;
        this.Password = Password;
        this.CurrentLocation =CurrentLocation;
    }

    public void updateHistory(String newStore){
        this.Visited.add(0,newStore);
    }
}
