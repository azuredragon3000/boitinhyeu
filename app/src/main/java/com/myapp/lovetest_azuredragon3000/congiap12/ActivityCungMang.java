package com.myapp.lovetest_azuredragon3000.congiap12;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.myapp.lovetest_azuredragon3000.boiphuongdong.adapter.AdapterCungMang;
import com.myapp.lovetest_azuredragon3000.databinding.ActivityCungmangBinding;
import com.myapp.lovetest_azuredragon3000.common.SubApp;

public class ActivityCungMang extends AppCompatActivity {

    //private RecyclerView rclView;
    private ActivityCungmangBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCungmangBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("cung mạng");
        actionBar.setDisplayHomeAsUpEnabled(true);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        binding.cungMangRclView.setLayoutManager(manager);

        AdapterCungMang adapter = new AdapterCungMang(this, ((SubApp) getApplication()).getDatabaseTuviManager2().getCungMang());
        binding.cungMangRclView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
