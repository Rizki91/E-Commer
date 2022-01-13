package com.fahrul.e_commer.fragmen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.fahrul.e_commer.R;
import com.fahrul.e_commer.db.AppDataBase;
import com.fahrul.e_commer.db.LoginDao;
import com.fahrul.e_commer.db.LoginModel;
import com.squareup.picasso.Picasso;

public class ProfileFargmen extends Fragment {

    AppDataBase appDataBase;
    LoginDao loginDao;
    ImageView photoProfile;
    EditText Nama, tlp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmen_profile, container, false);

        Nama = view.findViewById(R.id.txNamaProfile);
        tlp = view.findViewById(R.id.Nomor);
        photoProfile = view.findViewById(R.id.imgsProfile);

        InitData();

        return view;
    }


    public  void InitData(){

        appDataBase = AppDataBase.getInstance(getContext());
        loginDao = appDataBase.getLoginDao();


        LoginModel loginModel = loginDao.getAll();

        if(loginModel != null){

            Nama.setText(loginModel.getNAMA());
            tlp.setText(loginModel.getPHONE());
//            String imgs = loginModel.getPHOTO().replace("http", "https");
//            Picasso.get().load(imgs).into(photoProfile);



        }




    }
}
