package com.example.wannacry.login;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnmasuk;
    EditText masukemail, masukpass, daftaremail, daftarpass;

    ArrayList<Daftar> daftar = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inisial();

        btnmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean status = false;

                for(int i=0 ; i<= daftar.size() ; i++) {
                    if (daftar.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Anda Belum terdaftar", Toast.LENGTH_SHORT).show();
                        masukemail.setText("");
                        masukpass.setText("");
                    } else {
                        if (masukemail.getText().toString().equals(daftar.get(i).getEmail()) && masukpass.getText().toString().equals(daftar.get(i).getPass())) {
                            status = true;
                            break;
                        } else {
                            status = false;
                        }
                    }
                }
                if(status == true){
                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                    masukemail.setText("");
                    masukpass.setText("");
                }
                else{
                    Toast.makeText(MainActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                    masukemail.setText("");
                    masukpass.setText("");
                }

            }
        });
    }
    private void inisial() {
        btnmasuk = findViewById(R.id.btnmasuk);
        masukemail = findViewById(R.id.masukemail);
        masukpass = findViewById(R.id.masukpass);
        daftaremail = findViewById(R.id.daftaremail);
        daftarpass = findViewById(R.id.daftarpass);
    }

    public void onClickAlert(View v){
        showAlert("Sign up Form", "Enter your email and Password");
    }
    public void showAlert (String title, String isi){
        final EditText daftaremail;
        final EditText daftarpass;

        AlertDialog.Builder pesan = new AlertDialog.Builder(this);
        LayoutInflater getInflater = getLayoutInflater();
        View v = getInflater.inflate(R.layout.tampil_alert, null,false);
        daftaremail = v.findViewById(R.id.daftaremail);
        daftarpass = v.findViewById(R.id.daftarpass);
        pesan
                .setView(v)
                .setCancelable(false)
                .setPositiveButton("Sign up", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String a = daftaremail.getText().toString();
                        String b = daftarpass.getText().toString();
                        daftar.add(new Daftar(a,b));

                        Toast.makeText(MainActivity.this, "Sign up successfully", Toast.LENGTH_SHORT).show();

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
        Dialog dialog=pesan.create();dialog.show();
    }
    public void klik (View v){
        alertfb("judul", "isi");
    }
    public void alertfb (String title, String isi){
        AlertDialog.Builder lihat = new AlertDialog.Builder(this);
        LayoutInflater inflate = getLayoutInflater();
        View v = inflate.inflate(R.layout.alertfb, null, false);
        lihat
                .setView(v)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        Dialog show = lihat.create();show.show();
    }
}
