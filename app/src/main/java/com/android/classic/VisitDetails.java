package com.android.classic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class VisitDetails extends AppCompatActivity {

    private EditText OrderNumber,CompanyName,ContactPerson,email,phone,address,OrderDate,VisitDate,CloseDate;
    private String ONumber,CName,CPerson,Mail,Mobile,Add,ODate,VDate,CDate;
    private CheckBox Project,Demo,Other;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit_details);

        getWindow().setStatusBarColor(ContextCompat.getColor(VisitDetails.this,R.color.turqoise));
        ActivityCompat.requestPermissions(VisitDetails.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        OrderNumber=findViewById(R.id.oNumber);
        CompanyName=findViewById(R.id.CName);
        ContactPerson=findViewById(R.id.CPerson);
        email=findViewById(R.id.editTextEmailAddress);
        phone=findViewById(R.id.editTextPhone);
        address=findViewById(R.id.editTextTextPostalAddress);
        OrderDate=findViewById(R.id.oDate);
        VisitDate=findViewById(R.id.DateofVisit);
        CloseDate=findViewById(R.id.dateofClose);

        Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                updateCalendar();
            }
            private void updateCalendar() {
                String Format="dd/MM/yy";
                SimpleDateFormat sdf=new SimpleDateFormat(Format, Locale.US);
                //String
                OrderDate.setText(sdf.format(calendar.getTime()));
            }
        };

        OrderDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new DatePickerDialog(VisitDetails.this,date,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        Calendar calendar1 = Calendar.getInstance();

        DatePickerDialog.OnDateSetListener date1=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar1.set(Calendar.YEAR,year);
                calendar1.set(Calendar.MONTH,month);
                calendar1.set(Calendar.DAY_OF_MONTH,dayOfMonth);

                updateCalender1();
            }

            private void updateCalender1() {
                String Format = "dd/MM/yy";
                SimpleDateFormat sdf1=new SimpleDateFormat(Format,Locale.US);

                VisitDate.setText(sdf1.format(calendar1.getTime()));
            }
        };

        VisitDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new DatePickerDialog(VisitDetails.this,date1,calendar1.get(Calendar.YEAR),calendar1.get(Calendar.MONTH),calendar1.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        Calendar calendar2 = Calendar.getInstance();

        DatePickerDialog.OnDateSetListener date2=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar2.set(Calendar.YEAR,year);
                calendar2.set(Calendar.MONTH,month);
                calendar2.set(Calendar.DAY_OF_MONTH,dayOfMonth);

                updateCalender2();
            }

            private void updateCalender2() {
                String Format = "dd/MM/yy";
                SimpleDateFormat sdf2=new SimpleDateFormat(Format,Locale.US);

                CloseDate.setText(sdf2.format(calendar2.getTime()));
            }
        };

        CloseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new DatePickerDialog(VisitDetails.this,date2,calendar2.get(Calendar.YEAR),calendar2.get(Calendar.MONTH),calendar2.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        Project=findViewById(R.id.ProjectcheckBox1);
        Demo=findViewById(R.id.DemocheckBox2);
        Other=findViewById(R.id.OthercheckBox3);

        Button button = (Button) findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VisitDetails.this, EngineerInfo.class);
                boolean isProject=Project.isChecked(),isDemo=Demo.isChecked(),isOther=Other.isChecked();

                ONumber=OrderNumber.getText().toString();
                CName=CompanyName.getText().toString();
                CPerson=ContactPerson.getText().toString();
                Mail=email.getText().toString();
                Mobile=phone.getText().toString();
                Add=address.getText().toString();
                ODate=OrderDate.getText().toString();
                VDate=VisitDate.getText().toString();
                CDate=CloseDate.getText().toString();


                i.putExtra("V1",ONumber);
                i.putExtra("V2",CName);
                i.putExtra("V3",CPerson);
                i.putExtra("V4",Mail);
                i.putExtra("V5",Mobile);
                i.putExtra("V6",Add);
                i.putExtra("V7",ODate);
                i.putExtra("V8",VDate);
                i.putExtra("V9",CDate);
                i.putExtra("V20",isProject);
                i.putExtra("V21",isDemo);
                i.putExtra("V22",isOther);

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