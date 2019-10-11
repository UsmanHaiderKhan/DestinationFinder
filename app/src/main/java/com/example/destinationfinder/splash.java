package com.example.destinationfinder;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class splash extends AppCompatActivity {
    TextView t;
    private Button register, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        t = (TextView) findViewById(R.id.dest_text);
        Typeface destinationFont = Typeface.createFromAsset(getAssets(), "AbrilDisplay-Extrabold.otf");
        t.setTypeface(destinationFont);

        t = (TextView) findViewById(R.id.find_text);
        Typeface finder = Typeface.createFromAsset(getAssets(), "Montserrat-Light.ttf");
        t.setTypeface(finder);


        t = (TextView) findViewById(R.id.exp_text);
        Typeface explore = Typeface.createFromAsset(getAssets(), "Montserrat-Regular.ttf");
        t.setTypeface(explore);

        t = (TextView) findViewById(R.id.login_btn);
        Typeface loginbtn = Typeface.createFromAsset(getAssets(), "Montserrat-Regular.ttf");
        t.setTypeface(loginbtn);

        t = (TextView) findViewById(R.id.register_btn);
        Typeface registerbtn = Typeface.createFromAsset(getAssets(), "Montserrat-Regular.ttf");
        t.setTypeface(registerbtn);

        register = (Button) findViewById(R.id.register_btn);
        login = (Button) findViewById(R.id.login_btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginActivity();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerActivity();
            }
        });
    }

    public void loginActivity() {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }

    public void registerActivity() {
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }
}