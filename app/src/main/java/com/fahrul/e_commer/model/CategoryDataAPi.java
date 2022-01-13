
package com.fahrul.e_commer.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CategoryDataAPi {

    @SerializedName("err_code")
    @Expose
    private String errCode;
    @SerializedName("err_msg")
    @Expose
    private String errMsg;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

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

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

}
