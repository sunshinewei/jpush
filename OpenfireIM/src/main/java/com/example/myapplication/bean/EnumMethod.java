package com.example.myapplication.bean;

/**
 * Created by mm on 2018/10/29.
 */

public enum EnumMethod {

    GET("aaaa"),

    POST("bbb");

    private String value;

    EnumMethod(String value) {
        this.value = value;
    }


    public boolean getMethod() {

        switch (this) {
            case GET:
                break;
            case POST:
                break;
        }

        return true;
    }
}
