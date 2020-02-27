package com.example.dz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button ballActBut,flagActBut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ballActBut=findViewById(R.id.BallActBut);
        flagActBut=findViewById(R.id.FlagActBut);
        ballActBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ballIntent=new Intent(MainActivity.this,BallActivity.class);
                startActivity(ballIntent);
            }
        });
        flagActBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent flagIntent = new Intent(MainActivity.this,FlagActivity.class);
                startActivity(flagIntent);
            }
        });
    }
}