package com.example.iteng;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.iteng.R.drawable.common_google_signin_btn_icon_dark;

public class Tab1 extends Fragment {
    ArrayList<Long> value = new ArrayList<Long>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    FirebaseAuth auth = FirebaseAuth.getInstance();
    DatabaseReference myRef = database.getReference("Baza"+auth.getUid());
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_baza_act,container,false);
        ImageView button1 = (ImageView) v.findViewById(R.id.Button_baza_1);
        ImageView button2 = (ImageView) v.findViewById(R.id.Button_baza_2);
        ImageView button3 = (ImageView) v.findViewById(R.id.Button_baza_3);
        ImageView button4 = (ImageView) v.findViewById(R.id.Button_baza_4);
        ImageView button5 = (ImageView) v.findViewById(R.id.Button_baza_5);
        ImageView button6 = (ImageView) v.findViewById(R.id.Button_baza_6);
        ImageButton button_back_baza  = (ImageButton)v.findViewById(R.id.imageButton_back_baza);
        button_back_baza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);
            }
        });
        ProgressBar progressBar_baza = (ProgressBar)v.findViewById(R.id.progressBar_baza);
        TextView textView_progressbar_baza = (TextView)v.findViewById(R.id.textView_progressbar_baza);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Menu_baza_1.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Menu_baza_2.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Урок в разработке",
                        Toast.LENGTH_SHORT).show();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Урок в разработке",
                        Toast.LENGTH_SHORT).show();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Урок в разработке",
                        Toast.LENGTH_SHORT).show();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Урок в разработке",
                        Toast.LENGTH_SHORT).show();
            }
        });
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int c;
                int num;
                num=0;
                c=-1;
                for (DataSnapshot d : dataSnapshot.getChildren()){
                    Long v = d.getValue(Long.class);
                    if (!d.getKey().equals("num")) {
                        value.add(v);
                    } else{
                        continue;
                    }
                    c++;
                    switch (c){
                        case 0: if (value.get(c).intValue() ==1){button1.setImageResource(R.drawable.buttongreen);
                        num++;
                        }
                            break;
                        case 1:
                            if (value.get(c).intValue() ==1){button2.setImageResource(R.drawable.buttongreen);
                            num++;}
                            break;
                        case 2:
                            if (value.get(c).intValue() ==1){button3.setImageResource(R.drawable.buttongreen);
                            num++;}
                            break;
                        case 3:
                            if (value.get(c).intValue() ==1){button4.setImageResource(R.drawable.buttongreen);
                            num++;}
                            break;
                        case 4:
                            if (value.get(c).intValue() ==1){button5.setImageResource(R.drawable.buttongreen);
                            num++;}
                            break;
                        case 5:
                            if (value.get(c).intValue() ==1){button6.setImageResource(R.drawable.buttongreen);
                            num++;}
                            break;
                    }

                }
                progressBar_baza.setProgress(100*num/6);
                textView_progressbar_baza.setText(100*num/6+" %");
                myRef.child("num").setValue(num);
            }

            @Override
            public void onCancelled(DatabaseError error) {


            }
        });


        return v;
    }
}
