package com.myapp.lovetest_azuredragon3000.boiphuongtay;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.myapp.lovetest_azuredragon3000.R;
import com.myapp.lovetest_azuredragon3000.boiphuongtay.adapter.AdapterPhuongTay;
import com.myapp.lovetest_azuredragon3000.databinding.ActivityPhuongtayBinding;
import com.myapp.lovetest_azuredragon3000.boiphuongtay.data.PhuongTay;

import java.util.ArrayList;
import java.util.List;

public class ActivityPhuongTay extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY_PHUONG_TAY = "key_phuong_tay";
    ActivityPhuongtayBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhuongtayBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle(getString(R.string.phuongtay_boiphuongtay));
        actionBar.setDisplayHomeAsUpEnabled(true);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        binding.ptRclView.setLayoutManager(manager);
        AdapterPhuongTay adapter = new AdapterPhuongTay(this, getData(), this);
        binding.ptRclView.setAdapter(adapter);

    }

    private List<PhuongTay> getData() {
        List<PhuongTay> list = new ArrayList<>();
        list.add(new PhuongTay(1, R.drawable.aries, getString(R.string.phuongtay_aries)));
        list.add(new PhuongTay(2, R.drawable.taurus, getString(R.string.phuongtay_taurus)));
        list.add(new PhuongTay(3, R.drawable.gemini, getString(R.string.phuongtay_gemini)));
        list.add(new PhuongTay(4, R.drawable.cancer, getString(R.string.phuongtay_cancer)));
        list.add(new PhuongTay(5, R.drawable.leo, getString(R.string.phuongtay_leo)));
        list.add(new PhuongTay(6, R.drawable.virgo, getString(R.string.phuongtay_virgo)));
        list.add(new PhuongTay(7, R.drawable.libra, getString(R.string.phuongtay_libra)));
        list.add(new PhuongTay(8, R.drawable.scorpio, getString(R.string.phuongtay_scorpio)));
        list.add(new PhuongTay(9, R.drawable.sagittarius, getString(R.string.phuongtay_sagittarius)));
        list.add(new PhuongTay(10, R.drawable.capricorn, getString(R.string.phuongtay_capricorn)));
        list.add(new PhuongTay(11, R.drawable.aquarius, getString(R.string.phuongtay_aquarius)));
        list.add(new PhuongTay(12, R.drawable.pisces, getString(R.string.phuongtay_pisces)));
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
        if (v.getId() == R.id.pt_layout) {
            Intent intent = new Intent(this, ActivityPhuongTayDetail.class);
            intent.putExtra(KEY_PHUONG_TAY, getData().get(pos).getId() + "");
            startActivity(intent);
        }
    }
}
