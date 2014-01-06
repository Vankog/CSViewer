/**
 * 
 */
package training.daniel.IO;

import java.util.List;

import training.daniel.state.StateMgr;

/**
 * @author dmoench
 * 
 */
public class UIBuilder
{
    private static final String NL = System.lineSeparator();
    private static final String CURRENT_PAGE = "Current page: %d" + NL;
    private static final String LAST_PAGE = NL + "Last page: %d" + NL;
    private static final String MENU_NAV = NL + "[N]ext page, [P]revious page, [F]irst page, [L]ast page, e[X]it" + NL;

    /**
     * @param currentState
     */
    public void printUI(StateMgr currentState)
    {
        List<Integer> maxWidths = currentState.getCurrentMaxWidths();

        Printer printer = new CSVPrinter(System.out, "|", "-");
        printer.print(LAST_PAGE, currentState.getCurrNavState().getLastPage());
        printer.print(CURRENT_PAGE, currentState.getCurrNavState().getCurrentPage());
        printer.print(currentState.getHeader(), maxWidths);
        printer.printSeparatorLine(maxWidths);
        printer.print(currentState.getValues(), maxWidths, currentState.getCurrNavState().getCurrentPage(),
                        currentState.getPageSize());
        printer.print(MENU_NAV);
    }
}
