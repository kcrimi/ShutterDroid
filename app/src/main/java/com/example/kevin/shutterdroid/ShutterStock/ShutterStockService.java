package com.example.kevin.shutterdroid.ShutterStock;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by kevin on 3/7/15.
 */
public interface ShutterStockService {
    @GET("/images/search")
    public void search(@Query("query") String query, Callback<Response> cb);

    @GET("/images/search")
    public void getRecent(@Query("added_date_start") String date, Callback<Response> cb);
}
