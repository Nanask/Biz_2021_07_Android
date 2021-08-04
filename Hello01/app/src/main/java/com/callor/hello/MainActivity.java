package com.callor.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.callor.hello.ui.login.LoginActivity;
import com.google.android.material.snackbar.Snackbar;

/*
Activity.class
기본 하는 일
1. 화면에 UI를 표현하는 일
    *.xml 파일을 읽어서 화면을 구현
    event Handling 수행
2. Activity 이름 짓기
    Activity 클래스는 UI 관련된 파일을 1개 이상 연결한다
    이름Activity.java 라는 이름으로 작성하고
    activity_이름.xml 라는 이름으로 화면 구현 xml 파일을 작성
 */
public class MainActivity extends AppCompatActivity {

    private TextView txt1 = null;
    private TextView txt2 = null;

    private EditText edit_01 = null;

    private Button btn_next = null;
    private Button btn_login = null;
    private Button btn_phone = null;

    /*
    on* () method는 대체로 event Handler 들이다
    Create 동작이 실행될때 같이 동반하여 작동되는 Method
    작성하고 있는 App이 안드로이드 phone에서 생성될 때 작동하는 method

    안드로이드 App에서는 onCreate()를 진입점 method로 취급한다
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        res.layout.activity_main.xml 파일을 읽어서(열어서)
        시작화면(현재클래스가 작동되는 화면)을 만들어라
         */
        setContentView(R.layout.activity_main);

        /*
        xml view에 설정된 view content를 java code에서 사용하기 위하여
        import 하는 절차
        */
        txt1 = findViewById(R.id.txt_01);
        txt2 = findViewById(R.id.txt_02);

        edit_01 = findViewById(R.id.edit_01);

//        button을 사용하기 위해 초기화
        btn_next = findViewById(R.id.btn_next);
        btn_login = findViewById(R.id.btn_login);
        btn_phone = findViewById(R.id.btn_phone);

//            click event를 처리할 event Handler를 선언하기
//        interface를 사용하여 직접 객체를 생성하는 방법
//        전통자바에서는 interface를 impl한 클래스를 작성하고
//        클래스를 사용하여 객체를 선언(생성, 초기화) 하였는데
//        interface를 직접 객체를 사용하는 용도로 활용하기

        View.OnClickListener btn_Click = new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                if(v.getId() == R.id.btn_login) {

                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);

                }else if(v.getId() == R.id.btn_next) {

                    /*
                    *intent(인텐드)
                    * Android에서 Activity로 부르는 다른 이름
                    * Activity의 super parent 인터페이스 이다.
                    *
                    * 새로운 Activity를 보여주는 설치
                    * 1. Intent 클래스를 사용하여 인텐드 생성
                    * 2. startActivity() method 호출하여 새로운 Activity로 화면 전환
                    *
                    * startActivity()는 이미 준비된 method
                    */

                    //mainActivity에서 SecondActivity로 옮겨라...?
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);


                }else if(v.getId() == R.id.btn_phone) {
                    // 즉시 전화걸기(권한필요)
//                    Intent intent = new Intent("android.intent.action.CALL", Uri.parse("010-9652-8085"));
//                    startActivity(intent);

                    //전화걸기 화면 띄우기
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-9652-8085"));
                    startActivity(intent);
                }

            }
        };
//        하나의 이벤트 핸들러를 생성하여 버튼 동시에 적용하기
//        공통으로 핸들러를 적용시키기
        btn_next.setOnClickListener(btn_Click);
        btn_login.setOnClickListener(btn_Click);
        btn_phone.setOnClickListener(btn_Click);

        txt1.setText("우리나라 만세");
        txt2.setText("대한민국 만세");

        txt2.setOnClickListener((view)->{

            String txt = edit_01.getText().toString();
            txt = "입력한 전화번호 " + txt;

            Toast.makeText(this, txt, Toast.LENGTH_LONG)
                    .show();
        });

        txt1.setOnClickListener(view->{

            String str = edit_01.getText().toString();
            String msg = String.format("입력한 번호 : %s", str);


            Snackbar.make(view,
                    msg, Snackbar.LENGTH_LONG)
                    .show();
        });

    }
}