package com.example.appproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Alldata> lakeArrayList = new ArrayList<>();
    private ArrayAdapter<Alldata> lakeArrayAdapter;
    private SQLiteDatabase database;
    private com.example.persistence.Helper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lakeArrayAdapter = new ArrayAdapter<>(this, R.layout.list_line, R.id.list_text, lakeArrayList);//kopplar ihop xml-filen, textview elementet och listan
        ListView myListView = findViewById(R.id.lake_list);
        myListView.setAdapter(lakeArrayAdapter);

        new JsonTask().execute("https://wwwlab.iit.his.se/brom/kurser/mobilprog/dbservice/admin/getdataasjson.php?type=c20emili");
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
            Intent about = new Intent(MainActivity.this, About.class);
            startActivity(about);
            return true;
        }
        if (id == R.id.menu_item_huvudsida) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @SuppressLint("StaticFieldLeak")
    private class JsonTask extends AsyncTask<String, String, String> {

        private HttpURLConnection connection = null;
        private BufferedReader reader = null;

        protected String doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null && !isCancelled()) {
                    builder.append(line).append("\n");
                }
                return builder.toString();
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String json) {
            Log.d("Json ==>", " : "+  json);
            try {
                Gson gson = new Gson();
                Lake[] lakes = gson.fromJson(json, Lake[].class);
                for (int i = 0; i < lakes.length; i++) {
                    Log.d("lista ==>", ""+ lakes[i]);
                }
            }
            catch (Exception e){
                Log.d("JsonException ==>", "Error: "+ e);
            }
            fetchData();
            lakeArrayAdapter.notifyDataSetChanged();
        }
    }
    private long addData(String id, String name, String company, int size, int cost, String location, String category, String depth, String wiki) {
        ContentValues values = new ContentValues();
        values.put(Database.Alldata.COLUMN_NAME_ID, id);
        values.put(Database.Alldata.COLUMN_NAME_NAME, name);
        values.put(Database.Alldata.COLUMN_NAME_COMPANY, company);
        values.put(Database.Alldata.COLUMN_NAME_SIZE, size);
        values.put(Database.Alldata.COLUMN_NAME_COST, cost);
        values.put(Database.Alldata.COLUMN_NAME_COMPANY, company);
        values.put(Database.Alldata.COLUMN_NAME_CATEGORY, category);
        values.put(Database.Alldata.COLUMN_NAME_DEPTH, depth);
        values.put(Database.Alldata.COLUMN_NAME_WIKI, wiki);
        return database.insert(Database.Alldata.TABLE_NAME, null, values);
    }
    private void fetchData(String sort) {
        Cursor cursor = database.query(Database.Alldata.TABLE_NAME, null, null, null, null, null, null);
        lakeArrayList.clear();

        while (cursor.moveToNext()) {
            if (cursor.getString(cursor.getColumnIndexOrThrow(Database.Alldata.COLUMN_NAME_CATEGORY))==sort) {
                Alldata alldata = new Alldata(
                        cursor.getString(cursor.getColumnIndexOrThrow(Database.Alldata.COLUMN_NAME_ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Database.Alldata.COLUMN_NAME_NAME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Database.Alldata.COLUMN_NAME_COMPANY)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(Database.Alldata.COLUMN_NAME_SIZE)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(Database.Alldata.COLUMN_NAME_COST)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Database.Alldata.COLUMN_NAME_LOCATION)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Database.Alldata.COLUMN_NAME_CATEGORY)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Database.Alldata.COLUMN_NAME_DEPTH)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Database.Alldata.COLUMN_NAME_WIKI))
                );
                lakeArrayList.add(alldata);
            }
            else if (sort=="ALL") {
                Alldata alldata = new Alldata(
                        cursor.getString(cursor.getColumnIndexOrThrow(Database.Alldata.COLUMN_NAME_ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Database.Alldata.COLUMN_NAME_NAME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Database.Alldata.COLUMN_NAME_COMPANY)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(Database.Alldata.COLUMN_NAME_SIZE)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(Database.Alldata.COLUMN_NAME_COST)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Database.Alldata.COLUMN_NAME_LOCATION)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Database.Alldata.COLUMN_NAME_CATEGORY)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Database.Alldata.COLUMN_NAME_DEPTH)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Database.Alldata.COLUMN_NAME_WIKI))
                );
                lakeArrayList.add(alldata);
            }
            else{
                Log.d("Sort ==>", ""+ sort);
            }
        }
        cursor.close();
        return;
    }
}