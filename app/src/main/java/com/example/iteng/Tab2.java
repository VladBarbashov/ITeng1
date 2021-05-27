package com.example.iteng;

import android.content.Intent;
import android.os.Bundle;
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
import androidx.fragment.app.FragmentActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Tab2 extends Fragment {
    ArrayList<Long> value = new ArrayList<Long>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    FirebaseAuth auth = FirebaseAuth.getInstance();
    DatabaseReference myRef = database.getReference("Profile"+auth.getUid());
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_profile_act,container,false);
        ImageView button1 = (ImageView) v.findViewById(R.id.Button_profile_1);
        ImageView button2 = (ImageView) v.findViewById(R.id.Button_profile_2);
        ImageView button3 = (ImageView) v.findViewById(R.id.Button_profile_3);
        ImageView button4 = (ImageView) v.findViewById(R.id.Button_profile_4);
        ImageView button5 = (ImageView) v.findViewById(R.id.Button_profile_5);
        ImageView button6 = (ImageView) v.findViewById(R.id.Button_profile_6);
        ImageButton button_back_profile = (ImageButton)v.findViewById(R.id.imageButton_back_profile);
        TextView textView_progressbar_profile = (TextView)v.findViewById(R.id.textView_progressbar_profile);
        button_back_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Уроки профильного уровня в разработке",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ProgressBar progressBar_profile = (ProgressBar)v.findViewById(R.id.progressBar_profile);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Уроки профильного уровня в разработке",
                        Toast.LENGTH_SHORT).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Уроки профильного уровня в разработке",
                        Toast.LENGTH_SHORT).show();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Уроки профильного уровня в разработке",
                        Toast.LENGTH_SHORT).show();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Уроки профильного уровня в разработке",
                        Toast.LENGTH_SHORT).show();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Уроки профильного уровня в разработке",
                        Toast.LENGTH_SHORT).show();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Уроки профильного уровня в разработке",
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
                        num++;}
                            break;
                        case 1:
                            if (value.get(c).intValue() ==1){button2.setImageResource(R.drawable.buttongreen);
                            num++;}
                            break;
                        case 2:
                            if (value.get(c).intValue() ==1){button3.setImageResource(R.drawable.buttongreen);
                            num++; }
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
                progressBar_profile.setProgress(100*num/6);
                textView_progressbar_profile.setText(100*num/6+" %");
                myRef.child("num").setValue(num);

            }

            @Override
            public void onCancelled(DatabaseError error) {


            }
        });
        return v;
    }
}