package com.callor.cacao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.callor.cacao.model.Cacao;
import com.callor.cacao.service.FirebaseServiceImplV1;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText txt_msg;
    private Button button;

    private RecyclerView cacao_list_view;
    private CacaoAdapter cacaoAdapter;

    private List<Cacao> cacaoList;

    private DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cacao_list_view = findViewById(R.id.cacao_list_view);

        cacaoList = new ArrayList<Cacao>();

        cacaoAdapter = new CacaoAdapter(cacaoList);

        cacao_list_view.setAdapter(cacaoAdapter);

        RecyclerView.LayoutManager layoutManager
                = new LinearLayoutManager(this);
        cacao_list_view.setLayoutManager(layoutManager);

        FirebaseDatabase dbConn = FirebaseDatabase.getInstance();

        dbRef = dbConn.getReference("chatting");

        ChildEventListener childEventListener = new FirebaseServiceImplV1(cacaoAdapter);

        dbRef.addChildEventListener(childEventListener);

        txt_msg = findViewById(R.id.txt_msg);
        button = findViewById(R.id.button);

        button.setOnClickListener(view -> {
            String msg = txt_msg.getText().toString();

            if(msg != null && !msg.isEmpty()) {

                Cacao cacao = new Cacao();
                cacao.setMsg(msg);
                cacao.setName("나나");

                dbRef.push().setValue(cacao);

                txt_msg.setText("");
            }
        });



    }
}