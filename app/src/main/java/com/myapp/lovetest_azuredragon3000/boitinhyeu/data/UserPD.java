package com.myapp.lovetest_azuredragon3000.boitinhyeu.data;

import com.myapp.lovetest_azuredragon3000.congiap12.model.ModelCungMang;

import java.util.List;

class UserPD {

    String[] arrayCung;
    int NamAmlich;
    int index;
    String cung;

    public UserPD(String[] arrayCung) {
        this.arrayCung = arrayCung;
    }

    public int getNamAmlich() {
        return NamAmlich;
    }

    public void setNamAmlich(int namAmlich) {
        NamAmlich = namAmlich;
    }

    private void getPrivateIndex() {
        if(arrayCung.length > 0){
            for(int i=0;i<arrayCung.length;i++){
                String temp = arrayCung[i].toLowerCase();
                String temp_cung = cung.toLowerCase();
                if(!temp_cung.equals("")){
                    if(temp_cung.equals(temp)){
                        index = i;
                    }
                }
            }
        }
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getCung() {
        return cung;
    }

    public void setCung(String cung) {
        cung = cung;
    }

    public void getIndex(List<ModelCungMang> cungmang) {
        for (int i = 0; i < cungmang.size(); i++) {
            if (NamAmlich == cungmang.get(i).getNamSinh()) {
                cung = cungmang.get(i).getCung();
                getPrivateIndex();
            }
        }
    }
}
