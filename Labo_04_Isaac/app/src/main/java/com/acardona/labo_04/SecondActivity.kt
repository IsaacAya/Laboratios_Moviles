package com.acardona.labo_04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {


    private lateinit var shareButton: Button

    var fullName : String = ""
    var fullEmail : String = ""
    var fullPhoneNumber : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        fullName = intent.getStringExtra("name").toString()
        fullEmail = intent.getStringExtra("email").toString()
        fullPhoneNumber = intent.getStringExtra("phone").toString()
        fullPhoneNumber = intent.getStringExtra("phone").toString()

        bind()
        addListener()
    }

    private fun bind(){

        shareButton = findViewById(R.id.share_button)
    }

    private fun addListener(){

        shareButton.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(
                    Intent.EXTRA_TEXT, getString(R.string.share_text, fullName,
                    fullEmail, fullPhoneNumber))
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

    }
}