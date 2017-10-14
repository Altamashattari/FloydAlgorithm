package com.example.dell.floydalgorithm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {


    Button b1,b2,b3,b4,b5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        b1 = (Button)findViewById(R.id.ps);
        b2 = (Button)findViewById(R.id.algo);
        b3 = (Button)findViewById(R.id.application);
        b4 = (Button)findViewById(R.id.example);
        b5 = (Button)findViewById(R.id.design);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,problem_stat.class);
                MainActivity.this.startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,pseudocode.class);
                MainActivity.this.startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Applications.class);
                MainActivity.this.startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,example.class);
                MainActivity.this.startActivity(i);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,runAlgo.class);
                MainActivity.this.startActivity(i);
            }
        });
    }
}
