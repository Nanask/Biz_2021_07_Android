package com.nana.libary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.nana.libary.service.NaverBookService;
import com.nana.libary.service.impl.NaverBookServiceImplV1;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.book_list_view);
//
//        recyclerView.setOnClickListener(view-> {
    //실행되면서 바로 나오게 코드 설정
        // 여기서 데이터를 받아서 recylerView 에게 넘겨줌
            NaverBookService naverBookService
                    = new NaverBookServiceImplV1(recyclerView);


            naverBookService.getBooks("고양이");

    }
}