package com.example.appproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        Button back = findViewById(R.id.button_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button fish = findViewById(R.id.button_fish);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        Button info = findViewById(R.id.button_fishing_info);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
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
        if (id == R.id.menu_item_settings) {
            finish();
            return true;
        }
        if (id == R.id.menu_item_fiskar) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}