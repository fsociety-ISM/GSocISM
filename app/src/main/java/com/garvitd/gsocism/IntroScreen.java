package com.garvitd.gsocism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class IntroScreen extends AppCompatActivity {

    Button ToAdminBtn,ToStudentBtn;
    FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_screen);

        mAuth= FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser()!=null){

            Intent intent;
            String email_user = mAuth.getCurrentUser().getEmail();
            String email_rev = reverse(email_user);

            if(email_rev.substring(0,13).equalsIgnoreCase("ni.ca.msitii@")){
                 intent= new Intent(this,FirstScreen_admin.class);
            } else {
                 intent= new Intent(this,FirstScreen.class);
            }
            startActivity(intent);
        }

        ToAdminBtn=(Button)findViewById(R.id.ToAdminBtn);
        ToStudentBtn=(Button)findViewById(R.id.ToStudentBtn);
        ToAdminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(IntroScreen.this,login_admin.class);
                startActivity(intent);
            }
        });
        ToStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(IntroScreen.this,LoginPage.class);
                startActivity(intent);
            }
        });



    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private String reverse(String s) {
        int n = s.length();
        String rev = "";
        for(int i =n-1;i>=0;i--){
            rev =rev+(s.charAt(i));

        }

        return rev;

    }
}