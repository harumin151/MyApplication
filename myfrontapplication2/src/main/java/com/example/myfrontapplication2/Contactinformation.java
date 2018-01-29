package com.example.myfrontapplication2;

/**
 * Created by Panda on 2018/01/25.
 */

import android.graphics.Bitmap;

/**
 * Created by yuto on 2018/01/24.
 */

public class Contactinformation  {
    int No;
    String name;
    String location;
    String memo;
    Bitmap picture;

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Bitmap getPicture() {
        return picture;
    }

    public void setPicture(Bitmap picture) {
        this.picture = picture;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
