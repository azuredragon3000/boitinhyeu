package com.myapp.lovetest_azuredragon3000.truyentinhyeu;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.myapp.lovetest_azuredragon3000.R;


public class ActivityTruyenTinhYeu extends AppCompatActivity {
    NavController navController;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truyentinhyeu);

        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment2);
        assert navHostFragment != null;
        navController = navHostFragment.getNavController();

    }
}