
package com.fahrul.e_commer.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ProdukDataApi {

    @SerializedName("err_code")
    @Expose
    private String errCode;
    @SerializedName("err_msg")
    @Expose
    private String errMsg;
    @SerializedName("data")
    @Expose
    private List<DatumProduk> data = null;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public List<DatumProduk> getData() {
        return data;
    }

    public void setData(List<DatumProduk> data) {
        this.data = data;
    }

}
