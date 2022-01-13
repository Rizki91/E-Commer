package com.fahrul.e_commer.db;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProdukDao {

    @Query("SELECT * FROM ProdukDb WHERE ID_KATEGORI=:Id_Produk ")
    List<ProdukMode> getIdProduk(String Id_Produk);

    @Query("SELECT * FROM ProdukDb ")
    List<ProdukMode> getIdProdukALL();

    @Query("SELECT * FROM ProdukDb ")
    ProdukMode getProdukOne();

    @Query("DELETE FROM ProdukDb WHERE ID_PRODUK=:id")
    void deleteById(String id);


    @Insert
    void Insert (ProdukMode... produkModes);

    @Insert
    void InsertOne (ProdukMode produkMode);

    @Delete
    void Delete (ProdukMode... produkModes);

}
