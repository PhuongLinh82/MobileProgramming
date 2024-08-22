package com.example.ontap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyDatabase database;
    public static ListView listView;
    public static List<SanPham> sanPhamList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = new MyDatabase(this);
        database.open();

        listView = findViewById(R.id.listProducts);

        prepareData();
        try {
            LoadDataToListView();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        database.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        database.close();
        super.onPause();
    }

    private void prepareData() {
        this.database.createSanPham("SP1", "Vertu Constellation", 10000);
        this.database.createSanPham("SP2", "IPhone 5S", 10000);
        this.database.createSanPham("SP3", "Nokia Lumia 925", 10000);
        this.database.createSanPham("SP4", "SamSung Galaxy S4", 10000);
        this.database.createSanPham("SP5", "HTC Desire 600", 10000);
        this.database.createSanPham("SP6", "HKPhone Revo LEAD", 10000);
    }

    private void LoadDataToListView() {
        sanPhamList = this.database.getAllSanPham();
        if (sanPhamList != null) {
            listView.setAdapter(new MyAdapter(MainActivity.this));
        }
    }
    
}