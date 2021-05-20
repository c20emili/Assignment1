package com.example.appproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class Details extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        WebView wikiped = findViewById(R.id.webview_1);
        TextView infotext =findViewById(R.id.details_text);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_item_about) {
            finish();
            Intent about = new Intent(Details.this, About.class);
            startActivity(about);
            return true;
        }
        if (id == R.id.menu_item_huvudsida) {
            finish();
            Intent main = new Intent(Details.this, MainActivity.class);
            startActivity(main);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}