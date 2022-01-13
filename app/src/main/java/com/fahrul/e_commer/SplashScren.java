package com.fahrul.e_commer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.fahrul.e_commer.db.AppDataBase;
import com.fahrul.e_commer.db.LoginDao;
import com.fahrul.e_commer.db.LoginModel;

public class SplashScren extends AppCompatActivity {

    private int waktu = 1000;
    AppDataBase appDataBase;
    LoginDao loginDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_scren);

        appDataBase = AppDataBase.getInstance(this);
        loginDao = appDataBase.getLoginDao();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                LoginModel loginModel = loginDao.getAll();

                if(loginModel != null){

                    Intent MainActivity = new Intent(SplashScren.this,MainActivity.class);
                    startActivity(MainActivity);
                    finish();
                }else {

                    Intent MainActivity = new Intent(SplashScren.this,LoginActivity.class);
                    startActivity(MainActivity);
                    finish();
                }



            }
        },waktu);


    }
}