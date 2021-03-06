/**
 * 
 */
package training.csviewer.IO;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * @author dmoench
 * 
 */
public class InputReaderImpl implements InputReader
{

    private final InputStream in;
    private final PrintStream out;

    /**
     * 
     */
    public InputReaderImpl(PrintStream outPrompt, InputStream inReader)
    {
        out = outPrompt;
        in = inReader;
    }

    @Override
    public Character readKey() throws IOException
    {
        return readKey("");
    }

    @Override
    public Character readKey(String prompt) throws IOException
    {
        out.print(prompt);
        char[] cbuf = new char[1];
        InputStreamReader iStream = new InputStreamReader(in);
        iStream.read(cbuf);
        return Character.valueOf(cbuf[0]);
    }

    @Override
    public String readLine() throws IOException
    {
        return readLine("");
    }

    @Override
    public String readLine(String prompt) throws IOException
    {
        out.print(prompt);
        char[] cbuf = new char[80];
        InputStreamReader iStream = new InputStreamReader(in);
        iStream.read(cbuf);
        return cbuf.toString();
    }

}
