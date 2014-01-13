/**
 * 
 */
package com.intershop.training.csviewer;

import java.io.IOException;

import com.intershop.training.csviewer.server.WebServer;

/**
 * 
 */
public class CSViewerServerMain
{
    /**
     * The Port on which the server shall be available.
     */
    public static final Integer WEBSERVER_PORT = Integer.valueOf(8081);

    /**
     * Starts up the Webserver and runs the CSViewer application.
     * 
     * @param args
     *            Not defined.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException
    {
        try
        {
            // Desktop.getDesktop().browse(new URI("http://localhost:" + WEBSERVER_PORT));
            @SuppressWarnings("unused")
            WebServer server = new WebServer(WEBSERVER_PORT);
        }
        catch(Exception e)
        {
            throw new RuntimeException("Exception in Server", e);
        }
    }
}
