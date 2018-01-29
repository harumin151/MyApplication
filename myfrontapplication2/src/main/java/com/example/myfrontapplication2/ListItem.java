package com.example.myfrontapplication2;

import android.graphics.Bitmap;

import java.sql.Blob;

/**
 * Created by Panda on 2018/01/24.
 */

//画像のリソースIDと文字を格納するクラスでリストの１行の情報を格納するためのクラス



public class ListItem {

    private String name = null;
    private Bitmap picture = null;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getPicture() {
        return picture;
    }

    public void setPicture(Bitmap picture) {
        this.picture = picture;
    }
}
