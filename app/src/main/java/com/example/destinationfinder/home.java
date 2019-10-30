package com.example.destinationfinder;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class home extends AppCompatActivity {
    List<resturant> resturants;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        resturants = new ArrayList<>();
        resturants.add(new resturant("My is Khan", "Category", "Some Thing Going Wrong", R.drawable.gl));
        resturants.add(new resturant("My is Khan", "Category", "Some Thing Going Wrong", R.drawable.gl));
        resturants.add(new resturant("My is Khan", "Category", "Some Thing Going Wrong", R.drawable.gl));
        resturants.add(new resturant("My is Khan", "Category", "Some Thing Going Wrong", R.drawable.gl));
        resturants.add(new resturant("My is Khan", "Category", "Some Thing Going Wrong", R.drawable.gl));
        resturants.add(new resturant("My is Khan", "Category", "Some Thing Going Wrong", R.drawable.gl));
        resturants.add(new resturant("My is Khan", "Category", "Some Thing Going Wrong", R.drawable.gl));
        resturants.add(new resturant("My is Khan", "Category", "Some Thing Going Wrong", R.drawable.gl));
        resturants.add(new resturant("My is Khan", "Category", "Some Thing Going Wrong", R.drawable.gl));
        resturants.add(new resturant("My is Khan", "Category", "Some Thing Going Wrong", R.drawable.gl));
        resturants.add(new resturant("My is Khan", "Category", "Some Thing Going Wrong", R.drawable.gl));
        resturants.add(new resturant("My is Khan", "Category", "Some Thing Going Wrong", R.drawable.gl));
        resturants.add(new resturant("My is Khan", "Category", "Some Thing Going Wrong", R.drawable.gl));
        resturants.add(new resturant("My is Khan", "Category", "Some Thing Going Wrong", R.drawable.gl));
        resturants.add(new resturant("My is Khan", "Category", "Some Thing Going Wrong", R.drawable.gl));
        resturants.add(new resturant("My is Khan", "Category", "Some Thing Going Wrong", R.drawable.gl));
        resturants.add(new resturant("My is Khan", "Category", "Some Thing Going Wrong", R.drawable.gl));
        resturants.add(new resturant("My is Khan", "Category", "Some Thing Going Wrong", R.drawable.gl));
        resturants.add(new resturant("My is Khan", "Category", "Some Thing Going Wrong", R.drawable.gl));
        resturants.add(new resturant("My is Khan", "Category", "Some Thing Going Wrong", R.drawable.gl));
        resturants.add(new resturant("My is Khan", "Category", "Some Thing Going Wrong", R.drawable.gl));
        resturants.add(new resturant("My is Khan", "Category", "Some Thing Going Wrong", R.drawable.gl));
        resturants.add(new resturant("My is Khan", "Category", "Some Thing Going Wrong", R.drawable.gl));
        resturants.add(new resturant("My is Khan", "Category", "Some Thing Going Wrong", R.drawable.gl));

        RecyclerView view = (RecyclerView) findViewById(R.id.recycleView_Id);
        Adapter adapter = new Adapter(this, resturants);
        view.setLayoutManager(new GridLayoutManager(this, 3));
        view.setAdapter(adapter);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        ImageView imageView = (ImageView) findViewById(R.id.back_arrow);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                moveBack();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public void moveBack() {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }
}
