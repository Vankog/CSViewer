package com.intershop.training.csviewer.server;

import org.eclipse.jetty.servlet.ServletHandler;

/**
 * Registers the Servlet Handlers for each URL path.
 */
public class ServletRegistrator
{

    /**
     * For a given URL-path a certain Servlet will be responsible. This mapping declares which Servlet classes are used
     * for which paths.
     * 
     * @param handler
     *            The ServletHandler that is assigned to the server.
     */
    public void registerServlets(ServletHandler handler)
    {
        // !! This is a raw Servlet, not a servlet that has been configured through a web.xml or anything like that !!
        handler.addServletWithMapping(CSViewerServlet.class, "/*");
    }

}