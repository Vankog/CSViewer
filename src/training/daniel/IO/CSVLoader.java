/**
 * 
 */
package training.daniel.IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dmoench
 * 
 */
public class CSVLoader
{
    private final String columnSep;

    public CSVLoader(String columnSep)
    {
        this.columnSep = columnSep;
    }

    public List<List<String>> load(String filePath)
    {
        List<List<String>> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            int i = 0;
            String dataRow = reader.readLine();
            while(dataRow != null)
            {
                String[] dataArray = dataRow.split(columnSep);
                List<String> row = new ArrayList<>(dataArray.length + 1);
                row.add(String.valueOf(i));
                row.addAll(Arrays.asList(dataArray));
                result.add(row);
                i++;
                dataRow = reader.readLine(); // Read next line of data.
            }
        }
        catch(IOException e)
        {
            throw new RuntimeException("Can't load file: " + filePath);
        }
        return result;
    }
}