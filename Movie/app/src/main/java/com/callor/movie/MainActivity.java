package com.callor.movie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.callor.movie.databinding.ActivityMainBinding;
import com.callor.movie.service.NaverMovieServiceImplV1;
import com.callor.movie.service.NaverService;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding main_binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        main_binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(main_binding.getRoot());

        NaverService naverService = new NaverMovieServiceImplV1(main_binding.movieListView);
        naverService.getMoive("사랑");
    }
}