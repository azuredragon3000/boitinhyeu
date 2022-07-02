package com.myapp.lovetest_azuredragon3000.boiphuongdong;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.myapp.lovetest_azuredragon3000.R;
import com.myapp.lovetest_azuredragon3000.databinding.ActivityPhuongdongdetailBinding;
import com.myapp.lovetest_azuredragon3000.common.SubApp;


public class ActivityPhuongDongDetail extends AppCompatActivity {

    ActivityPhuongdongdetailBinding binding;
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhuongdongdetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(getString(R.string.phuongdong_boiphuongdong));

        Intent intent = getIntent();
        String id = intent.getStringExtra(ActivityPhuongDong.KEY_CONGIAP);
        binding.pdDetailTxt.setText(((SubApp) getApplication()).getDatabaseTuviManager2()
                .getBoiPhuongDong(id).getContent());

        switch (id) {
            case "13":
                binding.pdDetailImg.setImageDrawable(getResources().getDrawable(R.drawable.ti));
                break;
            case "14":
                binding.pdDetailImg.setImageDrawable(getResources().getDrawable(R.drawable.suu));
                break;
            case "15":
                binding.pdDetailImg.setImageDrawable(getResources().getDrawable(R.drawable.dan));
                break;
            case "16":
                binding.pdDetailImg.setImageDrawable(getResources().getDrawable(R.drawable.mao));
                break;
            case "17":
                binding.pdDetailImg.setImageDrawable(getResources().getDrawable(R.drawable.thin));
                break;
            case "18":
                binding.pdDetailImg.setImageDrawable(getResources().getDrawable(R.drawable.ran));
                break;
            case "19":
                binding.pdDetailImg.setImageDrawable(getResources().getDrawable(R.drawable.ngo));
                break;
            case "20":
                binding.pdDetailImg.setImageDrawable(getResources().getDrawable(R.drawable.mui));
                break;
            case "21":
                binding.pdDetailImg.setImageDrawable(getResources().getDrawable(R.drawable.than));
                break;
            case "22":
                binding.pdDetailImg.setImageDrawable(getResources().getDrawable(R.drawable.dau));
                break;
            case "23":
                binding.pdDetailImg.setImageDrawable(getResources().getDrawable(R.drawable.tuat));
                break;
            case "24":
                binding.pdDetailImg.setImageDrawable(getResources().getDrawable(R.drawable.hoi));
                break;
            default:
                binding.pdDetailImg.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (android.R.id.home == item.getItemId()) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
