package com.example.trackandtrace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class trace extends AppCompatActivity {
    ImageView back;
    Button scanQRBtn, barcodeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trace);

        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I=new Intent(trace.this,MainActivity.class);
                startActivity(I);
            }
        });

        scanQRBtn=findViewById(R.id.qrbtn);

        scanQRBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(trace.this,ScanQrcode.class);
                startActivity(i);
            }
        });

        barcodeBtn = findViewById(R.id.barbtn);

        barcodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(trace.this,ScanQrcode.class);
                startActivity(i);
            }
        });
    }
}