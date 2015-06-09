package com.example.kevin.shutterdroid.ShutterStock;

import android.util.Base64;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

/**
 * Created by kevin on 3/7/15.
 */
public class ShutterStock {
    private static final String API_URL = "https://api.shutterstock.com/v2/";
    private static final RestAdapter REST_ADAPTER = new RestAdapter.Builder()
            .setEndpoint(API_URL)
            .setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    String authInfo = "a2b8f6dda2f35e976a86:da720c91f5cc6996adf877884ac8cd49ef78fbd9";
                    String authString = "Basic " + Base64.encodeToString(authInfo.getBytes(), Base64.NO_WRAP);
                    request.addHeader("Authorization", authString);
                }
            })
            .build();
    private static final ShutterStockService SERVICE = REST_ADAPTER.create(ShutterStockService.class);


    public static void search(String query, Callback<List<Image>> cb){
        SERVICE.search(query, new ImageCallback(cb) {
        });
    }

    public static void getRecent(Date date, Callback<List<Image>> cb){
        SERVICE.getRecent(new SimpleDateFormat("yyyy-MM-dd").format(date), new ImageCallback(cb));
    }

    private static class ImageCallback implements Callback<Response>{
        Callback<List<Image>> cb;
        ImageCallback(Callback<List<Image>> cb){
            this.cb = cb;
        }
        @Override
        public void success(Response response, retrofit.client.Response response2) {
            cb.success(response.data,response2);
        }

        @Override
        public void failure(RetrofitError error) {
            cb.failure(error);
        }
    }
}
