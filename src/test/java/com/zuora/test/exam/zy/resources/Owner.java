package com.zuora.test.exam.zy.resources;

/**
 * Created by kaiser_zhao on 3/17/18.
 */
public class Owner {
    private Integer id;
    private String email;
    private boolean is_admin;
    private boolean is_account_owner;
    private boolean is_disabled;
    private String name;

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public boolean isIs_account_owner() {
        return is_account_owner;
    }

    public boolean isIs_disabled() {
        return is_disabled;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public void setIs_account_owner(boolean is_account_owner) {
        this.is_account_owner = is_account_owner;
    }

    public void setIs_disabled(boolean is_disabled) {
        this.is_disabled = is_disabled;
    }

    public void setName(String name) {
        this.name = name;
    }
}
