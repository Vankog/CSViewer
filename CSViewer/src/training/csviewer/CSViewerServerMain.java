/**
 * 
 */
package training.csviewer;

import java.io.IOException;

import training.csviewer.server.WebServer;

/**
 * 
 */
public class CSViewerServerMain
{

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
            WebServer server = new WebServer();
        }
        catch(Exception e)
        {
            throw new RuntimeException("Exception in Server", e);
        }
    }
}