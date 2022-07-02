package com.myapp.lovetest_azuredragon3000.boitinhyeu.data;

import android.app.Activity;
import android.widget.EditText;

import com.myapp.lovetest_azuredragon3000.R;

import java.util.regex.Pattern;

public class ProcessDataBoiTinhYeu {
    String str_nameNam;
    String str_nameNu;
    String str_tuoiNam;
    String str_tuoiNu;
    String str_dateNam;
    String str_dateNu;
    String str_monNam;
    String str_monNu;

    int namNam;
    int namNu;
    int dateNam;
    int dateNu;
    int monNam;
    int monNu;

    Activity activity;
    public ProcessDataBoiTinhYeu(
            EditText nameName,
            EditText womanName,
            EditText tvtuoinam,
            EditText tvtuoitu,
            EditText tvdatenam,
            EditText tvdatenu,
            EditText tvmonnam,
            EditText tvmonnu,
            Activity activity) {

         this.activity = activity;
         str_nameNam = nameName.getText().toString();
         str_nameNu = womanName.getText().toString();
         str_tuoiNam = tvtuoinam.getText().toString();
         str_tuoiNu = tvtuoitu.getText().toString();
         str_dateNam = tvdatenam.getText().toString();
         str_dateNu = tvdatenu.getText().toString();
         str_monNam = tvmonnam.getText().toString();
         str_monNu = tvmonnu.getText().toString();

         if( (!checkNullParameter()) && (checkNumber()) ) {
             namNam = Integer.parseInt(str_tuoiNam);
             namNu = Integer.parseInt(str_tuoiNu);
             dateNam = Integer.parseInt(str_dateNam);
             dateNu = Integer.parseInt(str_dateNu);
             monNam = Integer.parseInt(str_monNam);
             monNu = Integer.parseInt(str_monNu);
         }
    }

    public boolean checkNumber() {
        boolean s1 = checkWithPattern(str_tuoiNam);
        boolean s2 = checkWithPattern(str_tuoiNu);
        boolean s3 = checkWithPattern(str_dateNam);
        boolean s4 = checkWithPattern(str_dateNu);
        boolean s5 = checkWithPattern(str_monNam);
        boolean s6 = checkWithPattern(str_monNu);

        return s1 && s2 && s3 && s4 && s5 && s6;

    }

    private boolean checkWithPattern(String strNum) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public boolean checkOverParameter() {
        return   namNam > 2020 || namNam < 1900
                || namNu > 2020 || namNu < 1900
                || dateNam > 31 || dateNam <= 0
                || dateNu > 31 || dateNu <= 0
                || monNam > 12 || monNam <= 0
                || monNu > 12 || monNu <= 0;
    }

    public boolean checkNullParameter() {
        return str_nameNam.equals("") ||
                str_nameNu.equals("") ||
                str_tuoiNam.equals("") ||
                str_tuoiNu.equals("") ||
                str_dateNam.equals("") ||
                str_dateNu.equals("") ||
                str_monNam.equals("") ||
                str_monNu.equals("");
    }

    public String getInfor() {
            String rs = "";
            if(namNam > 2020){
                //rs = rs + "năm của bạn Nam không được quá 2020 \n";
                rs = rs + activity.getString(R.string.boitinhyeu_rulenam2020); //"năm của bạn Nam không được quá 2020 \n";
            }
            if(namNam < 1900){
                //rs = rs + "năm của bạn Nam  không được nhỏ hơn 1900 \n";
                rs = rs + activity.getString(R.string.boitinhyeu_rulenam1900);
            }
            if(namNu > 2020){
                //rs = rs + "năm của bạn nữ không được quá 2020 \n";
                rs = rs + activity.getString(R.string.boitinhyeu_rulenu2020);
            }
            if(namNu < 1900){
                //rs = rs + "năm của bạn nữ không được nhỏ hơn 1900 \n";
                rs = rs + activity.getString(R.string.boitinhyeu_rulenu1900);
            }
            if(dateNam > 31){
                //rs = rs + "ngày của bạn nam không được lớn hơn 31 \n";
                rs = rs + activity.getString(R.string.boitinhyeu_rulenam31);
            }
            if(dateNam <= 0){
                //rs = rs + "ngày của bạn nam không được nhỏ hơn bằng 0 \n";
                rs = rs + activity.getString(R.string.boitinhyeu_rulenam0);
            }
            if(dateNu > 31){
                //rs = rs + "ngày của bạn nữ không được lớn hơn 31 \n";
                rs = rs + activity.getString(R.string.boitinhyeu_rulenu31);
            }
            if(dateNu <= 0){
                //rs = rs + "ngày của bạn nữ không được nhỏ hơn bằng 0 \n";
                rs = rs + activity.getString(R.string.boitinhyeu_rulenu0);
            }
            if(monNam > 12){
                //rs = rs + "tháng của bạn nam không được lớn hơn 12 \n";
                rs = rs + activity.getString(R.string.boitinhyeu_rulenam12);
            }
            if(monNam <= 0){
                //rs = rs + "tháng của bạn nam không được nhỏ hơn bằng 0 \n";
                rs = rs + activity.getString(R.string.boitinhyeu_rulenammon0);
            }
            if(monNu > 12){
                //rs = rs + "tháng của bạn nữ không được lớn hơn 12 \n";
                rs = rs + activity.getString(R.string.boitinhyeu_rulenu12);
            }
            if(monNu <= 0){
                //rs = rs + "tháng của bạn nữ không được nhỏ hơn bằng 0 \n";
                rs = rs + activity.getString(R.string.boitinhyeu_rulenumon0);
            }

            return rs;
    }

    public String getStringCombination() {
        return str_dateNam+"-"+str_monNam+"-"+str_tuoiNam+":"+str_dateNu+"-"+str_monNu+"-"+str_tuoiNu;
    }

    public int getHashNumber() {
        int hash = str_nameNam.hashCode() + str_nameNu.hashCode() + str_tuoiNam.hashCode() + str_tuoiNu.hashCode();
        String str_hash = String.valueOf(hash);
        return Character.getNumericValue(str_hash.charAt(str_hash.length()-1));
    }
}
