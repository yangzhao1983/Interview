package com.zuora.test.exam.zy.cases;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaiser_zhao on 3/14/18.
 *
 * Class representing a xml file or a case.
 */
public class UseCase {

    // For use case
    final static String tagUseCase = "useCase";
    final static String tagDescription = "description";
    final static String tagName = "name";

    // For testCase
    final static String tagTestCase = "testCase";

    UseCaseHeader usecaseHeader;
    String testPrefix;
    String tenantName;
    String testName;
    String testDescription;
    String userId;
    String password;

    public UseCaseHeader getUsecaseHeader() {
        return usecaseHeader;
    }

    public String getTestPrefix() {
        return testPrefix;
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getTestName() {
        return testName;
    }

    public String getTestDescription() {
        return testDescription;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setUsecaseHeader(UseCaseHeader usecaseHeader) {
        this.usecaseHeader = usecaseHeader;
    }

    public void setTestPrefix(String testPrefix) {
        this.testPrefix = testPrefix;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public void setTestDescription(String testDescription) {
        this.testDescription = testDescription;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UseCase() {

        usecaseHeader = new UseCaseHeader();
        testPrefix = null;

        tenantName = null;
        testName = null;

        testDescription = null;

        // TODO Where to get it?
        //userId = ResourceConstants.ADMIN_USER;
        //password = ResourceConstants.ADMIN_PASSWORD
    }
    /**
     * Use case header.
     * For now, only two items.
     *
     */
    public class UseCaseHeader {

        String testName;
        String testDescription;

        public UseCaseHeader() {

            testName = "";
            testDescription = "";
        }

        public void setTestName(String value) {
            this.testName = value;
        }

        public void setTestDescription(String value) {
            this.testDescription = value;
        }

        public String getTestName() {
            return this.testName;
        }

        public String getTestDescription() {
            return this.testDescription;
        }
    }

    public List<TestCaseREST> extractTestCases(String xmlFile) {
        List<TestCaseREST> listTestsCases = new ArrayList<TestCaseREST>();

        UseCaseHeader header = new UseCaseHeader();

        try {
            // Parse the file TODO: need schema?
            Document doc = parsexml(xmlFile);

            NodeList nList = doc.getElementsByTagName(tagUseCase);

            // if the list NodeList is empty, that means this is not a useCase, but only a testCase,
            // then search about test case."
            if (nList.getLength() != 0) {
                // get the name and description of the useCase

                for (int iN = 0; iN < nList.getLength(); iN++) {
                    Node nNode = nList.item(iN);
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element rElement = (Element) nNode;
                        System.out.println("Analyse test case : rElement.getTagName(): " + rElement.getTagName());
                        NodeList ucList = nNode.getChildNodes();

                        for (int j = 0; j < ucList.getLength(); j++) {
                            Node lsnode = ucList.item(j);
                            if (lsnode.getNodeType() == Node.ELEMENT_NODE) {
                                Element elem = (Element) lsnode;
                                if (elem.getTagName().contains(tagName)) {
                                    header.setTestName(removeSpace(elem.getTextContent()));
                                } else if (elem.getTagName().contains(tagDescription)) {
                                    // System.out.println("Analyse test case : UseCane Descr : " + elem.getTextContent());
                                    // Remove nre line chars from the description, it causes reporting issues
                                    header.setTestDescription(elem.getTextContent().replaceAll("[\r\n]+", "").trim());
                                } else if (elem.getTagName().contains(tagTestCase)) {
                                    TestCaseREST testCaseRest = new TestCaseREST();
                                    listTestsCases.add(testCaseRest.testCaseAnalysis(lsnode, header));
                                }
                            }
                        }
                    }
                }
            } else {
                nList = doc.getElementsByTagName(tagTestCase);
                for (int iN = 0; iN < nList.getLength(); iN++) {
                    Node nNode = nList.item(iN);
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        TestCaseREST testCaseRest = new TestCaseREST();
                        listTestsCases
                                .add(testCaseRest.testCaseAnalysis(nNode, header));
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(" Test not executed " + xmlFile);
            ex.printStackTrace();
        }
        System.out.println("test case over " );
        return listTestsCases;
    }

    private Document parsexml(String xmlFile) {

        Document doc = null;
        File fxmlFile = new File(xmlFile);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        final SchemaFactory sf = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fxmlFile);
        } catch (ParserConfigurationException ex) {
            System.err.println("parsexml failed with Exception " + ex.getMessage());
        } catch (SAXException ex) {
            System.err.println("parsexml failed with Exception  " + ex.getMessage());

        } catch (IOException ex) {
            System.err.println("parsexml failed with Exception " + ex.getMessage());
        }
        return doc;
    }

    private static String removeSpace(String value) {

        String newValue;
        newValue = value.replaceAll("\\s", ""); // renvoie une copie du String
        newValue = newValue.trim();

        return newValue;
    }
}
