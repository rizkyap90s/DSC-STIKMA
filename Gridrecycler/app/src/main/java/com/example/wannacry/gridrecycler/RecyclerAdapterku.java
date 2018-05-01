package com.example.wannacry.gridrecycler;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import static com.example.wannacry.gridrecycler.R.layout.custom_recycler;

public class RecyclerAdapterku extends RecyclerView.Adapter<RecyclerAdapterku.MyHolder>{

    List<Jomblo> jomblo;
    public RecyclerAdapterku(List<Jomblo> jomblo){
        this.jomblo=jomblo;
    }

    @NonNull
    @Override
    public RecyclerAdapterku.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recycler, null);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterku.MyHolder holder, final int position) {
        holder.txtnama.setText(jomblo.get(position).getNama());
        holder.txtstory.setText(jomblo.get(position).getStory());
        holder.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jomblo.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return jomblo.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView txtnama, txtstory;
        FloatingActionButton fab;
        public MyHolder(View itemView) {
            super(itemView);
            txtnama = itemView.findViewById(R.id.txtnama);
            txtstory = itemView.findViewById(R.id.txtstory);
            fab = itemView.findViewById(R.id.fab);
        }
    }
}