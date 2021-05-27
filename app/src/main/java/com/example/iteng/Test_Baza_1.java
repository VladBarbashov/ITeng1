package com.example.iteng;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.dynamic.SupportFragmentWrapper;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Test_Baza_1 extends AppCompatActivity {
    int num=1;
    int count=0;
    FragmentManager f = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_baza1);
        Button a = (Button)findViewById(R.id.Button_test_baza_1_a);
        Button b = (Button)findViewById(R.id.Button_test_baza_1_b);
        Button c = (Button)findViewById(R.id.Button_test_baza_1_c);
        Button d = (Button)findViewById(R.id.Button_test_baza_1_d);
        a.setText("Case");
        b.setText("Speaker");
        c.setText("Monitor");
        d.setText("Processor");

    }
    public void onChange(View view){
        Button a = (Button)findViewById(R.id.Button_test_baza_1_a);
        Button b = (Button)findViewById(R.id.Button_test_baza_1_b);
        Button c = (Button)findViewById(R.id.Button_test_baza_1_c);
        Button d = (Button)findViewById(R.id.Button_test_baza_1_d);
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.Button_test_baza_1_a:
                if (num==1 || num==5){count++;}
                num++;
                break;
            case R.id.Button_test_baza_1_b:
                if (num==3){count++;}
                num++;
                break;
            case R.id.Button_test_baza_1_c:
                if (num==4){count++;}
                num++;
                break;
            case R.id.Button_test_baza_1_d:
                if (num==2 || num==6){count++;}
                num++;
                break;
        }
        switch (num){

            case  1:
                if (fragment!=null){
                    remove(fragment);}
                fragment = new Fragment_test_baza_1_1();
                replace(fragment);
                a.setText("Case");
                b.setText("Speaker");
                c.setText("Monitor");
                d.setText("Processor");
                break;

            case  2:
                if (fragment!=null){
                    remove(fragment);}
                fragment = new Fragment_test_baza_1_2();
                replace(fragment);
                a.setText("Printer");
                b.setText("Hard disc");
                c.setText("Keyboard");
                d.setText("Monitor");
                break;
            case  3:
                if (fragment!=null){
                    remove(fragment);}
                fragment = new Fragment_test_baza_1_3();
                replace(fragment);
                a.setText("Case");
                b.setText("Video card");
                c.setText("Microphone");
                d.setText("Operative memory");
                break;
            case  4:
                if (fragment!=null){
                    remove(fragment);}
                fragment = new Fragment_test_baza_1_4();
                replace(fragment);
                a.setText("Disc");
                b.setText("Mouse");
                c.setText("Motherboard");
                d.setText("Printer");
                break;
            case  5:
                if (fragment!=null){
                    remove(fragment);}
                fragment = new Fragment_test_baza_1_5();
                replace(fragment);
                a.setText("Mouse");
                b.setText("Hard disc");
                c.setText("Cooler");
                d.setText("Operative memory");
                break;
            case  6:
                if (fragment!=null){
                    remove(fragment);}
                fragment = new Fragment_test_baza_1_6();
                replace(fragment);
                a.setText("Case");
                b.setText("Projector");
                c.setText("Microphone");
                d.setText("Speakers");
                break;
            case  7:
                Log.d("num",String.valueOf(num));
                Log.d("count",String.valueOf(count));
                if(count>=3) {
                    Intent i = new Intent(Test_Baza_1.this, Result_1.class);
                    i.putExtra("result",String.valueOf(count));
                    i.putExtra("class","Baza");
                    i.putExtra("num", "1");
                    i.putExtra("value",String.valueOf(num-1));
                    startActivity(i);
                }else {
                    Intent i = new Intent(Test_Baza_1.this, Result_0.class);
                    i.putExtra("result",String.valueOf(count));
                    i.putExtra("class", "Baza");
                    i.putExtra("num","1");
                    i.putExtra("value",String.valueOf(num-1));
                    startActivity(i);
                }
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
        ft.replace((R.id.fragment_test_baza_1_1), fragment);
        ft.commit();

    }
}