package com.nana.chatt.model;

public class chatt {

    private String name;
    private String msg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "chatt{" +
                "name='" + name + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
