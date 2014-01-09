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
import training.daniel.IO.StringFileReader;
import training.daniel.state.StateMgr;

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
        response.getWriter().println(reader.readAll("./src/training/daniel/resources/header.template"));
        response.getWriter().printf(reader.readAll("./src/training/daniel/resources/input.template"), file, pSize);

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
