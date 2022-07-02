package com.myapp.lovetest_azuredragon3000.boiphuongtay.data;

public class PhuongTay {
    private int id;
    private int image;
    private String content;

    public PhuongTay(int id, int image, String content) {
        this.id = id;
        this.image = image;
        this.content = content;
    }

    public PhuongTay(int id, String content) {
        this.id = id;
        this.content = content;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
