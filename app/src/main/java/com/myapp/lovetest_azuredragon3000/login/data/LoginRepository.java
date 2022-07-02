package com.myapp.lovetest_azuredragon3000.login.data;

import com.myapp.lovetest_azuredragon3000.listener.LoginRepositoryListener;
import com.myapp.lovetest_azuredragon3000.listener.LoginViewListener;
import com.myapp.lovetest_azuredragon3000.common.UserApp;

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */
public class LoginRepository implements LoginRepositoryListener {

    private static volatile LoginRepository instance;
    LoginViewListener interfaaceFirebaseUtiti3;

    private LoginDataSourceFirebase dataSource;

    private UserApp user = null;

    // private constructor : singleton access
    private LoginRepository(LoginDataSourceFirebase dataSource) {
        this.dataSource = dataSource;
    }

    public static LoginRepository getInstance(LoginDataSourceFirebase dataSource) {
        if (instance == null) {
            instance = new LoginRepository(dataSource);
        }
        return instance;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public void logout() {
        user = null;
        dataSource.logout();
    }

    private void setUserApp(UserApp user) {
        this.user = user;
    }


    public void login(LoginViewListener interfaaceFirebaseUtiti3, String username, String password) {
        dataSource.login(this,username, password);
        this.interfaaceFirebaseUtiti3 = interfaaceFirebaseUtiti3;
    }

    @Override
    public void loginSuccess(Result<UserApp> result) {
        if (result instanceof Result.Success) {
            setUserApp(((Result.Success<UserApp>) result).getData());
        }
        this.interfaaceFirebaseUtiti3.loginSuccess(result);
    }
}