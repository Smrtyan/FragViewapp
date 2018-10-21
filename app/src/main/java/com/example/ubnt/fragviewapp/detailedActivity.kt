package com.example.ubnt.fragviewapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class detailedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)
        val intent = intent
        val country = intent.getStringExtra("country")
        val textView = findViewById<TextView>(R.id.textView)
        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setImageResource(resources.getIdentifier(country, "drawable", packageName))
        textView.text = country
    }
}
