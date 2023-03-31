package com.acardona.labo03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var count : TextView
    private lateinit var fiveCents : ImageView
    private lateinit var tenCents : ImageView
    private lateinit var quarter : ImageView
    private lateinit var dollar : ImageView

    private var counting = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        addListeners()
    }
    private fun bind(){
        count = findViewById(R.id.count_text_view)
        fiveCents =findViewById(R.id.five_cents_image_view)
        tenCents = findViewById(R.id.ten_cents_image_view)
        quarter = findViewById(R.id.quarter_image_view)
        dollar = findViewById(R.id.dollar_image_view)
    }

    private fun addListeners(){

        fiveCents.setOnClickListener{increaseMoney(0.05)}
        tenCents.setOnClickListener{increaseMoney(0.10)}
        quarter.setOnClickListener{increaseMoney(0.25)}
        dollar.setOnClickListener{increaseMoney(1.00)}
    }

    private fun increaseMoney(money : Double){
        counting += money
        count.text = "${String.format("%.2f", counting)}"

    }
}