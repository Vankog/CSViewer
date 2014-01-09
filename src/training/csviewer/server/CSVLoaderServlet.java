package training.csviewer.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import training.csviewer.IO.StringFileReader;

@SuppressWarnings("serial")
public class CSVLoaderServlet extends HttpServlet
{
    private final Charset chSet = Charset.forName("UTF-8");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Integer pSize;
        String file = request.getParameter("file");
        String paramPSize = request.getParameter("psize");
        if (paramPSize == null || paramPSize.isEmpty())
        {
            pSize = Integer.valueOf(3);
        }
        else
        {
            pSize = Integer.valueOf(paramPSize);
        }

        StringFileReader reader = new StringFileReader(chSet);
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println(reader.readWholeFile("./src/training/csviewer/resources/header.template"));
        out.printf(reader.readWholeFile("./src/training/csviewer/resources/input.template"), file, pSize);
        out.println("</html>");

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String param = request.getParameter("param");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");
        out.println("You entered \"" + param + "\" into the text box.");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}
