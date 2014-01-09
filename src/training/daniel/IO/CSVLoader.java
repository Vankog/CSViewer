/**
 * 
 */
package training.daniel.IO;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author dmoench
 * 
 */
public class CSVLoader
{
    private final Charset chSet;
    private final String columnSep;

    public CSVLoader(String columnSep, Charset charSet)
    {
        if (columnSep == null || columnSep.isEmpty())
        {
            throw new IllegalArgumentException("Missing column Separator");
        }
        Objects.requireNonNull(charSet, "Missing charset");
        this.columnSep = columnSep;
        this.chSet = charSet;

    }

    public List<List<String>> load(String filePath)
    {
        List<List<String>> result = new ArrayList<>();

        StringFileReader fileReader = new StringFileReader(chSet);
        List<String> lines;
        try
        {
            lines = fileReader.readAllLines(filePath);
        }
        catch(RuntimeException e)
        {
            throw new RuntimeException("Can't load CSV file: " + filePath);
        }

        int size = lines.size();
        for (int i = 0; i < size; i++)
        {
            String dataRow = lines.get(i);
            String[] dataArray = dataRow.split(columnSep);
            List<String> row = new ArrayList<>(dataArray.length + 1);
            row.add(String.valueOf(i));
            row.addAll(Arrays.asList(dataArray));
            result.add(row);
        }
        return result;
    }
}
