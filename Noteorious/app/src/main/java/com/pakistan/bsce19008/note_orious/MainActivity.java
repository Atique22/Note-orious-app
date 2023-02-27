package com.pakistan.bsce19008.note_orious;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

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
        int i=0;
        for (File file : files) {
            if (file.isFile()) {
                String fileName = file.getName();
                Log.d("*******************File Name", fileName);
                if (file.length() > 0) {
                    try {
                        FileInputStream myFileInput = openFileInput(fileName);
                        BufferedReader readData = new BufferedReader(new InputStreamReader(myFileInput));
                        String myTextFile = readData.readLine();
                        if (myTextFile.length() > 30) {
                            String shortStr = myTextFile.substring(0, 30);
                            myTextFile = i + " : " + shortStr + ".....";
                        } else {
                            myTextFile = i + " : " + myTextFile + ".....";
                        }
                        Log.d("++++++++++++++++++++++File Content", myTextFile);
                        TextView text = new TextView(this);
                        text.setText(myTextFile);
                        text.setPadding(20, 20, 20, 20); // Set padding to 20 pixels on all sides
                        scrollLayout.addView(text);
                        text.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent i = new Intent(getApplicationContext(),MainActivityView.class);
                                String myFile = fileName.toString();
                                i.putExtra("filename", myFile);
                                startActivity(i);
                                Toast.makeText(getApplicationContext(),"clicked ****"+fileName,Toast.LENGTH_LONG).show();
                            }
                        });

                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "File is null!", Toast.LENGTH_LONG).show();
                }
                i = i + 1;
            }
        }


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