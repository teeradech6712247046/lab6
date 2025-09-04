package com.example.lab6;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;

public class AddNoteActivity extends AppCompatActivity {
    Button addBack;

    Button addButton;

    EditText title,textContent,name,id;

    TextView display;

    TextView display1;

    Button addcheck;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_note);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addBack = findViewById(R.id.button6);//event aource
        addBack.setOnClickListener(new View.OnClickListener() {//event listener
            @Override
            public void onClick(View view) {//event handler
                System.out.println("Click!!");
                Intent addBack = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(addBack);
            }

        });
        addButton = findViewById(R.id.button2);
        title = findViewById(R.id.editTextText);
        textContent = findViewById(R.id.editTextText2);
        display = findViewById(R.id.textView3);
        display1 = findViewById(R.id.textView4);
        addcheck = findViewById(R.id.button3);
        name = findViewById(R.id.editTextText3);
        id = findViewById(R.id.editTextText4);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get data from user (EditText)
                String strOfTitle = title.getText().toString();
                String strOfContent = textContent.getText().toString();

                String strOfDate = new Date().toString();


                //set data to TextNote class
                TextNote note1 = new TextNote();
                note1.setTitle(strOfTitle);

                note1.setTextContent(strOfContent);

                note1.createdDate = strOfDate;

                //show note on TextView
                display.setText(note1.getSummary());
            }
        });
        addcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strOfTitle = title.getText().toString();
                String strOfDate = new Date().toString();

                ChecklistNote note1 = new ChecklistNote();
                note1.setTitle(strOfTitle);

                note1.createdDate = strOfDate;

                display1.setText(note1.getSummary());
            }
        });
    }
}