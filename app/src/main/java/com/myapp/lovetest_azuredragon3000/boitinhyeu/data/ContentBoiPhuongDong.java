package com.myapp.lovetest_azuredragon3000.boitinhyeu.data;

import android.app.Activity;

import com.myapp.lovetest_azuredragon3000.R;
import com.myapp.lovetest_azuredragon3000.congiap12.model.ModelCungMang;
import com.myapp.lovetest_azuredragon3000.common.DatabaseBoiPhuongDong;
import com.myapp.lovetest_azuredragon3000.common.FunctionCommon;
import com.myapp.lovetest_azuredragon3000.common.SubApp;

import java.util.List;

public class ContentBoiPhuongDong {

    Activity activity;
    DatabaseBoiPhuongDong databaseBoiPhuongDong;
    public String getPD(String fulldate, Activity activity) {
        this.activity = activity;
        databaseBoiPhuongDong = ((SubApp) activity.getApplication()).getDatabaseBoiPhuongDong();

        String dtnam = fulldate.split(":")[0];
        int stdatenam = Integer.parseInt(dtnam.split("-")[0]);
        int stmonnam = Integer.parseInt(dtnam.split("-")[1]);
        int styearnam = Integer.parseInt(dtnam.split("-")[2]);
        String dtnu = fulldate.split(":")[1];
        int stdatenu = Integer.parseInt(dtnu.split("-")[0]);
        int stmonnu = Integer.parseInt(dtnu.split("-")[1]);
        int styearnu = Integer.parseInt(dtnu.split("-")[2]);

        UserPD userNam = new UserPD(activity.getResources().getStringArray(R.array.boitinhyeu_cungmang));
        UserPD userNu = new UserPD(activity.getResources().getStringArray(R.array.boitinhyeu_cungmang));
        userNam.NamAmlich = FunctionCommon.convertAmlichV2(stdatenam, stmonnam, styearnam);
        userNu.NamAmlich = FunctionCommon.convertAmlichV2(stdatenu, stmonnu, styearnu);
        String ret = activity.getString(R.string.boitinhyeu_errorname); //"lỗi vui lòng check lại năm sinh và tháng sinh";

        List<ModelCungMang> cungmang = ((SubApp) activity.getApplication()).getDatabaseTuviManager2().getCungMang();
        userNam.getIndex(cungmang);
        userNu.getIndex(cungmang);

        String temp3 = databaseBoiPhuongDong.getContent((userNu.index) + String.valueOf(userNam.index));
        if (temp3 != null) {

            /*ret =   "năm sinh âm lịch của Nam là: " + userNam.NamAmlich + "\n"+
                    "Nam thuộc cung: " + userNam.cung + "\n"+
                    "năm sinh âm lịch của Nữ là: " + userNu.NamAmlich + "\n"+
                    "Nữ thuộc cung: " + userNu.cung + "\n"+ temp3+
                    "\n\n" + "kết quả trên dựa vào dử liệu đúc kết từ thời trước nên không nên tin tuyệt đối, " +
                    "cơ bản vẫn là do cách sống 2 bên ";*/

            ret =   activity.getString(R.string.boitinhyeu_amlichnams) + userNam.NamAmlich + "\n"+
                    activity.getString(R.string.boitinhyeu_cungnams) + userNam.cung + "\n"+
                    activity.getString(R.string.boitinhyeu_amlichnus) + userNu.NamAmlich + "\n"+
                    activity.getString(R.string.boitinhyeu_cungnus) + userNu.cung + "\n"+ temp3+
                    "\n\n" + activity.getString(R.string.boitinhyeu_thongtinthem);

        }
        return ret;
    }

}
