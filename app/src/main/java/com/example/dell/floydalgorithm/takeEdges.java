package com.example.dell.floydalgorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.Intent;
import java.util.*;

import org.w3c.dom.Text;

public class takeEdges extends AppCompatActivity {

    int n ;
    EditText src,to,weight;
    TextView error;
    Button add,submit;
    int[][] matrix;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_edges);
        n = Integer.parseInt(getIntent().getStringExtra("searchString"));
        matrix = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j)
                    matrix[i][j]=99999;
            }
        }
        src = (EditText)findViewById(R.id.from);
        to = (EditText)findViewById(R.id.to);
        weight = (EditText)findViewById(R.id.weight);
        add = (Button) findViewById(R.id.add);
        submit = (Button) findViewById(R.id.Submit);
        add.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                error = (TextView)findViewById(R.id.error_display);
                //error.setText(""+n);
                if(src.getText().toString().length()==0||to.getText().toString().length()==0||Integer.parseInt(src.getText().toString())>= n || Integer.parseInt(to.getText().toString())>= n || Integer.parseInt(src.getText().toString())==Integer.parseInt(to.getText().toString()))
                {
                    //error = (TextView)findViewById(R.id.error_display);
                    error.setText("** NODE VALUE SHOULD BE BETWEEN O TO NUMBER OF NODES-1 ");
                }
                else{
                    error.setText("");
                    int source = Integer.parseInt(src.getText().toString());
                    int des = Integer.parseInt(to.getText().toString());
                    int wt = Integer.parseInt(weight.getText().toString());
                    matrix[source][des]= wt;
                    Toast.makeText(takeEdges.this,"Added to Weight matrix",Toast.LENGTH_SHORT).show();
                    src.setText("");
                    to.setText("");
                    weight.setText("");
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(takeEdges.this,Floyd1.class);
                i.putExtra("numOfNodes",n);
                Bundle mBundle = new Bundle();
                mBundle.putSerializable("key_array_array", matrix);
                i.putExtras(mBundle);
                takeEdges.this.startActivity(i);
            }
        });
    }
}
