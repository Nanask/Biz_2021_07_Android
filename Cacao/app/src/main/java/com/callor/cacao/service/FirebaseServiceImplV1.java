package com.callor.cacao.service;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.callor.cacao.CacaoAdapter;
import com.callor.cacao.model.Cacao;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

public class FirebaseServiceImplV1 implements ChildEventListener {

    private CacaoAdapter adapter;

    public FirebaseServiceImplV1(CacaoAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
        Cacao cacao = snapshot.getValue(Cacao.class);
        adapter.addCacaoList(cacao);

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
