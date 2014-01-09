package training.csviewer.IO;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        List<String> lines = Collections.EMPTY_LIST;
        try
        {
            Objects.requireNonNull(filePath, "Path is missing.");
            lines = Files.readAllLines(filePath, chSet);
        }
        catch(IOException | NullPointerException e)
        {
            logger.error("Can't load file: " + filePath, e);
        }
        return lines;
    }

    /**
     * Returns a String of the whole text file.<br/>
     * Not buffered, therefore only suitable for small files!
     * 
     * @param filePath
     *            The path to the file as String.
     * @return The whole text file as a List of Strings.
     */
    public List<String> readAllLines(String filePath)
    {
        return readAllLines(Paths.get(filePath));
    }

    /**
     * Returns a String of the whole text file. LineSeparator is <code>System.lineSeparator()</code>.<br/>
     * Not buffered, therefore only suitable for small files!
     * 
     * @param filePath
     *            The path to the file as Path object.
     * @return The whole text file as a String.
     */
    public String readWholeFile(Path filePath)
    {
        return readWholeFile(filePath, System.lineSeparator());
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

    /**
     * Returns a String of the whole text file. LineSeparator is <code>System.lineSeparator()</code>.<br/>
     * Not buffered, therefore only suitable for small files!
     * 
     * @param filePath
     *            The file path to the file as String.
     * @return The whole text file as a String.
     */
    public String readWholeFile(String filePath)
    {
        return readWholeFile(filePath, System.lineSeparator());
    }

    /**
     * Returns a String of the whole text file. <br/>
     * Not buffered, therefore only suitable for small files!
     * 
     * @param filePath
     *            The file path to the file as String.
     * @param lineSeparator
     *            A String to insert as line separator.
     * @return The whole text file as a String.
     */
    public String readWholeFile(String filePath, String lineSeparator)
    {
        return readWholeFile(Paths.get(filePath), lineSeparator);
    }

}