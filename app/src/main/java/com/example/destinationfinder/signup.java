package com.example.destinationfinder;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity {
    TextView t;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        t = (TextView) findViewById(R.id.dest_text);
        Typeface destinationFont = Typeface.createFromAsset(getAssets(), "AbrilDisplay-Extrabold.otf");
        t.setTypeface(destinationFont);

        t = (TextView) findViewById(R.id.find_text);
        Typeface finder = Typeface.createFromAsset(getAssets(), "Montserrat-Light.ttf");
        t.setTypeface(finder);

        b = (Button) findViewById(R.id.login);
        Typeface btn = Typeface.createFromAsset(getAssets(), "Montserrat-Light.ttf");
        b.setTypeface(btn);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainMenuView();
            }
        });

    }

    public void mainMenuView() {
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }
}
