package com.callor.movies;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.callor.movies.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

//        content_main에 존재 : nav_host_fragment_content_main
        /*
        content_view.xml에 설정된 fragment view를
        NavController로 등록하여
        fragment 간의 이동을 쉽게 하겠다.
         */
        NavController navController
                = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        뒤로가기 버튼 등이 있을 때 처리를 쉽게 하기 위한 설정
//         ui에 뒤로가기 버튼이 생겼을 때 처리한다.
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
/*
ActionBar에 메뉴 등을 표현하기 위하여 작성되는 코드
res/menu/menu_main.xml 파일을 읽어서
ActionBar에 메뉴를 그리는 코드가 작성된다.
 */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
//        R.menu.menu_main불러와서 menu에 넣어라
//       여길 수정하려면 menu를 수정하면 된다.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Toast.makeText(MainActivity.this, "설정메뉴클릭"
            ,Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
/*
안드로이드의 물리적 버튼
원래 어플에 존재하는 버튼들을 의미(홈, 뒤로가기, 백그라운드목록)
위로가기,뒤로가기,어플종료,어플리스트 보기 등의 기능을 수행하는 활성화 시키는 event 핸들러

안드로이드 Up 버튼을 눌렀을 때 Navigation에 설정된 대로
뒤로가기를 수행하다가 가장 먼저 열린 화면에 도달했을 때
Up버튼을 누르면 어플을 종료하는 코드가 자동으로 실행된다.
 */
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController =
                Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}