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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Word extends AppCompatActivity {
    String text;
    String translate;
    int c;
    int num = 1;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    FragmentManager f = getSupportFragmentManager();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Word"+auth.getUid());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                c=0;
                for (DataSnapshot d : dataSnapshot.getChildren()){
                    c++;
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {


            }
        });
    }
    public void onChange(View view){
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.button_word:
                if (num<=1){num = num + 1;
                } else{num=num-1;}
                break;
        }
        Log.d("dsa", String.valueOf(num));
        switch (num){
            case  1:
                this.translate=((EditText)findViewById(R.id.word_translation)).getText().toString();
                myRef.child(String.valueOf(c)).setValue(this.text+"   "+this.translate);
                Intent intent = new Intent(Word.this, Activity_Tabbed.class);
                startActivity(intent);
            case  2:
                this.text=((EditText)findViewById(R.id.word_text)).getText().toString();
                if (fragment!=null){
                    remove(fragment);}
                fragment = new Fragment_Tab3_2();
                replace(fragment);
                break;
        }
    }
    public void remove(Fragment fragment){
        FragmentTransaction ft = f.beginTransaction();
        ft.remove(fragment);
        ft.commit();
    }
    public void replace(Fragment fragment){
        FragmentTransaction ft = f.beginTransaction();
        ft.replace((R.id.fragment_word), fragment);
        ft.commit();
    }
}