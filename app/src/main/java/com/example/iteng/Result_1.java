package com.example.iteng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Result_1 extends AppCompatActivity {
    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Baza"+auth.getUid());
    String s;
    String clas;
    String num;
    String result;
    String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result1);
        Intent intent = getIntent();
        clas=intent.getStringExtra("class");
        result=intent.getStringExtra("result");
        num=intent.getStringExtra("num");
        value=intent.getStringExtra("value");
        DatabaseReference myRef = database.getReference(clas+auth.getUid());
        myRef.child(num).setValue(1);
        TextView textView = findViewById(R.id.textView4);
        textView.setText("Вы прошли тест на  "+String.valueOf(result)+ " баллов из "+value+" возможных");
        Button button = findViewById(R.id.button_result1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Result_1.this, Activity_Tabbed.class);
                startActivity(i);
            }
        });

    }
}