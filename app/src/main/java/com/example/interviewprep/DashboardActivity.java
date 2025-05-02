package com.example.interviewprep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class DashboardActivity extends AppCompatActivity {
    ImageView HR, DSA, Coding, Quants, DILR, Verbal;
    ImageButton Home, Profile, Settings, Options, TakeTest;
CircleImageView Bot;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);  // Move this line to the beginning

        // Now initialize the views
        HR = findViewById(R.id.hr);
        DSA = findViewById(R.id.dsa);
        Coding = findViewById(R.id.lang);
        Quants = findViewById(R.id.quants);
        DILR = findViewById(R.id.logical);
        Verbal = findViewById(R.id.verbal);
        Home = findViewById(R.id.homedash);
        Settings = findViewById(R.id.settings);
        Profile = findViewById(R.id.profile);
        Options = findViewById(R.id.options);
        TakeTest = findViewById(R.id.test);
        Bot = findViewById(R.id.bot);

        // Set the click listeners
        HR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, HRActivity.class);
                startActivity(i);
            }
        });
        Coding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, CodingActivity.class);
                startActivity(i);
            }
        });
        DSA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, DSAActivity.class);
                startActivity(i);
            }
        });
        Quants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, QuantsActivity.class);
                startActivity(i);
            }
        });
        DILR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, DILRActivity.class);
                startActivity(i);
            }
        });
        Verbal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, VerbalActivity.class);
                startActivity(i);
            }
        });
        // Add other onClickListeners as needed
        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, UsersProfileActivity.class);
                startActivity(i);
            }
        });
    }
}
