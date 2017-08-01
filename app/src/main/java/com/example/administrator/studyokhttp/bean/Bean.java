package com.example.administrator.studyokhttp.bean;

/**
 * Created by Administrator on 2017/7/31.
 */

public class Bean {
    private String  images;
    private String title;

    public Bean(String images, String title) {
        this.images = images;
        this.title = title;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "images='" + images + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
