package com.myapp.lovetest_azuredragon3000.common;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;

public class AnimScaleObject {

    ObjectAnimator scaleDown;
    Animator.AnimatorListener animatorListener;

    public AnimScaleObject(Animator.AnimatorListener animatorListener, View view){
        scaleDown = ObjectAnimator.ofPropertyValuesHolder(
                view,
                PropertyValuesHolder.ofFloat("scaleX",0.5f),
                PropertyValuesHolder.ofFloat("scaleY",0.5f)
        );

        this.animatorListener = animatorListener;

    }

    public void startAnim(int duration, int repeatCount){
        scaleDown.setDuration(duration);
        scaleDown.setRepeatCount(repeatCount);
        scaleDown.setRepeatMode(ValueAnimator.REVERSE);
        scaleDown.addListener(animatorListener);
        scaleDown.start();
    }
}
