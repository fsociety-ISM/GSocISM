package com.garvitd.gsocism;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class showPetitions extends AppCompatActivity {

    private RecyclerView showPetition_admin_recyclerView;
    petitionAdapter petitionAdapter;
    private List<Petition> petitionList;
    String departments;
    ProgressBar progressBar_show_petition;
    TextView textView1a,textView2a,textView3a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_petitions);

        textView1a=(TextView)findViewById(R.id.textView1a);
        textView2a=(TextView)findViewById(R.id.textView2a);
        textView3a=(TextView)findViewById(R.id.textView3a);

        textView1a.setBackgroundColor(Color.RED);
        textView2a.setBackgroundColor(Color.YELLOW);
        textView3a.setBackgroundColor(Color.GREEN);

        progressBar_show_petition=(ProgressBar)findViewById(R.id.progressBar_show_petition);
        Intent intent = getIntent();
        departments = intent.getStringExtra(Intent.EXTRA_TEXT);


        loadusers();
    }

    public void loadusers() {


        petitionList = new ArrayList<>();
        showPetition_admin_recyclerView = (RecyclerView) findViewById(R.id.show_petition_admin);
        showPetition_admin_recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DatabaseReference dbusers= FirebaseDatabase.getInstance().getReference("petitions").child(departments);
        dbusers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot dsUser: snapshot.getChildren()){
                        Petition petition = dsUser.getValue(Petition.class);
                        petitionList.add(petition);
                    }
                    progressBar_show_petition.setVisibility(View.GONE);
                    petitionAdapter petitionAdapter = new petitionAdapter(showPetitions.this,petitionList,departments);
                    showPetition_admin_recyclerView.setAdapter(petitionAdapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}