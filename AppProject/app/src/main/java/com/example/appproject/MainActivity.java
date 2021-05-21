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
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

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
    private List<Lake> lakeArrayList = new ArrayList<>();
    private ArrayAdapter<Lake> adapter;
    private SQLiteDatabase database;
    private Helper helper;
    private SharedPreferences konstant;
    private SharedPreferences.Editor konstantEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        konstant = getPreferences(MODE_PRIVATE);
        konstantEdit = konstant.edit();

        helper = new Helper(this);
        database = helper.getWritableDatabase();
        database.delete(Database.Lake.TABLE_NAME,null,null);
        new JsonTask().execute("https://wwwlab.iit.his.se/brom/kurser/mobilprog/dbservice/admin/getdataasjson.php?type=c20emili");


        lakeArrayList = fetchData(konstant.getString("choice","All"));
        adapter = new ArrayAdapter<>(this, R.layout.list_textview,R.id.text_item, lakeArrayList);
        ListView lakeListView = findViewById(R.id.main_list);
        lakeListView.setAdapter(adapter);

        lakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detaljer = new Intent(MainActivity.this, Details.class);
                Lake l =lakeArrayList.get(position);
                detaljer.putExtra("wiki_link",l.getAuxdata().getWiki());
                detaljer.putExtra("text_func",l.textFunc());
                startActivity(detaljer);
            }
        });
        TextView val=findViewById(R.id.titel);
        val.setText(konstant.getString("titel","Tom"));
        Button all = findViewById(R.id.knapp_all_lake);
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                konstantEdit.putString("choice","All");
                konstantEdit.putString("titel","Alla sjöar");
                konstantEdit.apply();
                val.setText(konstant.getString("titel","Tom"));
                lakeArrayList.clear();
                lakeArrayList.addAll(fetchData(konstant.getString("choice","All")));
                Log.d("Testlist==>", "onCreate: "+lakeArrayList.toString());
                adapter.notifyDataSetChanged();
            }
        });

        Button free = findViewById(R.id.knapp_free_lake);
        free.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                konstantEdit.putString("choice","Inget");
                konstantEdit.putString("titel","Gratis fiske");
                konstantEdit.apply();
                val.setText(konstant.getString("titel","Tom"));
                lakeArrayList.clear();
                lakeArrayList.addAll(fetchData(konstant.getString("choice","All")));
                Log.d("Testlist==>", "onCreate: "+lakeArrayList.toString());
                adapter.notifyDataSetChanged();
            }
        });

        Button card = findViewById(R.id.knapp_card_lake);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                konstantEdit.putString("choice","Fiskekort");
                konstantEdit.putString("titel","Fiskekort krävs");
                konstantEdit.apply();
                val.setText(konstant.getString("titel","Tom"));
                lakeArrayList.clear();
                lakeArrayList.addAll(fetchData(konstant.getString("choice","All")));
                Log.d("Testlist==>", "onCreate: "+lakeArrayList.toString());
                adapter.notifyDataSetChanged();
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
            lakeArrayList.clear();
            try {
                Gson gson = new Gson();
                Lake[] lakes = gson.fromJson(json, Lake[].class);
                for (int i = 0; i < lakes.length; i++) {
                    Log.d("lista ==>", ""+ lakes[i].getId() +" "+ lakes[i].getName() +" "+ lakes[i].getSize() +" "+ lakes[i].getCost() +" "+ lakes[i].getLocation() +" "+ lakes[i].getCategory() +" "+ lakes[i].getAuxdata().getDepth() +" "+ lakes[i].getAuxdata().getWiki());
                    addData(lakes[i]);
                }
            }
            catch (Exception e){
                Log.d("JsonException ==>", "Error: "+ e);
            }
            lakeArrayList.addAll(fetchData(konstant.getString("choice","All")));
            Log.d("==>", "listan: "+lakeArrayList.toString());
            adapter.notifyDataSetChanged();

        }
    }

    private long addData(Lake l) {
        ContentValues values = new ContentValues();
        values.put(Database.Lake.COLUMN_NAME_NAME, l.getName());
        values.put(Database.Lake.COLUMN_NAME_SIZE, l.getSize());
        values.put(Database.Lake.COLUMN_NAME_COST, l.getCost());
        values.put(Database.Lake.COLUMN_NAME_LOCATION, l.getLocation());
        values.put(Database.Lake.COLUMN_NAME_CATEGORY, l.getCategory());
        values.put(Database.Lake.COLUMN_NAME_DEPTH, l.getAuxdata().getDepth());
        values.put(Database.Lake.COLUMN_NAME_WIKI, l.getAuxdata().getWiki());
        return database.insert(Database.Lake.TABLE_NAME, null, values);
    }
    private ArrayList<Lake> fetchData(String sort) {
        Cursor cursor = database.query(Database.Lake.TABLE_NAME, null, null, null, null, null, null);
        ArrayList<Lake> lakeDatabase =new ArrayList<>();
        while (cursor.moveToNext()) {
            if (cursor.getString(cursor.getColumnIndexOrThrow(Database.Lake.COLUMN_NAME_CATEGORY)).equals(sort)) {
                Lake templake = new Lake(
                        cursor.getLong(cursor.getColumnIndexOrThrow(Database.Lake.COLUMN_NAME_ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Database.Lake.COLUMN_NAME_NAME)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(Database.Lake.COLUMN_NAME_SIZE)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(Database.Lake.COLUMN_NAME_COST)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Database.Lake.COLUMN_NAME_LOCATION)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Database.Lake.COLUMN_NAME_CATEGORY)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(Database.Lake.COLUMN_NAME_DEPTH)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Database.Lake.COLUMN_NAME_WIKI))
                );
                lakeDatabase.add(templake);
                Log.d(sort+" ==>", "fetchData: "+templake.getName()+" "+templake.getLocation());
            }
            else if (sort.equals("All")) {
                Lake templake = new Lake(
                        cursor.getLong(cursor.getColumnIndexOrThrow(Database.Lake.COLUMN_NAME_ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Database.Lake.COLUMN_NAME_NAME)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(Database.Lake.COLUMN_NAME_SIZE)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(Database.Lake.COLUMN_NAME_COST)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Database.Lake.COLUMN_NAME_LOCATION)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Database.Lake.COLUMN_NAME_CATEGORY)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(Database.Lake.COLUMN_NAME_DEPTH)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Database.Lake.COLUMN_NAME_WIKI))
                );
                lakeDatabase.add(templake);
                Log.d(sort+" ==>", "fetchData: "+templake.getName()+" "+templake.getLocation());
            }
        }
        cursor.close();
        return lakeDatabase;
    }

}