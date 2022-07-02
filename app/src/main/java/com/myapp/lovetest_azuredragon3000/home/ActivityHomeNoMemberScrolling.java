package com.myapp.lovetest_azuredragon3000.home;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.myapp.lovetest_azuredragon3000.common.Constant;
import com.myapp.lovetest_azuredragon3000.common.AdsInterstitial;
import com.myapp.lovetest_azuredragon3000.common.AdsRewarded;
import com.myapp.lovetest_azuredragon3000.common.UserApp;
import com.myapp.lovetest_azuredragon3000.congiap12.ActivityNamSinhMain;
import com.myapp.lovetest_azuredragon3000.databinding.ContentScrollingNoMemberBinding;
import com.myapp.lovetest_azuredragon3000.ngontinh.ActivityNgonTinh;
import com.myapp.lovetest_azuredragon3000.boiphuongdong.ActivityPhuongDong;
import com.myapp.lovetest_azuredragon3000.boiphuongtay.ActivityPhuongTay;
import com.myapp.lovetest_azuredragon3000.boitinhyeu.ActivityBTYMain;
import com.myapp.lovetest_azuredragon3000.boivochong.ActivityBoiChongVo;
import com.myapp.lovetest_azuredragon3000.cauduyen.ActivityCauDuyen;
import com.myapp.lovetest_azuredragon3000.databinding.ActivityScrollingHomeNoMemberBinding;
import com.myapp.lovetest_azuredragon3000.luckydraw.ActivityLuckyCirle;
import com.myapp.lovetest_azuredragon3000.common.FirebaseUtiti;
import com.myapp.lovetest_azuredragon3000.common.FunctionCommon;
import com.myapp.lovetest_azuredragon3000.common.SubApp;
import com.myapp.lovetest_azuredragon3000.common.UpdateManager;
import com.myapp.lovetest_azuredragon3000.register.ActivityRegisterApp;
import com.myapp.lovetest_azuredragon3000.truyentinhyeu.ActivityTruyenTinhYeu;
import com.myapp.lovetest_azuredragon3000.login.LoginActivity;

public class ActivityHomeNoMemberScrolling extends AppCompatActivity {

    private ActivityScrollingHomeNoMemberBinding binding;
    //private ContentScrollingNoMemberBinding binding2;
    /* private */
    FirebaseUtiti firebaseUtiti;
    AdsInterstitial adsInterstitial;
    AdsRewarded adsRewarded;
    UpdateManager updateManager;
    public UserApp userApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityScrollingHomeNoMemberBinding.inflate(getLayoutInflater());
       // binding2 = ContentScrollingNoMemberBinding.bind(binding.getRoot());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        userApp = new UserApp();

        settingDB();

        // setting ads
        settingAds();

        /* inform user to update App if user is using old version */
        settingInformUpdate();

        // setup UI
        settingUI();
    }

    private void settingDB() {
        firebaseUtiti = ((SubApp)this.getApplication()).getDatabaseFirebase();
    }

    private void settingAds() {
        // mediation process
        FunctionCommon.MediationProcess(this);
        // rewarded ads process
        adsRewarded = new AdsRewarded("ca-app-pub-8404443559572571/1507395858",this);
        // interstitial ads process
        adsInterstitial = new AdsInterstitial(
                "07CC7E40850ABA2DF210A2D2564CAD76",
                "ca-app-pub-8404443559572571/1888597557",
                this,
                firebaseUtiti);
    }

    private void settingInformUpdate() {
        updateManager = new UpdateManager(this);
    }

    private void settingUI() {

        binding.extendlayout.logoBoitinhyeu.setOnClickListener(v -> {
            Intent intent = new Intent(this, ActivityBTYMain.class);
            intent.putExtra("KEY_NAME", userApp);
            startActivity(intent);
            firebaseUtiti.updateDB("boitinhyeu", Constant.APPNAME);
            adsInterstitial.showAds(this);
        });

        binding.extendlayout.logoBoivochong.setOnClickListener(v -> {
            Intent intent = new Intent(this, ActivityBoiChongVo.class);
            startActivity(intent);
            firebaseUtiti.updateDB("boivochong",Constant.APPNAME);
            adsInterstitial.showAds(this);
        });

        binding.extendlayout.logoBoiphuongdong.setOnClickListener(v -> {
            Intent intent = new Intent(this, ActivityPhuongDong.class);
            startActivity(intent);
            firebaseUtiti.updateDB("boiphuongdong",Constant.APPNAME);
            adsInterstitial.showAds(this);
        });

        binding.extendlayout.logoBoiphuongtay.setOnClickListener(v -> {
            Intent intent = new Intent(this, ActivityPhuongTay.class);
            startActivity(intent);
            firebaseUtiti.updateDB("boiphuongtay",Constant.APPNAME);
            adsInterstitial.showAds(this);
        });

        binding.extendlayout.logoVongxoaymayman.setOnClickListener(v -> {
            Intent intent = new Intent(this, ActivityLuckyCirle.class);
            startActivity(intent);
            firebaseUtiti.updateDB("vongquaymayman",Constant.APPNAME);
            adsInterstitial.showAds(this);
        });

        binding.extendlayout.logoBoi12congiap.setOnClickListener(v -> {
            Intent intent = new Intent(this, ActivityNamSinhMain.class);
            startActivity(intent);
            firebaseUtiti.updateDB("boi12congiap",Constant.APPNAME);
            adsInterstitial.showAds(this);
        });

        binding.extendlayout.logoNgontinh.setOnClickListener(v -> {
            Intent intent = new Intent(this, ActivityNgonTinh.class);
            startActivity(intent);
            firebaseUtiti.updateDB("ngontinh",Constant.APPNAME);
            adsInterstitial.showAds(this);
        });

        binding.extendlayout.logoTruyentinhyeu.setOnClickListener(v -> {
            Intent intent = new Intent(this, ActivityTruyenTinhYeu.class);
            startActivity(intent);
            firebaseUtiti.updateDB("truyentinhyeu",Constant.APPNAME);
            adsInterstitial.showAds(this);
        });

        binding.extendlayout.logoCauduyen.setOnClickListener(v -> {
            Intent intent = new Intent(this, ActivityCauDuyen.class);
            startActivity(intent);
            firebaseUtiti.updateDB("cauduyen",Constant.APPNAME);
            adsInterstitial.showAds(this);
        });


        binding.btDangnhap.setOnClickListener(v -> {
            firebaseUtiti.updateDB("dangnhap",Constant.APPNAME);
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            adsInterstitial.showAds(this);
        });

        binding.btDangky.setOnClickListener(v -> {
            firebaseUtiti.updateDB("dangky",Constant.APPNAME);
            Intent intent = new Intent(this, ActivityRegisterApp.class);
            startActivity(intent);
            adsInterstitial.showAds(this);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateManager.PerformWhenResume(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        updateManager.performWhenStop();
    }
}