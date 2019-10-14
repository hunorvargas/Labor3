package com.example.labor3project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AddhobbyActivity extends AppCompatActivity {

    private User newuser;

    public AddhobbyActivity(User newuser) {
        this.newuser = newuser;
    }

    public User getNewuser() {
        return newuser;
    }

    public void setNewuser(User newuser) {
        this.newuser = newuser;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addhobby);
    }
}
