package com.fahrul.e_commer.fragmen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fahrul.e_commer.R;
import com.fahrul.e_commer.adapter.AdapterMain;
import com.fahrul.e_commer.adapter.AdapterProduk;
import com.fahrul.e_commer.db.AppDataBase;
import com.fahrul.e_commer.db.KategoriDao;
import com.fahrul.e_commer.db.KategoriMdel;
import com.fahrul.e_commer.db.LoginDao;
import com.fahrul.e_commer.db.LoginModel;
import com.fahrul.e_commer.db.ProdukDao;
import com.fahrul.e_commer.db.ProdukMode;
import com.fahrul.e_commer.directori.LayoutMarginDecoration;
import com.fahrul.e_commer.directori.Tools;
import com.fahrul.e_commer.model.ProdukDataApi;
import com.fahrul.e_commer.service.APIInterfacesRest;
import com.fahrul.e_commer.service.ApiClinet;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProdukFragmen extends Fragment {

    AppDataBase appDataBase;
    KategoriDao kategoriDao;
    KategoriMdel kategoriMdel;
    RecyclerView ryProduk;
    LayoutMarginDecoration grid;
    ProdukDao produkDao;
    LoginDao loginDao;
    AdapterProduk adapterProduk;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmen_produk, container, false);


        ryProduk = view.findViewById(R.id.ryProduk);

        GridLayoutManager mLayout = new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false);
        ryProduk.setLayoutManager(mLayout);
        grid = new LayoutMarginDecoration(2, Tools.dp2px(getContext(), 2));
        ryProduk.addItemDecoration(grid);
        ryProduk.setHasFixedSize(true);

        InitData();

        return view;

    }

    public void InitData() {
        appDataBase = AppDataBase.getInstance(getContext());
        kategoriDao = appDataBase.getKategori();
        loginDao = appDataBase.getLoginDao();
        produkDao = appDataBase.getProduk();


        LoginModel loginModel = loginDao.getAll();
        List<ProdukMode> produkModel = produkDao.getIdProdukALL();

//        if (produkModel.size() > 0) {
//            AdapterProduk adapterProduk = new AdapterProduk(getContext(), produkModel);
//            ryProduk.setAdapter(adapterProduk);
//
//        } else {
            callProduk(loginModel.getIDTIER());
//        }

    }

    APIInterfacesRest apiInterfacesRest;
    public void callProduk(String idTier) {
        apiInterfacesRest = ApiClinet.getClient().create(APIInterfacesRest.class);
        produkDao = appDataBase.getProduk();
        loginDao = appDataBase.getLoginDao();


        Call<ProdukDataApi> addKategori = apiInterfacesRest.getProduk(
                idTier, "", ""
        );


        addKategori.enqueue(new Callback<ProdukDataApi>() {
            @Override
            public void onResponse(Call<ProdukDataApi> call, Response<ProdukDataApi> response) {


                if (response.isSuccessful()) {

                    ProdukDataApi data = response.body();

                    if (data.getData() != null) {

                        ProdukMode produkMode = produkDao.getProdukOne();


                        ProdukMode produkMode1 = new ProdukMode();
                        for (int i = 0; i < data.getData().size(); i++) {
                            produkMode1.setID_PRODUK(data.getData().get(i).getIdProduct());
                            produkMode1.setNAMA_BARANG(data.getData().get(i).getNamaBarang());
                            produkMode1.setHARGA(data.getData().get(i).getHarga());
                            produkMode1.setHARGA_DISKON(data.getData().get(i).getHrgDiskon());
                            produkMode1.setDISKON(data.getData().get(i).getDiskon());
                            produkMode1.setQTY(data.getData().get(i).getQty());
                            produkMode1.setPAKET(data.getData().get(i).getPaket());
                            produkMode1.setDESKRIPSI(data.getData().get(i).getDeskripsi());
                            produkMode1.setIMGS(data.getData().get(i).getImg());
                            produkDao.deleteById(produkMode1.getID_PRODUK());
                            produkDao.Insert(produkMode1);
                        }
                        List<ProdukMode> produkALL = produkDao.getIdProdukALL();

                        if(produkALL != null){
                            AdapterProduk adapterMain = new AdapterProduk(getContext(), produkALL);

                            ryProduk.setAdapter(adapterMain);

                        }


                    }
                }
            }

            @Override
            public void onFailure(Call<ProdukDataApi> call, Throwable t) {

            }
        });


    }
}
