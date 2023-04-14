package com.acardona.labo_04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var nameS :EditText
    private lateinit var emailS :EditText
    private lateinit var phoneNumberS :EditText
    private lateinit var saveButton :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        addListener()
    }

    private fun bind(){

        nameS = findViewById(R.id.name_text)
        emailS = findViewById(R.id.email_text)
        phoneNumberS = findViewById(R.id.phone_number_text)
        saveButton = findViewById(R.id.save_button)
    }

    private fun addListener(){
        saveButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)

            val fullName = nameS.text.toString()
            val fullEmail = emailS.text.toString()
            val fullPhoneNumber = phoneNumberS.text.toString()

            intent.putExtra("name" , fullName)
            intent.putExtra("email" , fullEmail)
            intent.putExtra("phone" , fullPhoneNumber)

            startActivity(intent)
        }
    }
}