package com.example.wannacry.gridrecycler;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import static com.example.wannacry.gridrecycler.R.layout.custom_add;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerdata;
    RecyclerAdapterku adapter;
    List<Jomblo> jomblo;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init() {
        recyclerdata = findViewById(R.id.recyclerdata);
        jomblo = new ArrayList<>();
        adapter = new RecyclerAdapterku(jomblo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_data, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final EditText editnama, editstory;
        switch (item.getItemId()){
            case R.id.add:
                AlertDialog.Builder add = new AlertDialog.Builder(this);
                LayoutInflater get = getLayoutInflater();
                View v =  get.inflate(R.layout.custom_add, null, false);
                editnama = v.findViewById(R.id.editnama);
                editstory = v.findViewById(R.id.editstory);
                add
                        .setView(v)
                        .setCancelable(false)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String a = editnama.getText().toString();
                                String b = editstory.getText().toString();

                                jomblo.add(new Jomblo(a,b));

                                recyclerdata.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                                recyclerdata.setAdapter(adapter);
                            }
                        })
                        .setNegativeButton("Cancel",null);
                Dialog tampil = add.create();tampil.show();

        }
        return super.onOptionsItemSelected(item);
    }

    public void hapusaja(final int posision){

    }
}