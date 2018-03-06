package com.app.lee.api;

import com.app.lee.model.LoginResponse;

import io.reactivex.Flowable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by lichen on 2018/1/11.
 */

public interface ApiService {
    @POST("base-gateway")
    Flowable<LoginResponse> login(@Query("api") String api,
                                  @Query("method") String method,
                                  @Query("version") String version,
                                  @Query("params") String params,
                                  @Query("deviceId") String deviceId,
                                  @Query("appId") String appId);

}
