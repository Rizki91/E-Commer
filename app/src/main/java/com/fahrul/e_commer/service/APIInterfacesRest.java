package com.fahrul.e_commer.service;



import com.fahrul.e_commer.model.CategoryDataAPi;
import com.fahrul.e_commer.model.Login;
import com.fahrul.e_commer.model.ProdukDataApi;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIInterfacesRest {

    @FormUrlEncoded
    @POST("member/login")
    Call <Login>loginRequest (

            @Field("email") String email,
             @Field("password") String password
    );

    @GET("category")
    Call<CategoryDataAPi> getKategori();

    @FormUrlEncoded
    @POST("principal/products")
    Call <ProdukDataApi> getProduk (
            @Field("id_tier") String id_tier,
            @Field("id_kategori") String id_kategori,
            @Field("keyword") String keyword
    );



}
