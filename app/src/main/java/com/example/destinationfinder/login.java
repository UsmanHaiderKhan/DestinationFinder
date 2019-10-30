package com.example.destinationfinder;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    TextView t;
    Button b;
    DbContext db;
    EditText email, password, phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DbContext(this);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        phone = (EditText) findViewById(R.id.phone);
        b = (Button) findViewById(R.id.login);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = email.getText().toString();
                String p = password.getText().toString();
                String ph = phone.getText().toString();
                Boolean checkcredential = db.Login(e, p, ph);
                if (checkcredential == true) {
                    Toast.makeText(getApplicationContext(), "Login SuccessFully", Toast.LENGTH_SHORT).show();
                    mainMenuView();

                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Email and Password", Toast.LENGTH_SHORT).show();
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


        t = (TextView) findViewById(R.id.registerText);
        final String text = "New User ? Register Here ";
        SpannableString ss = new SpannableString(text);
        int termStart = text.indexOf("Register");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this, signup.class));
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };
        ss.setSpan(clickableSpan, 11, 19, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorSignTwo)),
                11, 19, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.setMovementMethod(LinkMovementMethod.getInstance());
        t.setTextColor(Color.BLACK);
        t.setText(ss);


//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    }

    public void mainMenuView() {
        Intent intent = new Intent(this, profile.class);
        startActivity(intent);
    }
}
