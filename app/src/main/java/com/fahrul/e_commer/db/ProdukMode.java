package com.fahrul.e_commer.db;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ProdukDb")
public class ProdukMode implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private int ID;
    @ColumnInfo(name = "ID_KATEGORI")
    private String ID_KATEGORI;
    @ColumnInfo(name = "ID_PRODUK")
    private String ID_PRODUK;
    @ColumnInfo(name = "NAMA_BARANG")
    private String NAMA_BARANG;
    @ColumnInfo(name = "HARGA")
    private String HARGA;
    @ColumnInfo(name = "HARGA_DISKON")
    private Double HARGA_DISKON;
    @ColumnInfo(name = "DISKON")
    private String DISKON;
    @ColumnInfo(name = "QTY")
    private int QTY;
    @ColumnInfo(name = "PAKET")
    private int PAKET;
    @ColumnInfo(name = "DESKRIPSI")
    private String DESKRIPSI;
    @ColumnInfo(name = "IMGS")
    private String IMGS;
    @ColumnInfo(name = "NAMA_KATEGORI")
    private String NAMA_KATEGORI;
    @ColumnInfo(name = "CNT_BELI")
    private String CNT_BELI;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getID_PRODUK() {
        return ID_PRODUK;
    }

    public void setID_PRODUK(String ID_PRODUK) {
        this.ID_PRODUK = ID_PRODUK;
    }

    public String getNAMA_BARANG() {
        return NAMA_BARANG;
    }

    public void setNAMA_BARANG(String NAMA_BARANG) {
        this.NAMA_BARANG = NAMA_BARANG;
    }

    public String getHARGA() {
        return HARGA;
    }

    public void setHARGA(String HARGA) {
        this.HARGA = HARGA;
    }

    public Double getHARGA_DISKON() {
        return HARGA_DISKON;
    }

    public void setHARGA_DISKON(Double HARGA_DISKON) {
        this.HARGA_DISKON = HARGA_DISKON;
    }

    public String getDISKON() {
        return DISKON;
    }

    public void setDISKON(String DISKON) {
        this.DISKON = DISKON;
    }

    public int getQTY() {
        return QTY;
    }

    public void setQTY(int QTY) {
        this.QTY = QTY;
    }

    public int getPAKET() {
        return PAKET;
    }

    public void setPAKET(int PAKET) {
        this.PAKET = PAKET;
    }

    public String getDESKRIPSI() {
        return DESKRIPSI;
    }

    public void setDESKRIPSI(String DESKRIPSI) {
        this.DESKRIPSI = DESKRIPSI;
    }

    public String getIMGS() {
        return IMGS;
    }

    public void setIMGS(String IMGS) {
        this.IMGS = IMGS;
    }

    public String getNAMA_KATEGORI() {
        return NAMA_KATEGORI;
    }

    public void setNAMA_KATEGORI(String NAMA_KATEGORI) {
        this.NAMA_KATEGORI = NAMA_KATEGORI;
    }

    public String getCNT_BELI() {
        return CNT_BELI;
    }

    public void setCNT_BELI(String CNT_BELI) {
        this.CNT_BELI = CNT_BELI;
    }

    public static Creator<ProdukMode> getCREATOR() {
        return CREATOR;
    }

    public  ProdukMode(){

    }

    protected ProdukMode(Parcel in) {
        ID = in.readInt();
        ID_PRODUK = in.readString();
        NAMA_BARANG = in.readString();
        HARGA = in.readString();
        HARGA_DISKON = in.readDouble();
        DISKON = in.readString();
        QTY = in.readInt();
        PAKET = in.readInt();
        DESKRIPSI = in.readString();
        IMGS = in.readString();
        NAMA_KATEGORI = in.readString();
        CNT_BELI = in.readString();
        ID_KATEGORI = in.readString();
    }

    public String getID_KATEGORI() {
        return ID_KATEGORI;
    }

    public void setID_KATEGORI(String ID_KATEGORI) {
        this.ID_KATEGORI = ID_KATEGORI;
    }

    public static final Creator<ProdukMode> CREATOR = new Creator<ProdukMode>() {
        @Override
        public ProdukMode createFromParcel(Parcel in) {
            return new ProdukMode(in);
        }

        @Override
        public ProdukMode[] newArray(int size) {
            return new ProdukMode[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeString(ID_PRODUK);
        dest.writeString(NAMA_BARANG);
        dest.writeString(HARGA);
        dest.writeDouble(HARGA_DISKON);
        dest.writeString(DISKON);
        dest.writeInt(QTY);
        dest.writeInt(PAKET);
        dest.writeString(DESKRIPSI);
        dest.writeString(IMGS);
        dest.writeString(NAMA_KATEGORI);
        dest.writeString(ID_KATEGORI);
        dest.writeString(CNT_BELI);
    }
}
