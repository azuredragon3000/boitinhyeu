package com.myapp.lovetest_azuredragon3000.boiphuongdong;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.myapp.lovetest_azuredragon3000.R;
import com.myapp.lovetest_azuredragon3000.boiphuongdong.adapter.AdapterNamSinh;
import com.myapp.lovetest_azuredragon3000.congiap12.model.TuVi;
import com.myapp.lovetest_azuredragon3000.databinding.ActivityPhuongdongBinding;


import java.util.ArrayList;
import java.util.List;

public class ActivityPhuongDong extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY_CONGIAP = "key_con_giap_pd";
    ActivityPhuongdongBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhuongdongBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getString(R.string.phuongdong_boiphuongdong));
        actionBar.setDisplayHomeAsUpEnabled(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        binding.phuongDongRclView.setLayoutManager(manager);
        AdapterNamSinh adapter = new AdapterNamSinh(this, getData(), this);
        binding.phuongDongRclView.setAdapter(adapter);
    }

    private List<TuVi> getData() {
        List<TuVi> list = new ArrayList<>();
        list.add(new TuVi("13", getString(R.string.phuongdong_tuoiti)));
        list.add(new TuVi("14", getString(R.string.phuongdong_tuoisuu)));
        list.add(new TuVi("15", getString(R.string.phuongdong_tuoidan)));
        list.add(new TuVi("16", getString(R.string.phuongdong_tuoimao)));
        list.add(new TuVi("17", getString(R.string.phuongdong_tuoithin)));
        list.add(new TuVi("18", getString(R.string.phuongdong_tuoiran)));
        list.add(new TuVi("19", getString(R.string.phuongdong_tuoingo)));
        list.add(new TuVi("20", getString(R.string.phuongdong_tuoimui)));
        list.add(new TuVi("21", getString(R.string.phuongdong_tuoithan)));
        list.add(new TuVi("22", getString(R.string.phuongdong_tuoidau)));
        list.add(new TuVi("23", getString(R.string.phuongdong_tuoituat)));
        list.add(new TuVi("24", getString(R.string.phuongdong_tuoihoi)));
        return list;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int pos = (int) v.getTag();
        if (v.getId() == R.id.nam_sinh_layout) {
            Intent intent = new Intent(this, ActivityPhuongDongDetail.class);
            intent.putExtra(KEY_CONGIAP, getData().get(pos).getIdTuoi());
            startActivity(intent);
        }
    }
}
