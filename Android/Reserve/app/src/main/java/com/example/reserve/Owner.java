package com.example.reserve;

import java.util.ArrayList;

public class Owner {

    int ID;
    String Username;
    String Password;
    ArrayList<String> Stores = new ArrayList<String>();

    public Owner(int ID, String Username, String Password, ArrayList<String> Stores){
        this.ID = ID;
        this.Username = Username;
        this.Password = Password;
    }
}
