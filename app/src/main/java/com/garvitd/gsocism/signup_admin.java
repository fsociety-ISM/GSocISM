package com.garvitd.gsocism;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class signup_admin extends AppCompatActivity {

    EditText editTextemail_admin, editTextpassword_admin, editTextName_admin;
    ProgressBar progressbar;
    private FirebaseAuth mAuth;
    TextView backtologin_admin;
    Button SignUpButton_admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_admin);

        editTextemail_admin =(EditText) findViewById(R.id.emailAddress_admin);
        editTextpassword_admin =(EditText) findViewById(R.id.password_signup_admin);
        editTextName_admin =(EditText)findViewById(R.id.name_admin);
        progressbar=(ProgressBar)findViewById(R.id.progressBar_admin);
        mAuth = FirebaseAuth.getInstance();
        backtologin_admin =(TextView) findViewById(R.id.backtologin_admin);
        SignUpButton_admin =(Button)findViewById(R.id.SignUpButton_admin);
        SignUpButton_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser_Admin();
            }
        });
        backtologin_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(signup_admin.this,login_admin.class);
                startActivity(intent);
            }
        });

    }



    public void registerUser_Admin() {
        String email = editTextemail_admin.getText().toString().trim();
        String password= editTextpassword_admin.getText().toString().trim();
        String name= editTextName_admin.getText().toString().trim();

        String email_2= reverse(email);
        if(email.length()==0){
            editTextemail_admin.setError("Please enter your email address");
            editTextemail_admin.requestFocus();
            return;
        } else {
            if(email_2.substring(0,13).equalsIgnoreCase("ni.ca.msitii@")){

                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    editTextemail_admin.setError("Please enter a valid email");
                    editTextemail_admin.requestFocus();
                    return;
                }
                if(password.isEmpty()){
                    editTextpassword_admin.setError("Please enter your password");
                    editTextpassword_admin.requestFocus();
                    return;
                }
                if(name.isEmpty()){
                    editTextName_admin.setError("Please enter your name");
                    editTextName_admin.requestFocus();
                    return;
                }
                progressbar.setVisibility(View.VISIBLE);
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressbar.setVisibility(View.GONE);
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "User registered successfully", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(signup_admin.this,FirstScreen_admin.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        } else {
                            if(task.getException() instanceof FirebaseAuthUserCollisionException){
                                Toast.makeText(getApplicationContext(), "Email is already registered", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "An unexpected error occurred.Please try again or check your internet connection", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });

            }
            else{
                editTextemail_admin.setError("Please login with your college email credentials (as an administrator, students are not allowed here)");
                editTextemail_admin.requestFocus();
                return;
            }
        }




    }

    @Override
    public void onBackPressed() {
        Intent intent= new Intent(this,login_admin.class);
        startActivity(intent);
        //super.onBackPressed();
    }

    public String reverse(String s){
        int n = s.length();
        String rev = "";
        for(int i =n-1;i>=0;i--){
            rev =rev+(s.charAt(i));

        }

        return rev;
    }

}