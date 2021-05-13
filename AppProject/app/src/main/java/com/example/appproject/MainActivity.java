package com.example.appproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Lake> lakeArrayList = new ArrayList<>();
    private ArrayAdapter<Lake> lakeArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lakeArrayAdapter = new ArrayAdapter<Lake>(this, R.layout.list_line, R.id.list_item, lakeArrayList);//kopplar ihop xml-filen, textview elementet och listan
        ListView myListView = findViewById(R.id.lake_list);
        myListView.setAdapter(lakeArrayAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_item_1) {
            setContentView(R.layout.about);
            return true;
        }
        if (id == R.id.menu_item_2) {
            setContentView(R.layout.activity_main);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}