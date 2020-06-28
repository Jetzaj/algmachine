package com.algmachine.service.common.clone;

import java.io.Serializable;

public class ObjectPropertyClone implements Cloneable, Serializable {
    private String name;
    private double propertyA;

    public ObjectPropertyClone(String name, double propertyA) {
        this.name = name;
        this.propertyA = propertyA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPropertyA() {
        return propertyA;
    }

    public void setPropertyA(double propertyA) {
        this.propertyA = propertyA;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
