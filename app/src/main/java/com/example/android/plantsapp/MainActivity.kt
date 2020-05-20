package com.example.android.plantsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.intro_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.buttonNext)
        button.setOnClickListener{
            val intent = Intent(this, second_activity::class.java)
            startActivity(intent)

        }

    }
}