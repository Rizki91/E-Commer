
package com.fahrul.e_commer.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Login {

    @SerializedName("err_code")
    @Expose
    private String errCode;
    @SerializedName("err_msg")
    @Expose
    private String errMsg;
    @SerializedName("profile_info")
    @Expose
    private ProfileInfo profileInfo;

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

    public ProfileInfo getProfileInfo() {
        return profileInfo;
    }

    public void setProfileInfo(ProfileInfo profileInfo) {
        this.profileInfo = profileInfo;
    }

}
