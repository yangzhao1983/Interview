package com.zuora.test.exam.zy.testproviders;

import com.zuora.test.exam.zy.cases.*;
import com.zuora.test.exam.zy.resources.CommonResourcesREST;

import java.io.File;
import java.util.*;

/**
 * Created by kaiser_zhao on 3/14/18.
 *
 * This class is used to generate the cases as "data" provided by dataprovider.
 */
public class CommonResources {
    static String fileExtension = ".xml";

    public void executeOperations(String baseUrl, String testName, String testDescription,
                                  List<TestCaseREST> testSteps){

        for (int i1 = 0; i1 < testSteps.size(); i1++) {
            TestCaseREST testStep = testSteps.get(i1);

            CommonResourcesREST commonRest = new CommonResourcesREST();
            commonRest.executeREST(baseUrl, testName, testDescription, testStep);
        }


    }

    /**
     * Provide the cases
     *
     * @param testDirectory
     * @param testName
     * @return
     */
    public Iterator<Object[]> providerExecuteMultiScenarios(String testDirectory, String testName) {

        List listTests = new ArrayList();
        File dir = new File(testDirectory);

        File createDirectory = new File(testDirectory);
        String localDir = createDirectory.getName();

        File[] categoryFiles = createDirectory.listFiles();
        Arrays.sort(categoryFiles);

        for (File catFile : categoryFiles) {

            // TODO: Whether to skip a directory?
            String categoryDirectory = catFile.getAbsolutePath();
            System.out.println("categoryDirectory: " + categoryDirectory);
            File root = new File(categoryDirectory);

            listTests = addTestToList(categoryDirectory, testName, root, listTests);
        }
        Iterator<Object[]> testCase = listTests.listIterator();
        System.out.println("providerExecuteMultiScenarios over " );
        return testCase;
    }

    private List addTestToList(String testDirectory, String testName, File f, List listTests) {

        UseCase useCase = new UseCase();
        List<TestCaseREST> listTestsCases;

        if (f.getName().endsWith((fileExtension))) {

            String testFile = f.getAbsoluteFile().toString();
            listTestsCases = useCase.extractTestCases(testFile);

            boolean runTest = false;

            TestCaseREST curtestsQueries = listTestsCases.get(0);
            UseCase.UseCaseHeader useCaseHeader = curtestsQueries.getUseCaseHeader();

            boolean isListRequest = false;
            for (TestCaseREST testQuery : listTestsCases) {
                UseCase.UseCaseHeader testUseCaseHeader = testQuery.getUseCaseHeader();

                String curOperation = testQuery.getOperation();
                if (curOperation.equalsIgnoreCase("LIST")) {
                    isListRequest = true;
                    break;
                }
            }

            String testNameToadd = null;
            if (useCaseHeader.getTestName() != null) {
                testNameToadd = testName + "_" + useCaseHeader.getTestName();
            }

            String testDescription = useCaseHeader.getTestDescription();
                listTests.add(new Object[]{new TestParameters(testNameToadd, testDescription, "NA",
                        testFile, listTestsCases)});
        }
        System.out.println("addTestToList over " );
        return listTests;
    }
}
