package com.myapp.lovetest_azuredragon3000.truyentinhyeu.model;

public class ModelTruyenTinhYeu {

    //public int content;
    public String title;
    public String content;

    public ModelTruyenTinhYeu(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
