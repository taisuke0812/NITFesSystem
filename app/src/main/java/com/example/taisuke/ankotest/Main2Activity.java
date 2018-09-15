package com.example.taisuke.ankotest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import javax.crypto.NullCipher;

public class Main2Activity extends AppCompatActivity {
    //private Intent intent = new Intent(getApplication(), QrCodeReadInViewActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
        if(i.getStringExtra("DATA") != null) {
            String name = i.getStringExtra("DATA");
            TextView textView = findViewById(R.id.ReadData);
            textView.setText(name);
        }

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplication(), QrCodeReadInViewActivity.class);
                startActivity(intent1);
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplication(), Kuchikomi.class);
                startActivity(intent2);
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplication(), Graph.class);
                startActivity(intent3);
            }
        });
    }



}
