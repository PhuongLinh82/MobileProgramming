package com.example.bth3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

public class ThirdActivity extends AppCompatActivity {

    GridView gridView2;
    Bundle myOriginalMemoryBundle;
    Integer[] thumbnails = {R.drawable.img_chania, R.drawable.img_girl, R.drawable.pic_trulli};
    Integer[] largeImages = thumbnails;
    ImageView imgSoloPhoto;
    Button btnSoloBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        myOriginalMemoryBundle = savedInstanceState;

        gridView2 = findViewById(R.id.gridView2);

        gridView2.setAdapter(new MyImageAdapter(this, thumbnails));

        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                showBigScreen(position);
            }
        });

    }

    private void showBigScreen(int position) {
        setContentView(R.layout.solo_picture);

        imgSoloPhoto = findViewById(R.id.imgSoloPhoto);

        imgSoloPhoto.setImageResource(largeImages[position]);

        btnSoloBack = findViewById(R.id.btnSoloBack);
        btnSoloBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCreate(myOriginalMemoryBundle);
            }
        });

    }
}