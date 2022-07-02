package com.myapp.lovetest_azuredragon3000.listener;

import com.myapp.lovetest_azuredragon3000.login.data.Result;
import com.myapp.lovetest_azuredragon3000.common.UserApp;

public interface LoginRepositoryListener {
    void loginSuccess(Result<UserApp> result);
}
