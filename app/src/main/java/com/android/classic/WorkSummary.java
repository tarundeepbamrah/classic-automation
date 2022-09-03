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

public class WorkSummary extends AppCompatActivity {

    private CheckBox completed,pending,other3;
    private EditText L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,other;
    private String Line1,Line2,Line3,Line4,Line5,Line6,Line7,Line8,Line9,Line10,mentionother;
    private String ONumber,CName,CPerson,Mail,Mobile,Add,ODate,VDate,CDate,E1Name,E2Name,E3Name,E1Phone,E2Phone,E3Phone,App;
    private boolean isproject,isdemo,isother;
    private boolean isplc,isdrive,isother2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_summary);

        getWindow().setStatusBarColor(ContextCompat.getColor(WorkSummary.this,R.color.turqoise));

        L1=findViewById(R.id.Line1);
        L2=findViewById(R.id.Line2);
        L3=findViewById(R.id.Line3);
        L4=findViewById(R.id.Line4);
        L5=findViewById(R.id.Line5);
        L6=findViewById(R.id.Line6);
        L7=findViewById(R.id.Line7);
        L8=findViewById(R.id.Line8);
        L9=findViewById(R.id.Line9);
        L10=findViewById(R.id.Line10);
        other=findViewById(R.id.othermention);

        completed=findViewById(R.id.completed);
        pending=findViewById(R.id.pending);
        other3=findViewById(R.id.other3);

        ONumber=getIntent().getExtras().getString("V1");
        CName=getIntent().getExtras().getString("V2");
        CPerson=getIntent().getExtras().getString("V3");
        Mail=getIntent().getExtras().getString("V4");
        Mobile=getIntent().getExtras().getString("V5");
        Add=getIntent().getExtras().getString("V6");
        ODate=getIntent().getExtras().getString("V7");
        VDate=getIntent().getExtras().getString("V8");
        CDate=getIntent().getExtras().getString("V9");
        E1Name=getIntent().getExtras().getString("V10");
        E2Name=getIntent().getExtras().getString("V11");
        E3Name=getIntent().getExtras().getString("V12");
        E1Phone=getIntent().getExtras().getString("V13");
        E2Phone=getIntent().getExtras().getString("V14");
        E3Phone=getIntent().getExtras().getString("V15");
        App=getIntent().getExtras().getString("V16");
        isplc=getIntent().getExtras().getBoolean("V17");
        isdrive=getIntent().getExtras().getBoolean("V18");
        isother2=getIntent().getExtras().getBoolean("V19");
        isproject=getIntent().getExtras().getBoolean("V20");
        isdemo=getIntent().getExtras().getBoolean("V21");
        isother=getIntent().getExtras().getBoolean("V22");


        Button next3 = (Button) findViewById(R.id.next3);
        Button Back2 = (Button) findViewById(R.id.BACKTO);

        Back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(WorkSummary.this, EngineerInfo.class);
                startActivity(j);
                finish();
            }
        });

        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WorkSummary.this, Signature.class);
                boolean ifcompleted=completed.isChecked(),ifpending=pending.isChecked(),ifother3=other3.isChecked();

                Line1=L1.getText().toString();
                Line2=L2.getText().toString();
                Line3=L3.getText().toString();
                Line4=L4.getText().toString();
                Line5=L5.getText().toString();
                Line6=L6.getText().toString();
                Line7=L7.getText().toString();
                Line8=L8.getText().toString();
                Line9=L9.getText().toString();
                Line10=L10.getText().toString();
                mentionother=other.getText().toString();



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
                i.putExtra("V17",isplc);
                i.putExtra("V18",isdrive);
                i.putExtra("V19",isother2);
                i.putExtra("V20",isproject);
                i.putExtra("V21",isdemo);
                i.putExtra("V22",isother);
                i.putExtra("V23",Line1);
                i.putExtra("V24",Line2);
                i.putExtra("V25",Line3);
                i.putExtra("V26",Line4);
                i.putExtra("V27",Line5);
                i.putExtra("V28",Line6);
                i.putExtra("V29",Line7);
                i.putExtra("V30",Line8);
                i.putExtra("V31",Line9);
                i.putExtra("V32",Line10);
                i.putExtra("V33",ifcompleted);
                i.putExtra("V34",ifpending);
                i.putExtra("V35",ifother3);
                i.putExtra("V36",mentionother);

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