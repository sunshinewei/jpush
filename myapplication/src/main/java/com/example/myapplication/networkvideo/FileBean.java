package com.example.myapplication.networkvideo;

/**
 * Created by wzxai on 2018-7-27.
 */

public class FileBean {
    private String url;
    private String file_name;
    private boolean isFinish=false;
    private String size;

    public FileBean(String url, String file_name,boolean isFinish,String size) {
        this.url = url;
        this.file_name = file_name;
        this.isFinish=isFinish;
        this.size=size;
    }

    public String getUrl() {
        return url;
    }

    public String getFile_name() {
        return file_name;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void setFinish(boolean finish) {
        isFinish = finish;
    }

    public String getSize() {
        return size;
    }
}
