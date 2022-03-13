package com.example.trackandtrace;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;

import java.io.ByteArrayOutputStream;


public class MainActivity extends AppCompatActivity {



    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Button track;
    Button trace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        nav = (NavigationView) findViewById(R.id.navmenu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        track = findViewById(R.id.button2);
        trace = findViewById(R.id.button);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I=new Intent(MainActivity.this,tracking.class);
                startActivity(I);
            }
        });

        trace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I=new Intent(MainActivity.this,trace.class);
                startActivity(I);
            }
        });

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_home:
                        Intent i = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(i);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_history:
                        Intent I = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(I);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_how:
                        Intent intent = new Intent(MainActivity.this, how_it_works.class);
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_about:
                        Intent in = new Intent(MainActivity.this, about.class);
                        startActivity(in);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_signout:
                        Intent inte = new Intent(MainActivity.this, Login.class);
                        startActivity(inte);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }

                return true;
            }
        });


    }

}