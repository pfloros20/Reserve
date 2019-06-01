package com.example.reserve;

import java.util.ArrayList;

public class Review {

    public int ID;
    public int SubmittedBy;
    public int Store_ID;
    public int Stars;
    public String Description;
    ArrayList<Integer> Reports = new ArrayList<Integer>();

    public Review(int ID, int SubmittedBy, int Store_ID, int Stars, String Description){
        this.ID = ID;
        this.SubmittedBy = SubmittedBy;
        this.Store_ID = Store_ID;
        this.Stars = Stars;
        this.Description = Description;
    }

    public Review(int ID, int SubmittedBy, int Store_ID, int Stars, String Description, ArrayList<Integer> Reports){
        this.ID = ID;
        this.SubmittedBy = SubmittedBy;
        this.Store_ID = Store_ID;
        this.Stars = Stars;
        this.Description = Description;
        this.Reports = Reports;
    }
}
