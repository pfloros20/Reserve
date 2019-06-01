package com.example.reserve;

import java.util.ArrayList;
import java.util.Arrays;

public final class Data {
    static ArrayList<Admin> admins = new ArrayList<Admin>(Arrays.asList(
        new Admin(0, "george52", "12345"),
        new Admin(1,"pfloros","54321"),
        new Admin(2,"teogrx","kodikos"),
        new Admin(3,"panosxatz","kodikos"),
        new Admin(4,"chrikyriak","@13d32")));

    static ArrayList<Owner> owners = new ArrayList<Owner>(Arrays.asList(
         new Owner(0,"bas41","12345a"),
         new Owner(1,"dimitraSa","asdasd"),
         new Owner(2,"kakadim","asd1234"),
         new Owner(3,"owner1","ffds1")));

    static ArrayList<User> users = new ArrayList<User>(Arrays.asList(
        new User(0,"george","a"),
        new User(0,"basilis","asdasd"),
        new User(1,"JIMMYS","1234"),
        new User(2,"aliki","asd123"),
        new User(3,"marina","asd"),
        new User(4,"Aristidis","ll21")));

    static ArrayList<Store> stores = new ArrayList<Store>(Arrays.asList(
        new Store(0,"STORE0",1,42,10,"This is the best store in Patras",true,"RESTAURANT"),
        new Store(1,"STORE1",2,70,30,"This is the greatest store in Patras",true,"RESTAURANT"),
        new Store(2,"STORE2",3,55,24,"This is the most popular store in Patras",true,"COFFEE SHOP"),
        new Store(3,"STORE3",4,50,30,"This is one of the best stores in Patras",true,"PIZZA SHOP"),
        new Store(4,"STORE4",4,50,30,"This is one of the great stores in Patras",true,"RESTAURANT"),
        new Store(5,"STORE5",1,20,8,"This is the second best store in Patras", false,"RESTAURANT")));

    static ArrayList<Table> tables = new ArrayList<Table>(Arrays.asList(
        new Table(0,1,4,"FREE"),
        new Table(1,1,4,"TAKEN"),
        new Table(2,1,8,"BOOKED"),
        new Table(3,1,4,"BOOKED"),
        new Table(4,1,4,"FREE"),
        new Table(5,1,4,"BOOKED"),
        new Table(6,1,4,"TAKEN"),
        new Table(7,1,8,"TAKEN"),
        new Table(8,1,2,"FREE"),
        new Table(9,2,4,"TAKEN"),
        new Table(10,2,4,"FREE"),
        new Table(11,2,4,"FREE"),
        new Table(12,2,4,"BOOKED"),
        new Table(13,2,4,"TAKEN"),
        new Table(14,3,5,"FREE"),
        new Table(15,3,5,"FREE"),
        new Table(16,3,5,"TAKEN"),
        new Table(17,3,5,"FREE"),
        new Table(18,3,5,"FREE"),
        new Table(19,3,5,"TAKEN"),
        new Table(20,3,10,"BOOKED"),
        new Table(21,3,5,"FREE"),
        new Table(22,3,5,"FREE"),
        new Table(23,3,10,"BOOKED"),
        new Table(24,3,8,"TAKEN"),
        new Table(25,3,2,"BOOKED"),
        new Table(26,4,2,"FREE"),
        new Table(27,4,2,"FREE"),
        new Table(28,4,4,"TAKEN"),
        new Table(29,4,2,"BOOKED"),
        new Table(30,4,5,"BOOKED"),
        new Table(31,4,5,"TAKEN"),
        new Table(32,4,5,"FREE"),
        new Table(33,4,5,"FREE"),
        new Table(34,4,5,"TAKEN"),
        new Table(35,4,5,"TAKEN"),
        new Table(36,4,10,"FREE"),
        new Table(37,4,5,"TAKEN"),
        new Table(38,5,6,"FREE"),
        new Table(39,5,6,"FREE"),
        new Table(40,5,6,"FREE"),
        new Table(41,5,6,"FREE"),
        new Table(42,5,6,"FREE"),
        new Table(43,5,10,"BOOKED"),
        new Table(44,5,2,"TAKEN"),
        new Table(45,5,2,"TAKEN"),
        new Table(46,5,2,"BOOKED"),
        new Table(47,5,2,"BOOKED"),
        new Table(48,5,2,"TAKEN")));

    static ArrayList<Reservation> reservations = new ArrayList<Reservation>(Arrays.asList(
        new Reservation(0,1,3,"ACCEPTED"),
        new Reservation(1,2,1,"ACCEPTED"),
        new Reservation(2,3,3,"DENIED"),
        new Reservation(3,4,4,"ACCEPTED"),
        new Reservation(4,5,5,"ACCEPTED"),
        new Reservation(5,1,4,"DENIED")));

    static ArrayList<Event> events = new ArrayList<Event>(Arrays.asList(
        new Event(0,"EVENT0",1,"2019-5-10","2019-5-16","2nd anniversary"),
        new Event(1,"EVENT1",3,"2019-7-1","2019-7-7","5th anniversary"),
        new Event(2,"EVENT2",4,"2019-1-1","2019-1-2","3rd anniversary"),
        new Event(3,"EVENT3",5,"2019-5-13","2019-5-13","mother birthday"),
        new Event(4,"EVENT4",4,"2019-1-1","2019-1-2","35th anniversary")));

    static ArrayList<Review> reviews = new ArrayList<Review>(Arrays.asList(
        new Review(0,1,1,4,"a"),
        new Review(1,2,1,5,"great store"),
        new Review(2,3,5,1,"the worst store ever"),
        new Review(3,4,1,4,"nice store"),
        new Review(4,1,5,1,"rly bad shit")));

    static ArrayList<Report> reports = new ArrayList<Report>(Arrays.asList(
        new Report(0,2,1,5,"he should not speak like that",new ArrayList<String>(Arrays.asList("HATE_SPEECH"))),
        new Report(1,2,3,3, "lies",new ArrayList<String>(Arrays.asList("OTHER")))));



}
