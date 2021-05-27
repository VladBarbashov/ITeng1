package com.example.iteng;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Baza_2 extends AppCompatActivity {

    int num = 1;
    FragmentManager f = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baza2);
        Button button_back_baza2 = (Button)findViewById(R.id.button_back_baza2);
        button_back_baza2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Baza_2.this, Menu_baza_2.class);
                startActivity(i);
            }
        });

    }




    public void onChange(View view){

        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.Baza_2_next:
                if (num<2){num = num + 1;}
                break;
            case R.id.Baza_2_previos:
                if (num>1){ num = num - 1;}
                break;
        }
        switch (num){

            case  1:
                if (fragment!=null){
                    remove(fragment);}
                fragment = new com.example.iteng.Fragment_baza_2_1();
                replace(fragment);
                break;
            case  2:
                if (fragment!=null){
                    remove(fragment);}
                fragment = new Fragment_baza_2_2();
                replace(fragment);
                break;
        }
        Log.d("Wow", String.valueOf(num));





    }


    public void remove(Fragment fragment){
        FragmentTransaction ft = f.beginTransaction();
        ft.remove(fragment);
        ft.commit();
    }
    public void replace(Fragment fragment){
        FragmentTransaction ft = f.beginTransaction();
        ft.replace((R.id.fragment_baza_2), fragment);
        ft.commit();

    }
}