package com.myapp.lovetest_azuredragon3000.boitinhyeu.data;

import android.app.Activity;

import com.myapp.lovetest_azuredragon3000.R;
import com.myapp.lovetest_azuredragon3000.common.DatabaseCungHoangDao;
import com.myapp.lovetest_azuredragon3000.common.SubApp;

public class ContentBoiPhuongTay {

    DatabaseCungHoangDao databaseCungHoangDao;
    Activity activity;
    public ContentBoiPhuongTay(Activity activity){
        this.activity = activity;
        databaseCungHoangDao = ((SubApp) activity.getApplication()).getDatabaseCungHoangDao();
    }

    public String getCHD(String fulldate){
        String dtnam = fulldate.split(":")[0];
        String dtnu = fulldate.split(":")[1];

        int datename = Integer.parseInt(dtnam.split("-")[0]);
        int datenu = Integer.parseInt(dtnu.split("-")[0]);
        int monthnam = Integer.parseInt(dtnam.split("-")[1]);
        int monthnu = Integer.parseInt(dtnu.split("-")[1]);

        String cungNam = cunghoangdao(convert(monthnam), datename);
        String cungNu = cunghoangdao(convert(monthnu), datenu);

        return databaseCungHoangDao.getContent(cungNam+"_"+cungNu);
    }

    private String cunghoangdao(String month, int date) {
        String sign = "";
        switch (month) {
            case "January":
                if (date < 20)
                    sign = activity.getString(R.string.phuongtay_capricorn); //"Capricorn";
                else
                    sign = activity.getString(R.string.phuongtay_aquarius); //"Aquarius";
                break;
            case "February":
                if (date < 19)
                    sign = activity.getString(R.string.phuongtay_aquarius); //"Aquarius";
                else
                    sign = activity.getString(R.string.phuongtay_pisces); //"Pisces";
                break;
            case "March":
                if (date < 21)
                    sign = activity.getString(R.string.phuongtay_pisces); //"Pisces";
                else
                    sign = activity.getString(R.string.phuongtay_aries); //"Aries";
                break;
            case "April":
                if (date < 20)
                    sign = activity.getString(R.string.phuongtay_aries); //"Aries";
                else
                    sign = activity.getString(R.string.phuongtay_taurus); //"Taurus";
                break;
            case "May":
                if (date < 21)
                    sign = activity.getString(R.string.phuongtay_taurus); //"Taurus";
                else
                    sign = activity.getString(R.string.phuongtay_gemini); //"Gemini";
                break;
            case "June":
                if (date < 21)
                    sign = activity.getString(R.string.phuongtay_gemini); //"Gemini";
                else
                    sign = activity.getString(R.string.phuongtay_cancer); //"Cancer";
                break;
            case "July":
                if (date < 23)
                    sign = activity.getString(R.string.phuongtay_cancer); //"Cancer";
                else
                    sign = activity.getString(R.string.phuongtay_leo); //"Leo";
                break;
            case "August":
                if (date < 23)
                    sign = activity.getString(R.string.phuongtay_leo); //"Leo";
                else
                    sign = activity.getString(R.string.phuongtay_virgo); //"Virgo";
                break;
            case "September":
                if (date < 23)
                    sign = activity.getString(R.string.phuongtay_virgo); //"Virgo";
                else
                    sign = activity.getString(R.string.phuongtay_libra); //"Libra";
                break;
            case "October":
                if (date < 23)
                    sign = activity.getString(R.string.phuongtay_libra); //"Libra";
                else
                    sign = activity.getString(R.string.phuongtay_scorpio); //"Scorpio";
                break;
            case "November":
                if (date < 22)
                    sign = activity.getString(R.string.phuongtay_scorpio); //"Scorpio";
                else
                    sign = activity.getString(R.string.phuongtay_sagittarius); //"Sagittarius";
                break;
            case "December":
                if (date < 22)
                    sign = activity.getString(R.string.phuongtay_sagittarius); //"Sagittarius";
                else
                    sign = activity.getString(R.string.phuongtay_capricorn); //"Capricorn";
                break;
        }
        return sign;
    }

    private String convert(int monthnam) {
        switch (monthnam) {
            case 1:
                return activity.getString(R.string.phuongtay_january); //"January";
            case 2:
                return activity.getString(R.string.phuongtay_february); //"February";
            case 3:
                return activity.getString(R.string.phuongtay_march); //"March";
            case 4:
                return activity.getString(R.string.phuongtay_april); //"April";
            case 5:
                return activity.getString(R.string.phuongtay_may); //"May";
            case 6:
                return activity.getString(R.string.phuongtay_june); //"June";
            case 7:
                return activity.getString(R.string.phuongtay_july); //"July";
            case 8:
                return activity.getString(R.string.phuongtay_august); //"August";
            case 9:
                return activity.getString(R.string.phuongtay_september); //"September";
            case 10:
                return activity.getString(R.string.phuongtay_october); //"October";
            case 11:
                return activity.getString(R.string.phuongtay_november); //"November";
            case 12:
                return activity.getString(R.string.phuongtay_december); //"December";
            default:
                return activity.getString(R.string.phuongtay_somethingwrong); //"somethingwrong";
        }
    }



}
