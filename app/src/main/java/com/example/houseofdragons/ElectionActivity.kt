package com.example.houseofdragons

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity


class ElectionActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_election)

        val chckB1 = findViewById<CheckBox>(R.id.chckB1)
        val chckB2 = findViewById<CheckBox>(R.id.chckB2)
        val txtMsg2 = findViewById<TextView>(R.id.txtMsg2)
        val btn1 = findViewById<Button>(R.id.btn1)
        fun updateMsg() {

            txtMsg2.text = when {
                chckB1.isChecked && chckB2.isChecked -> "Jugar a dos bandas es muy peligroso... Tu cabeza podrá rodar en cualquier momento."
                chckB1.isChecked -> "Has decidido apoyar a una mujer por encima del primogénito varón... Lo pagarás con sangre."
                chckB2.isChecked -> "Has elegido a Aegon contra la voluntad del difunto rey... Arderás por tu elección... Dracarys!"
                else -> "Si no tomas una decisión no podrás salir de esta encrucijada."
            }
        }

        chckB1.setOnCheckedChangeListener { _, _ -> updateMsg() }
        chckB2.setOnCheckedChangeListener { _, _ -> updateMsg() }

        updateMsg()

        btn1.setOnClickListener {
            if (!chckB1.isChecked && !chckB2.isChecked) Toast.makeText(
                this,
                "Si no tomas una decisión no podrás salir de esta encrucijada." , Toast.LENGTH_SHORT
            ).show() else {
                val intent = Intent(this, ActivityFinal::class.java)

                val msg = when {
                    chckB1.isChecked && chckB2.isChecked -> "Has Seleccionado a Ambos."
                    chckB1.isChecked -> "Has elegido a Raenira Targaryen"
                    chckB2.isChecked -> "Has elegido a Aegon Targaryen"
                    else -> "No has seleccionado a ninguno"
                }
                intent.putExtra("checkbox_selection" , msg)
                startActivity(intent)
            }
        }
    }
}