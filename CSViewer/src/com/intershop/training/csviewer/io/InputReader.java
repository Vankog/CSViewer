/**
 * 
 */
package com.intershop.training.csviewer.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Simple input reader for the console.
 */
public class InputReader
{

    private final InputStream in;
    private final PrintStream out;

    /**
     * Constructor to initialize in and output stream.
     * 
     * @param outPrompt
     *            Output stream.
     * @param inReader
     *            Input stream.
     */
    public InputReader(PrintStream outPrompt, InputStream inReader)
    {
        out = outPrompt;
        in = inReader;
    }

    /**
     * Reads a single Character and returns it.
     * 
     * @return The input.
     * @throws IOException
     */
    public Character readKey() throws IOException
    {
        return readKey("");
    }

    /**
     * Displays the prompt message, reads a single Character and returns it.
     * 
     * @return The input.
     * @param promptMessage
     *            The message to prompt for the input.
     * @throws IOException
     */
    public Character readKey(String promptMessage) throws IOException
    {
        out.print(promptMessage);
        char[] cbuf = new char[1];
        InputStreamReader iStream = new InputStreamReader(in);
        iStream.read(cbuf);
        return Character.valueOf(cbuf[0]);
    }

    /**
     * Reads a line and returns it.
     * 
     * @return The input.
     * @throws IOException
     */
    public String readLine() throws IOException
    {
        return readLine("");
    }

    /**
     * Displays the prompt message, reads a line and returns it.
     * 
     * @param promptMessage
     *            The message to prompt for the input.
     * @return The input.
     * @throws IOException
     */
    public String readLine(String promptMessage) throws IOException
    {
        out.print(promptMessage);
        char[] cbuf = new char[80];
        InputStreamReader iStream = new InputStreamReader(in);
        iStream.read(cbuf);
        return cbuf.toString();
    }

}
