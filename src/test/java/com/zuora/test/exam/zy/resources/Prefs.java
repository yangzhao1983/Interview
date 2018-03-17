package com.zuora.test.exam.zy.resources;

/**
 * Created by kaiser_zhao on 3/17/18.
 */
public class Prefs {
    private int id;
    private String pic;
    private String template;
    private String width;
    private String currency;
    private String signature;
    private boolean task_reminder;
    private String currentDomainUserName;

    public int getId() {
        return id;
    }

    public String getPic() {
        return pic;
    }

    public String getTemplate() {
        return template;
    }

    public String getWidth() {
        return width;
    }

    public String getCurrency() {
        return currency;
    }

    public String getSignature() {
        return signature;
    }

    public boolean isTask_reminder() {
        return task_reminder;
    }

    public String getCurrentDomainUserName() {
        return currentDomainUserName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void setTask_reminder(boolean task_reminder) {
        this.task_reminder = task_reminder;
    }

    public void setCurrentDomainUserName(String currentDomainUserName) {
        this.currentDomainUserName = currentDomainUserName;
    }
}
