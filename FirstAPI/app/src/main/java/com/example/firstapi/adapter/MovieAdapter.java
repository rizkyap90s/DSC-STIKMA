package com.example.firstapi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.firstapi.Detail;
import com.example.firstapi.MainActivity;
import com.example.firstapi.R;
import com.example.firstapi.model.Movies;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    public MovieAdapter(Context context, List<Movies> moviesList) {
        this.context = context;
        this.moviesList = moviesList;
    }

    Context context;
    List<Movies> moviesList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_rv, parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.titlemovie.setText(moviesList.get(i).getMtitle());
        holder.overview.setText(moviesList.get(i).getMoverview());
        String ratingg = Double.toString(moviesList.get(i).getMrating());
        holder.rating.setText(ratingg);

        Glide.with(context)
                .asBitmap()
                .load(moviesList.get(i).getMposter())
                .into(holder.imgmovie);


    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

       @BindView(R.id.imgmovie)
       ImageView imgmovie;

       @BindView(R.id.titlemovie)
       TextView titlemovie;

       @BindView(R.id.overview)
       TextView overview;

       @BindView(R.id.rating)
       TextView rating;


       public ViewHolder(@NonNull View itemView) {
           super(itemView);
           ButterKnife.bind(this,itemView);

           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   int post = getAdapterPosition();
                   Intent intent = new Intent(context, Detail.class);

                   intent.putExtra("title", moviesList.get(post).getMtitle());
                   intent.putExtra("overview", moviesList.get(post).getMoverview());
                   intent.putExtra("img", moviesList.get(post).getMposter());
                   intent.putExtra("rating", moviesList.get(post).getMrating());
                   intent.putExtra("backdrop", moviesList.get(post).getMbackdrop());
                   intent.putExtra("date", moviesList.get(post).getMdate());

                   context.startActivity(intent);
               }
           });
       }
   }
}
