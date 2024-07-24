package com.example.bth3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView txtMsg;
    GridView gridView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtMsg = findViewById(R.id.txtMsg);
        gridView1 = findViewById(R.id.gridView1);

        ArrayAdapter aa = ArrayAdapter.createFromResource(this, R.array.data, android.R.layout.simple_list_item_1);
        gridView1.setAdapter(aa);

        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                TextView txtText = (TextView) view;
                txtMsg.setText(Integer.toString(position) + ": " + txtText.getText().toString());
            }
        });


    }
}