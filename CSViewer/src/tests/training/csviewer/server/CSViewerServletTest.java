package tests.training.csviewer.server;

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

public class CSViewerServletTest
{
    private WebClient client;

    @After
    public void closeClient()
    {
        client.closeBrowser();
    }

    @Before
    public void resolveClient()
    {
        client = new WebClientImpl();
    }

    @Test
    public void testSimple()
    {
        WebClientRunner runner = new WebClientRunner(client, URI.create("http://localhost:8081"));
        Assert.assertTrue(runner.containsText("CSV"));

        Map<String, String> formData = new HashMap<>();
        formData.put("file", "src/tests/training/resources/test.csv");
        runner.submitForm("showCSV", formData);
        Assert.assertTrue(runner.containsText("Ilmenau"));
    }

}
