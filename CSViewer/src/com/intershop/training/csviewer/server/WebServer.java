package com.intershop.training.csviewer.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 * Creates an embedded simple Server.
 */
public class WebServer
{

    /**
     * Creates an embedded simple server on the provided port and registers the servlets.
     * 
     * @param port
     *            The port on which the server should be accessible.
     * @throws Exception
     */
    public WebServer(Integer port) throws Exception
    {
        // Create a basic jetty server object that will listen on port 8080. Note that if you set this to port 0
        // then a randomly available port will be assigned that you can either look in the logs for the port,
        // or programmatically obtain it for use in test cases.
        Server server = new Server(port.intValue());

        // The ServletHandler is a dead simple way to create a context handler that is backed by an instance of a
        // Servlet. This handler then needs to be registered with the Server object.
        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);

        // Passing in the class for the servlet allows jetty to instantite an instance of that servlet and mount it
        // on a given context path.
        new ServletRegistrator().registerServlets(handler);

        // Start things up! By using the server.join() the server thread will join with the current thread.
        // See "http://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Thread.html#join()" for more details.
        server.start();
        server.join();
    }
}