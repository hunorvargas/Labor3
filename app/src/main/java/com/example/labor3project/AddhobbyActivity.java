package com.example.labor3project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class AddhobbyActivity extends AppCompatActivity {

    ArrayList<User> users =new ArrayList<User>();
    Button addHobbyButton;
    EditText editHobbytext;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addhobby);
        addHobbyButton = (Button) findViewById(R.id.addHobbyButton);
        editHobbytext = (EditText) findViewById(R.id.editHobbyText);

        Intent intent = getIntent();
        User user = intent.getParcelableExtra("User");
        String name,password,date;

        name=user.getName();
        password=user.getPassword();
        date=user.getDate();
        addData(name,password,date);
        addHobby();
    }

    private void addHobby() {
        addHobbyButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted=db.inserthobby(editHobbytext.getText().toString());
                        if(isInserted= true){
                            Toast.makeText(AddhobbyActivity.this,"Hobby Inserted",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(AddhobbyActivity.this,"Hobby is not Inserted",Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

    private void addData(final String name, final String password, final String date) {
                        boolean isInserted = db.insertdata(name,password,date);
                        if(isInserted= true){
                            Toast.makeText(AddhobbyActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(AddhobbyActivity.this,"Data is not Inserted",Toast.LENGTH_LONG).show();
                        }
                    }

}
