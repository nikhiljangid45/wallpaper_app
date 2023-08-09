package com.example.wallpapre;


import static com.example.wallpapre.ApiUtilities.API;

import com.example.wallpapre.Modles.SearchModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiInterface {

    String BAE_URL="https://api.pexels.com/v1/";

    @Headers("Authorization: " + API)
    @GET("curated")

    Call<SearchModel> getImage(
            @Query("page") int page,
            @Query("per_page") int per_page

    );


    @Headers("Authorization: " + API)
    @GET("search")

    Call<SearchModel> getSearchImage(
            @Query("query") String query,
            @Query("page") int page,
            @Query("per_page") int per_page

    );





}
