package com.example.reserve;

import java.util.ArrayList;

public class Report {

    public int ID;
    public int SubmittedBy;
    public int Target;
    public String Description;
    public String Claim;
    ArrayList<String> Claims = new ArrayList<String>();

    public Report(int ID, int SubmittedBy, int Target, String Description, String Claim, ArrayList<String> Claims){
        this.ID = ID;
        this.SubmittedBy = SubmittedBy;
        this.Target = Target;
        this.Description = Description;
        this.Claim = Claim;

    }
}
