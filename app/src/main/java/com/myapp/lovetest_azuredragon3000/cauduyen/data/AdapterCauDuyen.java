package com.myapp.lovetest_azuredragon3000.cauduyen.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myapp.lovetest_azuredragon3000.R;

import java.util.ArrayList;

public class AdapterCauDuyen extends
        RecyclerView.Adapter<AdapterCauDuyen.ViewHolder>{

    private Context mContext;
    private ArrayList<String> mLists;

    public AdapterCauDuyen(Context mContext, ArrayList<String> mHeros) {
        this.mContext = mContext;
        this.mLists = mHeros;
    }

    @NonNull
    @Override
    public AdapterCauDuyen.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View heroView = inflater.inflate(R.layout.layout_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(heroView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCauDuyen.ViewHolder holder, int position) {
        String hero = mLists.get(position);
        holder.mTextName.setText(hero);
    }

    @Override
    public int getItemCount() {
        return mLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextName = itemView.findViewById(R.id.text_name);
        }
    }
}
