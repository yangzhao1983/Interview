package com.zuora.test.exam.zy.cases;

import java.util.List;

/**
 * Created by kaiser_zhao on 3/15/18.
 */
public class TestParameters {


    private String testName = null;
    private String testDescription = null;
    private String expectedError = null;
    private String testFile = null;
    private List<TestCaseREST> testCases = null;

    public TestParameters(String name,
                          String description,
                          String expectedError,
                          String testFile,
                          List<TestCaseREST> testCases) {
        this.testName = name;
        this.testDescription = description;
        this.expectedError = expectedError;
        this.testFile = testFile;
        this.testCases = testCases;
    }

    public String getTestName() {
        return testName;
    }

    public String getTestDescription() {
        return testDescription;
    }

    public String getExpectedError() {
        return expectedError;
    }

    public String getTestFile() {
        return testFile;
    }

    public List<TestCaseREST> getTestCases() {
        return testCases;
    }
}
