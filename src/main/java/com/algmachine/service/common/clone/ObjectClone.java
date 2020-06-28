package com.algmachine.service.common.clone;

import java.io.Serializable;

public class ObjectClone implements Cloneable, Serializable {
    private String name;
    private int value;
    private ObjectPropertyClone property;

    public ObjectClone(String name, int value, ObjectPropertyClone property) {
        this.name = name;
        this.value = value;
        this.property = property;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectPropertyClone getProperty() {
        return property;
    }

    public void setProperty(ObjectPropertyClone property) {
        this.property = property;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ObjectClone obj = (ObjectClone) super.clone();
        obj.setProperty((ObjectPropertyClone) this.property.clone());
        return obj;
    }
}
