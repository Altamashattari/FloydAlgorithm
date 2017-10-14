package com.example.dell.floydalgorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Floyd1 extends AppCompatActivity {

    TextView txt;
    int n;
    int[][] graph;
    ArrayList<String> ar ;
    ListView show;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floyd1);
        show = (ListView) findViewById(R.id.result);
        ar = new ArrayList<>();
        n= getIntent().getIntExtra("numOfNodes",0);
        graph=null;
        Object[] objectArray = (Object[]) getIntent().getExtras().getSerializable("key_array_array");
        if(objectArray!=null){
            graph = new int[n][n];
            for(int i=0;i<n;i++){
                graph[i]=(int[]) objectArray[i];
            }
        }
        floydWarshall(graph,n);
    }

    void floydWarshall(int graph[][],int V)
    {
        int dist[][] = new int[V][V];
        int i, j, k;

        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];

        for (k = 0; k < V; k++)
        {
            for (i = 0; i < V; i++)
            {
                for (j = 0; j < V; j++)
                {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        // Print the shortest distance matrix
        printSolution(dist);
    }

    private void printSolution(int[][] dist) {
        StringBuilder res = new StringBuilder("");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){

                if(dist[i][j]!=99999)
                    ar.add("Distance from "+i+" to "+j+" = "+dist[i][j]);
                else
                    ar.add("Distance from "+i+" to "+j+" is ∞(infinity)");
            }
        }
        ArrayAdapter<String> adp = new ArrayAdapter<String>(Floyd1.this,android.R.layout.simple_list_item_1,ar);
        show.setAdapter(adp);
    }
}


