package com.callor.movies.service;

import com.callor.movies.config.NaverAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
retrofit을 사용하여 openAPI를 조회할 때
필요한 연결 session(Connection) 정보를 만드는 클래스
 */
public class RetrofitClient {

    // 연결 Connection 생성
    private static Retrofit getInstance() {
        return new Retrofit.Builder().baseUrl(NaverAPI.NAVER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }
//    Naver API연결 Connection을 생성하고
    // DTO Mapper를 만들어 return하기
    public static NaverRetrofit getAPIClient() {
        return getInstance().create(NaverRetrofit.class);
    }
}
