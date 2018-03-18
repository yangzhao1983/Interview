package com.zuora.test.exam.zy.httputils;

import com.google.common.collect.ImmutableMap;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.body.RequestBodyEntity;

/**
 * Created by kaiser_zhao on 3/17/18.
 */
public class HttpAccess {

    public enum Operation{
        POST, PUT, GET
    }

    /**
     * Send request
     *
     * @param op
     * @param url
     * @param requestBody
     * @param userName
     * @param key
     * @return
     */
    public static RestResponse httpClientSendRequest(Operation op, String url, String requestBody, String userName, String key){

        HttpResponse<String> response = null;

        switch (op){
            case POST:
                response = sendPostRequest(url,userName, key, requestBody);
                break;
            case GET:
                response = sendGetRequest(url,userName, key);
                break;
            case PUT:
                break;
        }
        RestResponse rr = new RestResponse();

        if(response == null){
            rr.setCode("FailCode");
            rr.setBody("FailBody");
        }else{
            rr.setCode(Integer.toString(response.getStatus()));
            rr.setBody(response.getBody());
        }

        return rr;
    }

    /**
     * Send get request
     *
     * @param url
     * @param name
     * @param key
     * @return
     */
    private static HttpResponse sendGetRequest(String url, String name, String key){

        //GetRequest request = Unirest.get(url).basicAuth(name, key)
        //       .headers(ImmutableMap.of("Content-Type", "application/json", "Accept", "application/json"));
        System.out.println(url);
        System.out.println(name);
        System.out.println(key);
        GetRequest request = Unirest.get(url).basicAuth(name, key);
        HttpResponse<String> response = null;
        try {
            response = request.asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * Send post request
     *
     * @param url
     * @param name
     * @param key
     * @param body
     * @return
     */
    private static HttpResponse sendPostRequest(String url, String name, String key, String body){

        RequestBodyEntity request = Unirest.post(url).basicAuth(name, key)
                .headers(ImmutableMap.of("Content-Type", "application/json", "Accept", "application/json"))
                .body(body);
        HttpResponse<String> response = null;
        try {
            response = request.asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return response;
    }
}
