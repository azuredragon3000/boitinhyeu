package com.myapp.lovetest_azuredragon3000.boiphuongtay;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.myapp.lovetest_azuredragon3000.R;
import com.myapp.lovetest_azuredragon3000.databinding.ActivityPhuongtaydetailBinding;
import com.myapp.lovetest_azuredragon3000.common.SubApp;


public class ActivityPhuongTayDetail extends AppCompatActivity {

    ActivityPhuongtaydetailBinding binding;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhuongtaydetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(getString(R.string.phuongtay_boiphuongtay));
        Intent intent = getIntent();
        String id = intent.getStringExtra(ActivityPhuongTay.KEY_PHUONG_TAY);
        binding.ptDetailTxt.setText(((SubApp) getApplication()).getDatabaseTuviManager2().getBoiPhuongTay(id).getContent());

        switch (id) {
            case "1":
                binding.ptDetailImg.setImageDrawable(getResources().getDrawable(R.drawable.aries));
                break;
            case "2":
                binding.ptDetailImg.setImageDrawable(getResources().getDrawable(R.drawable.taurus));
                break;
            case "3":
                binding.ptDetailImg.setImageDrawable(getResources().getDrawable(R.drawable.gemini));
                break;
            case "4":
                binding.ptDetailImg.setImageDrawable(getResources().getDrawable(R.drawable.cancer));
                break;
            case "5":
                binding.ptDetailImg.setImageDrawable(getResources().getDrawable(R.drawable.leo));
                break;
            case "6":
                binding.ptDetailImg.setImageDrawable(getResources().getDrawable(R.drawable.virgo));
                break;
            case "7":
                binding.ptDetailImg.setImageDrawable(getResources().getDrawable(R.drawable.libra));
                break;
            case "8":
                binding.ptDetailImg.setImageDrawable(getResources().getDrawable(R.drawable.scorpio));
                break;
            case "9":
                binding.ptDetailImg.setImageDrawable(getResources().getDrawable(R.drawable.sagittarius));
                break;
            case "10":
                binding.ptDetailImg.setImageDrawable(getResources().getDrawable(R.drawable.capricorn));
                break;
            case "11":
                binding.ptDetailImg.setImageDrawable(getResources().getDrawable(R.drawable.aquarius));
                break;
            case "12":
                binding.ptDetailImg.setImageDrawable(getResources().getDrawable(R.drawable.pisces));
                break;
            default:
                break;
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
