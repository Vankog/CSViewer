package training.csviewer.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import training.csviewer.IO.StringFileReader;

@SuppressWarnings("serial")
public class CSViewerServlet extends HttpServlet
{
    private final Charset chSet = Charset.forName("UTF-8");
    private final String headerResName = "/training/csviewer/resources/header.template";
    private final String inputResName = "/training/csviewer/resources/input.template";

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    /**
     * Handles a GET request.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        /*
         * SAMPLE stub
         */

        // get parameters
        Integer pSize;
        String file = request.getParameter("file");
        String paramPSize = request.getParameter("psize");
        if (paramPSize == null || paramPSize.isEmpty())
            pSize = Integer.valueOf(3); // Fallback to a default value.
        else
            pSize = Integer.valueOf(paramPSize);

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
            URL resURL = System.class.getResource(headerResName);
            Path resPath = Paths.get(resURL.toURI());
            out.println(reader.readWholeFile(resPath, System.lineSeparator()));

            resURL = System.class.getResource(inputResName);
            resPath = Paths.get(resURL.toURI());
            // printf() for formatted strings, so you can use arguments
            out.printf(reader.readWholeFile(resPath, System.lineSeparator()), file, pSize);

            // print out file and add line breaks
            if (file != null)
                out.println(reader.readWholeFile(file, "<br/>"));

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
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
}