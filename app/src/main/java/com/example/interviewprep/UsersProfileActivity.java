package com.example.interviewprep;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;

public class UsersProfileActivity extends AppCompatActivity {
//    private ImageButton back, insertpic;
    private TextView tvfullname,tvemail,tvinstitution;
    private ProgressBar progressBar;
    private String fullname, email, institution;
    private FirebaseAuth authProfile;
    CircleImageView Profilepic;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_profile);
//        getSupportActionBar().setTitle("HOME");
//        back= findViewById(R.id.backbtn);
        Profilepic=findViewById(R.id.profilepic);
        tvfullname=findViewById(R.id.tvfullname);
        tvemail= findViewById(R.id.tvemail);
        tvinstitution=findViewById(R.id.tvins);
        progressBar = findViewById(R.id.progressBar2);
        authProfile = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = authProfile.getCurrentUser();
        if(firebaseUser == null){
            Toast.makeText(UsersProfileActivity.this, "Something is wrong! User details are not available at the moment ", Toast.LENGTH_LONG ).show();

        }else {
            checkifEmailVerified(firebaseUser);
            progressBar.setVisibility(View.VISIBLE);
            showUserProfile(firebaseUser);
        }

    }

    private void checkifEmailVerified(FirebaseUser firebaseUser) {
       if (!firebaseUser.isEmailVerified()){
           showAlertDialog();
       }
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(UsersProfileActivity.this );
        builder.setTitle("Email not verified");
        builder.setMessage("Please verify your email. You can't login without email verification.");
        builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_APP_EMAIL);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }

    private void showUserProfile(FirebaseUser firebaseUser) {
        String userID = firebaseUser.getUid();
        DatabaseReference referenceProfile = FirebaseDatabase.getInstance().getReference("Registered Users");
        referenceProfile.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ReadWriteuserdetails readuserdetails = snapshot.getValue(ReadWriteuserdetails.class);
                if (readuserdetails != null) {
                    // Use the values from the ReadWriteuserdetails class
                    fullname = firebaseUser.getDisplayName(); // If the display name is set in Firebase Auth
                    email = readuserdetails.email;
                    institution = readuserdetails.institution;

                    // Set these values to the TextViews
                    tvfullname.setText(fullname);
                    tvemail.setText(email);
                    tvinstitution.setText(institution);
                } else {
                    Toast.makeText(UsersProfileActivity.this, "User data not found", Toast.LENGTH_LONG).show();
                }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UsersProfileActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }

}