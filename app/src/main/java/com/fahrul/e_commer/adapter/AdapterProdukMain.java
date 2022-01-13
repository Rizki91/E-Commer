package com.fahrul.e_commer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fahrul.e_commer.R;
import com.fahrul.e_commer.db.ProdukMode;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterProdukMain extends RecyclerView.Adapter<AdapterProdukMain.ViewHolder> {
    List<ProdukMode> data;
    Context context;

    public AdapterProdukMain(Context context, List<ProdukMode> data) {
        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public AdapterProdukMain.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_produk,parent,false);

        AdapterProdukMain.ViewHolder myViewHolder = new AdapterProdukMain.ViewHolder(view);

        return  myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProdukMain.ViewHolder holder, int position) {
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
