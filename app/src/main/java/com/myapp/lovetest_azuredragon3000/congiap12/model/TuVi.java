package com.myapp.lovetest_azuredragon3000.congiap12.model;



public class TuVi {
    private String idConGiap;
    private String nameConGiap;
    private int imageConGiap;
    private String idTuoi;
    private String tuoiName;
    private String male;
    private String intro;
    private String tdName;


    public TuVi() {
    }

    public TuVi(String idConGiap, String nameConGiap, int imageConGiap) {
        this.idConGiap = idConGiap;
        this.nameConGiap = nameConGiap;
        this.imageConGiap = imageConGiap;
    }

    public TuVi(String idTuoi, String tuoiName) {
        this.idTuoi = idTuoi;
        this.tuoiName = tuoiName;
    }


    // detail tu vi
    public TuVi(String male, String intro, String tdName) {
        this.male = male;
        this.intro = intro;
        this.tdName = tdName;
    }

    public String getIdConGiap() {
        return idConGiap;
    }

    public void setIdConGiap(String idConGiap) {
        this.idConGiap = idConGiap;
    }

    public String getNameConGiap() {
        return nameConGiap;
    }

    public void setNameConGiap(String nameConGiap) {
        this.nameConGiap = nameConGiap;
    }

    public String getIdTuoi() {
        return idTuoi;
    }

    public void setIdTuoi(String idTuoi) {
        this.idTuoi = idTuoi;
    }

    public String getTuoiName() {
        return tuoiName;
    }

    public void setTuoiName(String tuoiName) {
        this.tuoiName = tuoiName;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getImageConGiap() {
        return imageConGiap;
    }

    public void setImageConGiap(int imageConGiap) {
        this.imageConGiap = imageConGiap;
    }

    public String getTdName() {
        return tdName;
    }

    public void setTdName(String tdName) {
        this.tdName = tdName;
    }
}
