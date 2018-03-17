package com.zuora.test.exam.zy.resources;

import java.util.List;

/**
 * Created by kaiser_zhao on 3/17/18.
 */
public class Deal {

//    public boolean isSameDealWith(Deal target){
//        if(){
//
//        }
//    }

    private List<Contact> contacts;
    private Integer id;
    private String name;
    private String description;
    private int expected_value;
    private String pipeline_id;
    private String milestone;
    private int probability;
    private Long close_date;
    private Long created_time;
    private int entity_type;
    private Owner owner;
    private Prefs prefs;
    private String pic;
    private DomainUser domainUser;

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Contact> getContacts() {

        return contacts;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getExpected_value() {
        return expected_value;
    }

    public String getPipeline_id() {
        return pipeline_id;
    }

    public String getMilestone() {
        return milestone;
    }

    public int getProbability() {
        return probability;
    }

    public Long getClose_date() {
        return close_date;
    }

    public Long getCreated_time() {
        return created_time;
    }

    public int getEntity_type() {
        return entity_type;
    }

    public Owner getOwner() {
        return owner;
    }

    public Prefs getPrefs() {
        return prefs;
    }

    public String getPic() {
        return pic;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public void setExpected_value(int expected_value) {
        this.expected_value = expected_value;
    }

    public void setPipeline_id(String pipeline_id) {
        this.pipeline_id = pipeline_id;
    }

    public void setMilestone(String milestone) {
        this.milestone = milestone;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    public void setClose_date(Long close_date) {
        this.close_date = close_date;
    }

    public void setCreated_time(Long created_time) {
        this.created_time = created_time;
    }

    public void setEntity_type(int entity_type) {
        this.entity_type = entity_type;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setPrefs(Prefs prefs) {
        this.prefs = prefs;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public void setDomainUser(DomainUser domainUser) {
        this.domainUser = domainUser;
    }

    public DomainUser getDomainUser() {

        return domainUser;
    }
}
