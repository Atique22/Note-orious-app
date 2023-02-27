package com.pakistan.bsce19008.note_orious;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout scrollLayout = findViewById(R.id.linearlayout);
        ImageButton addNoteBtn;

        ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
        File directory = contextWrapper.getFilesDir();
        File[] files = directory.listFiles();
        Button [] historyText = new Button[files.length];
        for (File file : files) {
            int i=0;
            if (file.isFile()) {
                // Do something with the file, such as displaying its name on the screen
                String fileName = file.getName();
                Button button = new Button(getApplicationContext());
                Log.d("File Name", fileName);
                // Assume editingText is the reference to the AppCompatEditText object
//                AppCompatEditText editingText = findViewById(R.id.editingText);

                button.setText(fileName);
                historyText[i] = button;
                scrollLayout.addView(historyText[i]);
                i++;
            }
        }

//        Button [] historyText = new Button[30];
//        for (int i = 0; i < 30; i++) {
//            Button button = new Button(getApplicationContext());
//            button.setText("Button " + i);
//            historyText[i] = button;
//            scrollLayout.addView(historyText[i]);
//        }
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