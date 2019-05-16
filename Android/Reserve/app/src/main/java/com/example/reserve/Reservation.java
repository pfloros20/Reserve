package com.example.reserve;

import java.util.ArrayList;

public class Reservation {

    public int ID;
    public int SubmittedBy;
    public int Store;
    public String State;
    ArrayList<Integer> Tables = new ArrayList<Integer>();

    public Reservation(int ID, int SubmittedBy, int Store, String State, ArrayList<Integer> Tables){
        this.ID = ID;
        this.SubmittedBy =SubmittedBy;
        this.Store = Store;
        this.State = State;
    }

    public void Delete(Reservation Obj){
        Obj = null;
    }
}
