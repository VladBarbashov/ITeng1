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
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Test_Baza_2 extends AppCompatActivity {
    int num=1;
    int count=0;
    FragmentManager f = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_baza2);
        Button a = (Button)findViewById(R.id.Button_test_baza_2_a);
        a.setText("ДАЛЕЕ");


    }
    public void onChange(View view){
        Button a = (Button)findViewById(R.id.Button_test_baza_2_a);
        EditText b = (EditText)findViewById(R.id.plaintext_test_baza2);
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.Button_test_baza_2_a:
                num++;
                Log.d("count",String.valueOf(count));
                break;
        }
        switch (num){

            case  1:
                if (fragment!=null){
                    remove(fragment);}
                fragment = new Fragment_test_baza_2_1();
                replace(fragment);
                break;

            case  2:
                Log.d("ttt", b.getText().toString());
                if ((b.getText().toString()).equals("error")){
                    count++;
                }
                b.setText("");
                if (fragment!=null){
                remove(fragment);}
                fragment = new Fragment_test_baza_2_2();
                replace(fragment);
                break;
            case  3:if (b.getText().toString().equals("denied")){
                count++;
            }
                b.setText("");
                if (fragment!=null){
                    remove(fragment);}
                fragment = new Fragment_test_baza_2_3();
                replace(fragment);
                break;
            case  4:
                if (b.getText().toString().equals("code")){
                count++;
                }
                b.setText("");
                if (fragment!=null){
                    remove(fragment);}
                fragment = new Fragment_test_baza_2_4();
                replace(fragment);

                break;
            case  5:
                if (b.getText().toString().equals("error")){
                count++;
                }
                b.setText("");
                if (fragment!=null){
                    remove(fragment);}
                fragment = new Fragment_test_baza_2_5();
                replace(fragment);

                break;
            case  6:
                if (b.getText().toString().equals("problem")){
                    count++;
                }
                Log.d("num",String.valueOf(num));
                Log.d("count",String.valueOf(count));
                if(count>=3) {
                    Intent i = new Intent(Test_Baza_2.this, Result_1.class);
                    i.putExtra("result",String.valueOf(count));
                    i.putExtra("class","Baza");
                    i.putExtra("num", "2");
                    i.putExtra("value",String.valueOf(num));
                    startActivity(i);
                }else {
                    Intent i = new Intent(Test_Baza_2.this, Result_0.class);
                    i.putExtra("result",String.valueOf(count));
                    i.putExtra("class", "Baza");
                    i.putExtra("num","2");
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
        ft.replace((R.id.fragment_test_baza_2_1), fragment);
        ft.commit();

    }
}
