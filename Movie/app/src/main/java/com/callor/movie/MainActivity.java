package com.callor.movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.SearchView;


import com.callor.movie.databinding.ActivityMainBinding;
import com.callor.movie.model.NaverMovieDTO;
import com.callor.movie.service.NaverMovieServiceImplV1;
import com.callor.movie.service.NaverService;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding main_binding;
    private RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<NaverMovieDTO> moiveList = new ArrayList<>();

//        Toolbar main_toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(main_toolbar);

        main_binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(main_binding.getRoot());
        Random random = new Random();




        NaverService naverService = new NaverMovieServiceImplV1(main_binding.movieListView);

        naverService.getMoive("harry");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_toolbar_menu,menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();

        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("영화제목 검색");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {


                NaverService naverService = new NaverMovieServiceImplV1(main_binding.movieListView);
                naverService.getMoive(query.trim());
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("문자열",newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}