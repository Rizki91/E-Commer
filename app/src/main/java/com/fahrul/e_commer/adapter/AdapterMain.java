package com.fahrul.e_commer.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.fahrul.e_commer.R;
import com.fahrul.e_commer.db.KategoriMdel;
import com.fahrul.e_commer.model.CategoryDataAPi;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Callback;

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.ViewHolder> {


    List<KategoriMdel> data;
    Context context;

    public AdapterMain(Context context, List<KategoriMdel> data) {
        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public AdapterMain.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main,parent,false);

        ViewHolder myViewHolder = new ViewHolder(view);

        return  myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMain.ViewHolder holder, int position) {

        holder.txKategori.setText(data.get(position).getNAMAKATEGORI());
        String imgs = data.get(position).getIMAGE().replace("http", "https");
        Picasso.get().load(imgs).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setClickListener(Callback<CategoryDataAPi> categoryDataAPiCallback) {
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position, List<KategoriMdel> data);

    }
    public KategoriMdel getItem(int id) {
        return data.get(id);
    }

    private ItemClickListener mClickListener;

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView img ;
        TextView txKategori;
        CardView cvMain;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.imgsMain);
            txKategori = (TextView) itemView.findViewById(R.id.txMain);
            cvMain = (CardView) itemView.findViewById(R.id.cvMain);
            cvMain.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) mClickListener.onItemClick(v, this.getAdapterPosition(),data);
        }
    }


}
