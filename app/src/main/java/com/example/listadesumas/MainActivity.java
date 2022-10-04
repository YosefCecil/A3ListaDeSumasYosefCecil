package com.example.listadesumas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private EditText etNum1, etNum2;
    private Button btnAdd;
    private ListView lv1;
    private double n1 = 0;
    private  double n2 = 0;
    private double res = 0;
    private ArrayList<String> sumas;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        btnAdd = findViewById(R.id.btnAdd);
        lv1 = (ListView) findViewById(R.id.lv1);

        sumas = new ArrayList<String>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_nombres, sumas);

        lv1.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

             n1 = Double.valueOf(etNum1.getText().toString());
             n2 = Double.valueOf(etNum2.getText().toString());

             res = n1 + n2;
             adapter.add(n1 + " + " + n2 + " = " + res);
             adapter.notifyDataSetChanged();

             etNum1.requestFocus();
            }
        });

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Toast.makeText(MainActivity.this, "Has pulsado:" + sumas.get(i), Toast.LENGTH_LONG).show();
            }
        });

    }


}