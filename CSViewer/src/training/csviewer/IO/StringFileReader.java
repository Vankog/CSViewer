package training.csviewer.IO;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringFileReader
{
    private final Charset chSet;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public StringFileReader(Charset charSet)
    {
        Objects.requireNonNull(charSet, "Missing charset");
        this.chSet = charSet;
    }

    /**
     * Returns a String of the whole text file.<br/>
     * Not buffered, therefore only suitable for small files!
     * 
     * @param filePath
     *            The path to the file as Path object.
     * @return The whole text file as a List of Strings.
     */
    public List<String> readAllLines(Path filePath)
    {
        Objects.requireNonNull(filePath, "Path is missing.");
        List<String> lines = Collections.EMPTY_LIST;
        try
        {
            lines = Files.readAllLines(filePath, chSet);
        }
        catch(IOException | NullPointerException e)
        {
            logger.error("Can't load file: " + filePath, e);
        }
        return lines;
    }

    /**
     * Returns a String of the whole text file. <br/>
     * Not buffered, therefore only suitable for small files!
     * 
     * @param filePath
     *            The path to the file as Path object.
     * @param lineSeparator
     *            A String to insert as line separator.
     * @return The whole text file as a String.
     */
    public String readWholeFile(Path filePath, String lineSeparator)
    {
        Objects.requireNonNull(filePath, "Path missing.");
        Objects.requireNonNull(lineSeparator, "Line separator missing.");

        List<String> lines = readAllLines(filePath);

        StringBuilder sb = new StringBuilder();
        for (String s : lines)
        {
            sb.append(s);
            sb.append(lineSeparator);
        }

        return sb.toString();
    }

}
