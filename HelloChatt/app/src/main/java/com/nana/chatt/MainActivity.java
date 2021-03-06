package com.nana.chatt;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nana.chatt.adpter.ChattAdapter;
import com.nana.chatt.model.chatt;
import com.nana.chatt.service.FirebaseServiceImplV1;

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

    //firebase와 연결하는 컨넥션을 위한 객체선언
    private DatabaseReference dbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // adpter가 먼저 선언이 되야하기 때문에 위치를 바꾸줬음

        // layout.xml 파일을 읽어서 화면을 만드는 method
        // setContentView는 한개의 파일을 읽어서 한개의 전체 화면을 만드는 것
        setContentView(R.layout.activity_main);

        chat_list_view = findViewById(R.id.chatt_list_view);
//
//        //0. 보여줄 데이터 객체 생성

        chattList = new ArrayList<chatt>();

        // 1. Adpter 객체 생성
        // Adapter 객체를 생성할 때 보여줄 데이터 객체를 생성자 매개변수로 주입해주어야 한다
        chattAdapter = new ChattAdapter(chattList);

        // 2. RecyclerView.Adpterd와 RecyclerView, 를 서로연결
        chat_list_view.setAdapter(chattAdapter);

        // 3.RecyclerView의 데이터를 표현할 때 사용할 Layout 매니저를 설정
        RecyclerView.LayoutManager layoutManager
                = new LinearLayoutManager(this);
        chat_list_view.setLayoutManager(layoutManager);


        FirebaseDatabase dbConn = FirebaseDatabase.getInstance();
        // 사용할 table(path)
        // realtimeDatebase에서는 table을 path라는 개념으로 부른다.
        dbRef = dbConn.getReference("chatting");

        // firebase로부터 데이터 변화 이벤트가 전달되면
        // 이벤트를 수신하여 할 일을 지정하기 위한 핸들러 선언
        ChildEventListener childEventListener = new FirebaseServiceImplV1(chattAdapter);

        // 이벤트 핸들러 연결
        dbRef.addChildEventListener(childEventListener);

        txt_msg = findViewById(R.id.txt_msg);
        btn_send = findViewById(R.id.btn_send);

//        chat_list_view = findViewById(R.id.chatt_list_view);
//
//        //0. 보여줄 데이터 객체 생성
        /*
        realtime으로 연동해서 하기 때문에 가상의 데이터는 필요없어지므로 주석처리
        chattList = new ArrayList<chatt>();
        chatt chatt = new chatt();
        chatt.setName("홍길동");
        chatt.setMsg("반갑습니다");
        chattList.add(chatt);

        chatt = new chatt();
        chatt.setName("성춘향");
        chatt.setMsg("안녕하세요");
        chattList.add(chatt);

         */


//        // 1. Adpter 객체 생성
//        // Adapter 객체를 생성할 때 보여줄 데이터 객체를 생성자 매개변수로 주입해주어야 한다
//        chattAdapter = new ChattAdapter(chattList);
//
//        // 2. RecyclerView.Adpterd와 RecyclerView, 를 서로연결
//        chat_list_view.setAdapter(chattAdapter);
//
//        // 3.RecyclerView의 데이터를 표현할 때 사용할 Layout 매니저를 설정
//        RecyclerView.LayoutManager layoutManager
//                = new LinearLayoutManager(this);
//        chat_list_view.setLayoutManager(layoutManager);

        /**
         * EditBox에 메시지를 입력하고 Send 버튼을 클릭했을 때 할일 지정하기
         *
         * EditBox에 메세지를 입력하고 Send를 하면
         * Firebase의 Realtime DatoBase에 데이터를 insert하기         */

        btn_send.setOnClickListener(view -> {
            // EditBox에 입력된 문자열을 추출하여 문자열 변수에 담기
            String msg = txt_msg.getText().toString();
            // 입력된 값이 null이 아니고 비어있지 않다면
            if(msg != null && !msg.isEmpty()) {

                String toastMsg = String.format("메세지 : %s",msg);

                Toast.makeText(this,toastMsg,Toast.LENGTH_SHORT).show();

                chatt chattVO = new chatt();
                chattVO.setMsg(msg);
                chattVO.setName("홍길동");

                Log.d("클릭", chattVO.toString());

                //chattList.add(chattVO);
                // firebase의 realtime DB의 table에 데이터를 insert하라
                // = push하라

                 dbRef.push().setValue(chattVO);

                // 전송되었는지 확인하는 테스트 코드드
               txt_msg.setText("");

            }

        });

    }
}