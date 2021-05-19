package com.garvitd.gsocism;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ViewPetitionAdmin extends AppCompatActivity {

    TextView titleViewAdmin,emailViewAdmin,textViewAdmin;
    RadioGroup radioGrpStatus;
    Button setStatusBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_petition_admin);

        Intent intent = getIntent();
        String petitionTitleAdmin = intent.getStringExtra("titleAdmin");
        String petitionText_Admin = intent.getStringExtra("petitionTextAdmin");
        String petitionEmailAdmin = intent.getStringExtra("emailAdmin");
        String department = intent.getStringExtra("department");

        titleViewAdmin=(TextView)findViewById(R.id.email_alert_admin);
        emailViewAdmin=(TextView)findViewById(R.id.coordinates_admin_alert);
        textViewAdmin=(TextView)findViewById(R.id.textMyPetition);
        radioGrpStatus=(RadioGroup)findViewById(R.id.radioGrp_status);
        setStatusBtn=(Button)findViewById(R.id.setStatusBtn);

        titleViewAdmin.setText(petitionTitleAdmin);
        emailViewAdmin.setText(petitionEmailAdmin);
        textViewAdmin.setText(petitionText_Admin);
        setStatusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateStaus(petitionTitleAdmin,petitionEmailAdmin,petitionText_Admin,department);
            }
        });
    }

    private void updateStaus(String petitionTitleAdmin, String petitionEmailAdmin, String petitionText_admin, String petitionDepartment_admin) {

        String status;
        int k = radioGrpStatus.getCheckedRadioButtonId();

        switch(k){
            case R.id.pending_status:
                status = "pending" ;
                break;
            case R.id.in_progress_status:
                status = "in progress" ;
                break;
            case R.id.resolved_status:
                status = "resolved" ;
                break;

            default:
                status = "pending";
        }

        Petition petition = new Petition(petitionEmailAdmin,petitionText_admin,status,petitionTitleAdmin);
        DatabaseReference dbUser = FirebaseDatabase.getInstance().getReference("petitions").child(petitionDepartment_admin).child(petitionTitleAdmin);
        dbUser.setValue(petition).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Intent intent = new Intent(ViewPetitionAdmin.this,FirstScreen_admin.class);
                startActivity(intent);
            }
        });

    }

}