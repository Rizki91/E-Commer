
package com.fahrul.e_commer.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class DatumProduk {

    @SerializedName("id_product")
    @Expose
    private String idProduct;
    @SerializedName("id_kategori")
    @Expose
    private String idKategori;
    @SerializedName("nama_barang")
    @Expose
    private String namaBarang;
    @SerializedName("harga")
    @Expose
    private String harga;
    @SerializedName("hrg_diskon")
    @Expose
    private Double hrgDiskon;
    @SerializedName("diskon")
    @Expose
    private String diskon;
    @SerializedName("qty")
    @Expose
    private Integer qty;
    @SerializedName("paket")
    @Expose
    private Integer paket;
    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("nama_kategori")
    @Expose
    private String namaKategori;
    @SerializedName("cnt_beli")
    @Expose
    private Integer cntBeli;

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(String idKategori) {
        this.idKategori = idKategori;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public Double getHrgDiskon() {
        return hrgDiskon;
    }

    public void setHrgDiskon(Double hrgDiskon) {
        this.hrgDiskon = hrgDiskon;
    }

    public String getDiskon() {
        return diskon;
    }

    public void setDiskon(String diskon) {
        this.diskon = diskon;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getPaket() {
        return paket;
    }

    public void setPaket(Integer paket) {
        this.paket = paket;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public void setNamaKategori(String namaKategori) {
        this.namaKategori = namaKategori;
    }

    public Integer getCntBeli() {
        return cntBeli;
    }

    public void setCntBeli(Integer cntBeli) {
        this.cntBeli = cntBeli;
    }

}
