package com.pakistan.bsce19008.note_orious;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivityView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);
        LinearLayout layoutlinear2;
        Button back;
        ImageButton deleteContent;
        back = findViewById(R.id.backBtn2);
        deleteContent = findViewById(R.id.deleteBtn);
        layoutlinear2 = findViewById(R.id.viewScroll);

        String fileName = getIntent().getStringExtra("filename");
        Log.d("******************", "onCreate: file received:"+fileName);
        FileInputStream myFileInput = null;
        try {
            myFileInput = openFileInput(fileName);
            BufferedReader readData = new BufferedReader(new InputStreamReader(myFileInput));
            String myTextFile = readData.readLine();
            Log.d("++++++++++++++++++++++File Content", myTextFile);
            TextView text = new TextView(this);
            text.setText(myTextFile);
            text.setPadding(20, 20, 20, 20); // Set padding to 20 pixels on all sides
            layoutlinear2.addView(text);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        deleteContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
                File directory = contextWrapper.getFilesDir();
                File[] files = directory.listFiles();
                for (File file : files) {
                    if (file.isFile() && file.getName().equals(fileName)) {
                       file.delete();
                        break;
                    }
                }
                Log.d("***************", "onClick: delete calling ***********");
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }
}