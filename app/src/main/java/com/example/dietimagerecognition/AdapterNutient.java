package com.example.dietimagerecognition;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterNutient extends RecyclerView.Adapter<AdapterNutient.ItemViewHolder> {

    // adapter에 들어갈 list 입니다.
    private ArrayList<Data> listData = new ArrayList<>();

    @NonNull
    @Override
    public AdapterNutient.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // LayoutInflater를 이용하여 전 단계에서 만들었던 item.xml을 inflate 시킵니다.
        // return 인자는 ViewHolder 입니다.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nutient, parent, false);
        return new AdapterNutient.ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterNutient.ItemViewHolder holder, int position) {
        // Item을 하나, 하나 보여주는(bind 되는) 함수입니다.
        holder.onBind(listData.get(position));
    }

    @Override
    public int getItemCount() {
        // RecyclerView의 총 개수 입니다.
        return listData.size();
    }

    void addItem(Data data) {
        // 외부에서 item을 추가시킬 함수입니다.
        listData.add(data);
    }

    // RecyclerView의 핵심인 ViewHolder 입니다.
    // 여기서 subView를 setting 해줍니다.
    class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView textMenu;
        private TextView number;
        private TextView unit;


        ItemViewHolder(View itemView) {
            super(itemView);

            textMenu = itemView.findViewById(R.id.textMenu);
            number = itemView.findViewById(R.id.number);
            unit = itemView.findViewById(R.id.unit);
        }

        void onBind(Data data) {
            textMenu.setText(data.getTitle());
            number.setText(data.getContent());
            unit.setText(data.getContent2());

        }
    }
}
