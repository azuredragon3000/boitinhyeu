package com.myapp.lovetest_azuredragon3000.congiap12.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myapp.lovetest_azuredragon3000.R;
import com.myapp.lovetest_azuredragon3000.congiap12.model.TuVi;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterConGiap extends RecyclerView.Adapter<AdapterConGiap.ConGiapViewHolder> {

    private final List<TuVi> list;
    private final View.OnClickListener mOnClickListener;

    public AdapterConGiap(List<TuVi> list, View.OnClickListener onClickListener) {
        this.list = list;
        this.mOnClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ConGiapViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tuvi_congiap, parent, false);
        return new ConGiapViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConGiapViewHolder holder, int position) {
        TuVi tv = list.get(position);
        holder.conGiapTxt.setText(tv.getNameConGiap());
        Picasso.get().load(tv.getImageConGiap()).fit().into(holder.conGiapImg);
        holder.itemConGiap.setTag(position);
        holder.itemConGiap.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ConGiapViewHolder extends RecyclerView.ViewHolder{

        public ImageView conGiapImg;
        public TextView conGiapTxt;
        public RelativeLayout itemConGiap;

        public ConGiapViewHolder(@NonNull View itemView) {
            super(itemView);
            conGiapImg = itemView.findViewById(R.id.item_congiap_img);
            conGiapTxt = itemView.findViewById(R.id.item_congiap_txt);
            itemConGiap = itemView.findViewById(R.id.item_congiap_layout);
        }
    }
}
