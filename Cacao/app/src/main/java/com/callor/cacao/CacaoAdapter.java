package com.callor.cacao;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.callor.cacao.model.Cacao;

import java.util.List;

// Adapter : RecyclerView와 데이터들을 연결해주는 역할
public class CacaoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Cacao> cacaoList;

    public void addCacaoList(Cacao cacao) {
        cacaoList.add(cacao);

        // 아이템이 추가된 것을 갱신하기 위함
        notifyItemInserted(cacaoList.size()-1);
    }

    public CacaoAdapter(List<Cacao> cacaoList) {
        this.cacaoList = cacaoList;
    }

    // 레이아웃을 세팅해서 보여주는 것
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View item_layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout, parent,false);


        CacaoViewHolder viewHolder = new CacaoViewHolder(item_layout);
        return viewHolder;
    }

    // position : VO의 인덱스 값
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Cacao cacao = cacaoList.get(position);

        CacaoViewHolder cacaoViewHolder = (CacaoViewHolder) holder;

        cacaoViewHolder.item_name.setText(cacao.getName());
        cacaoViewHolder.item_msg.setText(cacao.getMsg());

    }

    @Override
    public int getItemCount() {
        return cacaoList == null ? 0 : cacaoList.size();
    }

    public static class CacaoViewHolder extends RecyclerView.ViewHolder {

        public TextView item_name;
        public TextView item_msg;

        public CacaoViewHolder(@NonNull View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.item_name);
            item_msg = itemView.findViewById(R.id.item_msg);
        }
    }
}
