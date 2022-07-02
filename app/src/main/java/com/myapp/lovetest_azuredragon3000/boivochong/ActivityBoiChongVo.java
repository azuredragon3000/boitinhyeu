package com.myapp.lovetest_azuredragon3000.boivochong;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.myapp.lovetest_azuredragon3000.common.Constant;
import com.myapp.lovetest_azuredragon3000.R;
import com.myapp.lovetest_azuredragon3000.common.AdsBanner;
import com.myapp.lovetest_azuredragon3000.common.AnimChangeTextPerTimeBoiVoChong;
import com.myapp.lovetest_azuredragon3000.databinding.ActivityBoivochongBinding;
import com.myapp.lovetest_azuredragon3000.listener.InterfaceAnimBoiVoChong;
import com.myapp.lovetest_azuredragon3000.listener.InterfaceAnimation;
import com.myapp.lovetest_azuredragon3000.common.FirebaseUtiti;
import com.myapp.lovetest_azuredragon3000.common.SubApp;

import java.util.Random;

public class ActivityBoiChongVo extends AppCompatActivity implements InterfaceAnimation, InterfaceAnimBoiVoChong {

    AnimChangeTextPerTimeBoiVoChong animChangeTextPerTime;
    private ActivityBoivochongBinding binding;
    FirebaseUtiti firebaseUtiti;
    String[] name;
    int radianid;
    String randomString;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBoivochongBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        firebaseUtiti = ((SubApp)this.getApplication()).getDatabaseFirebase();
        new AdsBanner(this,this, R.id.adView);
        binding.timvo.setOnClickListener(v -> {
            firebaseUtiti.updateDB("clickboivochong", Constant.APPNAME);
            firebaseUtiti.updateDB2("clickboivochongcontent",Constant.APPNAME,
                    binding.display.getText().toString());

            try {
                radianid = binding.radio.getCheckedRadioButtonId();
                if(binding.radioNam.getId() == radianid){
                    animChangeTextPerTime = new AnimChangeTextPerTimeBoiVoChong(this, this);
                    animChangeTextPerTime.startRepeatingTask(2000, 1000);
                }else if(binding.radioNu.getId() == radianid){
                    animChangeTextPerTime = new AnimChangeTextPerTimeBoiVoChong(this, this);
                    animChangeTextPerTime.startRepeatingTask(2000, 1000);
                }else{
                    //binding.display.setText("vui lòng điền tên bạn hoặc chọn giới tính");
                    binding.display.setText(getString(R.string.boivochong_chongioitinh));
                }
            }catch (Exception e){
                //binding.display.setText("vui lòng điền tên bạn hoặc chọn giới tính");
                binding.display.setText(getString(R.string.boivochong_chongioitinh));
            }
        });
    }

    @Override
    public void doWork() {
        Random random = new Random();
        if(binding.radioNam.getId() == radianid){
            name = getResources().getStringArray(R.array.tennu);
            randomString = name[random.nextInt(name.length)];
            binding.display.setText("vợ bạn trong tương lai là: "+randomString);
        }else if(binding.radioNu.getId() == radianid){
            name = getResources().getStringArray(R.array.tennam);
            randomString = name[random.nextInt(name.length)];
            binding.display.setText("chồng bạn trong tương lai là: "+randomString);
        }
    }

    @Override
    public void boivochongResult() {
        if(binding.radioNam.getId() == radianid){
            binding.display.setText("vợ bạn trong tương lai là: "+randomString);
        }else if(binding.radioNu.getId() == radianid){
            binding.display.setText("chồng bạn trong tương lai là: "+randomString);
        }
    }
}
