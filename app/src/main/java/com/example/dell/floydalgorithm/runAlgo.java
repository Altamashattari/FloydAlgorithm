package com.example.dell.floydalgorithm;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class runAlgo extends AppCompatActivity {

    Button b;
    EditText num;
    TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_algo);
        b = (Button)findViewById(R.id.noOfNodes);
        error = (TextView)findViewById(R.id.error);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                num = (EditText)findViewById(R.id.nodes);
                String valueStr = num.getText().toString();

                if(valueStr.length()> 0 && Integer.parseInt(valueStr) > 1) {
                    error.setText("");
                    Intent i = new Intent(runAlgo.this, takeEdges.class);
                    i.putExtra("searchString", valueStr);
                    runAlgo.this.startActivity(i);
                }
                else{
                    error.setTextColor(Color.WHITE);
                    error.setText("**NUMBER OF NODES SHOULD BE GREATER THAN ONE");
                }

            }
        });
    }
}
