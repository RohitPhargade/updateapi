package com.demo.dto;

import java.io.Serializable;

public class Associates extends Person implements Serializable {


    boolean isAssociate;

    public Associates() {
    }

    public Associates(boolean isAssociate) {
        this.isAssociate = isAssociate;
    }

    public Associates(int id, boolean isAssociate) {
        super(id);
        this.isAssociate = isAssociate;
    }

    @Override
    public String toString() {
        return "Associates{" +
                "isAssociate=" + isAssociate +
                ", id=" + id +
                '}';
    }
}
