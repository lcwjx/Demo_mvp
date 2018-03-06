package com.app.lee.model;

import com.app.lee.base.BaseBean;

/**
 * Created by lichen on 2018/1/11.
 */

public class LoginResponse implements BaseBean {

    public String retCode = "";
    public String retDesc = "";
    public String version;
    public String appId;
    public String deviceId;
    public String api;
    public String method;
    public String token;
    public long startTime;
    public long endTime;
    public JsonBodyBean jsonBody;

    public static class JsonBodyBean {
        public String token;
    }
}
