package com.garvitd.gsocism;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class WritePetition extends AppCompatActivity {


    EditText petition,petitionTitle;
    Button submitPetition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_petition);

        petition=(EditText)findViewById(R.id.petition);
        submitPetition=(Button)findViewById(R.id.submitPetition);
        petitionTitle=(EditText)findViewById(R.id.petitionTitle);




        submitPetition.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                String petitionTitleText = petitionTitle.getText().toString();
                String petitionText= petition.getText().toString();

                if(petitionTitleText.length()==0){
                    petitionTitle.setError("Title cannot be empty");
                    petition.requestFocus();
                    return;
                }
                if(petitionText.length()==0){
                    petition.setError("Body of petition cannot be empty");
                    petition.requestFocus();
                    return;
                }

                Intent intent = new Intent(WritePetition.this,Categories.class);
                intent.putExtra("petitionText",petitionText);
                intent.putExtra("petitionTitle",petitionTitleText);
                startActivity(intent);




            }
        });
    }
}