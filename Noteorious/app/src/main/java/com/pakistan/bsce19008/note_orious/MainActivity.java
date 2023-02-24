package com.pakistan.bsce19008.note_orious;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout scrollLayout = findViewById(R.id.linearlayout);
        Button [] historyText = new Button[30];
        ImageButton addNoteBtn;
        for (int i = 0; i < 30; i++) {
            Button button = new Button(getApplicationContext());
            button.setText("Button " + i);
            historyText[i] = button;
            scrollLayout.addView(historyText[i]);
        }
//        scrollLayout.addView(historyText);
//        scrollLayout.addView(historyText);
        addNoteBtn = findViewById(R.id.createBtn);
        addNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("*******add page call ", "***********onClick: *****");
                Intent i = new Intent(getApplicationContext(),MainActivityEditing.class);
                startActivity(i);
            }
        });


    }
}