package com.example.taisuke.ankotest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main2Activity extends AppCompatActivity {
    //private Intent intent = new Intent(getApplication(), QrCodeReadInViewActivity.class);
    private String name;
    private int count = 0;
    //private StringBuilder sb;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
       /*
        if(i.getStringExtra("DATA") != null) {
           setName(i.getStringExtra("DATA"));
            TextView textView = findViewById(R.id.ReadData);
            textView.setText(getName());
            setCount(1);
        }*/

//ここに読み出しの部分を書きたい
//        try {
//            FileInputStream fileInputStream = openFileInput("data.txt");
//            data = fileInputStream.read();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        /*
        TextView write_text = findViewById(R.id.Write_Data);
        String data = "Read";
        write_text.setText(data);
*/
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent1 = new Intent(getApplication(), QrCodeReadInViewActivity.class);
                Intent intent1 = new Intent(getApplication(), button_activity.class);
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
                intent3.putExtra("DATA",getName());
                int num = getCount();
                intent3.putExtra("Count",1);
                startActivity(intent3);
            }
        });
        findViewById(R.id.logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getApplication(), MainActivity.class);

                startActivity(intent4);
            }
        });

    }

    private void setName(String intent_text){
        this.name = intent_text;
        return;
    }

    private String getName(){

        return name;
    }
    private void setCount(int a){
        this.count +=a;
    }

    private int getCount(){
        return this.count;
    }

/*
    private void SetTextBox(String text){
        this.sb.append(text);
    }

    private StringBuilder getTextBox(){

        return this.sb;
    }

*/

}
