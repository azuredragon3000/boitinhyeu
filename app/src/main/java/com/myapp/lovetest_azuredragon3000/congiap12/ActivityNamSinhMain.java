package com.myapp.lovetest_azuredragon3000.congiap12;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.myapp.lovetest_azuredragon3000.R;
import com.myapp.lovetest_azuredragon3000.congiap12.adapter.AdapterConGiap;
import com.myapp.lovetest_azuredragon3000.databinding.ActivityNamsinhmainBinding;
import com.myapp.lovetest_azuredragon3000.congiap12.model.TuVi;

import java.util.ArrayList;
import java.util.List;


public class ActivityNamSinhMain extends AppCompatActivity implements View.OnClickListener {

    private List<TuVi> list;
    public static final String KEY_CONGIAP = "key_congiap";
    public static final String KEY_CONGIAP_NAME = "key_congiap_name";
    ActivityNamsinhmainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNamsinhmainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 2);
        binding.mainRclView.setLayoutManager(manager);
        AdapterConGiap adapter = new AdapterConGiap( getData(), this);
        binding.mainRclView.setAdapter(adapter);
    }

    private List<TuVi> getData() {
        list = new ArrayList<>();
        list.add(new TuVi("1",getString(R.string.phuongdong_tuoiti), R.drawable.ti));
        list.add(new TuVi("2",getString(R.string.phuongdong_tuoisuu), R.drawable.suu));
        list.add(new TuVi("3",getString(R.string.phuongdong_tuoidan), R.drawable.dan));
        list.add(new TuVi("4",getString(R.string.phuongdong_tuoimao), R.drawable.mao));
        list.add(new TuVi("5",getString(R.string.phuongdong_tuoithin), R.drawable.thin));
        list.add(new TuVi("6",getString(R.string.phuongdong_tuoiran), R.drawable.ran));
        list.add(new TuVi("7",getString(R.string.phuongdong_tuoingo), R.drawable.ngo));
        list.add(new TuVi("8",getString(R.string.phuongdong_tuoimui), R.drawable.mui));
        list.add(new TuVi("9",getString(R.string.phuongdong_tuoithan), R.drawable.than));
        list.add(new TuVi("10",getString(R.string.phuongdong_tuoidau), R.drawable.dau));
        list.add(new TuVi("11",getString(R.string.phuongdong_tuoituat), R.drawable.tuat));
        list.add(new TuVi("12",getString(R.string.phuongdong_tuoihoi), R.drawable.hoi));
        return list;
    }

    @Override
    public void onClick(View v) {
        int position = (int)v.getTag();
        if (v.getId() == R.id.item_congiap_layout) {
            Intent intent = new Intent(this, ActivityNamSinh.class);
            intent.putExtra(KEY_CONGIAP, list.get(position).getIdConGiap());
            intent.putExtra(KEY_CONGIAP_NAME, list.get(position).getNameConGiap());
            startActivity(intent);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
