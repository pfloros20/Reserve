package com.example.reserve;

import java.util.ArrayList;

public class User {

    public int ID;
    public String Username;
    public String Password;
    public ArrayList<String> Reviews = new ArrayList<String>();
    public ArrayList<String> Visited = new ArrayList<String>();
    public ArrayList<String> Reports = new ArrayList<String>();
    public float X;
    public float Y;

    public User(int ID, String Username, String Password, ArrayList<String> Reviews, ArrayList<String> Visited, ArrayList<String> Reports, float X, float Y){
        this.ID = ID;
        this.Username = Username;
        this.Password = Password;
		this.Reviews = Reviews;
		this.Visited = Visited;
		this.Reports = Reports;
        this.X = X;
        this.Y = Y;
    }

    public void updateHistory(String newStore){

        this.Visited.add(0,newStore);
    }
}
