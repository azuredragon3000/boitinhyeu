package com.myapp.lovetest_azuredragon3000.common;

import android.os.CountDownTimer;

import com.myapp.lovetest_azuredragon3000.listener.InterfaceAnimBoiVoChong;
import com.myapp.lovetest_azuredragon3000.listener.InterfaceAnimation;

public class AnimChangeTextPerTimeBoiVoChong extends AnimChangeTextPerTime{

    InterfaceAnimBoiVoChong interfaceAnimBoiVoChong;
    public AnimChangeTextPerTimeBoiVoChong(InterfaceAnimation animChangeTextPerTime
            , InterfaceAnimBoiVoChong animChangeTextPerTimeBoiVoChong) {
        super(animChangeTextPerTime);
        this.interfaceAnimBoiVoChong = animChangeTextPerTimeBoiVoChong;
    }

    public void startRepeatingTask(long maxCounter, long diff){
        mStatusChecker.run();
        new CountDownTimer(maxCounter, diff) {
            public void onTick(long millisUntilFinished) {

            }
            public void onFinish() {
                stopRepeatingTask();
                // perform work
                interfaceAnimBoiVoChong.boivochongResult();
            }
        }.start();
    }
}
