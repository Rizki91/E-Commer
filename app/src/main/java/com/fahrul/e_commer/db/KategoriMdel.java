package com.fahrul.e_commer.db;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "KategoriModel")
public class KategoriMdel implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="ID")
    private int ID;
    @ColumnInfo(name = "IDKATEGORI")
    private String IDKATEGORI;
    @ColumnInfo(name = "NAMAKATEGORI")
    private String NAMAKATEGORI;
    @ColumnInfo(name = "IMAGE")
    private String IMAGE;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getIDKATEGORI() {
        return IDKATEGORI;
    }

    public void setIDKATEGORI(String IDKATEGORI) {
        this.IDKATEGORI = IDKATEGORI;
    }

    public String getNAMAKATEGORI() {
        return NAMAKATEGORI;
    }

    public void setNAMAKATEGORI(String NAMAKATEGORI) {
        this.NAMAKATEGORI = NAMAKATEGORI;
    }

    public String getIMAGE() {
        return IMAGE;
    }

    public void setIMAGE(String IMAGE) {
        this.IMAGE = IMAGE;
    }

    public static Creator<KategoriMdel> getCREATOR() {
        return CREATOR;
    }

    public KategoriMdel() {

    }
    public KategoriMdel(Parcel in) {
        ID = in.readInt();
        IDKATEGORI = in.readString();
        NAMAKATEGORI = in.readString();
        IMAGE = in.readString();
    }

    public static final Creator<KategoriMdel> CREATOR = new Creator<KategoriMdel>() {
        @Override
        public KategoriMdel createFromParcel(Parcel in) {
            return new KategoriMdel(in);
        }

        @Override
        public KategoriMdel[] newArray(int size) {
            return new KategoriMdel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeString(IDKATEGORI);
        dest.writeString(NAMAKATEGORI);
        dest.writeString(IMAGE);
    }
}
