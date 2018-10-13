package com.example.taisuke.ankotest

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_toki.*

class toki : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toki)
        //
        var countNumber = 0
        var countNumberText = findViewById(R.id.textView14) as TextView
        var countButton = findViewById(R.id.button5) as Button

        countButton.setOnClickListener {
            countNumber++
            countNumberText.setText(Integer.toString(countNumber))
        }

        //
    }
}
