package com.example.bth4;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editMsg = findViewById(R.id.editMsg);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Action Bar");
        actionBar.setSubtitle("Design a custom Action Bar");
        actionBar.setLogo(R.mipmap.app_logo);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {
            editMsg.setText("Search...");
            return true;
        } else if (id == R.id.action_share) {
            editMsg.setText("Share...");
            return true;
        }
        else if (id == R.id.action_download) {
            editMsg.setText("Download...");
            return true;
        }
        else if (id == R.id.action_about) {
            editMsg.setText("About...");
            return true;
        }
        else if (id == R.id.action_settings) {
            editMsg.setText("Settings...");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}