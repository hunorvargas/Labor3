package com.example.labor3project;

import android.os.Parcel;

public class User {

    private String Name,Password,Date,Hobby;
    public User(){}
    public User(String name, String password, String date, String hobby) {
        Name = name;
        Password = password;
        Date = date;
        Hobby = hobby;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getHobby() {
        return Hobby;
    }

    public void setHobby(String hobby) {
        Hobby = hobby;
    }


}
