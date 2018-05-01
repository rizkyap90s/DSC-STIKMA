package com.example.wannacry.customlistviewadapter;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class AdapterCustom extends ArrayAdapter<Mahasiswa>{
    Activity context;
    List<Mahasiswa> mhs;

    public AdapterCustom(@NonNull Activity context, List<Mahasiswa> mhs) {
        super(context,R.layout.custom_view, mhs);
        this.context = context;
        this.mhs = mhs;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = context.getLayoutInflater().inflate(R.layout.custom_view,null);

        TextView txtnama, txtnim, txtasal;
        txtnim = v.findViewById(R.id.txtnim);
        txtnama = v.findViewById(R.id.txtnama);
        txtasal = v.findViewById(R.id.txtasal);

        txtnim.setText(mhs.get(position).getNim());
        txtnama.setText(mhs.get(position).getNama());
        txtasal.setText(mhs.get(position).getAsal());
        return v;
    }
}