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
        for (int i=0; i<Stores.size();i++) {
            this.Stores.add(Stores.get(i));
        }
    }
}
