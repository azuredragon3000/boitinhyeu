package com.myapp.lovetest_azuredragon3000.common;

import android.annotation.SuppressLint;
import android.os.Handler;

import com.myapp.lovetest_azuredragon3000.listener.InterfaceAnimation;

public class AnimChangeTextPerTime {
    private int mInterval = 100;
    private Handler mHandler;
    private InterfaceAnimation animChangeTextPerTime;


    public AnimChangeTextPerTime(InterfaceAnimation animChangeTextPerTime){
        this.animChangeTextPerTime = animChangeTextPerTime;
        mHandler = new Handler();
    }
    Runnable mStatusChecker = new Runnable() {
        @SuppressLint("SetTextI18n")
        @Override
        public void run() {
            try{
                animChangeTextPerTime.doWork();
            }finally {
                mHandler.postDelayed(mStatusChecker,mInterval);
            }
        }
    };

    public void startRepeatingTask(){
        mStatusChecker.run();
    }

    public void stopRepeatingTask(){
        mHandler.removeCallbacks(mStatusChecker);
    }
}
