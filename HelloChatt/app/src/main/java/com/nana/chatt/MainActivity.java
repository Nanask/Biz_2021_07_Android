package com.nana.chatt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;

import com.nana.chatt.adpter.ChattAdapter;
import com.nana.chatt.model.chatt;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // chatt 메세지를 전달하는 view 들
    private EditText txt_msg;
    private AppCompatButton btn_send;

    // chatt 메세지를 표현할 view 들
    private RecyclerView chat_list_view;
    private ChattAdapter chattAdapter;

    private List<chatt> chattList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // layout.xml 파일을 읽어서 화면을 만드는 method
        // setContentView는 한개의 파일을 읽어서 한개의 전체 화면을 만드는 것
        setContentView(R.layout.activity_main);

        txt_msg = findViewById(R.id.txt_msg);
        btn_send = findViewById(R.id.btn_send);

        chat_list_view = findViewById(R.id.chatt_list_view);

        //0. 보여줄 데이터 객체 생성
        chattList = new ArrayList<chatt>();
        chatt chatt = new chatt();
        chatt.setName("홍길동");
        chatt.setMsg("반갑습니다");
        chattList.add(chatt);

        chatt = new chatt();
        chatt.setName("성춘향");
        chatt.setMsg("안녕하세요");
        chattList.add(chatt);


        // 1. Adpter 객체 생성
        // Adapter 객체를 생성할 때 보여줄 데이터 객체를 생성자 매개변수로 주입해주어야 한다
        chattAdapter = new ChattAdapter(chattList);

        // 2. RecyclerView.Adpterd와 RecyclerView, 를 서로연결
        chat_list_view.setAdapter(chattAdapter);

        // 3.RecyclerView의 데이터를 표현할 때 사용할 Layout 매니저를 설정
        RecyclerView.LayoutManager layoutManager
                = new LinearLayoutManager(this);
        chat_list_view.setLayoutManager(layoutManager);

    }
}