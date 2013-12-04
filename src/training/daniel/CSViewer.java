/**
 * 
 */
package training.daniel;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dmoench
 *
 */
public class CSViewer
{

    private static final String MENU_NAV = System.lineSeparator() 
                    + "[N]ext page, [P]revious page, [F]irst page, [L]ast page, e[X]it" 
                    + System.lineSeparator();
    private static final String LAST_PAGE = System.lineSeparator() 
                    + "Last page: %d"
                    + System.lineSeparator();
    private static final String CURRENT_PAGE = "Current page: %d"
                    + System.lineSeparator();
    private static final String INPUT_WAIT = "Waiting for input: ";

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException
    {
        CSVLoader loader = new CSVLoader(";");  
        List<List<String>> cells = loader.load(args[0]);
        State currentState = getState(cells, Integer.valueOf(args[1]));
        processMenu(currentState);
        
    }

    /**
     * @param currentState
     * @throws IOException
     */
    private static void processMenu(State currentState) throws IOException
    {
        NavigationState currentNavState = currentState.getCurrNavState();
        while(currentNavState.getCurrentPage() >= 0)
        {
            printUI(currentState);
            char c = readKey();
            currentNavState.setCurrentPage(currentNavState.getNextPage(c));
        }
    }

    /**
     * @param currentState
     */
    private static void printUI(State currentState)
    {
        List<Integer> maxWidths = currentState.getCurrentMaxWidths();
        
        CSVPrinter.print(LAST_PAGE, currentState.getCurrNavState().getLastPage());
        CSVPrinter.print(CURRENT_PAGE, currentState.getCurrNavState().getCurrentPage());
        CSVPrinter.print(currentState.getHeader(), maxWidths);
        CSVPrinter.printSeparatorLine(maxWidths);
        CSVPrinter.print(currentState.getValues(), maxWidths, currentState.getCurrNavState().getCurrentPage(), currentState.getPageSize());
        CSVPrinter.print(MENU_NAV);
        CSVPrinter.print(INPUT_WAIT);
    }

    
    public static State getState(List<List<String>> cells, Integer pSize)
    {
        State result = new State(pSize);
        result.setHeader(cells.get(0));
        List<List<String>> prepareValues = new ArrayList<>(cells.size());
        prepareValues.addAll(cells);
        prepareValues.remove(0);
        result.setValues(prepareValues);
        return result;
    }

    private static char readKey() throws IOException
    {
        InputStreamReader istream = new InputStreamReader(System.in);
        char[] cbuf = new char[1];
        istream.read(cbuf);
        return cbuf[0];
    }

}
