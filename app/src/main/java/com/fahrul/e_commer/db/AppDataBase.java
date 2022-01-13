package com.fahrul.e_commer.db;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {LoginModel.class, KategoriMdel.class, ProdukMode.class},  version =  1)
public abstract class AppDataBase extends RoomDatabase {

    private static final String DATABASE_NAME = "ecommer_db";
    private static AppDataBase database;

    public static AppDataBase getInstance(Context context) {
        synchronized (AppDataBase.class) {
            if (database == null) {
                //get from server
                database = Room.databaseBuilder(context, AppDataBase.class, DATABASE_NAME)
                        .allowMainThreadQueries()
                        //.addMigrations(MIGRATION)
                        .build();
                //get from asset
//                database = Room.databaseBuilder(context,
//                        AppDataBase.class,
//                        "mobileappraisalniaga")
//                        .createFromAsset("database/mobileappraisalniaga.db")
//                        .allowMainThreadQueries()
//                       // .addMigrations(MIGRATION)
//                        .build();
            }
        }
        return database;
    }
public  abstract  LoginDao getLoginDao();
public  abstract  KategoriDao getKategori();
public  abstract  ProdukDao getProduk();

}
