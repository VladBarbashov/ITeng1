package com.example.iteng;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Menu_baza_2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_baza2);
        ImageView Button_baza_2_pr = (ImageView) findViewById(R.id.button_menu_baza_2_pr);
        Button_baza_2_pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu_baza_2.this, Test_Baza_2.class);
                startActivity(i);
            }
        });

        ImageView Button_baza_2_t = (ImageView) findViewById(R.id.Button_menu_baza_2_t);
        Button_baza_2_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu_baza_2.this, Baza_2.class);
                startActivity(i);
            }
        });
        ImageButton imageButton_back_menu_baza_2 = (ImageButton)findViewById(R.id.imageButton_back_menu_baza_2);
        imageButton_back_menu_baza_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu_baza_2.this, Activity_Tabbed.class);
                startActivity(i);
            }
        });

    }
}
