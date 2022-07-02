package com.myapp.lovetest_azuredragon3000.boiphuongdong.model;

public class PhuongDong {
    private String tuoi;
    private String content;

    public PhuongDong() {
    }

    public PhuongDong(String tuoi, String content) {
        this.tuoi = tuoi;
        this.content = content;
    }

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
