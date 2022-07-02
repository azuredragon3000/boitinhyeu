package com.myapp.lovetest_azuredragon3000.boitinhyeu.data;

import android.app.Activity;

import com.myapp.lovetest_azuredragon3000.ngontinh.model.ModelDanhNgon;
import com.myapp.lovetest_azuredragon3000.common.FunctionCommon;
import com.myapp.lovetest_azuredragon3000.common.SubApp;

import java.util.List;

public class BoitinhyeuObject {
    public int numberLove;
    public String contentLove;
    public String fulldate;

    public void start_app( int numberLove, String fulldate, Activity activity) {
        this.numberLove = numberLove;
        this.fulldate = fulldate;
        switch (numberLove){
            case 1:
                this.numberLove = 60;
                break;
            case 2:
                this.numberLove = 65;
                break;
            case 3:
                this.numberLove = 70;
                break;
            case 4:
                this.numberLove = 75;
                break;
            case 5:
                this.numberLove = 80;
                break;
            case 6:
                this.numberLove = 85;
                break;
            case 7:
                this.numberLove =  90;
                break;
            case 8:
                this.numberLove = 95;
                break;
            case 9:
                this.numberLove = 98;

                break;
            default:
                this.numberLove = 100;
                break;
        }
        contentLove = queryRandomData(activity);
    }

    private String queryRandomData(Activity activity) {
        List<ModelDanhNgon> modelDanhNgonList = ((SubApp) activity.getApplication()).getDatabaseTuviManager2().getDanhNgon();
        int random = FunctionCommon.getRandom(modelDanhNgonList.size(),0);
        return modelDanhNgonList.get(random).getContent();
    }
}
