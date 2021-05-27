package com.example.iteng;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Profile_1 extends AppCompatActivity {
    FragmentManager f = getSupportFragmentManager();
    int num = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_1);
        Button button_back_profile1 = (Button)findViewById(R.id.button_back_profile1);
        button_back_profile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Profile_1.this, Activity_Tabbed.class);
                startActivity(i);
            }
        });
    }
    public void onChange(View view){

        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.Profile_1_next:
                if (num<=1){num = num + 1;}

                break;
            case R.id.Profile_1_previos:
                if (num>1){ num = num - 1;}
                break;
        }
        switch (num){

            case  1:
                if (fragment!=null){
                    remove(fragment);}
                fragment = new com.example.iteng.Fragment_profile_1_1();
                replace(fragment);
                break;
            case  2:
                if (fragment!=null){
                    remove(fragment);}
                fragment = new Fragment_profile_1_2();
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
        ft.replace((R.id.fragment_profile_1), fragment);
        ft.commit();

    }
}