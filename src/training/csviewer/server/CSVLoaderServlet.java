package training.csviewer.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import training.csviewer.CSViewer;
import training.csviewer.IO.CSVLoader;
import training.csviewer.IO.StringFileReader;
import training.csviewer.state.StateMgr;

@SuppressWarnings("serial")
public class CSVLoaderServlet extends HttpServlet
{
    private final Charset chSet = Charset.forName("UTF-8");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String file = request.getParameter("file");
        if (file == null)
        {
            file = "";
        }
        String paramPSize = request.getParameter("psize");
        if (paramPSize == null)
        {
            paramPSize = "1";
        }
        Integer pSize = Integer.valueOf(paramPSize);

        StringFileReader reader = new StringFileReader(chSet);
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println(reader.readAll("./src/training/csviewer/resources/header.template"));
        out.printf(reader.readAll("./src/training/csviewer/resources/input.template"), file, pSize);
        out.println("</html>");

        out.close();

        if (file.isEmpty() || pSize == null)
        {
            return;
        }

        CSVLoader loader = new CSVLoader(";", chSet);
        List<List<String>> cells = loader.load(file);
        response.getWriter().println(new StringFileReader(chSet).readAll(file));
        System.out.println(new StringFileReader(chSet).readAll(file));
        response.getWriter().println(cells.toString());
        CSViewer instance = new CSViewer();
        StateMgr currentState = instance.getState(cells, Integer.valueOf(paramPSize));

    }
}
