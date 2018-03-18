package com.zuora.test.exam.zy.resources;

import com.zuora.test.exam.zy.httputils.HttpAccess;
import com.zuora.test.exam.zy.httputils.RestResponse;
import com.zuora.test.exam.zy.cases.TestCaseREST;
import com.zuora.test.exam.zy.cases.UseCase;

/**
 * Created by kaiser_zhao on 3/17/18.
 */
public class CommonResourcesREST {

    public void executeREST(String baseUrl, String testName, String testDescription,TestCaseREST testStep) {

        UseCase.UseCaseHeader usecaseheader = testStep.getUseCaseHeader();

        String operation = testStep.getOperation();


        System.out.println("===========================================================================");
        System.out.println("===========================================================================");
        System.out.println(" REST request : " + operation);
        System.out.println("===========================================================================");
        System.out.println("===========================================================================");

        if (operation.equalsIgnoreCase("POST")) {

            //TODO: 3.3 dev/api/opportunity (List) should add new tag <list>true</list> to xml file
            //TODO: 3.5 dev/api/opportunity/email/{email}
            // Solution 1. xml tag <email>
            //TODO: 3.7 dev/api/opportunity/bulk
            POSTresource(baseUrl, testDescription, testStep);
        } else if (operation.equalsIgnoreCase("DELETE")) {
            //TODO: 3.6 dev/api/opportunity/{id}
            Getresource(baseUrl, testDescription, testStep);
        } else if (operation.equalsIgnoreCase("GET")) {
            // TODO: 3.1 need to pre-process the parameter
            // TODO: 3.2 dev/api/opportunity/{id}
            //TODO: 3.8 dev/api/opportunity/byMilestone
            //TODO: 3.9 dev/api/opportunity/byPipeline/based
            // TODO: 3.10 dev/api/opportunity/based
            // TODO: 3.11 dev/api/contacts/{id}/deals
            // TODO: 3.12 dev/api/opportunity/my/deals
            Getresource(baseUrl, testDescription,testStep);
        }  else if(operation.equalsIgnoreCase("PUT")){
            // TODO: 3.4 dev/api/opportunity/partial-update
            // TODO:3.13 dev/api/opportunity/partial-update/delete-contact
        }
        else {
            System.out.println("ERROR : Operation is not set in the scenario");
        }
    }

    public void Getresource(String baseUrl, String testDescription,TestCaseREST testCase) {

        String resourceEndPoint = baseUrl + testCase.getResourceEndPoint();

        String httpErrorCode = testCase.getExpectedHTTPerror();

        String response = testCase.getResponseString();

        String step = testCase.getStepDescription();

        String requestString = testCase.getRequestString();

        System.out.println("=======================================================");
        System.out.println("Description : " + testDescription);
        System.out.println("Endpoint : " + resourceEndPoint);
        System.out.println("Step : " + step);
        System.out.println("Check Error code  : " + httpErrorCode);
        System.out.println("Request string  : " + requestString);
        System.out.println("Expected response string  : " + response);
        System.out.println("=======================================================");

        System.out.println("GET ****************************************************");
        System.out.println("GET Parse the input scenario");
        System.out.println("GET ****************************************************");


        String responseString = "";

        RestResponse rr = HttpAccess.httpClientSendRequest(HttpAccess.Operation.GET, resourceEndPoint, requestString, "wynet321@163.com", "4ebpehvr1a4n1vjljnf0qr7n3m");
        System.out.println("code is :" + rr.getCode());
        System.out.println("body is :" + rr.getBody());

        // TODO: do assert
        // 1. verify code.
        // 2. verify response body by comparing string or by comparing object? use ResourceComparator?
    }

    /* ======================================================================
 *  POSTresource
 ====================================================================== */
    public void POSTresource(String baseUrl, String testDescription,TestCaseREST testCase) {

        String resourceEndPoint = baseUrl + testCase.getResourceEndPoint();

        String httpErrorCode = testCase.getExpectedHTTPerror();

        String response = testCase.getResponseString();

        String step = testCase.getStepDescription();

        String requestString = testCase.getRequestString();

        String reponseCode = null;

        System.out.println("=======================================================");
        System.out.println("Scenario : " + testDescription);
        System.out.println("Step : " + step);
        System.out.println("Check Error code  : " + httpErrorCode);
        System.out.println("=======================================================");

        System.out.println("POST ****************************************************");
        System.out.println("POST Parse the input scenario");
        System.out.println("POST ****************************************************");


        String responseString = "";

        RestResponse rr = HttpAccess.httpClientSendRequest(HttpAccess.Operation.POST, resourceEndPoint, requestString, "wynet321@163.com", "4ebpehvr1a4n1vjljnf0qr7n3m");
        System.out.println("code is :" + rr.getCode());
        System.out.println("body is :" + rr.getBody());

        // TODO: verify
        // 1. verify code.
        // 2. verify response body by comparing string or by comparing object? use ResourceComparator?
    }
}