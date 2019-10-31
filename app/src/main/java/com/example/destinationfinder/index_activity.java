package com.example.destinationfinder;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class index_activity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_activity);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.nav_home:

                                Intent intent = new Intent(getBaseContext(), profile.class);
                                startActivity(intent);
                                return true;
                            case R.id.fav_color:
                                Intent intents = new Intent(getBaseContext(), Resturant_View.class);
                                startActivity(intents);
                                return true;
                            case R.id.search:
                                // TODO
                                return true;
                        }
                        return false;
                    }
                });
    }
}
