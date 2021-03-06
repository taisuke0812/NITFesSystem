
package com.example.taisuke.ankotest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import static com.google.firebase.internal.FirebaseAppHelper.getUid;

public class Graph extends AppCompatActivity {
    private static final String TAG = "" ;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int num = 1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("data");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Map<String, Object> map = new HashMap<>();
                map.put("time",dataSnapshot.getValue(Object.class));
                String text = map.get("time").toString();
                setText(text);
                Log.d(TAG, "Value is: " + text);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        Intent i = getIntent();
        if(i.getStringExtra("DATA") != null) {
            String text = i.getStringExtra("DATA");

            i.getIntExtra("Count" ,num);
            if (num == 1) {
                //TextView textView1 = findViewById(R.id.textview10);
                //textView1.setText(text);
                }
                if (num == 2) {
                   //TextView textView2 = findViewById(R.id.textview2);
                   //textView2.setText(text);
                }

        }
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), Main2Activity.class);
                startActivity(intent);
            }
        });


    }

    void setText(String text){
        TextView textview1= findViewById(R.id.textview1);
        textview1.setText(text);
    }

}
