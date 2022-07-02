package com.myapp.lovetest_azuredragon3000.login.model;

public class ModelDataBoiTinhYeu {

    public String res;
    public int number;
    public String fulldate;
    public String result;

    public ModelDataBoiTinhYeu(){

    }

    public ModelDataBoiTinhYeu(int number, String res,String fulldate, String result) {
        this.number = number;
        this.res = res;
        this.fulldate = fulldate;
        this.result = result;
    }
}
