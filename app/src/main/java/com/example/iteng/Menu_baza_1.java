package com.example.iteng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Menu_baza_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_baza1);
        ImageView Button_baza_1_pr = (ImageView) findViewById(R.id.button_menu_baza_1_pr);
        Button_baza_1_pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu_baza_1.this, Test_Baza_1.class);
                startActivity(i);
            }
        });

        ImageView Button_baza_1_t = (ImageView) findViewById(R.id.Button_menu_baza_1_t);
        Button_baza_1_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu_baza_1.this, Baza_1.class);
                startActivity(i);
            }
        });
        ImageButton imageButton_back_menu_baza_1 = (ImageButton)findViewById(R.id.imageButton_back_menu_baza_1);
        imageButton_back_menu_baza_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu_baza_1.this, Activity_Tabbed.class);
                startActivity(i);
            }
        });

    }
}