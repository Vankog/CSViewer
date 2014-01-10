package tests.com.intershop.training.csviewer.server;

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
        WebClientRunner runner = new WebClientRunner(client, URI.create("http://localhost:"
                        + CSViewerServerMain.WEBSERVER_PORT));
        Assert.assertTrue(runner.containsText("CSV"));

        Map<String, String> formData = new HashMap<>();
        formData.put("file", "resources" + RESOURCES.TEST_CVS_SMALL);
        runner.submitForm("showCSV", formData);
        Assert.assertTrue(runner.containsText("Ilmenau"));
    }

}
