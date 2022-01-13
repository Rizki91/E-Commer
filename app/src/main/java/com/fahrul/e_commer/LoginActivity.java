package com.fahrul.e_commer;



import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.fahrul.e_commer.db.AppDataBase;
import com.fahrul.e_commer.db.LoginDao;
import com.fahrul.e_commer.db.LoginModel;
import com.fahrul.e_commer.model.Login;
import com.fahrul.e_commer.service.APIInterfacesRest;
import com.fahrul.e_commer.service.ApiClinet;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    EditText tvUsername,tvPassword;
    LoginDao loginDao;
    AppDataBase appDataBase;
    Button btnLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        initData();
    }

    public void  initData(){

        tvUsername = findViewById(R.id.tvUsername);
        tvPassword = findViewById(R.id.tvPassword);
        btnLogin = findViewById(R.id.btnLogin);


        appDataBase = AppDataBase.getInstance(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent activity = new Intent(LoginActivity.this, SingUp.class);
//                startActivity(activity);
                CallLogin();
                //cekLogin();
                finish();
            }
        });

    }

    APIInterfacesRest apiInterface;
    ProgressDialog progressDialog;

   public  void CallLogin(){
       apiInterface = ApiClinet.getClient().create(APIInterfacesRest.class);
//       progressDialog = new ProgressDialog(LoginActivity.this);
//       progressDialog.setTitle("Loading");
//       progressDialog.show();

       loginDao = appDataBase.getLoginDao();



       apiInterface.loginRequest(tvUsername.getText().toString(),tvPassword.getText().toString())
        .enqueue(new Callback<Login>() {
           @Override
           public void onResponse(Call<Login> call, Response<Login> response) {
//               progressDialog.dismiss();

              // Login  status = response.body();

               if(response.isSuccessful()){

                   Login status = response.body();

                   try{
                       if(status.getErrMsg().equals("Ok")){

                           LoginModel loginModel = new LoginModel();
                           loginModel.setIDMEMBER(status.getProfileInfo().getIdMember());
                           loginModel.setIDTIER(status.getProfileInfo().getIdTier());
                           loginModel.setEMAIL(status.getProfileInfo().getEmail());
                           loginModel.setNAMA(status.getProfileInfo().getNama());
                           loginModel.setSTATUSNAME(status.getProfileInfo().getStatusName());
                           loginModel.setSTATUS(status.getProfileInfo().getStatus());
                           loginModel.setPHONE(status.getProfileInfo().getPhone());

                           loginDao.Insert(loginModel);

                           Intent i = new Intent(LoginActivity.this,MainActivity.class);
                           startActivity(i);
                           finish();

                       }  else {
////                   progressDialog.dismiss();
                   try
                   {
                       JsonObject jsonObjectErro = new JsonObject();
                       String error = jsonObjectErro.get("Status_detail").toString();
                       Toast.makeText(LoginActivity.this, error, Toast.LENGTH_SHORT).show();
                   } catch  (Exception e){
                       Toast.makeText(LoginActivity.this, "Maaf Koneksi Bermasalah", Toast.LENGTH_SHORT).show();
                       e.printStackTrace();
                   }
               }

                   }
                   catch (Exception e){
                       e.printStackTrace();
                   }
               }

//               if(status != null){
//
//
//                   LoginModel loginModel = new LoginModel();
//
//                   loginModel.setIDMEMBER(status.getProfileInfo().getIdMember());
//                   loginModel.setIDTIER(status.getProfileInfo().getIdTier());
//                   loginModel.setEMAIL(status.getProfileInfo().getEmail());
//                   loginModel.setNAMA(status.getProfileInfo().getNama());
//                   loginModel.setSTATUSNAME(status.getProfileInfo().getStatusName());
//                   loginModel.setSTATUS(status.getProfileInfo().getStatus());
//                   loginModel.setPHONE(status.getProfileInfo().getPhone());
//
//                   loginDao.Insert(loginModel);
//
//                   Intent i = new Intent(LoginActivity.this,MainActivity.class);
//                   startActivity(i);
//                   finish();
//
//
//
//
//
//
//               }
           }

           @Override
           public void onFailure(Call<Login> call, Throwable t) {
//               progressDialog.dismiss();
               Toast.makeText(LoginActivity.this, "Maaf Koneksi Bermasalah", Toast.LENGTH_SHORT).show();
               call.cancel();
           }
       });

   }



}