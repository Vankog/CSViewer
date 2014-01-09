/**
 * 
 */
package training.csviewer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import training.csviewer.IO.InputReader;
import training.csviewer.IO.InputReaderImpl;
import training.csviewer.IO.UIBuilder;
import training.csviewer.navigation.NavigationRegistrator;
import training.csviewer.navigation.NavigationRegistratorImpl;
import training.csviewer.navigation.Navigator;
import training.csviewer.navigation.NavigatorImpl;
import training.csviewer.server.CSVServer;
import training.csviewer.state.NavigationState;
import training.csviewer.state.StateMgr;

/**
 * @author dmoench
 * 
 */
public class CSViewer
{

    private static final String LINE_NUMBER = "Line";

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException
    {
        try
        {
            CSVServer server = new CSVServer();
        }
        catch(Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // instance.processMenu(currentState);
    }

    public StateMgr getState(List<List<String>> cells, Integer pSize)
    {
        StateMgr result = new StateMgr(pSize, Integer.valueOf(0));
        List<String> header = cells.get(0);
        header.set(0, LINE_NUMBER);
        result.setHeader(header);
        List<List<String>> prepareValues = new ArrayList<>(cells.size());
        prepareValues.addAll(cells);
        prepareValues.remove(0);
        result.setValues(prepareValues);
        return result;
    }

    /**
     * @param currentState
     * @throws IOException
     */
    private void processMenu(StateMgr currentState) throws IOException
    {
        UIBuilder ui = new UIBuilder();
        InputReader in = new InputReaderImpl(System.out, System.in);

        NavigationRegistrator registrator = new NavigationRegistratorImpl(in);
        Navigator navigator = new NavigatorImpl(registrator.getNavActionRegistry());

        NavigationState currentNavState = currentState.getCurrNavState();
        while(currentNavState.getCurrentPage() >= 0)
        {
            ui.printUI(currentState);
            Integer newPage = navigator.getNewPage(in, currentNavState.getFirstPage(),
                            currentNavState.getCurrentPage(), currentNavState.getLastPage());
            currentNavState.setCurrentPage(newPage);
        }
    }

}
