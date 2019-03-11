package com.example.lab2_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String kohta;
    ArrayList<String> countries = new ArrayList<>();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button addBtn = findViewById(R.id.add_button);
        Button removeButton = findViewById(R.id.remove_button);
        final ListView myListView = findViewById(R.id.country_list_view);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, countries);


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText kirjoitaMaa = findViewById(R.id.text_editor);
                countries.add(kirjoitaMaa.getText().toString());
                adapter.notifyDataSetChanged();

            }
        });

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                kohta = myListView.getItemAtPosition(position).toString();
            }
        });

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countries.remove(kohta);
                adapter.notifyDataSetChanged();

            }
        });

        myListView.setAdapter(adapter);
    }
}

