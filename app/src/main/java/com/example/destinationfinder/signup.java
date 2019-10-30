package com.example.destinationfinder;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity {
    DbContext db;
    TextView t;
    Button b;
    EditText email, password, con_pass, phone, address, username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        db = new DbContext(this);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        con_pass = (EditText) findViewById(R.id.con_password);
        phone = (EditText) findViewById(R.id.phone);
        address = (EditText) findViewById(R.id.country);
        username = (EditText) findViewById(R.id.username);
        b = (Button) findViewById(R.id.login);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = username.getText().toString();
                String s2 = email.getText().toString();
                String s3 = password.getText().toString();
                String s4 = con_pass.getText().toString();
                String s5 = phone.getText().toString();
                String s6 = address.getText().toString();

                if (s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("") || s5.equals("") || s6.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are Empty", Toast.LENGTH_SHORT).show();
                } else {
                    if (s3.equals(s4)) {
                        Boolean checkemail = db.checkemail(s2);
                        if (checkemail == true) {
                            Boolean insertData = db.insertData(s1, s2, s3, s5, s6);

                            if (insertData == true) {
                                Toast.makeText(getApplicationContext(), "User Has Been Register SuccessFully", Toast.LENGTH_SHORT).show();
                                mainMenuView();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "This Email is Already Exist", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Password Do Not Match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        t = (TextView) findViewById(R.id.dest_text);
        Typeface destinationFont = Typeface.createFromAsset(getAssets(), "AbrilDisplay-Extrabold.otf");
        t.setTypeface(destinationFont);

        t = (TextView) findViewById(R.id.find_text);
        Typeface finder = Typeface.createFromAsset(getAssets(), "Montserrat-Light.ttf");
        t.setTypeface(finder);

        b = (Button) findViewById(R.id.login);
        Typeface btn = Typeface.createFromAsset(getAssets(), "Montserrat-Light.ttf");
        b.setTypeface(btn);


    }

    public void mainMenuView() {
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }
}
