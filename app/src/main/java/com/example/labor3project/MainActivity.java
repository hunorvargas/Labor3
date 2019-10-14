package com.example.labor3project;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Switch;
import android.content.Context;
import java.util.Calendar;
import java.util.Locale;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    private Calendar myCalendar = Calendar.getInstance();
    private SharedPreferences sharedPreferences;
    private EditText usernameEditText,emailEditText,passwordEditText;
    private TextView dateViewText;
    private Switch switchButton;
    private Button loginButton,datepickerButton;
    private User newUser;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        usernameEditText = (EditText) findViewById(R.id.username);
        emailEditText =(EditText) findViewById(R.id.emailtext);
        passwordEditText =(EditText) findViewById(R.id.password);
        dateViewText =(TextView) findViewById(R.id.dateview);
        switchButton = (Switch) findViewById(R.id.switchButton);
        loginButton =(Button) findViewById(R.id.loginbutton);
        datepickerButton = (Button) findViewById(R.id.pickdatebutton);

        sharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE);
        getSharedPreferenceStrings("Name","Email","Password", "Date");

        datepickerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, setdate, myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }

        });



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchButton.isChecked()) {

                    newUser.setName(usernameEditText.getText().toString());
                    newUser.setPassword(passwordEditText.getText().toString());
                    newUser.setDate(dateViewText.getText().toString());

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("Name", usernameEditText.getText().toString());
                    editor.putString("Email", emailEditText.getText().toString());
                    editor.putString("Password", passwordEditText.getText().toString());
                    editor.putString("Date", dateViewText.getText().toString());
                    editor.commit();
                    Toast.makeText(MainActivity.this, "Saved!", Toast.LENGTH_LONG).show();
                    Intent addhobbyintent=new Intent(getApplicationContext(),AddhobbyActivity.class);
                    addhobbyintent.putExtra("User", newUser);
                    startActivity(addhobbyintent);
                }else
                {
                    Toast.makeText(MainActivity.this, "Not saved!", Toast.LENGTH_LONG).show();
                    Intent addhobbyintent=new Intent(getApplicationContext(),AddhobbyActivity.class);
                }

            }
        });

    }

    final DatePickerDialog.OnDateSetListener setdate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "dd/MM/yy"; //Change as you need
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                dateViewText.setText(sdf.format(myCalendar.getTime()));

    }
        };




    private void getSharedPreferenceStrings(String nameKey,String emailKey,String passwordKey, String dateKey)
    {
        String name = sharedPreferences.getString(nameKey,"");
        if (name!="")
        {
            usernameEditText.setText(name);
        }
        String email = sharedPreferences.getString(emailKey,"");
        if (email!="")
        {
            emailEditText.setText(email);
        }
        String password = sharedPreferences.getString(passwordKey,"");
        if (password!="")
        {
            passwordEditText.setText(password);
        }
        String date = sharedPreferences.getString(dateKey, "");
        if (date!=""){
            dateViewText.setText(date);
        }
    }
}
