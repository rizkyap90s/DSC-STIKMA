package com.example.firstapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.firstapi.R.id.detail_backdrop;
import static com.example.firstapi.R.id.detail_overview;
import static com.example.firstapi.R.id.detail_poster;

public class Detail extends AppCompatActivity {

    @BindView(R.id.detail_overview)
    TextView overview;

    @BindView(R.id.detail_title)
    TextView title;

    @BindView(R.id.detail_rilis)
    TextView rilis;

    @BindView(R.id.detail_poster)
    ImageView posterr;

    @BindView(R.id.detail_rating)
    TextView rating;
    @BindView(R.id.detail_backdrop)
    ImageView backdrop;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String titl= intent.getStringExtra("title");
        String over = intent.getStringExtra("overview");
        String ril = intent.getStringExtra("date");
        String im = intent.getStringExtra("img");
        String back = intent.getStringExtra("backdrop");
        Double rate = intent.getExtras().getDouble("rating");

        Glide.with(this)
                .load(im)
                .into(posterr);
        Glide.with(this)
                .load(back)
                .into(backdrop);




        overview.setText(over);
        title.setText(titl);
        rilis.setText("Tanggal Rilis "+ril);
        rating.setText("rating : "+rate+"/10");

        if(getSupportActionBar()!= null){
            getSupportActionBar().setTitle(titl);
        }


    }
}
