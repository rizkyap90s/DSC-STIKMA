package com.example.wannacry.firstdatabase;

import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.wannacry.firstdatabase.sqlite.SQLiteOpenHelperR;

public class MainActivity extends AppCompatActivity {

    SQLiteOpenHelper dbconfig;
    SQLiteDatabase db;
    Cursor cursor;
    ListView listdata;
    FloatingActionButton fabadd;
    EditText editnama, editasal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        fabadd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                adddata();

            }
        });
    }
    private void init() {
        dbconfig= new SQLiteOpenHelperR(this);
        fabadd = findViewById(R.id.fabadd);
        listdata = findViewById(R.id.listdata);
    }

    public void adddata(){
        LayoutInflater get = getLayoutInflater();
        View v = get.inflate(R.layout.alertadd, null,false);
        editnama = v.findViewById(R.id.editnama);
        editasal = v.findViewById(R.id.editasal);

        AlertDialog.Builder isi = new AlertDialog.Builder(MainActivity.this);
        isi
                .setView(v)
                .setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        db = dbconfig.getWritableDatabase();
                        db.execSQL("insert into tb_mahasiswa (nama, asal) values ('"+editnama.getText().toString()+"','"+editasal.getText().toString()+"')");

                        Toast.makeText(MainActivity.this, "DATA ADDED", Toast.LENGTH_SHORT).show();
                        alldata();

                    }
                })
                .setNegativeButton("CANCEL", null);
        Dialog dialog=isi.create();dialog.show();
    }
    public void alldata(){
        db = dbconfig.getReadableDatabase();
        cursor = db.rawQuery("SELECT * from tb_mahasiswa ",null);
        String[] nama = new String[cursor.getCount()];
        if(cursor.getCount() != 0 ){
            for(int i=0 ; i<cursor.getCount() ; i++){
                cursor.moveToPosition(i);
                nama[i]= cursor.getString(1);
                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,nama);
                listdata.setAdapter(adapter);
             }
        }
        else{
            Toast.makeText(this, "Data Kosong", Toast.LENGTH_SHORT).show();
        }
    }
}
