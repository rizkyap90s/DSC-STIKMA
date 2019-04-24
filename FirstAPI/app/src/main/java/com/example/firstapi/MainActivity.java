package com.example.firstapi;

import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.os.Build;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.firstapi.adapter.MovieAdapter;
import com.example.firstapi.api.Client;
import com.example.firstapi.api.Service;
import com.example.firstapi.model.MovieRespone;
import com.example.firstapi.model.Movies;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.mainview)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.rv)
    RecyclerView rv;

    ProgressDialog pd;

    List<Movies> movies;
    MovieAdapter adapter;
    Movies movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initview();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initview();
            }
        });


    }

    private void initview() {
        pd = new ProgressDialog(this);
        pd.setMessage("Fetching Movie");
        pd.setCancelable(false);
        pd.show();

        if(MainActivity.this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            rv.setLayoutManager(new GridLayoutManager(this, 2));
        }
        else {
            rv.setLayoutManager(new GridLayoutManager(this, 4));
        }

        movies = new ArrayList<>();
        adapter = new MovieAdapter(MainActivity.this, movies);
        rv.setAdapter(adapter);
        
        loadjson();
    }

    private void loadjson() {

        try{
            Client client =new Client();
            Service apiservice = client.getClient().create(Service.class);

            Call<MovieRespone> call = apiservice.getNowPlayingMovie(BuildConfig.API_KEY);

            call.enqueue(new Callback<MovieRespone>() {
                @Override
                public void onResponse(Call<MovieRespone> call, Response<MovieRespone> response) {
                    List<Movies> movies = response.body().getMresult();
                    rv.setAdapter(new MovieAdapter(MainActivity.this, movies));

                    if(swipeRefreshLayout.isRefreshing()){
                        swipeRefreshLayout.setRefreshing(false);
                    }
                    pd.dismiss();

                }

                @Override
                public void onFailure(Call<MovieRespone> call, Throwable t) {
                    Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();

                }
            });

        }catch (Exception e){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }


    }
}
