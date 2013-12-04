package tests.training.daniel;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import training.daniel.CSViewer;
import training.daniel.State;

public class CSViewerTest
{

    @Test
    public void testGetStateHeader()
    {
        final int columns = 5;
        final int rows = 7;
        final int pageSize = 3;
        
        List<String> testHeader = new ArrayList<>(columns);
        testHeader.add("A"); 
        testHeader.add("B");
        testHeader.add("CCCCCC");
        testHeader.add("D");
        testHeader.add("E");
        
        List<List<String>> testValues = new ArrayList<>(rows+1);
        testValues.add(testHeader);
        for (int i = 1; i <= rows; i++)
        {
            List<String> testRow = new ArrayList<>(columns);
            for (int j = 1; j <= columns; j++)
            {
                testRow.add(Integer.toString(i)+";"+Integer.toString(j));
            }
            testValues.add(testRow);
        }
        
        CSViewer viewer = new CSViewer();
        State state = viewer.getState(testValues, pageSize);
        
        Assert.assertEquals("Header not correct", testHeader.toString(), state.getHeader().toString());
    }
    
    @Test
    public void testGetStateFirstValue()
    {
        final int columns = 5;
        final int rows = 7;
        final int pageSize = 3;
        final int validationRowNo = 1;
        
        List<String> testHeader = new ArrayList<>(columns);
        testHeader.add("A"); 
        testHeader.add("B");
        testHeader.add("CCCCCC");
        testHeader.add("D");
        testHeader.add("E");
        
        List<String> validationRow = new ArrayList<>(columns);
        
        List<List<String>> testValues = new ArrayList<>(rows+1);
        testValues.add(testHeader);
        for (int i = 1; i <= rows; i++)
        {
            List<String> testRow = new ArrayList<>(columns);
            for (int j = 1; j <= columns; j++)
            {
                String entry = Integer.toString(i)+";"+Integer.toString(j);
                testRow.add(entry);
                if (i == validationRowNo)
                {
                    validationRow.add(entry); // compare later
                }
            }
            testValues.add(testRow);
        }
        
        CSViewer viewer = new CSViewer();
        State state = viewer.getState(testValues, pageSize);
        
        Assert.assertEquals("First value row not correct", validationRow.toString(), state.getValues().get(validationRowNo-1).toString());
    }
    
    @Test
    public void testGetStateLastValue()
    {
        final int columns = 5;
        final int rows = 7;
        final int pageSize = 3;
        final int validationRowNo = rows;
        
        List<String> testHeader = new ArrayList<>(columns);
        testHeader.add("A"); 
        testHeader.add("B");
        testHeader.add("CCCCCC");
        testHeader.add("D");
        testHeader.add("E");
        
        List<String> validationRow = new ArrayList<>(columns);
        
        List<List<String>> testValues = new ArrayList<>(rows+1);
        testValues.add(testHeader);
        for (int i = 1; i <= rows; i++)
        {
            List<String> testRow = new ArrayList<>(columns);
            for (int j = 1; j <= columns; j++)
            {
                String entry = Integer.toString(i)+";"+Integer.toString(j);
                testRow.add(entry);
                if (i == validationRowNo)
                {
                    validationRow.add(entry); // compare later
                }
            }
            testValues.add(testRow);
        }
        
        CSViewer viewer = new CSViewer();
        State state = viewer.getState(testValues, pageSize);
        
        Assert.assertEquals("First value row not correct", validationRow.toString(), state.getValues().get(validationRowNo-1).toString());
    }

}
