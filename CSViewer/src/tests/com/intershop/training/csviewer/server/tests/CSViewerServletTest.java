package tests.com.intershop.training.csviewer.server.tests;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import resources.tests.com.intershop.training.csviewer.data.RESOURCES;

import com.intershop.html.client.element.WebClient;
import com.intershop.html.client.gargoyle.element.WebClientImpl;
import com.intershop.html.runner.WebClientRunner;
import com.intershop.training.csviewer.CSViewerServerMain;

/*
 * ====================
 * JUnit 4 Quick Guide:
 * ====================
 * 
 * @Test
 *      Mark your test cases with @Test annotations.
 * 
 * @Before
 * @After
 *      Use @Before and @After annotations for “setup” and “tearDown” methods respectively. They run
 *      before and after every test case.
 * 
 * @BeforeClass
 * @AfterClass
 *      Use @BeforeClass and @AfterClass annotations for class wide “setup” and “tearDown”
 *      respectively. Think them as one time setup and tearDown. They run for one time before and after all test cases.
 * 
 * @Test(expected = ExampleException.class)
 *      Use “expected” parameter with @Test annotation for test cases that expect exception. Write the class name of
 *      the exception that will be thrown.
 * 
 * @Test(timeout = 1000)
 *       Define a timeout period in milliseconds with “timeout” parameter. The test fails when the timeout
 *       period exceeds.
 * 
 * @Ignore("Message")
 *      Put @Ignore annotation for test cases you want to ignore. You can add an optional string parameter that
 *      defines the reason of ignorance if you want.
 */

/**
 * Tests the CSV servlet.
 * 
 */
public class CSViewerServletTest
{
    private WebClient client;
    private WebClientRunner runner;

    /**
     * Constructor to get the HTML client and set it up. Not possible in @BeforeClass because it has to be static.
     * 
     * @throws IOException
     */
    public CSViewerServletTest() throws IOException
    {
        client = new WebClientImpl();
        client.setScriptingEnabled(false);
        runner = new WebClientRunner(client, URI.create("http://localhost:" + CSViewerServerMain.WEBSERVER_PORT));
    }

    /** SetUp. */
    @Before
    public void setUpWebsiteTest()
    { /* noop */  }

    /**
     * Example (In Behavior Driven Design: Tests are named after phrases that start with "should".) Should open the help
     * page on help link click.
     */
    @Test
    public void shouldGoToHelpOnLinkClick()
    {
        runner.clickLink("What is a CSV?");
        Assert.assertTrue(runner.containsText("LMGTFY"));
    }

    /**
     * Example Should set in a default value for Page Size if none is provided.
     */
    @Test
    public void shouldShowADefaultPageSizeValue()
    {
        Map<String, String> formData = new HashMap<>();
        formData.put("CSVInputForm_file", "");
        formData.put("CSVInputForm_psize", "");
        runner.fillFormByID("CSVInputForm", formData);
        runner.submitForm("CSVInputForm");
        Assert.assertTrue(runner.containsText("3"));
    }

    /**
     * Example Should show a temporary visualization of the provided file content.
     */
    @Test
    public void shouldShowTheInputFileContent()
    {
        Map<String, String> formData = new HashMap<>();
        formData.put("CSVInputForm_file", "resources" + RESOURCES.TEST_CVS_SMALL);
        formData.put("CSVInputForm_psize", "5");
        runner.fillFormByID("CSVInputForm", formData);
        runner.submitForm("CSVInputForm");
        Assert.assertTrue(runner.containsText("Boris;Paris;asdf"));
    }

    /**
     * TearDown Closes the client after each test.
     */
    @After
    public void closeClient()
    {
        client.closeBrowser();
    }

}
