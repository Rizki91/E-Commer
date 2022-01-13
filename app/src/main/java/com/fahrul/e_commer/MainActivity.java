package com.fahrul.e_commer;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fahrul.e_commer.adapter.AdapterMain;
import com.fahrul.e_commer.db.AppDataBase;
import com.fahrul.e_commer.db.KategoriDao;
import com.fahrul.e_commer.db.KategoriMdel;
import com.fahrul.e_commer.directori.LayoutMarginDecoration;
import com.fahrul.e_commer.directori.Tools;
import com.fahrul.e_commer.fragmen.MainFargmen;
import com.fahrul.e_commer.fragmen.ProdukFragmen;
import com.fahrul.e_commer.fragmen.ProfileFargmen;
import com.fahrul.e_commer.model.CategoryDataAPi;
import com.fahrul.e_commer.service.APIInterfacesRest;
import com.fahrul.e_commer.service.ApiClinet;
import com.fahrul.e_commer.utility.SharedPrefUtil;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements  BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottom = findViewById(R.id.btnNavigasi);
        bottom.setOnNavigationItemSelectedListener(this);
        bottom.setSelectedItemId(R.id.home);


    }

    MainFargmen mainFargmen = new MainFargmen();
    ProfileFargmen profileFargmen = new ProfileFargmen();
    ProdukFragmen produkFragmen = new ProdukFragmen();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.person:
                getSupportFragmentManager().beginTransaction().replace(R.id.frMain, profileFargmen).commit();
                return true;

            case R.id.home:

                getSupportFragmentManager().beginTransaction().replace(R.id.frMain, mainFargmen).commit();
                return  true;

            case R.id.shope:
                getSupportFragmentManager().beginTransaction().replace(R.id.frMain, produkFragmen).commit();
                return true;
        }
        return false;
    }






}