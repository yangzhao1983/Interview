package com.zuora.test.exam.zy.testproviders;

import com.zuora.test.exam.zy.cases.TestCaseREST;
import com.zuora.test.exam.zy.cases.TestParameters;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import org.testng.log4testng.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kaiser_zhao on 3/14/18.
 */
public class RestResources {
    //TODO: need to generate an unique id for testing to support CI
    private static String uniqueIdent = Long.toString(System.currentTimeMillis());
  //  public static Logger logger = Logger.getLogger(RestResources.class);

    private static final CommonResources common = new CommonResources();

    /**
     * This method will get the xml files(cases) from specific dir. And parse them and wrap them as test case object.
     *
     * @return
     */
    @DataProvider(name = "ProviderRestResources")
    public static Iterator<Object[]> ProviderRestResources() {

        String testDirectory = null;
        String testName = "Deal";

        // TODO:
        // To Get the directory containing the cases.
        // From Configuration file? Or from system properties passed in by gradle
        testDirectory = "/Users/kaiser_zhao/Work/projects/Interview/src/test/resources/testData/deal/";

        return common.providerExecuteMultiScenarios(testDirectory, testName);
    }

    @Test(groups = "restAPI", dataProvider = "ProviderRestResources", dataProviderClass = RestResources.class)
    public void executeResources(TestParameters testParams){
        String testName = testParams.getTestName();
        String testDescription = testParams.getTestDescription();
        List<TestCaseREST> testCases = testParams.getTestCases();

        System.out.println("CreateResources: "+ testName + testDescription);

        //TODO: get from properties? SystemProperties?
        String baseUrl = "https://interview.agilecrm.com/dev/api";

        common.executeOperations(baseUrl, testName, testDescription, testCases);
    }
}
