package com.myapp.lovetest_azuredragon3000.listener;

import com.myapp.lovetest_azuredragon3000.common.UserApp;

public interface InterfaceFirebaseUtiti {
    void insertSuccessful(UserApp user);
    void informWrongUserName();
    void navigateToHome(UserApp user);

    void informNotExistUser();
}
