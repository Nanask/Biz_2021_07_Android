package com.callor.movie.service;

import com.callor.movie.config.NaverAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NaverRetrofitClient {

    private static Retrofit getInstance() {
        return new Retrofit.Builder().baseUrl(NaverAPI.NAVER_BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static NaverRetroFit getApiClinet() {
        return getInstance().create(NaverRetroFit.class);
    }
}
