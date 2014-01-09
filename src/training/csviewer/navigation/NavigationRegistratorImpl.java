/**
 * 
 */
package training.csviewer.navigation;

import java.util.Objects;

import training.csviewer.IO.InputReader;
import training.csviewer.navigation.action.NavActionExit;
import training.csviewer.navigation.action.NavActionFirst;
import training.csviewer.navigation.action.NavActionGoTo;
import training.csviewer.navigation.action.NavActionLast;
import training.csviewer.navigation.action.NavActionNext;
import training.csviewer.navigation.action.NavActionPrevious;

/**
 * @author dmoench
 * 
 */
public class NavigationRegistratorImpl implements NavigationRegistrator
{
    private static final String GO_TO_PAGE_PROMPT = System.lineSeparator() + "Go to page: ";

    private final InputReader inReader;

    /**
     * 
     */
    public NavigationRegistratorImpl(InputReader inReader)
    {
        Objects.requireNonNull(inReader);
        this.inReader = inReader;
    }

    @Override
    public NavActionRegistry getNavActionRegistry()
    {
        return initRegistry();
    }

    private NavActionRegistry initRegistry()
    {
        NavActionRegistry registry = new NavActionRegistry();

        registry.addAction('N', new NavActionNext());
        registry.addAction('P', new NavActionPrevious());
        registry.addAction('F', new NavActionFirst());
        registry.addAction('L', new NavActionLast());
        registry.addAction('G', new NavActionGoTo(GO_TO_PAGE_PROMPT, inReader));
        registry.addAction('X', new NavActionExit());

        return registry;
    }
}
