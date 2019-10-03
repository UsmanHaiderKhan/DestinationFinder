package com.example.destinationfinder;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {
      ConstraintLayout layout;
        AnimationDrawable drawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  layout=(ConstraintLayout) findViewById(R.id.root_layout);

  drawable =(AnimationDrawable) layout.getBackground();
  drawable.setEnterFadeDuration(4500);
  drawable.setExitFadeDuration(5000);
  drawable.start();
    }
}
