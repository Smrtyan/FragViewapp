package com.example.ubnt.fragviewapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class detailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        Intent intent = getIntent();
        String country = intent.getStringExtra("country");
        TextView textView = findViewById(R.id.textView);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(getResources().getIdentifier(country,"drawable",getPackageName()));
        textView.setText(country);
    }
}
