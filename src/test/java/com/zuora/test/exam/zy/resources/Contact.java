package com.zuora.test.exam.zy.resources;

import java.util.List;

/**
 * Created by kaiser_zhao on 3/17/18.
 */
public class Contact {

    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {

        return id;
    }

    public String getType() {
        return type;
    }

    private String type;

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public List<Property> getProperties() {

        return properties;
    }

    List<Property> properties;
}
