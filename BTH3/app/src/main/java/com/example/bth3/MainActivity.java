package com.example.bth3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtSelection;
    Spinner spinner1;
    String [] items = {
            "Khoa Quản Trị Kinh Doanh",
            "Khoa Kế Toán Kiểm Toán",
            "Khoa Tài Chính - Ngân hàng",
            "Khoa Kinh tế và Luật",
            "Khoa Công Nghệ Thông Tin",
            "Khoa Công Nghệ Sinh Học",
            "Khoa Xây Dựng và Điện",
            "Khoa Ngoại Ngữ"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSelection = findViewById(R.id.txtSelection);
        spinner1 = findViewById(R.id.spinner1);

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);

        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(aa);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                txtSelection.setText(items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}