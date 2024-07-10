package com.example.bth2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.commons.lang3.StringUtils;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    Button btnHello;
    Button btnChao;
    Button btnClearText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        btnHello = findViewById(R.id.btnHello);
        btnChao = findViewById(R.id.btnChao);
        btnClearText = findViewById(R.id.btnClearText);

        if(btnHello == null || editTextName == null || btnChao == null)
            return;

        if (editTextName.getText().toString().length() == 0)
            return;

        btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence text = "Hello " + editTextName.getText().toString();
                //editTextName.setText(text);
                Toast toast = Toast.makeText(MainActivity.this,text, Toast.LENGTH_LONG);
                toast.show();
            }
        });


        btnChao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence text = "Chao " + editTextName.getText().toString();
                Toast toast = Toast.makeText(MainActivity.this,text, Toast.LENGTH_LONG);
                toast.show();
            }
        });

        btnClearText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               editTextName.setText(StringUtils.EMPTY);
            }
        });
    }
}