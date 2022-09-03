package com.android.classic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.github.gcacace.signaturepad.views.SignaturePad;
import com.google.android.material.timepicker.TimeFormat;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Signature extends AppCompatActivity {
    SignaturePad signature1,signature2;
    Bitmap bmp,scaledbmp;
    Bitmap check,scaledcheck;
    Bitmap sign1,scaledsign1;
    Bitmap sign2,scaledsign2;
    Bitmap uncheck,scaleduncheck;


    private String ONumber,CName,CPerson,Mail,Mobile,Add,ODate,VDate,CDate,E1Name,E2Name,E3Name,E1Phone,E2Phone,E3Phone,App;
    private String Line1,Line2,Line3,Line4,Line5,Line6,Line7,Line8,Line9,Line10,mentionother;
    private boolean isplc,isdrive,isother2,projectis,demois,otheris,ifcompleted,ifpending,ifother3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature);
        getWindow().setStatusBarColor(ContextCompat.getColor(Signature.this,R.color.turqoise));

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
        projectis=getIntent().getExtras().getBoolean("V20");
        demois=getIntent().getExtras().getBoolean("V21");
        otheris=getIntent().getExtras().getBoolean("V22");
        Line1=getIntent().getExtras().getString("V23");
        Line2=getIntent().getExtras().getString("V24");
        Line3=getIntent().getExtras().getString("V25");
        Line4=getIntent().getExtras().getString("V26");
        Line5=getIntent().getExtras().getString("V27");
        Line6=getIntent().getExtras().getString("V28");
        Line7=getIntent().getExtras().getString("V29");
        Line8=getIntent().getExtras().getString("V30");
        Line9=getIntent().getExtras().getString("V31");
        Line10=getIntent().getExtras().getString("V32");
        ifcompleted=getIntent().getExtras().getBoolean("V33");
        ifpending=getIntent().getExtras().getBoolean("V34");
        ifother3=getIntent().getExtras().getBoolean("V35");
        mentionother=getIntent().getExtras().getString("V36");


        bmp= BitmapFactory.decodeResource(getResources(),R.drawable.cover);
        scaledbmp= Bitmap.createScaledBitmap(bmp,1150,200,false);

        check= BitmapFactory.decodeResource(getResources(),R.drawable.check);
        scaledcheck= Bitmap.createScaledBitmap(check,30,30,false);

        uncheck= BitmapFactory.decodeResource(getResources(),R.drawable.notcheck);
        scaleduncheck= Bitmap.createScaledBitmap(uncheck,30,30,false);

        signature1=findViewById(R.id.signature_pad_1);
        Button clear1 = (Button) findViewById(R.id.clear1);

        signature2=findViewById(R.id.signature_pad_2);
        Button clear2 = (Button) findViewById(R.id.clear2);

        clear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             signature1.clear();
            }
        });

        clear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signature2.clear();
            }
        });

        Button Back4 = (Button) findViewById(R.id.back4);

        Back4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Signature.this, VisitDetails.class);
                startActivity(i);
                finish();
            }
        });


    }

    public void createMyPDF(View view) {

        PdfDocument myPdfDocument = new PdfDocument();
        PdfDocument.PageInfo myPageInfo = new PdfDocument.PageInfo.Builder(1200, 2500, 1).create();
        PdfDocument.Page myPage = myPdfDocument.startPage(myPageInfo);
        sign1=signature1.getTransparentSignatureBitmap();
        scaledsign1= Bitmap.createScaledBitmap(sign1,250,150,false);
        sign2=signature2.getTransparentSignatureBitmap();
        scaledsign2= Bitmap.createScaledBitmap(sign2,250,150,false);

        int a=0;
        Date Time=Calendar.getInstance().getTime();
        SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        String date=df.format(Time);
        String currentTime=Time.toString();

        Canvas canvas = myPage.getCanvas();
        Paint myPaint = new Paint();
        Paint myPaint2 = new Paint();
        Paint myPaint3 = new Paint();
        myPaint.setTextSize(14);

        canvas.drawBitmap(scaledbmp, 18, 0, myPaint);
        canvas.drawBitmap(scaledsign1, 40, 1770, myPaint);
        canvas.drawBitmap(scaledsign2, 900, 1770, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(280, 260, 640, 620, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(640, 260, 880, 620, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(280, 660, 640, 860, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(640, 660, 880, 860, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(280, 1320, 640, 1360, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(640, 1320, 880, 1360, myPaint);


        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 220, 1170, 260, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 260, 1170, 340, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 340, 1170, 380, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 380, 1170, 420, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 420, 1170, 460, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 460, 1170, 500, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 500, 1170, 540, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 540, 1170, 620, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 620, 1170, 660, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 660, 1170, 700, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 700, 1170, 740, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 740, 1170, 780, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 780, 1170, 820, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 820, 1170, 860, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 860, 1170, 920, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 920, 1170, 960, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 960, 1170, 1000, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 1000, 1170, 1040, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 1040, 1170, 1080, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 1080, 1170, 1120, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 1120, 1170, 1160, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 1160, 1170, 1200, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 1200, 1170, 1240, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 1240, 1170, 1280, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 1280, 1170, 1320, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 1320, 1170, 1360, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 1360, 1170, 1400, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 1400, 1170, 1440, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 1440, 1170, 1480, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 1480, 1170, 1520, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 1520, 1170, 1560, myPaint);

        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(4);
        canvas.drawRect(30, 1560, 1170, 1600, myPaint);

        //HEADINGS
        myPaint.setTextAlign(Paint.Align.CENTER);
        myPaint.setStyle(Paint.Style.FILL);
        myPaint.setTextSize(28f);
        myPaint.setColor(0xff0000ff);
        myPaint.setFakeBoldText(true);
        myPaint.setUnderlineText(true);
        myPaint.setTypeface(Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD));
        myPage.getCanvas().drawText("SERVICE REPORT", 600, 250, myPaint);
        myPage.getCanvas().drawText("ENGINEER INFORMATION", 600, 650, myPaint);
        myPage.getCanvas().drawText("WORK SUMMARY", 600, 900, myPaint);
        myPage.getCanvas().drawText("CUSTOMER SUGGESTION", 600, 1390, myPaint);


        myPaint2.setTextAlign(Paint.Align.LEFT);
        myPaint2.setStyle(Paint.Style.FILL);
        myPaint2.setTextSize(28f);
        myPaint2.setFakeBoldText(true);
        myPaint2.setUnderlineText(false);
        myPaint2.setTypeface(Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD));
        myPage.getCanvas().drawText("For", 40, 1710, myPaint2);
        myPage.getCanvas().drawText("Classic Automation & Control", 40, 1750, myPaint2);
        myPage.getCanvas().drawText("Auth. Signatory", 40, 1950, myPaint2);
        myPage.getCanvas().drawText("CORRESPONDENCE ADDRESS", 40, 2150, myPaint2);
        myPaint2.setFakeBoldText(false);
        myPaint2.setTextSize(20f);
        myPage.getCanvas().drawText("In front of Green Ply Industry,Sector -9 SIDCUL-Pantnagar", 40, 2190, myPaint2);
        myPage.getCanvas().drawText("Rudrapur, Distt:- U.S.Nagar, Uttaranchal", 40, 2230, myPaint2);
        myPage.getCanvas().drawText("PH-05944-247837,MOB:-09927800226,09927800228", 40, 2270, myPaint2);
        myPage.getCanvas().drawText("Email-control1@rediffmail.com,classic_automation@rediffmail.com", 40, 2310, myPaint2);
        myPage.getCanvas().drawText(currentTime, 470, 2470, myPaint2);

        myPaint2.setFakeBoldText(true);
        myPaint2.setTextSize(28f);
        myPaint2.setTextAlign(Paint.Align.RIGHT);
        myPage.getCanvas().drawText("For", 1160, 1710, myPaint2);
        myPage.getCanvas().drawText(CName, 1160, 1750, myPaint2);
        myPage.getCanvas().drawText("Auth. Signatory", 1160, 1950, myPaint2);
        myPage.getCanvas().drawText("COMPANY REGISTRATION DETAILS", 1160, 2150, myPaint2);
        myPaint2.setFakeBoldText(false);
        myPaint2.setTextSize(20f);
        myPage.getCanvas().drawText("Tin NO.:-05004616934", 1160, 2190, myPaint2);
        myPage.getCanvas().drawText("SERVICE TAX:-AFNPD2842PST001", 1160, 2230, myPaint2);
        myPage.getCanvas().drawText("ECC NO.:-AFNPD2842PXD", 1160, 2270, myPaint2);

        myPaint3.setTextAlign(Paint.Align.RIGHT);
        myPaint3.setStyle(Paint.Style.FILL);
        myPaint3.setTextSize(28f);
        myPaint3.setColor(0xffff0000);
        myPaint3.setFakeBoldText(true);
        myPaint3.setUnderlineText(false);
        myPaint3.setTypeface(Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD));
        myPage.getCanvas().drawText("GST NO.-05AFNPD2842P1Z6", 1160, 2310, myPaint3);

        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setStyle(Paint.Style.FILL);
        myPaint.setTextSize(20f);
        myPaint.setColor(0xff0000ff);
        myPaint.setFakeBoldText(false);
        myPaint.setUnderlineText(false);
        myPaint.setTypeface(Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD));
        myPage.getCanvas().drawText("Purchase Order Number", 40, 310, myPaint);
        myPage.getCanvas().drawText("Purchase Order Date", 650, 310, myPaint);
        myPage.getCanvas().drawText("Date of visit commenced", 40, 370, myPaint);
        myPage.getCanvas().drawText("Date of visit closed", 650, 370, myPaint);
        myPage.getCanvas().drawText("Company Name", 40, 410, myPaint);
        myPage.getCanvas().drawText("Contact Person", 40, 450, myPaint);
        myPage.getCanvas().drawText("Service Visit", 650, 450, myPaint);
        myPage.getCanvas().drawText("Phone", 40, 490, myPaint);
        myPage.getCanvas().drawText("Project", 680, 490, myPaint);
        myPage.getCanvas().drawText("Email", 40, 530, myPaint);
        myPage.getCanvas().drawText("Demo", 680, 530, myPaint);
        myPage.getCanvas().drawText("Registered Company", 40, 570, myPaint);
        myPage.getCanvas().drawText("Address City, ZIP Code", 40, 600, myPaint);
        myPage.getCanvas().drawText("Other", 680, 570, myPaint);
        myPage.getCanvas().drawText("Engineer Name", 40, 690, myPaint);
        myPage.getCanvas().drawText("Engineer Phone", 650, 690, myPaint);
        myPage.getCanvas().drawText("Engineer Name", 40, 730, myPaint);
        myPage.getCanvas().drawText("Engineer Phone", 650, 730, myPaint);
        myPage.getCanvas().drawText("Engineer Name", 40, 770, myPaint);
        myPage.getCanvas().drawText("Engineer Phone", 650, 770, myPaint);
        myPage.getCanvas().drawText("Application", 650, 810, myPaint);
        myPage.getCanvas().drawText("Product Visit For", 650, 850, myPaint);
        myPage.getCanvas().drawText("Work Completion Detail", 40, 1350, myPaint);
        myPage.getCanvas().drawText("Other", 650, 1350, myPaint);


        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setStyle(Paint.Style.FILL);
        myPaint.setTextSize(20f);
        myPaint.setColor(0xff0000ff);
        myPaint.setFakeBoldText(true);
        myPaint.setUnderlineText(false);
        myPaint.setTypeface(Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD));
        myPage.getCanvas().drawText("Contact Person Signature", 890, 410, myPaint);

        myPaint2.setTextAlign(Paint.Align.LEFT);
        myPaint2.setStyle(Paint.Style.FILL);
        myPaint2.setTextSize(20f);
        myPaint2.setFakeBoldText(false);
        myPaint2.setUnderlineText(false);
        myPaint2.setTypeface(Typeface.create(Typeface.SANS_SERIF, Typeface.NORMAL));
        myPage.getCanvas().drawText("PLC", 920, 850, myPaint2);
        myPage.getCanvas().drawText("Drive", 1000, 850, myPaint2);
        myPage.getCanvas().drawText("Other", 1080, 850, myPaint2);
        myPaint2.setFakeBoldText(true);
        myPage.getCanvas().drawText("•", 60, 950, myPaint2);
        myPage.getCanvas().drawText("•", 60, 990, myPaint2);
        myPage.getCanvas().drawText("•", 60, 1030, myPaint2);
        myPage.getCanvas().drawText("•", 60, 1070, myPaint2);
        myPage.getCanvas().drawText("•", 60, 1100, myPaint2);
        myPage.getCanvas().drawText("•", 60, 1150, myPaint2);
        myPage.getCanvas().drawText("•", 60, 1190, myPaint2);
        myPage.getCanvas().drawText("•", 60, 1230, myPaint2);
        myPage.getCanvas().drawText("•", 60, 1270, myPaint2);
        myPage.getCanvas().drawText("•", 60, 1310, myPaint2);
        myPaint2.setFakeBoldText(false);
        myPage.getCanvas().drawText("Completed", 320, 1350, myPaint2);
        myPage.getCanvas().drawText("Pending", 455, 1350, myPaint2);
        myPage.getCanvas().drawText("Other", 570, 1350, myPaint2);


        myPaint2.setTypeface(Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD));
        myPage.getCanvas().drawText(ONumber, 290, 310, myPaint2);
        myPage.getCanvas().drawText(VDate, 290, 370, myPaint2);
        myPage.getCanvas().drawText(CName, 290, 410, myPaint2);
        myPage.getCanvas().drawText(CPerson, 290, 450, myPaint2);
        myPage.getCanvas().drawText(Mobile, 290, 490, myPaint2);
        myPage.getCanvas().drawText(Mail, 290, 530, myPaint2);
        myPage.getCanvas().drawText(Add, 290, 590, myPaint2);
        myPage.getCanvas().drawText(E1Name, 290, 690, myPaint2);
        myPage.getCanvas().drawText(E2Name, 290, 730, myPaint2);
        myPage.getCanvas().drawText(E3Name, 290, 770, myPaint2);
        myPage.getCanvas().drawText(Line1, 100, 950, myPaint2);
        myPage.getCanvas().drawText(Line2, 100, 990, myPaint2);
        myPage.getCanvas().drawText(Line3, 100, 1030, myPaint2);
        myPage.getCanvas().drawText(Line4, 100, 1070, myPaint2);
        myPage.getCanvas().drawText(Line5, 100, 1110, myPaint2);
        myPage.getCanvas().drawText(Line6, 100, 1150, myPaint2);
        myPage.getCanvas().drawText(Line7, 100, 1190, myPaint2);
        myPage.getCanvas().drawText(Line8, 100, 1230, myPaint2);
        myPage.getCanvas().drawText(Line9, 100, 1270, myPaint2);
        myPage.getCanvas().drawText(Line10, 100, 1310, myPaint2);

        myPage.getCanvas().drawText(ODate, 890, 310, myPaint2);
        myPage.getCanvas().drawText(CDate, 890, 370, myPaint2);
        myPage.getCanvas().drawText(E1Phone, 890, 690, myPaint2);
        myPage.getCanvas().drawText(E2Phone, 890, 730, myPaint2);
        myPage.getCanvas().drawText(E3Phone, 890, 770, myPaint2);
        myPage.getCanvas().drawText(App, 890, 810, myPaint2);
        myPage.getCanvas().drawText(mentionother, 890, 1350, myPaint2);

        if (isplc) {
            canvas.drawBitmap(scaledcheck, 885, 825, myPaint);
        }
        else {
            canvas.drawBitmap(scaleduncheck, 885, 825, myPaint);
        }

        if (isdrive) {
            canvas.drawBitmap(scaledcheck, 965, 825, myPaint);
        }
        else {
            canvas.drawBitmap(scaleduncheck, 965, 825, myPaint);
        }

        if (isother2) {
            canvas.drawBitmap(scaledcheck, 1050, 825, myPaint);
        }
        else {
            canvas.drawBitmap(scaleduncheck, 1050, 825, myPaint);
        }

        if (projectis) {
            canvas.drawBitmap(scaledcheck, 645, 465, myPaint);
        }
        else {
            canvas.drawBitmap(scaleduncheck, 645, 465, myPaint);
        }

        if (demois) {
            canvas.drawBitmap(scaledcheck, 645, 505, myPaint);
        }
        else {
            canvas.drawBitmap(scaleduncheck, 645, 505, myPaint);
        }

        if (otheris) {
            canvas.drawBitmap(scaledcheck, 645, 545, myPaint);
        }
        else {
            canvas.drawBitmap(scaleduncheck, 645, 545, myPaint);
        }

        if (ifcompleted) {
            canvas.drawBitmap(scaledcheck, 285, 1325, myPaint);
        }
        else {
            canvas.drawBitmap(scaleduncheck, 285, 1325, myPaint);
        }

        if (ifpending) {
            canvas.drawBitmap(scaledcheck, 420, 1325, myPaint);
        }
        else {
            canvas.drawBitmap(scaleduncheck, 420, 1325, myPaint);
        }

        if (ifother3) {
            canvas.drawBitmap(scaledcheck, 535, 1325, myPaint);
        }
        else {
            canvas.drawBitmap(scaleduncheck, 535, 1325, myPaint);
        }

        myPdfDocument.finishPage(myPage);


        int number=0;
        String myFilePath= Environment.getExternalStorageDirectory().getPath() + "/Download/SR_"+date+"_"+number+".pdf";
        File file =new File(myFilePath);

        while(file.exists()) {
            number++;
            myFilePath = Environment.getExternalStorageDirectory().getPath() + "/Download/SR_"+ date+"_" +number+ ".pdf";
            file = new File(myFilePath);
        }

        File myFile=new File(myFilePath);
        try {
            myPdfDocument.writeTo(new FileOutputStream(myFile));
        }
        catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this,"Error Saving File",Toast.LENGTH_SHORT).show();
            a=1;
        }

        myPdfDocument.close();
        if(a==0) {
            Toast.makeText(this, "Pdf Saved Successfully", Toast.LENGTH_SHORT).show();
        }
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