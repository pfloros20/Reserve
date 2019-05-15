package com.example.admin;

public class Owner {

    int ID;
    String Username;
    String Password;
    String[] Stores;

    public Owner(int ID, String Username, String Password, String[] Stores){
        this.ID = ID;
        this.Username = Username;
        this.Password = Password;
        this.Stores = Stores;
    }
}
