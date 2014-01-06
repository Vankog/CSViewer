/**
 * 
 */
package training.daniel.navigation;

import java.util.HashMap;
import java.util.Map;

import training.daniel.navigation.action.NavAction;

/**
 * @author dmoench
 * 
 */
public class NavActionRegistry
{

    private static final Map<Character, NavAction> registry = new HashMap<>(10, 0.9f);

    public void addAction(Character key, NavAction action)
    {
        registry.put(key, action);
    }

    public NavAction getAction(Character key)
    {
        return registry.get(key);
    }

    public NavAction removeAction(Character key)
    {
        return registry.remove(key);
    }

}
