package com.example.wallpapre;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {
    private  static   Retrofit retrofit = null;
    public  static  final  String API ="K5TZ3XWeC8SSm9KmN9uSB0pXKrXdCEGiZULwgfVk5qhfCXeh80BpG2Xb";

    public  static  ApiInterface getApiInterfac(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(ApiInterface.BAE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(ApiInterface.class);
    }
}
