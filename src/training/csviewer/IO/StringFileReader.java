package training.csviewer.IO;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class StringFileReader
{
    private final Charset chSet;

    public StringFileReader(Charset charSet)
    {
        Objects.requireNonNull(charSet, "Missing charset");
        this.chSet = charSet;
    }

    public String readWholeFile(String filePath)
    {
        List<String> lines = readAllLines(filePath);

        StringBuilder sb = new StringBuilder();
        String nl = System.lineSeparator();
        for (String s : lines)
        {
            sb.append(s);
            sb.append(nl);
        }

        return sb.toString();
    }

    public List<String> readAllLines(String filePath)
    {
        Path p = Paths.get(filePath);
        List<String> lines;
        try
        {
            lines = Files.readAllLines(p, chSet);
        }
        catch(IOException e)
        {
            throw new RuntimeException("Can't load file: " + filePath);
        }
        return lines;
    }

}
