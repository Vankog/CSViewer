/**
 * 
 */
package com.intershop.training.csviewer.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * @author dmoench
 * 
 */
public class InputReaderImpl
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

    public Character readKey() throws IOException
    {
        return readKey("");
    }

    public Character readKey(String promptMessage) throws IOException
    {
        out.print(promptMessage);
        char[] cbuf = new char[1];
        InputStreamReader iStream = new InputStreamReader(in);
        iStream.read(cbuf);
        return Character.valueOf(cbuf[0]);
    }

    public String readLine() throws IOException
    {
        return readLine("");
    }

    public String readLine(String promptMessage) throws IOException
    {
        out.print(promptMessage);
        char[] cbuf = new char[80];
        InputStreamReader iStream = new InputStreamReader(in);
        iStream.read(cbuf);
        return cbuf.toString();
    }

}
