package tests.training.csviewer.html;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.intershop.html.client.element.WebClient;
import com.intershop.html.client.gargoyle.element.WebClientImpl;
import com.intershop.html.runner.WebClientRunner;

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

public class CSViewerHTMLUnitTest
{
    private WebClient client;
    private WebClientRunner runner;

    public CSViewerHTMLUnitTest()
    {
        client = getWebClient();
    }

    @Before
    public void setUpWebsiteTest()
    {
        client.setScriptingEnabled(false);
        runner = new WebClientRunner(client, URI.create("http://localhost:8081"));
    }

    // example
    @Test
    public void shouldGoToHelpOnLinkClick()
    {
        runner.clickLink("What is a CSV?");
        Assert.assertTrue(runner.containsText("LMGTFY"));
    }

    // example
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

    // example
    @Test
    public void shouldShowTheInputFileContent()
    {
        Map<String, String> formData = new HashMap<>();
        formData.put("CSVInputForm_file", ".\\src\\tests\\training\\resources\\test.csv");
        formData.put("CSVInputForm_psize", "5");
        runner.fillFormByID("CSVInputForm", formData);
        runner.submitForm("CSVInputForm");
        Assert.assertTrue(runner.containsText("Boris;Paris;asdf"));
    }

    @After
    public void closeClient()
    {
        client.closeBrowser();
    }

    protected WebClient getWebClient()
    {
        return new WebClientImpl();
    }

}
