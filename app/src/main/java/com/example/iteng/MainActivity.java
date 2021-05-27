package com.example.iteng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



public class MainActivity extends AppCompatActivity {
    FirebaseAuth auth=FirebaseAuth.getInstance();
    FirebaseUser user = auth.getCurrentUser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_registration = (Button) findViewById(R.id.button_registration);
        Button button_login = (Button) findViewById(R.id.button_login);
        button_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Registration.class);
                startActivity(i);

            }
        });
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View v) {
                Intent i = new Intent(MainActivity.this, Login.class);
                startActivity(i);

            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        auth.signOut();
    }
}