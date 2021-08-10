package com.nana.chatt.service;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.nana.chatt.adpter.ChattAdapter;
import com.nana.chatt.model.chatt;

// adpter에 있는 chattList에 추가해주어야함
public class FirebaseServiceImplV1 implements ChildEventListener {

    private ChattAdapter adapter;

    public FirebaseServiceImplV1(ChattAdapter adapter) {
        this.adapter = adapter;
    }

    //snapshot = chatt의 값을 갖고있는 것
    @Override
    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
        chatt chattVO = snapshot.getValue(chatt.class);
        adapter.addChatList(chattVO);
    }

    @Override
    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

    }

    @Override
    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

    }

    @Override
    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
}
