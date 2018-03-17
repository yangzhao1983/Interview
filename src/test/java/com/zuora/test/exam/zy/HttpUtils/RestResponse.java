package com.zuora.test.exam.zy.HttpUtils;

/**
 * Created by kaiser_zhao on 3/17/18.
 *
 * Contains the response from server side.
 */
public class RestResponse {
    private String code;
    private String body;

    public void setCode(String code) {
        this.code = code;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCode() {

        return code;
    }

    public String getBody() {
        return body;
    }
}
