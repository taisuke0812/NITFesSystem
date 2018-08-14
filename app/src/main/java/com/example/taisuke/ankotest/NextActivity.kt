package com.example.taisuke.ankotest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import org.jetbrains.anko.*

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        verticalLayout{
            gravity = Gravity.CENTER
            textView{
                gravity = Gravity.CENTER
                text = "ログイン成功"
                textSize = 24f
            }
        }


    }
}
