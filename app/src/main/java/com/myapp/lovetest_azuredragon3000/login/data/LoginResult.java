package com.myapp.lovetest_azuredragon3000.login.data;

import androidx.annotation.Nullable;

import com.myapp.lovetest_azuredragon3000.common.UserApp;

/**
 * Authentication result : success (user details) or error message.
 */
public class LoginResult {
    @Nullable
    private UserApp success;
    @Nullable
    private Integer error;

    public LoginResult(@Nullable Integer error) {
        this.error = error;
    }

    public LoginResult(UserApp success) {
        this.success = success;
    }




    @Nullable
    public UserApp getSuccess() {
        return success;
    }

    @Nullable
    public Integer getError() {
        return error;
    }
}