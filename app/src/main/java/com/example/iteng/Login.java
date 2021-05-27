package com.example.iteng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    String email;
    String name;
    String uid;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText email_edittext = ((EditText)findViewById(R.id.plaintext_login_l));
        EditText password_edittext = ((EditText)findViewById(R.id.Password_password_l));
        email_edittext.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (email_edittext.getText().toString().equals("ЭЛЕКТРОННАЯ ПОЧТА")){
                    email_edittext.setText("");
                }
            }
        });
        ImageView button_login_back = findViewById(R.id.button_login_back);
        button_login_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, MainActivity.class);
                startActivity(i);
            }
        });
        ImageView button_fill_l = (ImageView) findViewById(R.id.button_fill_l);
        button_fill_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email;
                String password;
                if (!email_edittext.getText().toString().equals("")&& !password_edittext.getText().toString().equals("")) {
                    email = email_edittext.getText().toString();
                    password = password_edittext.getText().toString();
                } else {
                    email="1";
                    password="1";
                }
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    GoogleSignInOptions gso = new GoogleSignInOptions
                                            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                                            .requestIdToken(getString(R.string.default_web_client_id))
                                            .requestEmail()
                                            .build();
                                    user = auth.getCurrentUser();
                                    name = user.getDisplayName();
                                    GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(Login.this, gso);
                                    uid = user.getUid();
                                    setEmail(user.getEmail());
                                    Intent i = new Intent(Login.this, Activity_Tabbed.class);
                                    startActivity(i);
                                    Log.d("user",user.getEmail());
                                } else {
                                    Toast.makeText(Login.this, "Неверный логин или пароль.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });


    }
    protected String getEmail(){
        return email;
    }
    protected void setEmail(String email){
        this.email=email;
        Log.d("eman", email);
    }
}