package com.nana.movies.service;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nana.movies.adapter.NaverMovieAdapter;
import com.nana.movies.config.NaverAPI;
import com.nana.movies.model.MovieDTO;
import com.nana.movies.model.NaverParent;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NaverMovieServiceImplV1 implements NaverApiService{

    private NaverMovieAdapter adapter;
    protected RecyclerView movieRecyclerView;

    public NaverMovieServiceImplV1(RecyclerView movieRecyclerView) {
        this.movieRecyclerView = movieRecyclerView;
    }

    @Override
    public void getNaverData(String search) {

        /*
Naver에서 API 조회를 수행하기 위한 객체를 생성하기
 */

        Call<NaverParent> naverCall =
                RetrofitClient.getApiClient().getMovie(
                        NaverAPI.NAVER_CLIENT_ID,
                        NaverAPI.NAVER_CLIENT_SECRET,
                        search, 1, 20);
/*
 생성된 API 객체에 대하여 비동기 Call method를 선언하기
 Retrofit이 naver에 API 요청을 하고
 API 결과가 다다르면(도착하면) 반응을 하는 method
 */
        naverCall.enqueue(new Callback<NaverParent>() {


            @Override
            public void onResponse(Call<NaverParent> call, Response<NaverParent> response) {
                Log.d("Naver 영화정보", response.toString());
                int resCode = response.code();
                if(resCode < 300) {
                    NaverParent naverParent = response.body();
                    Log.d("네이버에서 받은 데이터", naverParent.toString());

                    List<MovieDTO> movieDTOList = naverParent.items;

                    NaverMovieAdapter adapter = new NaverMovieAdapter(movieDTOList);
                    movieRecyclerView.setAdapter(adapter);

                    RecyclerView.LayoutManager layoutManager
                            = new LinearLayoutManager(movieRecyclerView.getContext());

             movieRecyclerView.setLayoutManager(layoutManager);


            }
            }
            @Override
            public void onFailure(Call<NaverParent> call, Throwable t){

            }
        });


    }
}
