package com.zuora.test.exam.zy.cases;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * Created by kaiser_zhao on 3/14/18.
 */
public class TestCaseREST{
    private final static String tagStep = "step";
    private final static String tagQueryResourceEndPoint = "queryResourceEndPoint";
    private final static String tagQueryExpectedHttpCode = "expecteHTTPStatus";
    private final static String tagQueryResourceParam = "queryResourceParam";
    private final static String tagQueryOperation = "queryOperation";
    private final static String tagRequest = "request";
    private final static String tagResponse = "response";

    public void setRequestString(String requestString) {
        this.requestString = requestString;
    }

    public void setResponseString(String responseString) {
        this.responseString = responseString;
    }

    public String getResourceEndPoint() {
        return resourceEndPoint;
    }

    public void setResourceEndPoint(String resourceEndPoint) {
        this.resourceEndPoint = resourceEndPoint;
    }

    private String requestString;
    private String responseString;
    private InputStream requestStream;
    private InputStream responseStream;
    private String resourceEndPoint;
    private String stepDescription;
    private String queryOperation;

    public String getStepDescription() {
        return stepDescription;
    }

    public String getQueryOperation() {
        return queryOperation;
    }

    public String getRequestString() {

        return requestString;
    }

    public String getResponseString() {

        return responseString;
    }

    public String getExpectedHTTPerror() {
        return expectedHTTPerror;
    }

    private String expectedHTTPerror;

    public void setExpectedHTTPerror(String expectedHTTPerror) {
        this.expectedHTTPerror = expectedHTTPerror;
    }

    public void setQueryOperation(String queryOperation) {
        this.queryOperation = queryOperation;
    }

    public void setStepDescription(String stepDescription) {
        this.stepDescription = stepDescription;
    }

    public void setRequestStream(InputStream requestStream) {
        this.requestStream = requestStream;
    }

    public void setResponseStream(InputStream responseStream) {
        this.responseStream = responseStream;
    }

    private UseCase.UseCaseHeader useCaseHeader;

    public void setUseCaseHeader(UseCase.UseCaseHeader usecaseHeader) {
        this.useCaseHeader = usecaseHeader;
    }

    public UseCase.UseCaseHeader getUseCaseHeader() {
        return this.useCaseHeader;
    }

    public String getOperation() {
        return this.queryOperation;
    }

    public TestCaseREST testCaseAnalysis(Node node, UseCase.UseCaseHeader header) {

        String request;
        String textContent;
        TestCaseREST tc = new TestCaseREST();

        tc.setUseCaseHeader(header);
        // tc.setUseCaseHeader(header);
        // Get all the childs from a testCase tag
        NodeList tcList = node.getChildNodes();
        for (int j = 0; j < tcList.getLength(); j++) {
            Node lsnode = tcList.item(j);

            if (lsnode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) lsnode;
                textContent = elem.getTextContent();
                //textContent = ResourceConstants.replaceSchemaValue(textContent);

                if (elem.getTagName().equalsIgnoreCase(tagRequest)) {

                    // TODO : some config value be used here?
                    tc.setRequestString(textContent);
                    tc.setRequestStream(new ByteArrayInputStream(textContent.getBytes()));
                } else if (elem.getTagName().equalsIgnoreCase(tagResponse)) {
                    tc.setResponseString(textContent);
                    tc.setResponseStream(new ByteArrayInputStream(textContent.getBytes()));
                } else if (elem.getTagName().equalsIgnoreCase(tagStep)) {
                    tc.setStepDescription(textContent);
                } else if (elem.getTagName().equalsIgnoreCase(tagQueryOperation)) {
                    tc.setQueryOperation(textContent);
                } else if (elem.getTagName().equalsIgnoreCase(tagQueryResourceEndPoint)) {
                    tc.setResourceEndPoint(textContent);
                } else if (elem.getTagName().equalsIgnoreCase(tagQueryExpectedHttpCode)) {
                    tc.setExpectedHTTPerror(textContent);
                }

            }
        }
        return tc;
    }
}
