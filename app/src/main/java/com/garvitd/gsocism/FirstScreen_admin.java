package com.garvitd.gsocism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class FirstScreen_admin extends AppCompatActivity{

    ImageView Logout_admin,administrative_admin,academic_admin,nonAcademic_admin,hostelRelated_admin,cleanliness_admin,securityAlert_admin;
    FirebaseAuth mAuth;
    String department;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen_admin);

        administrative_admin= (ImageView)findViewById(R.id.Administrative_admin);
        academic_admin= (ImageView)findViewById(R.id.Academic_admin);
        nonAcademic_admin= (ImageView)findViewById(R.id.NonAcademic_admin);
        hostelRelated_admin= (ImageView)findViewById(R.id.HostelRelated_admin);
        cleanliness_admin= (ImageView)findViewById(R.id.Cleanliness_admin);
        securityAlert_admin=(ImageView)findViewById(R.id.securityAlert_admin);

        Intent intent= new Intent(FirstScreen_admin.this,showPetitions.class);

        administrative_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                department= "administrative";
                intent.putExtra(Intent.EXTRA_TEXT,department);
                startActivity(intent);
            }
        });
        academic_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                department= "academic";
                intent.putExtra(Intent.EXTRA_TEXT,department);
                startActivity(intent);
            }
        });
        nonAcademic_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                department= "non academic";
                intent.putExtra(Intent.EXTRA_TEXT,department);
                startActivity(intent);
            }
        });
        hostelRelated_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                department= "hostel related";
                intent.putExtra(Intent.EXTRA_TEXT,department);
                startActivity(intent);
            }
        });
        cleanliness_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                department= "cleanliness and hygiene";
                intent.putExtra(Intent.EXTRA_TEXT,department);
                startActivity(intent);
            }
        });


        Logout_admin=(ImageView)findViewById(R.id.Logout_admin);
        mAuth=FirebaseAuth.getInstance();
        Logout_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent = new Intent(FirstScreen_admin.this,login_admin.class);
                startActivity(intent);
            }
        });

        securityAlert_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1= new Intent(FirstScreen_admin.this,SecurityUpdates_admin.class);
                startActivity(intent1);
            }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }

}