package tests.training.daniel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import training.daniel.IO.CSVLoader;

public class CSVLoaderTest
{
    private static List<List<String>> cells;
    private static final String HEADER_CITY = "City";
    private static File tempFile;
    private static final String VALUE_ILM = "Ilmenau";

    @BeforeClass
    public static void createFileContent() throws IOException
    {
        tempFile = File.createTempFile("testinitState", ".csv");
        FileWriter fWriter = new FileWriter(tempFile);
        fWriter.append("Name;" + HEADER_CITY + ";Age");
        fWriter.append(System.lineSeparator());
        fWriter.append("Hans;Wurststadt;-5");
        fWriter.append(System.lineSeparator());
        fWriter.append("Hacke;Jena;10");
        fWriter.append(System.lineSeparator());
        fWriter.append("Petra;" + VALUE_ILM + ";55555");
        fWriter.append(System.lineSeparator());
        fWriter.append("Bert;Berlin;159");
        fWriter.append(System.lineSeparator());
        fWriter.append("Boris;Paris;asdf");
        fWriter.append(System.lineSeparator());
        fWriter.append("Petra;Münster;/*-");
        fWriter.close();
        CSVLoader loader = new CSVLoader(";");
        cells = loader.load(tempFile.getPath());
    }

    @AfterClass
    public static void deleteContent()
    {
        tempFile.delete();
    }

    @Test
    public void testHeader() throws IOException
    {
        Assert.assertEquals("Second header element not " + HEADER_CITY, HEADER_CITY, cells.get(0).get(2));
    }

    @Test
    public void testLineNumber() throws IOException
    {
        Assert.assertEquals("6. line number incorrect ", "6", cells.get(6).get(0));
    }

    @Test
    public void testValues() throws IOException
    {
        Assert.assertEquals("3. value, city was not " + VALUE_ILM, VALUE_ILM, cells.get(3).get(2));
    }

}
