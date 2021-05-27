package com.example.iteng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {
    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        EditText email_edittext = ((EditText)findViewById(R.id.plaintext_login_r));
        EditText password_edittext = ((EditText)findViewById(R.id.Password_password_r));
        TextView textview = findViewById(R.id.textView_register);
        email_edittext.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (email_edittext.getText().toString().equals("ЭЛЕКТРОННАЯ ПОЧТА")){
                    email_edittext.setText("");
                }
            }
        });
        password_edittext.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (password_edittext.getText().toString().equals("")&&!textview.getText().toString().equals("")){
                    textview.setText("");
                }
            }
        });

        ImageView button_registration_back = findViewById(R.id.button_registration_back);
        button_registration_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Registration.this, MainActivity.class);
                startActivity(i);
            }
        });
        ImageButton button_fill_r = (ImageButton) findViewById(R.id.button_fill_r);
        button_fill_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = null;
                String password = null;
                if (!email_edittext.getText().toString().equals("")&& !password_edittext.getText().toString().equals("")) {
                    email = email_edittext.getText().toString();
                    password = password_edittext.getText().toString();
                } else {
                    email="1";
                    password="1";
                }
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Registration.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    user = auth.getCurrentUser();
                                    Intent i = new Intent(Registration.this, com.example.iteng.MainActivity.class);
                                    Toast.makeText(Registration.this, "Пользователь успешно зхарегестрирован",
                                            Toast.LENGTH_SHORT).show();
                                    startActivity(i);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(Registration.this, "ЧТО-ТО ПОШЛО НЕ ТАК",
                                            Toast.LENGTH_SHORT).show();

                                }

                            }
                        });
            }

        });

    }
}