package com.example.wannacry.customlistviewadapter;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView list_data;
    TextView txtnama;
    AdapterCustom adapter;
    List<Mahasiswa> mhs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mhs.add(new Mahasiswa("17871878","Rizky","tokyo"));
        mhs.add(new Mahasiswa("21871428","kiki","paris"));
        mhs.add(new Mahasiswa("22871878","ade","berlin"));
        mhs.add(new Mahasiswa("31871878","Kicky","tokyo"));
        mhs.add(new Mahasiswa("15871428","jokowi","paris"));
        mhs.add(new Mahasiswa("09871878","joko","berlin"));
        mhs.add(new Mahasiswa("97871878","Widodo","tokyo"));
        mhs.add(new Mahasiswa("00871428","sapa aja boleh","paris"));
        mhs.add(new Mahasiswa("43871878","Nella Kharisma","berlin"));

        initial();
        setlistview();

    }

    private void initial() {
        txtnama=findViewById(R.id.txtnama);
        list_data=findViewById(R.id.list_data);
        adapter = new AdapterCustom(this ,mhs);
    }

    private void setlistview() {
        adapter =new AdapterCustom(this, mhs);
        list_data.setAdapter(adapter);
    }
    public void AddEdit (String nim, String nama, String asal, final int posisi){
        View v = getLayoutInflater().inflate(R.layout.custom_addedit, null);

        final EditText editnim, editnama, editasal;
        editnim = v.findViewById(R.id.editnim);
        editnama = v.findViewById(R.id.editnama);
        editasal = v.findViewById(R.id.editasal);

        editnim.setText(nim);
        editnama.setText(nama);
        editasal.setText(asal);

        AlertDialog.Builder tampil = new AlertDialog.Builder(this);
        tampil
                .setView(v)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String nim = editnim.getText().toString();
                        String nama = editnama.getText().toString();
                        String asal = editasal.getText().toString();

                        mhs.set(posisi, new Mahasiswa(nim, nama, asal));
                        adapter = new AdapterCustom(MainActivity.this, mhs);
                        list_data.setAdapter(adapter);
                    }
                })
                .setNegativeButton("Cancel", null);
        Dialog dialog = tampil.create();dialog.show();

    }
}