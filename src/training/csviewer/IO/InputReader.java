/**
 * 
 */
package training.csviewer.IO;

import java.io.IOException;

public interface InputReader
{

    /**
     * Reads a single Character and returns it.
     * 
     * @return The input.
     * @throws IOException
     */
    public Character readKey() throws IOException;

    /**
     * Displays the prompt message, reads a single Character and returns it.
     * 
     * @return The input.
     * @param promptMessage
     *            The message to prompt for the input.
     * @throws IOException
     */
    public Character readKey(String promptMessage) throws IOException;

    /**
     * Reads a line and returns it.
     * 
     * @return The input.
     * @throws IOException
     */
    public String readLine() throws IOException;

    /**
     * Displays the prompt message, reads a line and returns it.
     * 
     * @param promptMessage
     *            The message to prompt for the input.
     * @return The input.
     * @throws IOException
     */
    public String readLine(String promptMessage) throws IOException;
}
