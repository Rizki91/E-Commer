package com.fahrul.e_commer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fahrul.e_commer.R;
import com.fahrul.e_commer.db.ProdukMode;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterProduk extends RecyclerView.Adapter<AdapterProduk.ViewHolder> {

    List<ProdukMode> data;
    Context context;

    public AdapterProduk(Context context, List<ProdukMode> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public AdapterProduk.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_produk,parent,false);

        AdapterProduk.ViewHolder myViewHolder = new AdapterProduk.ViewHolder(view);

        return  myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProduk.ViewHolder holder, int position) {

        holder.namaBarang.setText(data.get(position).getNAMA_BARANG());
        holder.Harga.setText(data.get(position).getHARGA());
        String imgs = data.get(position).getIMGS().replace("http", "https");
        Picasso.get().load(imgs).into(holder.imgs);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgs;
        TextView Harga, namaBarang;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgs = (ImageView) itemView.findViewById(R.id.imgProduk);
            Harga = (TextView)  itemView.findViewById(R.id.txHarga);
            namaBarang = (TextView)  itemView.findViewById(R.id.txNama);

        }
    }
}
