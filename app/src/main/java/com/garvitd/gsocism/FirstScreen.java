package com.garvitd.gsocism;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class FirstScreen extends AppCompatActivity {

    NavigationView NavView;
    ActionBarDrawerToggle Toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    FirebaseAuth mAuth;
    TextView ToPetitionPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavView=(NavigationView)findViewById(R.id.navmenu);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);

        ToPetitionPage = (TextView)findViewById(R.id.ToCategory);
        ToPetitionPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(FirstScreen.this,WritePetition.class);
                startActivity(intent);
            }
        });

        Toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(Toggle);
        Toggle.syncState();

        NavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.menu_profile :
                        Intent intent = new Intent(FirstScreen.this,MyProfile.class);
                        startActivity(intent);
                        finish();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_emerg :
                        Intent intent1 = new Intent(FirstScreen.this, FeelingUnsafe.class);
                        startActivity(intent1);
                        finish();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_logout :

                        mAuth= FirebaseAuth.getInstance();
                        mAuth.signOut();
                        Intent intent2 = new Intent(FirstScreen.this,IntroScreen.class);
                        startActivity(intent2);
                        finish();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_alerts:

                        Intent intent3 = new Intent(FirstScreen.this,SecurityUpdates_admin.class);
                        startActivity(intent3);
                        finish();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }


                return true;
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