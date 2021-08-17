package com.callor.movies.service.impl;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.callor.movies.adapter.NaverMoviesAdapter;
import com.callor.movies.config.NaverAPI;
import com.callor.movies.databinding.FragmentSecondBinding;
import com.callor.movies.model.MoviesDTO;
import com.callor.movies.model.NaverParent;
import com.callor.movies.service.NaverAPIService;
import com.callor.movies.service.NaverRetrofit;
import com.callor.movies.service.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NaverMoviesServiceImplV1 implements NaverAPIService {

    private NaverMoviesAdapter adapter;
    private FragmentSecondBinding secondBinding;

    public NaverMoviesServiceImplV1(FragmentSecondBinding secondBinding) {
        this.secondBinding = secondBinding;
    }

    @Override
    public void getNaverMovie(String search) {
/*
Naver에서 API 조회를 수행하기 위한 객체를 생성하기
 */

        Call<NaverParent> naverCall =
                RetrofitClient.getAPIClient().getMovies(
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

                    List<MoviesDTO> moviesDTOList = naverParent.items;
                    adapter = new NaverMoviesAdapter(moviesDTOList);

                    secondBinding.moviesListView.setAdapter(adapter);

                    RecyclerView.LayoutManager layoutManager
                            = new LinearLayoutManager(secondBinding.getRoot().getContext());
                    secondBinding.moviesListView.setLayoutManager(layoutManager);
                }else {
                    Log.d("오류발생",response.toString());
                }
            }

            @Override
            public void onFailure(Call<NaverParent> call, Throwable t) {

            }

        });
    }
}
