/**
 * 
 */
package training.daniel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import training.daniel.IO.CSVLoader;
import training.daniel.IO.InputReader;
import training.daniel.IO.InputReaderImpl;
import training.daniel.IO.UIBuilder;
import training.daniel.navigation.NavigationRegistrator;
import training.daniel.navigation.NavigationRegistratorImpl;
import training.daniel.navigation.Navigator;
import training.daniel.navigation.NavigatorImpl;
import training.daniel.state.NavigationState;
import training.daniel.state.StateMgr;

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
        CSVLoader loader = new CSVLoader(";");
        List<List<String>> cells = loader.load(args[0]);
        CSViewer instance = new CSViewer();
        StateMgr currentState = instance.getState(cells, Integer.valueOf(args[1]));
        instance.processMenu(currentState);

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
