package com.callor.cacao;

import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.callor.cacao.model.Cacao;

import java.util.List;

// Adapter : RecyclerView와 데이터들을 연결해주는 역할
public class CacaoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Cacao> cacaoList;
    private String name;

    public void addCacaoList(Cacao cacao) {
        cacaoList.add(cacao);

        // 아이템이 추가된 것을 갱신하기 위함
        notifyItemInserted(cacaoList.size()-1);
    }
//여기에 이름값을 넣으면 전역변수로 설정해 놓은 값에 값이 담기는 형식으로 만들 예정
    public CacaoAdapter(List<Cacao> cacaoList) {
//        this.cacaoList = cacaoList;
        this(cacaoList,"익명");
    }

    public CacaoAdapter(List<Cacao> cacaoList,String name) {
        this.cacaoList = cacaoList;
        this.name = name;
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

        /**
         * 현재 App에서 보낸 메세지를 DB에서 가져왔으면(Fetch) = 이름이 같다.
         * this.name 변수에는 App에 설정된 nickname이 담겨 있다.
         * 그리고 firebase에서 가져온 데이터에서 이름이 nickname과 같으면
         * 오른쪽 정렬하여 보여라
         * 오른쪽에 보이게 정렬하기
         */
        if(this.name.equals(cacao.getName())) {

            //이름과 메세지를 오른쪽 정렬
            cacaoViewHolder.item_name.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            cacaoViewHolder.item_msg.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);

            cacaoViewHolder.msgLinear.setGravity(Gravity.END);
            cacaoViewHolder.item_msg.setBackgroundColor(Color.parseColor("#ffEB3B"));

        }

    }

    @Override
    public int getItemCount() {
        return cacaoList == null ? 0 : cacaoList.size();
    }

    public static class CacaoViewHolder extends RecyclerView.ViewHolder {

        public TextView item_name;
        public TextView item_msg;

        public LinearLayout msgLinear;

        public CacaoViewHolder(@NonNull View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.item_name);
            item_msg = itemView.findViewById(R.id.item_msg);

            /**
             * item_name과 item_msg를 감싸고 있는 layout(LinearLayout)에 접근하기 위하여
             * 객체로 생성
             */
            msgLinear = itemView.findViewById(R.id.msg_linear);


        }
    }
}
