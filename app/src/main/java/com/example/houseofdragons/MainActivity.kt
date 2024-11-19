package com.example.houseofdragons

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        if (intent.getBooleanExtra("Exit", false))
            finish()

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            goToElection()
        }
    }


        fun goToElection() {
            val intent = Intent(this@MainActivity, ElectionActivity::class.java)
            val etNombre = this.findViewById<EditText>(R.id.editTextText2)
            intent.putExtra("NAME", etNombre.text.toString())
            startActivity(intent)
        }
    }
