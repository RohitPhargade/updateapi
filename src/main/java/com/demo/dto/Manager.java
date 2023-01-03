package com.demo.dto;

public class Manager extends Person {

    String mname;

    public Manager() {
    }

    public Manager(String mname) {
        this.mname = mname;
    }

    public Manager(int id, String mname) {
        super(id);
        this.mname = mname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "mname='" + mname + '\'' +
                ", id=" + id +
                '}';
    }
}
