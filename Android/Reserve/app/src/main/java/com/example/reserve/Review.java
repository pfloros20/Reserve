package com.example.reserve;

import java.util.ArrayList;

public class Review {

    public int ID;
    public int SubmittedBy;
    public int Store;
    public int Stars;
	public String Description;
    ArrayList<Integer> Reports = new ArrayList<Integer>();

    public Review(int ID, int SubmittedBy, int Store, int Stars, String Description, ArrayList<Integer> Reports){
        this.ID = ID;
        this.SubmittedBy = SubmittedBy;
        this.Store = Store;
        this.Stars = Stars;
		this.Description = Description;
    }
}
