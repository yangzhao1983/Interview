package com.zuora.test.exam.zy.resources;

/**
 * Created by kaiser_zhao on 3/17/18.
 */
public class Property {
    private String type;
    private String value;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {

        return type;
    }

    public String getValue() {
        return value;
    }
}
