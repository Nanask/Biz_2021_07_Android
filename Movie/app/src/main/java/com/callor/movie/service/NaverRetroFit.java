package com.callor.movie.service;

import com.callor.movie.model.NaverParent;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface NaverRetroFit {

    @GET("movie.json")
    public Call<NaverParent> getMovie(
            @Header("X-Naver-Client-Id") String clientId,
            @Header("X-Naver-Client-Secret") String clientsecret,
            @Query("query") String query,
            @Query("start") int start,
            @Query("display") int display
    );
}
