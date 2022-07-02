package com.myapp.lovetest_azuredragon3000.common;

import android.app.Application;

import java.io.Serializable;

public class UserApp implements Serializable {
    public String name;
    public String pass;
    public String userId;
    public String gold;
    private static volatile UserApp INSTANCE;

    UserApp(String user_id, String username, String password, String gold_id) {
        name = username;
        pass = password;
        userId = user_id;
        gold = gold_id;
    }

    public UserApp() {
        name = "";
        pass = "";
        userId = "";
        gold = "";
    }



    public String getGold() {
        return gold;
    }

    public void setGold(String gold) {
        this.gold = gold;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
