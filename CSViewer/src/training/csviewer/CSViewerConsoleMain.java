/**
 * 
 */
package training.csviewer;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

import training.csviewer.IO.InputReader;
import training.csviewer.IO.InputReaderImpl;
import training.csviewer.IO.StringFileReader;

/**
 * 
 */
public class CSViewerConsoleMain
{

    /**
     * Runs the CSViewer console application.
     * 
     * @param args
     *            <ul>
     *            <li><code>arg[0]</code> is the file path to the CSV file (UTF-8) as String. <br/>
     *            e.g. test.csv: <code>".\src\tests\training\resources\test.csv"</code></li>
     *            <li><code>arg[1]</code> is the page size as a String. <br/>
     *            e.g.: <code>"6"</code></li></li>
     *            </ul>
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException
    {
        /*
         * SAMPLE stub
         */
        if (args.length < 2)
            return;

        Path csvPath;
        Integer pageSize;
        try
        {
            csvPath = Paths.get(args[0]);
            pageSize = Integer.valueOf(args[1]);
        }
        catch(InvalidPathException | NumberFormatException e)
        {
            throw new RuntimeException("Could not load parameters.", e);
        }

        /*
         * temporary output stub
         */

        // readkey and readline implementations
        InputReader in = new InputReaderImpl(System.out, System.in);
        Character key = in.readKey("Enter 'y' to print file: ");

        if (key.equals('y'))
        {
            // simple file reader implementation
            // readAllLines() can also output lines as List<String>
            StringFileReader reader = new StringFileReader(Charset.forName("UTF-8"));
            reader.readWholeFile(csvPath, System.lineSeparator());

            System.out.println(reader.readWholeFile(csvPath, System.lineSeparator()));
        }
    }
}
