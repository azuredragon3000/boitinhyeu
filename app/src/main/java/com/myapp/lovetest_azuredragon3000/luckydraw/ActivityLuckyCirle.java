package com.myapp.lovetest_azuredragon3000.luckydraw;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.myapp.lovetest_azuredragon3000.databinding.ActivityLuckyCirleBinding;

import java.util.Random;

public class ActivityLuckyCirle extends AppCompatActivity {

    CountDownTimer timer;
    private ActivityLuckyCirleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLuckyCirleBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // creating an object of Random class
        // to generate random numbers for the spin
        Random random = new Random();

        // on click listener for btnSpin
        binding.btnSpin.setOnClickListener(view1 -> {
            // disabling the button so that user
            // should not click on the button
            // while the wheel is spinning
            binding.btnSpin.setEnabled(false);

            // reading random value between 10 to 30
            int spin = random.nextInt(20)+10;

            // since the wheel has 10 divisions, the
            // rotation should be a multiple of
            // 360/10 = 36 degrees
            spin = spin * 36;

            // timer for each degree movement
            timer = new CountDownTimer(spin*20,1) {
                @Override
                public void onTick(long l) {
                    // rotate the wheel
                    float rotation = binding.ivWheel.getRotation() + 2;
                    binding.ivWheel.setRotation(rotation);
                }

                @Override
                public void onFinish() {
                    // enabling the button again
                    binding.btnSpin.setEnabled(true);
                }
            }.start();

        });
    }
}