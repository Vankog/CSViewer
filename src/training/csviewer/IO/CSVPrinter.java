/**
 * 
 */
package training.csviewer.IO;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dmoench
 * 
 */
public class CSVPrinter implements Printer
{

    private String colSeparator;
    private String rowSeparator;
    private PrintStream outStream;

    public CSVPrinter(PrintStream stream, String columnSeparator, String rowSeparator)
    {
        this.outStream = stream;
        this.colSeparator = columnSeparator;
        this.rowSeparator = rowSeparator;

    }

    @Override
    public void print(List<String> row, List<Integer> maxWidths)
    {
        for (int i = 0; i < row.size(); i++)
        {
            String value = row.get(i);
            outStream.print(value);
            for (int spaces = 0; spaces < maxWidths.get(i) - value.length(); spaces++)
            {
                outStream.print(' ');
            }
            outStream.print(colSeparator);
        }
        outStream.print(System.lineSeparator());
    }

    @Override
    public void printSeparatorLine(List<Integer> maxWidths)
    {
        List<String> row = new ArrayList<>(maxWidths.size());
        for (int i = 0; i < maxWidths.size(); i++)
        {
            Integer width = maxWidths.get(i);
            StringBuilder strBuilder = new StringBuilder(width);
            for (int j = 0; j < width; j++)
            {
                strBuilder.append(rowSeparator);
            }
            row.add(strBuilder.toString());
        }
        print(row, maxWidths);
    }

    @Override
    public void print(String output)
    {
        outStream.print(output);
    }

    @Override
    public void print(String output, int value)
    {
        outStream.printf(output, value);
    }

    @Override
    public void print(List<List<String>> rows, List<Integer> maxWidths, int currentPage, Integer pageSize)
    {
        int startRow = currentPage * pageSize;
        int endRow = Math.min(startRow + pageSize, rows.size());
        for (int i = currentPage * pageSize; i < endRow; i++)
        {
            print(rows.get(i), maxWidths);
        }
    }

}
