package training.daniel.server;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import training.daniel.CSViewer;
import training.daniel.IO.CSVLoader;
import training.daniel.state.StateMgr;

@SuppressWarnings("serial")
public class CSVLoaderServlet extends HttpServlet
{
    final String head = "<head><title>Example Web Application</title></head>";
    final String input = "<body>"
                    + "<p>This website shows a CSV file on the server.</p>"
                    + "<form method='GET' action=''/>"
                    + "file path on server: <input name='file' type='text' value='%s'/><br/>"
                    + "page size: <input name='psize' type='number' value='%d'/><br/>"
                    + "<input type='submit' value='Submit' />"
                    + "</form>"
                    + "</body>";

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

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(head);
        response.getWriter().printf(input, file, pSize);

        if (file.isEmpty() || pSize == null)
        {
            return;
        }

        CSVLoader loader = new CSVLoader(";", Charset.forName("UTF-8"));
        List<List<String>> cells = loader.load(file);
        CSViewer instance = new CSViewer();
        StateMgr currentState = instance.getState(cells, Integer.valueOf(paramPSize));

    }
}
