
package com.fahrul.e_commer.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileInfo {

    @SerializedName("id_member")
    @Expose
    private String idMember;
    @SerializedName("id_tier")
    @Expose
    private String idTier;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("nama_toko")
    @Expose
    private Object namaToko;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("fcm_token")
    @Expose
    private Object fcmToken;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("status_name")
    @Expose
    private String statusName;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("current_pass")
    @Expose
    private String currentPass;
    @SerializedName("tgl_reg")
    @Expose
    private String tglReg;

    public String getIdMember() {
        return idMember;
    }

    public void setIdMember(String idMember) {
        this.idMember = idMember;
    }

    public String getIdTier() {
        return idTier;
    }

    public void setIdTier(String idTier) {
        this.idTier = idTier;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Object getNamaToko() {
        return namaToko;
    }

    public void setNamaToko(Object namaToko) {
        this.namaToko = namaToko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Object getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(Object fcmToken) {
        this.fcmToken = fcmToken;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCurrentPass() {
        return currentPass;
    }

    public void setCurrentPass(String currentPass) {
        this.currentPass = currentPass;
    }

    public String getTglReg() {
        return tglReg;
    }

    public void setTglReg(String tglReg) {
        this.tglReg = tglReg;
    }

}
