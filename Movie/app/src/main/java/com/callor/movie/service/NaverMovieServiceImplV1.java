package com.callor.movie.service;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.callor.movie.adapter.MovieViewAdapter;
import com.callor.movie.config.NaverAPI;
import com.callor.movie.model.NaverMovieDTO;
import com.callor.movie.model.NaverParent;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NaverMovieServiceImplV1 implements NaverService{

    private RecyclerView MovieListView;

    public NaverMovieServiceImplV1(RecyclerView movieListView) {
        MovieListView = movieListView;
    }


    @Override
    public void getMoive(String search) {

        Call<NaverParent> naverParentCall = NaverRetrofitClient.getApiClinet()
                .getMovie(NaverAPI.CLIENT_ID,NaverAPI.CLIENT_SECRET,search,1,10);

        naverParentCall.enqueue(new Callback<NaverParent>() {
            @Override
            public void onResponse(Call<NaverParent> call, Response<NaverParent> response) {
                int resCode = response.code();

                if(resCode < 300) {
                    Log.d("영화조회", response.body().toString());

                    List<NaverMovieDTO> movieDTOList = response.body().items;
                    MovieViewAdapter viewAdapter
                            = new MovieViewAdapter(movieDTOList);

                    MovieListView.setAdapter(viewAdapter);

                    RecyclerView.LayoutManager layoutManager
                            = new LinearLayoutManager(MovieListView.getContext());
                    MovieListView.setLayoutManager(layoutManager);
                }else  {
                    Log.d("오류발생",response.toString());
                }
            }

            @Override
            public void onFailure(Call<NaverParent> call, Throwable t) {

            }
        });

    }
}
