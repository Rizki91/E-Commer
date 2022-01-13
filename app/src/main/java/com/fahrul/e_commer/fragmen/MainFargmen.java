package com.fahrul.e_commer.fragmen;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fahrul.e_commer.MainActivity;
import com.fahrul.e_commer.R;
import com.fahrul.e_commer.adapter.AdapterMain;
import com.fahrul.e_commer.adapter.AdapterProdukMain;
import com.fahrul.e_commer.db.AppDataBase;
import com.fahrul.e_commer.db.KategoriDao;
import com.fahrul.e_commer.db.KategoriMdel;
import com.fahrul.e_commer.db.LoginDao;
import com.fahrul.e_commer.db.LoginModel;
import com.fahrul.e_commer.db.ProdukDao;
import com.fahrul.e_commer.db.ProdukMode;
import com.fahrul.e_commer.directori.LayoutMarginDecoration;
import com.fahrul.e_commer.directori.Tools;
import com.fahrul.e_commer.model.CategoryDataAPi;
import com.fahrul.e_commer.model.ProdukDataApi;
import com.fahrul.e_commer.service.APIInterfacesRest;
import com.fahrul.e_commer.service.ApiClinet;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFargmen extends Fragment implements  AdapterMain.ItemClickListener {

    AppDataBase appDataBase;
    KategoriDao kategoriDao;
    KategoriMdel kategoriMdel;
    RecyclerView ryKategori, ryProdukMain;
    LayoutMarginDecoration grid;
    LoginDao loginDao;
    ProdukMode produkMode;
    ProdukDao produkDao;
    AdapterMain adapterMain;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.	inflate(R.layout.fragmen_main, container, false);
        ryKategori = view.findViewById(R.id.ryKategori);
        ryProdukMain = view.findViewById(R.id.ryKProduk);

        InitData();


        return  view;

    }

    private void InitData(){


        GridLayoutManager mLayout = new GridLayoutManager(getContext(), 2, RecyclerView.HORIZONTAL,false);
        ryKategori.setLayoutManager(mLayout);
        grid = new LayoutMarginDecoration(2, Tools.dp2px(getContext(), 4));
        ryKategori.addItemDecoration(grid);
        ryKategori.setHasFixedSize(true);


        GridLayoutManager mLayout1 = new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false);
        ryProdukMain.setLayoutManager(mLayout1);
        grid = new LayoutMarginDecoration(2, Tools.dp2px(getContext(), 2));
        ryProdukMain.addItemDecoration(grid);
        ryProdukMain.setHasFixedSize(true);

        appDataBase = AppDataBase.getInstance(getContext());
        kategoriDao = appDataBase.getKategori();
        loginDao = appDataBase.getLoginDao();
        produkDao = appDataBase.getProduk();

        List<KategoriMdel> kategoriMdelList = kategoriDao.getALL();
        if(kategoriMdelList.size() > 0){

            AdapterMain adapterMain = new AdapterMain(getContext(), kategoriMdelList);
            ryKategori.setAdapter(adapterMain);
            adapterMain.setClickListener(this);

        } else {

            callKategori();
        }

    }

    APIInterfacesRest apiInterfacesRest;

    public  void callKategori(){

        kategoriDao = appDataBase.getKategori();
        apiInterfacesRest = ApiClinet.getClient().create(APIInterfacesRest.class);

        Call<CategoryDataAPi> call3 = apiInterfacesRest.getKategori();
        call3.enqueue(new Callback<CategoryDataAPi>() {
            @Override
            public void onResponse(Call<CategoryDataAPi> call, Response<CategoryDataAPi> response) {

                if(response.isSuccessful()){
                    CategoryDataAPi data = response.body();

                    if(data.getData() != null){

                        KategoriMdel kategoriMdel = new KategoriMdel();

                        for(int i= 0; i < data.getData().size(); i++){

                            kategoriMdel.setIDKATEGORI(data.getData().get(i).getIdKategori());
                            kategoriMdel.setNAMAKATEGORI(data.getData().get(i).getNamaKategori());
                            kategoriMdel.setIMAGE(data.getData().get(i).getImage());

                            kategoriDao.Insert(kategoriMdel);

                        }

                        List<KategoriMdel> kategoriMdelList = kategoriDao.getALL();


                        if(kategoriMdelList.size() > 0){

                            AdapterMain adapterMain = new AdapterMain(getContext(), kategoriMdelList);

                            ryKategori.setAdapter(adapterMain);
                            adapterMain.setClickListener(this);
                        }



                    }
                }


            }

            @Override
            public void onFailure(Call<CategoryDataAPi> call, Throwable t) {

            }
        });
    }



    @Override
    public void onItemClick(View view, int position, List<KategoriMdel> data) {

        //kategoriMdel = data.get(position);
//        adapterMain.getItem(position);
        LoginModel loginModel = loginDao.getAll();
        //int value = (int) adapterMain.getItemViewType(position);




            String idTier = loginModel.getIDTIER();
            String IdKategori = data.get(position).getIDKATEGORI();

                callProduk(idTier,IdKategori);





//        for(int i = 0 ; i < data.size(); i++){
//            if(data.get(i).getID()equals(position)){
//
//            }
//        }



    }

    public  void  callProduk(String idTier, String idKategori){
        apiInterfacesRest = ApiClinet.getClient().create(APIInterfacesRest.class);
        produkDao = appDataBase.getProduk();
        loginDao = appDataBase.getLoginDao();


        Call<ProdukDataApi> addKategori = apiInterfacesRest.getProduk(
                idTier,idKategori,""
        );


        addKategori.enqueue(new Callback<ProdukDataApi>() {
            @Override
            public void onResponse(Call<ProdukDataApi> call, Response<ProdukDataApi> response) {



                if(response.isSuccessful()){

                    ProdukDataApi data = response.body();

                    if(data.getData() != null){
                        ProdukMode produkModes = produkDao.getProdukOne();



                        ProdukMode produkMode1 = new ProdukMode();
                        for(int i=0; i < data.getData().size(); i++){
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


                        List<ProdukMode> produkMode = produkDao.getIdProduk(idKategori);

                        if(produkMode.size() > 0){

                            AdapterProdukMain adapterProdukMain = new AdapterProdukMain(getContext(), produkMode);
                            ryProdukMain.setAdapter(adapterProdukMain);


                        }


                    }
                }
            }

            @Override
            public void onFailure(Call<ProdukDataApi> call, Throwable t) {

            }
        });



    }

    public RequestBody toRequestBody(String value) {
        if (value == null) {
            value = "";
        }
        RequestBody body = RequestBody.create(MediaType.parse("text/plain"), value);
        return body;
    }
}
