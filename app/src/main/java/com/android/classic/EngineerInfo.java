package com.android.classic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class EngineerInfo extends AppCompatActivity {

    private String ONumber,CName,CPerson,Mail,Mobile,Add,ODate,VDate,CDate;
    private EditText EName1,EName2,EName3,EPhone1,EPhone2,EPhone3,Application;
    private String E1Name,E2Name,E3Name,E1Phone,E2Phone,E3Phone,App;
    private CheckBox PLC,Drive,Other2;
    private boolean isproject,isdemo,isother;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engineer_info);

        getWindow().setStatusBarColor(ContextCompat.getColor(EngineerInfo.this,R.color.turqoise));

        EName1=findViewById(R.id.EngName1);
        EName2=findViewById(R.id.EngName2);
        EName3=findViewById(R.id.EngName3);
        EPhone1=findViewById(R.id.EngPhone1);
        EPhone2=findViewById(R.id.EngPhone2);
        EPhone3=findViewById(R.id.EngPhone3);
        Application=findViewById(R.id.app);

        PLC=findViewById(R.id.PLC);
        Drive=findViewById(R.id.Drive);
        Other2=findViewById(R.id.Other);

        ONumber=getIntent().getExtras().getString("V1");
        CName=getIntent().getExtras().getString("V2");
        CPerson=getIntent().getExtras().getString("V3");
        Mail=getIntent().getExtras().getString("V4");
        Mobile=getIntent().getExtras().getString("V5");
        Add=getIntent().getExtras().getString("V6");
        ODate=getIntent().getExtras().getString("V7");
        VDate=getIntent().getExtras().getString("V8");
        CDate=getIntent().getExtras().getString("V9");
        isproject=getIntent().getExtras().getBoolean("V20");
        isdemo=getIntent().getExtras().getBoolean("V21");
        isother=getIntent().getExtras().getBoolean("V22");


        Button button = (Button) findViewById(R.id.next2);
        Button Back1 = (Button) findViewById(R.id.Back1);

        Back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EngineerInfo.this, VisitDetails.class);
                startActivity(i);
                finish();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EngineerInfo.this, WorkSummary.class);
                boolean isPLC=PLC.isChecked(),isDrive=Drive.isChecked(),isOther2=Other2.isChecked();

                E1Name=EName1.getText().toString();
                E2Name=EName2.getText().toString();
                E3Name=EName3.getText().toString();
                E1Phone=EPhone1.getText().toString();
                E2Phone=EPhone2.getText().toString();
                E3Phone=EPhone3.getText().toString();
                App=Application.getText().toString();



                i.putExtra("V1",ONumber);
                i.putExtra("V2",CName);
                i.putExtra("V3",CPerson);
                i.putExtra("V4",Mail);
                i.putExtra("V5",Mobile);
                i.putExtra("V6",Add);
                i.putExtra("V7",ODate);
                i.putExtra("V8",VDate);
                i.putExtra("V9",CDate);
                i.putExtra("V10",E1Name);
                i.putExtra("V11",E2Name);
                i.putExtra("V12",E3Name);
                i.putExtra("V13",E1Phone);
                i.putExtra("V14",E2Phone);
                i.putExtra("V15",E3Phone);
                i.putExtra("V16",App);
                i.putExtra("V17",isPLC);
                i.putExtra("V18",isDrive);
                i.putExtra("V19",isOther2);
                i.putExtra("V20",isproject);
                i.putExtra("V21",isdemo);
                i.putExtra("V22",isother);
                startActivity(i);
                finish();
            }
        });

    }
    int counter=0;
    @Override
    public void onBackPressed() {
        counter++;
        if(counter==1)
            Toast.makeText(this,"Press Back again to Exit",Toast.LENGTH_SHORT).show();
        else if(counter==2)
            super.onBackPressed();

    }
}