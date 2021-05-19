package com.garvitd.gsocism;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Categories extends AppCompatActivity {

    ImageView administrative,academic,nonAcademic,hostelRelated,cleanliness,submitted_animation;
    FirebaseAuth mAuth;
    AnimatedVectorDrawableCompat avd;
    AnimatedVectorDrawable avd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        administrative=(ImageView)findViewById(R.id.Administrative);
        academic=(ImageView)findViewById(R.id.Academic);
        nonAcademic=(ImageView)findViewById(R.id.NonAcademic);
        hostelRelated=(ImageView)findViewById(R.id.Hostel_Related);
        cleanliness = (ImageView)findViewById(R.id.Cleanliness);
        mAuth= FirebaseAuth.getInstance();
        submitted_animation=(ImageView)findViewById(R.id.submitted_animation);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );

        Intent intent=getIntent();
        String petitionTextNew = intent.getStringExtra("petitionText");
        String petitionTitleNew = intent.getStringExtra("petitionTitle");

        String email = mAuth.getCurrentUser().getEmail();
        Petition petition= new Petition(email,petitionTextNew,"pending",petitionTitleNew);
        DatabaseReference dbUsers = FirebaseDatabase.getInstance().getReference("petitions");


        administrative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbUsers.child("administrative").child(petitionTitleNew).setValue(petition).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        submitted_animation.setVisibility(View.VISIBLE);


                        Drawable drawable= submitted_animation.getDrawable();
                        if(drawable instanceof AnimatedVectorDrawableCompat){
                            avd = (AnimatedVectorDrawableCompat) drawable;
                            avd.start();
                        }

                        else if(drawable instanceof AnimatedVectorDrawable){
                            avd2 = (AnimatedVectorDrawable) drawable;
                            avd2.start();
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent1 = new Intent(Categories.this,FirstScreen.class);
                                startActivity(intent1);
                            }
                        },500);
                    }
                });
            }
        });

        academic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbUsers.child("academic").child(petitionTitleNew).setValue(petition).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        submitted_animation.setVisibility(View.VISIBLE);


                        Drawable drawable= submitted_animation.getDrawable();
                        if(drawable instanceof AnimatedVectorDrawableCompat){
                            avd = (AnimatedVectorDrawableCompat) drawable;
                            avd.start();
                        }

                        else if(drawable instanceof AnimatedVectorDrawable){
                            avd2 = (AnimatedVectorDrawable) drawable;
                            avd2.start();
                        }

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent1 = new Intent(Categories.this,FirstScreen.class);
                                startActivity(intent1);
                            }
                        },500);
                    }
                });
            }
        });

        nonAcademic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbUsers.child("non academic").child(petitionTitleNew).setValue(petition).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        submitted_animation.setVisibility(View.VISIBLE);


                        Drawable drawable= submitted_animation.getDrawable();
                        if(drawable instanceof AnimatedVectorDrawableCompat){
                            avd = (AnimatedVectorDrawableCompat) drawable;
                            avd.start();
                        }

                        else if(drawable instanceof AnimatedVectorDrawable){
                            avd2 = (AnimatedVectorDrawable) drawable;
                            avd2.start();
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent1 = new Intent(Categories.this,FirstScreen.class);
                                startActivity(intent1);
                            }
                        },500);
                    }
                });
            }
        });

        hostelRelated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbUsers.child("hostel related").child(petitionTitleNew).setValue(petition).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        submitted_animation.setVisibility(View.VISIBLE);


                        Drawable drawable= submitted_animation.getDrawable();
                        if(drawable instanceof AnimatedVectorDrawableCompat){
                            avd = (AnimatedVectorDrawableCompat) drawable;
                            avd.start();
                        }

                        else if(drawable instanceof AnimatedVectorDrawable){
                            avd2 = (AnimatedVectorDrawable) drawable;
                            avd2.start();
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent1 = new Intent(Categories.this,FirstScreen.class);
                                startActivity(intent1);
                            }
                        },500);
                    }
                });
            }
        });

        cleanliness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbUsers.child("cleanliness and hygiene").child(petitionTitleNew).setValue(petition).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        submitted_animation.setVisibility(View.VISIBLE);


                        Drawable drawable= submitted_animation.getDrawable();
                        if(drawable instanceof AnimatedVectorDrawableCompat){
                            avd = (AnimatedVectorDrawableCompat) drawable;
                            avd.start();
                        }

                        else if(drawable instanceof AnimatedVectorDrawable){
                            avd2 = (AnimatedVectorDrawable) drawable;
                            avd2.start();
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent1 = new Intent(Categories.this,FirstScreen.class);
                                startActivity(intent1);
                            }
                        },500);
                    }
                });
            }
        });
    }


}