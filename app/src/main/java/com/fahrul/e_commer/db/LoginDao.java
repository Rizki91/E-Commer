package com.fahrul.e_commer.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface LoginDao {


    @Query("SELECT * FROM LoginDb WHERE ID_MEMBER=:Id_mamber")
    LoginModel getByIdMamber(String Id_mamber);

    @Query("SELECT * FROM LoginDb")
    LoginModel getAll();

    @Insert
    void Insert(LoginModel... login);

    @Insert
    void InsertOne (LoginModel loginModel);

    @Delete
    void Delete (LoginModel loginModel);

}
