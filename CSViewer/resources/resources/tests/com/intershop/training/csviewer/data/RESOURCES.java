package resources.tests.com.intershop.training.csviewer.data;

/**
 * Lists the path to the available testing resources.
 */
public class RESOURCES
{
    private static final String RESOURCE_PATH = "/" + RESOURCES.class.getPackage().getName().replace(".", "/");

    /**
     * The path to the test CSV-file.
     */
    public static final String TEST_CVS_SMALL = RESOURCE_PATH + "/test.csv";
}
