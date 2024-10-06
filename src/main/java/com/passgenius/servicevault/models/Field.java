package com.passgenius.servicevault.models;

import java.io.Serializable;

public class Field implements Serializable {
    private ValueType dataType;
    private String name;
    private String value;
    private boolean isEncrypted;

    public Field() {
        this.dataType = ValueType.TEXT; // Default value
        this.name = "";
        this.value = "";
        this.isEncrypted = false;
    }

    // Getters and Setters
    public ValueType getDataType() {
        return dataType;
    }

    public void setDataType(ValueType dataType) {
        this.dataType = dataType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isEncrypted() {
        return isEncrypted;
    }

    public void setEncrypted(boolean encrypted) {
        isEncrypted = encrypted;
    }
}
