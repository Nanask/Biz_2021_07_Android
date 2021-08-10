package com.nana.chatt.adpter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nana.chatt.R;
import com.nana.chatt.model.chatt;

import java.util.List;

/*
RecyclerView.Adapter 구현한 클래스
RecyclerView 에 데이터를 표현하고자 할 때 사용하는 Helper클래스(도와주는 도구 클래스)

 */
public class ChattAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<chatt> chattList;


    /**
     * 외부에서 chatt 데이터 아이템을 List를 추가하고 추가된 List는 RecyclerView를 통해서
     * 화면에 다시 그려지게 될 것이다.
     * @param chatt
     */
    public void addChatList(chatt chatt) {

        // 메세지를 chattList에 추가하기
        chattList.add(chatt);

        // RecyclerView에게 chattList가 변화 되었으니 다시 화면에 그려라 라고 지시하기
        // chattList의 끝(size() -1위치에 값이 추가 되었으니)에 값이 추가 되었으니 다시 그려라

        public void addChatList (chatt chat){
            chattList.add(chat);

            notifyItemInserted(chattList.size() - 1);

        }

    /*
    RecyclerView 가 화면에 그릴 데이터들을 전달받을 통로
    @param chattList
     */
    public ChattAdapter(List < chatt > chattList) {
            this.chattList = chattList;
        }
    /*
    chatt_item.xml 파일을 읽어서 한개의 아이템을 화면에 그릴 준비
     */

        // item.xml파일을 뷰로 읽어주는 메서드 ChattViewHolder로 옮겨줌 그리고 그걸 onBindViewHolder로 받기
        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent,int viewType){

            // parent (메인엑티비티)를 가져와서
            // LayoutInflater.from().inflate(layout파일)
            // chatt_item.xml 파일은 한개의 파일이 화면 전체를 구성하지 않고
            // 여기에서는 RecyclerView 내부에 각각 데이터 아이템을 그릴 도구로 사용이 된다.
            // 이러한 layoudt은 setContentView()를 사용하지 않고
            // layoutInfalter.infalte() 함수를 사용하여 만든다
            // setContentView(R.layout.activity_main) 같은 레이아웃이나 다른 역할
            View item_layout
                    = LayoutInflater.from(parent.getContext()).inflate(R.layout.chatt_item, parent, false);

            ChattViewHolder viewHolder = new ChattViewHolder(item_layout);
            return viewHolder;

        }

        // viewholder 랑 연결해주는 코드?
        // chattList에서 한개의 데이터를 getter하여
        // chat_item.xml파일과 함께 rendering을 수행할 method
        @Override
        public void onBindViewHolder (@NonNull RecyclerView.ViewHolder holder,int position){

            //전체 chattList에서 현재 화면에 그릴 item 추출하기
            chatt chatt = chattList.get(position);

            //RecyclerView.ViewHolder holder를 변환시켜주기
            ChattViewHolder chattViewHolder = (ChattViewHolder) holder;

            //chat_item.xml의 TextView 객체에 데이터를 담기
            chattViewHolder.item_name.setText(chatt.getName());
            chattViewHolder.item_msg.setText(chatt.getMsg());

        }


        // RecyclerView 가 데이터들을 화면에 표시할 때 참조하는 함수
        // @return
        @Override
        public int getItemCount () {
            return chattList == null ? 0 : chattList.size();
        }

        // class 내부에 in class
        public static class ChattViewHolder extends RecyclerView.ViewHolder {

            public TextView item_name;
            public TextView item_msg;

            // 각각의 데이터를 표현하기 위한
            // chatt_item.xml의 view 객체를 초기화(생성)하는 method
            // findViewById는 호출하는 것
            public ChattViewHolder(@NonNull View itemView) {
                super(itemView);
                item_name = itemView.findViewById(R.id.item_name);
                item_msg = itemView.findViewById(R.id.item_msg);
            }
        }
    }
