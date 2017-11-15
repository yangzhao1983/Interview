package com.zuora.test.exam.testcases;

import static org.junit.Assert.fail;

import com.zuora.test.exam.TestBase;

import com.google.common.collect.ImmutableMap;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.body.RequestBodyEntity;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class ContactTest extends TestBase {

    /**
     * This case is just an example on how to use Unirest to send Rest request, and get the Rest
     * response. However, Unirest is not the only choice. You can use any tool that you are 
     * familiar with, e.g. httpclient. pom.xml need to be updated accordingly when you changed tool.
     * 
     * @throws UnirestException
     */
    @Test
    public void testCreateContacts() throws UnirestException {
        RequestBodyEntity request = Unirest.post("https://interview.agilecrm.com/dev/api/contacts").basicAuth("wynet321@163.com", "4ebpehvr1a4n1vjljnf0qr7n3m")
                .headers(ImmutableMap.of("Content-Type", "application/json", "Accept", "application/json"))
                .body("{    \"star_value\": \"4\",    \"lead_score\": \"92\",    \"tags\": [        \"Lead\",        \"Likely Buyer\"    ],    \"properties\": [        {            \"type\": \"SYSTEM\",            \"name\": \"first_name\",            \"value\": \"Samson\"        },        {            \"type\": \"SYSTEM\",            \"name\": \"last_name\",            \"value\": \"Nolan\"        },        {            \"type\": \"SYSTEM\",            \"name\": \"email\",            \"subtype\": \"work\",            \"value\": \""
                        + String.valueOf(Math.abs((new Random()).nextInt()))
                        + "@agilecrm.com\"        },        {            \"type\": \"SYSTEM\",            \"name\": \"address\",            \"value\": \"{\\\"address\\\":\\\"225 George Street\\\",\\\"city\\\":\\\"NSW\\\",\\\"state\\\":\\\"Sydney\\\",\\\"zip\\\":\\\"2000\\\",\\\"country\\\":\\\"Australia\\\"}\"        }    ]}");
        System.out.println(request.getBody().toString());
        HttpResponse<String> response = request.asString();
        System.out.println(response.getBody().toString());
        Assert.assertEquals(response.getStatus(), 200);
    }

    @Test
    public void testGetContacts() {
        // Refer to https://github.com/agilecrm/rest-api#11-listing-contacts-
        fail("this case is incomplete, please help to finish it.");
    }

    @Test
    public void testUpdateContacts() {
        // Refer to https://github.com/agilecrm/rest-api#11-listing-contacts-
        fail("this case is incomplete, please help to finish it.");
    }

    @Test
    public void testDeleteAccountingCode() {
        // Refer to https://github.com/agilecrm/rest-api#11-listing-contacts-
        fail("this case is incomplete, please help to finish it.");
    }
}
