package com.fahrul.e_commer.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface KategoriDao {

    @Query("SELECT * FROM KategoriModel ")
    List<KategoriMdel> getALL();

    @Insert
    void Insert (KategoriMdel... kategoriMdels);

    @Insert
    void InsertOn (KategoriMdel kategoriMdel);

}
