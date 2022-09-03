package com.android.classic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.logging.Handler;

public class StartingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setStatusBarColor(ContextCompat.getColor(StartingPage.this,R.color.turqoise));

        Thread thread= new Thread() {
            public void run() {
                try{
                    sleep(2500);

                }
                catch(Exception e){
                    e.printStackTrace();

                }
                finally{
                    Intent intent = new Intent(StartingPage.this,VisitDetails.class);
                    startActivity(intent);
                    finish();
                }
            }

        };thread.start();


    }
}