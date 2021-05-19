package com.garvitd.gsocism;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login_admin extends AppCompatActivity {

    Button loginButton;
    TextView signupbutton;
    EditText editTextemail,editTextpassword;
    ProgressBar progressBar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        editTextemail=(EditText)findViewById(R.id.email_admin);
        editTextpassword=(EditText)findViewById(R.id.password_admin);
        progressBar=(ProgressBar)findViewById(R.id.progressBar2_admin);
        progressBar.setVisibility(View.GONE);
        signupbutton=(TextView) findViewById(R.id.TosignPage);
        loginButton=(Button)findViewById(R.id.loginBtc_admin);
        mAuth=FirebaseAuth.getInstance();
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginuser();
            }
        });
        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(login_admin.this,signup_admin.class);
                startActivity(intent);
            }
        });
    }

    private void loginuser(){
        String email = editTextemail.getText().toString().trim();
        String password=editTextpassword.getText().toString().trim();


        if(email.isEmpty()){
            editTextemail.setError("Please enter your email address");
            editTextemail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextemail.setError("Please enter a valid email");
            editTextemail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editTextpassword.setError("Please enter your password");
            editTextpassword.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressBar.setVisibility(View.GONE);
                    Intent intent=new Intent(login_admin.this,FirstScreen_admin.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(),task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    @Override
    public void onBackPressed() {

        Intent intent= new Intent(this,IntroScreen.class);
        startActivity(intent);
        //super.onBackPressed();
    }
}