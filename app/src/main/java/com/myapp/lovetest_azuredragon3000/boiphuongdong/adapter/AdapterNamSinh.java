package com.myapp.lovetest_azuredragon3000.boiphuongdong.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.myapp.lovetest_azuredragon3000.R;
import com.myapp.lovetest_azuredragon3000.congiap12.model.TuVi;

import java.util.List;

public class AdapterNamSinh extends RecyclerView.Adapter<AdapterNamSinh.NamSinhViewHolder> {

    private Context context;
    private List<TuVi> list;
    private View.OnClickListener mOnClickListener;

    public AdapterNamSinh(Context context, List<TuVi> list, View.OnClickListener mOnClickListener) {
        this.context = context;
        this.list = list;
        this.mOnClickListener = mOnClickListener;
    }

    @NonNull
    @Override
    public NamSinhViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_nam_sinh, parent, false);
        return new NamSinhViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NamSinhViewHolder holder, int position) {
        holder.namSinhTxt.setText(list.get(position).getTuoiName());
        holder.namSinhLayout.setTag(position);
        holder.namSinhLayout.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class NamSinhViewHolder extends RecyclerView.ViewHolder{

        public TextView namSinhTxt;
        public RelativeLayout namSinhLayout;

        public NamSinhViewHolder(@NonNull View itemView) {
            super(itemView);
            namSinhTxt = itemView.findViewById(R.id.nam_sinh_txt);
            namSinhLayout = itemView.findViewById(R.id.nam_sinh_layout);
        }
    }
}
