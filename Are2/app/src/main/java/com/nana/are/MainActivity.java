package com.nana.are;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar main_toolbar =findViewById(R.id.main_toolbar);
        setSupportActionBar(main_toolbar);
        actionBar = getSupportActionBar();
        // 툴바 활성화
        actionBar.setDisplayHomeAsUpEnabled(true);
        // 햄버거 버튼 이미지 불러오기
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar,menu);

        return super.onCreateOptionsMenu(menu);
    }
}