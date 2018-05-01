package com.example.wannacry.recycleview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterMahasiswa extends RecyclerView.Adapter<AdapterMahasiswa.MyHolder> {

    List<ModelMahasiswa> dataku;

    public AdapterMahasiswa(List<ModelMahasiswa> dataku){
        this.dataku=dataku;
    }
    @NonNull
    @Override
    public AdapterMahasiswa.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.customku,null);
        return new MyHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull AdapterMahasiswa.MyHolder holder, int position) {
        holder.txtnama.setText(dataku.get(position).getNama());
        holder.txtasal.setText(dataku.get(position).getAsal());
        if(dataku.get(position).getJk().equals("laki")){
            holder.imgku.setImageResource(R.drawable.imag);
        }
        else {
            holder.imgku.setImageResource(R.drawable.imaj);
        }
    }
    @Override
    public int getItemCount() {
        return dataku.size();
    }
    public class MyHolder extends RecyclerView.ViewHolder {
        TextView txtnama, txtasal;
        ImageView imgku;
        public MyHolder(View itemView) {
            super(itemView);
            txtnama = itemView.findViewById(R.id.txtasal   );
            txtasal = itemView.findViewById(R.id.txtasal);
            imgku = itemView.findViewById(R.id.imgku);
        }
    }
}
