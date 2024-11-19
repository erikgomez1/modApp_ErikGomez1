package com.example.houseofdragons

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ActivityFinal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)


        val select = findViewById<TextView>(R.id.txtselect)
        val exit = findViewById<Button>(R.id.btnexit)
        val msg = intent.getStringExtra("checkbox_selection")

        select.text = msg

exit.setOnClickListener { finish() }
    }
}