package com.myapp.lovetest_azuredragon3000.login.data;

import android.app.Activity;

import com.myapp.lovetest_azuredragon3000.common.FirebaseUtiti;
import com.myapp.lovetest_azuredragon3000.listener.LoginRepositoryListener;
import com.myapp.lovetest_azuredragon3000.common.SubApp;
import com.myapp.lovetest_azuredragon3000.common.UserApp;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSourceFirebase {

    Activity activity;
    FirebaseUtiti firebaseUtiti;

    public LoginDataSourceFirebase(Activity activity) {
        this.activity = activity;
        firebaseUtiti = ((SubApp)activity.getApplication()).getDatabaseFirebase();
    }

    public void login(LoginRepositoryListener loginRepositoryListener, String username, String password) {
        firebaseUtiti.checkLogin(loginRepositoryListener,username,password);
    }

    public void logout() {
        // TODO: revoke authentication
    }

    public static boolean CheckUserName(String username, String pass, UserApp user) {
        try{
            return !user.getUserId().equals(username) || !user.getPass().equals(pass);
        }catch (Exception e){
            return true;
        }
    }
}