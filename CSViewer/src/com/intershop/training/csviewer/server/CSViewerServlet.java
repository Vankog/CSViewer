package com.intershop.training.csviewer.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import resources.com.intershop.training.csviewer.server.RESOURCES;

import com.intershop.training.csviewer.io.StringFileReader;

@SuppressWarnings("serial")
public class CSViewerServlet extends HttpServlet
{
    private final Charset chSet = Charset.forName("UTF-8");

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    /**
     * Handles a GET request.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // get parameters
        String parameterFile = request.getParameter("file");
        Integer parameterSize = getPageSize(request);

        // set meta data
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        /*
         * temporary output stub
         */
        try (PrintWriter out = response.getWriter())
        {
            StringFileReader reader = new StringFileReader(chSet);

            // write HTML
            out.println("<html>");

            // load HTML from text file (UTF-8 format)
            Path headerTemplate = Paths.get(System.class.getResource(RESOURCES.HEADER).toURI());
            out.println(reader.readWholeFile(headerTemplate, System.lineSeparator()));

            Path inputTemplate = Paths.get(System.class.getResource(RESOURCES.INPUT).toURI());
            out.printf(reader.readWholeFile(inputTemplate, System.lineSeparator()), parameterFile, parameterSize);

            // print out file and add line breaks
            if (parameterFile != null)
            {
                out.println(reader.readWholeFile(Paths.get(parameterFile), "<br/>"));
            }
            out.println("</html>");

        }
        catch(URISyntaxException e)
        {
            logger.error("Could not load resource", e);
        }
    }

    @Override
    /**
     * Handles a POST request.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
    IOException
    {
        /*
         * SAMPLE stub
         */

        // get parameters
        String param = request.getParameter("param");

        /*
         * temporary output stub
         */
        try (PrintWriter out = response.getWriter())
        {
            // write HTML
            out.println("<html>");
            out.println("<body>");
            out.printf("You entered \"%s\" into the text box.", param);
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * @param request
     * @return page size defined at request
     * @throws NumberFormatException
     */
    public Integer getPageSize(HttpServletRequest request) throws NumberFormatException
    {
        String paramPSize = request.getParameter("psize");
        if (paramPSize == null || paramPSize.isEmpty())
        {
            return Integer.valueOf(3); // Fallback to a default value.
        }
        return Integer.valueOf(paramPSize);
    }
}
