package com.pakistan.bsce19008.note_orious;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

public class MainActivityEditing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_editing);
        Button back,save;
        EditText messageText;// The text you want to save
        messageText = findViewById(R.id.editingText);
        back = findViewById(R.id.backBtn);
        save = findViewById(R.id.saveBtn);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String fileName = "myFile_" + System.currentTimeMillis() + ".txt"; // Generate a unique file name based on the current time
                        // Create a new file and write the text to it
                        try {
                            //internal storage
                            String data = new String(messageText.toString());
                            File dir = getFilesDir();
                            File createFile = new File(dir, fileName);
                            FileWriter fw = new FileWriter(createFile);
                            fw.write(data);
                            fw.close();
                            // Show a  message to indicate that the file was saved successfully
                            Log.d("************************", "save: created file successfully*****************: "+fileName);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();

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