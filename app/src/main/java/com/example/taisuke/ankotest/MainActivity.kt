package com.example.taisuke.ankotest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import org.jetbrains.anko.*
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //intentの設定
        //val intent: Intent = Intent(this@MainActivity, NextActivity::class.java)
        //val intent: Intent = Intent(this@MainActivity, QrCodeReadInViewActivity::class.java)
        //正式版は
        val intent: Intent = Intent(applicationContext, Main2Activity::class.java)
        val intent2 : Intent = Intent(applicationContext, Register::class.java)
        //↑これです
        //val intent: Intent = Intent(applicationContext,toki::class.java)
        create(intent,intent2)

    }


    private fun create(intent: Intent,intent2 : Intent){
        verticalLayout {
            gravity = Gravity.CENTER
            padding = dip(20)

            textView {
                gravity = Gravity.CENTER
                text = "Login Form"
                textSize = 24f
            }.lparams(width = matchParent) {
                margin = dip(20)
            }

            val name = editText {
                hint = "id"
            }

            val pass = editText {
                hint = "password"
            }

            button("Login!") {
                onClick {
                    toast("try login")
                    login(name.text.toString(), pass.text.toString(), intent)
                }
            }.lparams(dip(280), sp(60))

            button("新規登録"){
                onClick{
                    startActivity(intent2)
                }
            }.lparams(dip(280), sp(60))
        }

    }

    private fun login(id: String, pass: String, intent: Intent) {
        //なんらかの処理を並列で行うことを予想してthreadで書いておいた
        //thread {

            //Thread.sleep(2000)
            //実際のログイン処理はいつか書く
            if ((id == "okonomiyaki" && pass == "12") || (id == "yakitori" && pass == "15")) {
                //画面を遷移させる
                //toast("Success")
                intent.putExtra("DATA","start")
                startActivity(intent) //ログイン後の画面に遷移する

            } else {
                finish() //どう考えてもここはfinish()を使うべきではない
            }
       // }
    }


}


