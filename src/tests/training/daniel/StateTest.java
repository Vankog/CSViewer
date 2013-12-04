/**
 * 
 */
package tests.training.daniel;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import training.daniel.State;

/**
 * @author dmoench
 *
 */
public class StateTest
{
    /**
     * Test method for {@link training.daniel.State#setValues()}.
     */
    @Test
    public void testSetValues()
    {
        final int columns = 5;
        final int rows = 6;
        
        
        List<List<String>> testValues = new ArrayList<>(rows);
        for (int i = 1; i <= rows; i++)
        {
            List<String> testRow = new ArrayList<>(columns);
            for (int j = 1; j <= columns; j++)
            {
                testRow.add(Integer.toString(i)+";"+Integer.toString(j));
            }
            testValues.add(testRow);
        }
        
        State state = new State(3);
        state.setValues(testValues);
        
        Assert.assertEquals("value should be "+rows+","+columns, rows+";"+columns, state.getValues().get(rows-1).get(columns-1));
    }

    /**
     * Test method for {@link training.daniel.State#setValues()}.
     */
    @Test
    public void testLastPageNoRemainder()
    {
        final int columns = 5;
        final int rows = 6;
        final int pageSize = 3; // no remainder
        
        
        
        
        List<List<String>> testValues = new ArrayList<>(rows);
        for (int i = 1; i <= rows; i++)
        {
            List<String> testRow = new ArrayList<>(columns);
            for (int j = 1; j <= columns; j++)
            {
                testRow.add(Integer.toString(i)+";"+Integer.toString(j));
            }
            testValues.add(testRow);
        }
        
        State state = new State(pageSize);
        state.setValues(testValues);
        
        Assert.assertEquals("Last Page should be 1", 1, state.getCurrNavState().getLastPage());
    }
    
    /**
     * Test method for {@link training.daniel.State#setValues()}.
     */
    @Test
    public void testLastPageWithRemainder()
    {
        final int columns = 5;
        final int rows = 7;
        final int pageSize = 3; // 1 remaining
        
        
        
        
        List<List<String>> testValues = new ArrayList<>(rows);
        for (int i = 1; i <= rows; i++)
        {
            List<String> testRow = new ArrayList<>(columns);
            for (int j = 1; j <= columns; j++)
            {
                testRow.add(Integer.toString(i)+";"+Integer.toString(j));
            }
            testValues.add(testRow);
        }
        
        State state = new State(pageSize);
        state.setValues(testValues);
        
        Assert.assertEquals("Last Page should be 2", 2, state.getCurrNavState().getLastPage());
    }
    
    /**
     * Test method for {@link training.daniel.State#setValues()}.
     */
    @Test
    public void testLastPageUnderSize()
    {
        final int columns = 5;
        final int rows = 7;
        final int pageSize = 10; // greater than value size
        
        
        
        
        List<List<String>> testValues = new ArrayList<>(rows);
        for (int i = 1; i <= rows; i++)
        {
            List<String> testRow = new ArrayList<>(columns);
            for (int j = 1; j <= columns; j++)
            {
                testRow.add(Integer.toString(i)+";"+Integer.toString(j));
            }
            testValues.add(testRow);
        }
        
        State state = new State(pageSize);
        state.setValues(testValues);
        
        Assert.assertEquals("Last Page should be 0", 0, state.getCurrNavState().getLastPage());
    }

    /**
     * Test method for {@link training.daniel.State#getCurrentMaxWidths()}.
     */
    @Test
    public void testGetCurrentMaxWidthsFirst()
    {
        final int columns = 5;
        final int rows = 7;
        final int pageSize = 3;
        
        
        
        List<String> testHeader = new ArrayList<>(columns);
        testHeader.add("A"); //testing this column
        testHeader.add("B");
        testHeader.add("CCCCCC");
        testHeader.add("D");
        testHeader.add("E");
        
        List<List<String>> testValues = new ArrayList<>(rows);
        for (int i = 1; i <= rows; i++)
        {
            List<String> testRow = new ArrayList<>(columns);
            for (int j = 1; j <= columns; j++)
            {
                testRow.add(Integer.toString(i)+";"+Integer.toString(j));
            }
            testValues.add(testRow);
        }
        
        State state = new State(pageSize);
        state.setValues(testValues);
        state.setHeader(testHeader);
        
        
        Assert.assertEquals("Width should be 3", 3, state.getCurrentMaxWidths().get(1).intValue());
    }
    
    /**
     * Test method for {@link training.daniel.State#getCurrentMaxWidths()}.
     */
    @Test
    public void testGetCurrentMaxWidthsLast()
    {
        final int columns = 5;
        final int rows = 7;
        final int pageSize = 3;
        
        
        
        List<String> testHeader = new ArrayList<>(columns);
        testHeader.add("A");
        testHeader.add("B");
        testHeader.add("CCCCCC"); //testing this column
        testHeader.add("D");
        testHeader.add("E");
        
        List<List<String>> testValues = new ArrayList<>(rows);
        for (int i = 1; i <= rows; i++)
        {
            List<String> testRow = new ArrayList<>(columns);
            for (int j = 1; j <= columns; j++)
            {
                testRow.add(Integer.toString(i)+";"+Integer.toString(j));
            }
            testValues.add(testRow);
        }
        
        State state = new State(pageSize);
        state.setValues(testValues);
        state.setHeader(testHeader);
        
        
        Assert.assertEquals("Width should be 6", 6, state.getCurrentMaxWidths().get(2).intValue());
    }
}
