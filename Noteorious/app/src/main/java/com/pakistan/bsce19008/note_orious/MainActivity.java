package com.pakistan.bsce19008.note_orious;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout scrollLayout = findViewById(R.id.linearlayout);
        Button historyText;
        historyText = new Button(getApplicationContext());
        scrollLayout.addView(historyText);
//        scrollLayout.addView(historyText);
//        scrollLayout.addView(historyText);


    }
}