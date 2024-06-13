package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Removable{

    Dialog1 dialogWindow;
    String text;

    ListView listView;
    ArrayAdapter adapter;

    ArrayList<String> cars = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cars.add("Honda");
        cars.add("Mazda");






        listView = findViewById(R.id.listView);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cars);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                Bundle args = new Bundle();
                args.putString("VALUE", cars.get(i));


                dialogWindow = new Dialog1();
                dialogWindow.setArguments(args);
                dialogWindow.show(getSupportFragmentManager(), "custom");
                return false;
            }
        });










        listView.setAdapter(adapter);

    }


    @Override
    public void remove(String name) {
        adapter.remove(name);
    }
}