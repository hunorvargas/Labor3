package com.example.labor3project;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;

public class ListElementActivity extends AppCompatActivity {
    Button backButton;
    TextView viewHobbiestext;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_elements);
        db = new DatabaseHelper(this);

        backButton = (Button) findViewById(R.id.backButton);
        viewHobbiestext= (TextView) findViewById(R.id.myhobbysTextView) ;

        init();
        back();

    }

    private void init() {
        Cursor res = db.getAllHobbies();
        if(res.getCount() == 0) {
            // show message
            showMessage("Error","Nothing found");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
           // buffer.append("Id :"+ res.getString(0)+"\n");
            buffer.append("Hobby :"+ res.getString(3)+"\n");
        }

        // Show all data
        showMessage("Data",buffer.toString());
    }


    private void back() {
        backButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                        }

                }
        );
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
