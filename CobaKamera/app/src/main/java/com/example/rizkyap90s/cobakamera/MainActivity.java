package com.example.rizkyap90s.cobakamera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btnku, btnclr, btnnext;
    ImageView imgku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnku = findViewById(R.id.btnku);
        btnclr = findViewById(R.id.btnclr);
        imgku = findViewById(R.id.imgku);
        btnnext = findViewById(R.id.btncnext);


//        btnku.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent inten = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(inten,0);
//            }
//        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        btnclr.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                imgku.setImageResource(R.drawable.add);
            }
        });
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
//        imgku.setImageBitmap(bitmap);
//    }
}
