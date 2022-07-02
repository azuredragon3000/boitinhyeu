package com.myapp.lovetest_azuredragon3000.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.myapp.lovetest_azuredragon3000.home.ActivityHomeMemberScrolling;
import com.myapp.lovetest_azuredragon3000.R;
import com.myapp.lovetest_azuredragon3000.common.AdsBanner;
import com.myapp.lovetest_azuredragon3000.common.UserApp;
import com.myapp.lovetest_azuredragon3000.databinding.ActivityRegisterBinding;
import com.myapp.lovetest_azuredragon3000.listener.InterfaceFirebaseUtiti;
import com.myapp.lovetest_azuredragon3000.common.FirebaseUtiti;
import com.myapp.lovetest_azuredragon3000.common.SubApp;
import com.myapp.lovetest_azuredragon3000.login.LoginActivity;

public class ActivityRegisterApp extends AppCompatActivity implements InterfaceFirebaseUtiti {

    FirebaseUtiti firebaseUtiti;
    ActivityRegisterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        new AdsBanner(this,this, R.id.adView);

        firebaseUtiti = ((SubApp)this.getApplication()).getDatabaseFirebase();
        settingUI();
    }

    private void settingUI() {

        binding.btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityRegisterApp.this, LoginActivity.class);
            startActivity(intent);
        });

        binding.btnRegister.setOnClickListener(v -> {
            String username = binding.etUsername.getText().toString();
            String password = binding.etPassword.getText().toString();
            String confirm_password = binding.etCpassword.getText().toString();

            if(username.equals("") || password.equals("") || confirm_password.equals("")){
                Toast.makeText(getApplicationContext(), "Fields Required", Toast.LENGTH_SHORT).show();
            }else{
                if(password.equals(confirm_password)){
                    firebaseUtiti.firebaseCheckUsername(this,username,password);
                }else{
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void informWrongUserName() {
        Toast.makeText(getApplicationContext(), "Username already taken", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToHome(UserApp user) {

    }

    @Override
    public void informNotExistUser() {

    }

    public void insertSuccessful(UserApp user) {
        //Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_SHORT).show();
        binding.etUsername.setText("");
        binding.etPassword.setText("");
        binding.etCpassword.setText("");
        //this.userApp  = user;
        Intent intent = new Intent(ActivityRegisterApp.this, ActivityHomeMemberScrolling.class);
        intent.putExtra("KEY_NAME", user);
        startActivity(intent);
    }
}
