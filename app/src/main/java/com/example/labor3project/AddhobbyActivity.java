package com.example.labor3project;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Parcel;
import android.util.Log;

import java.util.ArrayList;


public class AddhobbyActivity extends AppCompatActivity {

    ArrayList<User> users =new ArrayList<User>();
    private DBManager dbManager;
    private DatabaseHelper db;

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
        init();
    }
    void init(){
    db = new DatabaseHelper(this);

    dbManager = new DBManager(this);
        dbManager.open();
    }
    void createUser(String name, String password, String date, String hobby) {
        User u = new User();
        u.setPassword(password);
        u.setDate(date);
        u.setHobby(hobby);
        Log.i("User",u.toString());
        users.add(u);
        toggleView();
    }
    void updateFood(User user, int position){
        dbManager.update(user.getId(),user.getName(),food.getPrice());

        // refreshing the list
        users.set(position, user);

    }
    private void deleteFood(int position) {
        User user = users.get(position);

        // deleting the food item from db

        dbManager.delete(user.getId());

        // removing the food item from the list
        users.remove(position);
       // mAdapter.notifyItemRemoved(position);
        toggleView();
    }
    private void toggleView() {
        if (users.size() > 0) {
            noFoodView.setVisibility(View.GONE);
        } else {
            noFoodView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbManager.close();
    }
}
