/**
 * 
 */
package training.daniel.navigation;

import java.io.IOException;
import java.util.Objects;

import training.daniel.IO.InputReader;
import training.daniel.navigation.action.NavAction;

/**
 * @author dmoench
 * 
 */
public class NavigatorImpl implements Navigator
{

    private static final String INPUT_WAIT = "Waiting for input: ";

    private final NavActionRegistry actionRegistry;

    /**
     * 
     */
    public NavigatorImpl(NavActionRegistry navActionRegistry)
    {
        Objects.requireNonNull(navActionRegistry);
        this.actionRegistry = navActionRegistry;
    }

    @Override
    public Integer getNewPage(InputReader inReader, Integer firstPage, Integer currentPage, Integer lastPage)
    {
        Objects.requireNonNull(inReader);
        Objects.requireNonNull(firstPage);
        Objects.requireNonNull(currentPage);
        Objects.requireNonNull(lastPage);

        Character key;
        try
        {
            key = Character.toUpperCase(inReader.readKey(INPUT_WAIT).charValue());
        }
        catch(IOException e)
        {
            return currentPage;
        }

        NavAction action = actionRegistry.getAction(key);
        if (action == null)
        {
            return currentPage;
        }
        return action.getPage(firstPage, currentPage, lastPage);
    }
}
