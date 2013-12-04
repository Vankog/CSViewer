/**
 * 
 */
package tests.training.daniel;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

import training.daniel.NavigationState;

/**
 * @author dmoench
 *
 */
public class NavigationStateTest
{
    private static NavigationState navState;
    
    private static final int FIRST_PAGE = 0;
    private static final int SECOND_PAGE = 1;
    private static final int LAST_PAGE = 2;

    @Test
    public void testNextPage() throws IOException
    {
        navState = new NavigationState();
        navState.setCurrentPage(FIRST_PAGE);
        navState.setLastPage(LAST_PAGE);
        Assert.assertEquals("next of 0", SECOND_PAGE, navState.getNextPage('N'));
    }
    
    @Test
    public void testNextPageOnLastPage() throws IOException
    {
        navState = new NavigationState();
        navState.setLastPage(LAST_PAGE);
        navState.setCurrentPage(navState.getLastPage());
        Assert.assertEquals("next of lastPage should be lastPage", navState.getLastPage(), navState.getNextPage('N'));
    }

    @Test
    public void testPrevPage() throws IOException
    {
        navState = new NavigationState();
        navState.setLastPage(LAST_PAGE);
        navState.setCurrentPage(SECOND_PAGE);
        Assert.assertEquals("previous to 1 should be 0", FIRST_PAGE, navState.getNextPage('P'));
    }

    @Test
    public void testPrevPageOnFirstPage() throws IOException
    {
        navState = new NavigationState();
        navState.setLastPage(LAST_PAGE);
        navState.setCurrentPage(FIRST_PAGE);
        Assert.assertEquals("previous to 0 should be 0", FIRST_PAGE, navState.getNextPage('P'));
    }
    

}
