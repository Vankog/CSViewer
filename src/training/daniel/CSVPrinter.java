/**
 * 
 */
package training.daniel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dmoench
 *
 */
public class CSVPrinter
{
    

    public static void print(List<String> row, List<Integer> maxWidths)
    {
        for(int i = 0; i < row.size(); i++)
        {
            String value = row.get(i);
            System.out.print(value);
            for(int spaces = 0; spaces < maxWidths.get(i) - value.length(); spaces++)
            {
                System.out.print(' ');
            }
            System.out.print('|');
        }
        System.out.print(System.lineSeparator());
    }
    
    public static void printSeparatorLine(List<Integer> maxWidths)
    {
        List<String> row = new ArrayList<>(maxWidths.size());
        for (int i = 0; i < maxWidths.size(); i++)
        {
            Integer width = maxWidths.get(i);
            StringBuilder strBuilder = new StringBuilder(width);
            for (int j = 0; j < width; j++)
            {
                strBuilder.append('-');
            }
            row.add(strBuilder.toString());
        }
        print(row, maxWidths);
    }

    public static void print(List<List<String>> rows, List<Integer> maxWidths, int currentPage, Integer pageSize)
    {
        int startRow = currentPage * pageSize;
        int endRow = Math.min(startRow + pageSize, rows.size()); 
        for (int i = currentPage * pageSize; i < endRow; i++)
        {
            print(rows.get(i), maxWidths);
        }
    }

    public static void print(String output)
    {
        System.out.print(output);        
    }

    public static void print(String output, int value)
    {
        System.out.printf(output, value);
    }
    

}
