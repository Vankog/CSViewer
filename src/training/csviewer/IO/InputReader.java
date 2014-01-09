/**
 * 
 */
package training.csviewer.IO;

import java.io.IOException;

/**
 * @author dmoench
 * 
 */
public interface InputReader
{
    public Character readKey() throws IOException;

    public Character readKey(String promptMessage) throws IOException;

    public String readLine() throws IOException;

    public String readLine(String promptMessage) throws IOException;
}
