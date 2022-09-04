package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClick = findViewById<Button>(R.id.mybutton)
        val txtDisp = findViewById<TextView>(R.id.textView)
        var peopleCount = 0

        btnClick.setOnClickListener {
            peopleCount++
            txtDisp.text = peopleCount.toString()

            Toast.makeText(this,"Hey Samarth!",Toast.LENGTH_SHORT).show()
        }
    }
}