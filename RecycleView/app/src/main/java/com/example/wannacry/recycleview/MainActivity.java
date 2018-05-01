package com.example.wannacry.recycleview;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView listdata;
    AdapterMahasiswa adapter;
    List<ModelMahasiswa> dataku;
    EditText editnama, editasal, editjk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

//        dataku.add(new ModelMahasiswa("Rizky", "paris","laki"));
//        dataku.add(new ModelMahasiswa("Raisa", "Roma","pr"));

        listdata.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        listdata.setAdapter(adapter);
    }
    private void init() {
        listdata = findViewById(R.id.listdata);
        dataku = new ArrayList<>();
        adapter = new AdapterMahasiswa(dataku);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_ku, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.addku:
                AlertDialog.Builder isi = new AlertDialog.Builder(this);
                LayoutInflater get = getLayoutInflater();
                View v = get.inflate(R.layout.addalert, null, false);
                editnama = v.findViewById(R.id.editnama);
                editasal = v.findViewById(R.id.editasal);
                editjk = v.findViewById(R.id.editjk);
                isi
                        .setView(v)
                        .setCancelable(false)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String a = editnama.getText().toString();
                                String b = editasal.getText().toString();
                                String c = editjk.getText().toString();

                                dataku.add(new ModelMahasiswa(a,b,c));
                                Toast.makeText(MainActivity.this, "Added Succcessfully", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                Dialog tampil = isi.create();tampil.show();
        }
        return super.onOptionsItemSelected(item);
    }
}