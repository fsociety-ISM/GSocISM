package com.garvitd.gsocism;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SecurityUpdates_admin extends AppCompatActivity {

    TextView coordinates_admin,email_alert_admin;
    Button openMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_updates_admin);

        coordinates_admin=(TextView)findViewById(R.id.coordinates_admin_alert);
        email_alert_admin=(TextView)findViewById(R.id.email_alert_admin);


    }
}