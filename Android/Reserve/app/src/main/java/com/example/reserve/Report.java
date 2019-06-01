package com.example.reserve;

import java.util.ArrayList;

public class Report {

    public int ID;
    public int SubmittedBy;
    public int Target;
    public String Description;
    public int Review_ID;
    ArrayList<String> Claims = new ArrayList<String>();

    public Report(int ID, int SubmittedBy, int Target, int Review_ID, String Description, ArrayList<String> Claims){
        this.ID = ID;
        this.SubmittedBy = SubmittedBy;
        this.Target = Target;
        this.Review_ID = Review_ID;
        this.Description = Description;
        this.Claims = Claims;

    }
}
