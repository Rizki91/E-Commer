package com.fahrul.e_commer.db;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Entity(tableName = "LoginDb")
public class LoginModel implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="ID")
    private int ID;
    @ColumnInfo(name = "ID_MEMBER")
    private String IDMEMBER;
    @ColumnInfo(name = "IDTIER")
    private String IDTIER;
    @ColumnInfo(name = "NAMA")
    private String NAMA;
    @ColumnInfo(name = "NAMATOKO")
    private String NAMATOKO;
    @ColumnInfo(name = "EMAIL")
    private String EMAIL;
    @ColumnInfo(name = "PHONE")
    private String PHONE;
    @ColumnInfo(name = "FCMTOKEN")
    private String FCMTOKEN;
    @ColumnInfo(name = "STATUS")
    private String STATUS;
    @ColumnInfo(name = "STATUSNAME")
    private String STATUSNAME;
    @ColumnInfo(name = "PHOTO")
    private String PHOTO;
    @ColumnInfo(name = "CUREENTPASS")
    private String CUREENTPASS;
    @ColumnInfo(name = "TGLREQ")
    private String TGLREQ;

    public LoginModel() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getIDMEMBER() {
        return IDMEMBER;
    }

    public void setIDMEMBER(String IDMEMBER) {
        this.IDMEMBER = IDMEMBER;
    }

    public String getIDTIER() {
        return IDTIER;
    }

    public void setIDTIER(String IDTIER) {
        this.IDTIER = IDTIER;
    }

    public String getNAMA() {
        return NAMA;
    }

    public void setNAMA(String NAMA) {
        this.NAMA = NAMA;
    }

    public String getNAMATOKO() {
        return NAMATOKO;
    }

    public void setNAMATOKO(String NAMATOKO) {
        this.NAMATOKO = NAMATOKO;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public String getFCMTOKEN() {
        return FCMTOKEN;
    }

    public void setFCMTOKEN(String FCMTOKEN) {
        this.FCMTOKEN = FCMTOKEN;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getSTATUSNAME() {
        return STATUSNAME;
    }

    public void setSTATUSNAME(String STATUSNAME) {
        this.STATUSNAME = STATUSNAME;
    }

    public String getPHOTO() {
        return PHOTO;
    }

    public void setPHOTO(String PHOTO) {
        this.PHOTO = PHOTO;
    }

    public String getCUREENTPASS() {
        return CUREENTPASS;
    }

    public void setCUREENTPASS(String CUREENTPASS) {
        this.CUREENTPASS = CUREENTPASS;
    }

    public String getTGLREQ() {
        return TGLREQ;
    }

    public void setTGLREQ(String TGLREQ) {
        this.TGLREQ = TGLREQ;
    }

    public static Creator<LoginModel> getCREATOR() {
        return CREATOR;
    }

    public static final Creator<LoginModel> CREATOR = new Creator<LoginModel>() {
        @Override
        public LoginModel createFromParcel(Parcel in) {
            return new LoginModel(in);
        }

        @Override
        public LoginModel[] newArray(int size) {
            return new LoginModel[size];
        }
    };

    public LoginModel(Parcel in) {
        this.ID = in.readInt();
        this.IDMEMBER = in.readString();
        this.IDTIER = in.readString();
        this.EMAIL = in.readString();
        this.NAMA = in.readString();
        this.PHONE = in.readString();


    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.ID);
        dest.writeString(this.IDMEMBER);
        dest.writeString(this.IDTIER);
        dest.writeString(this.EMAIL);
        dest.writeString(this.NAMA);
        dest.writeString(this.PHONE);
        dest.writeString(this.STATUS);
        dest.writeString(this.STATUSNAME);
        dest.writeString(this.TGLREQ);
        dest.writeString(this.PHOTO);
        dest.writeString(this.CUREENTPASS);


    }
}
