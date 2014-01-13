package resources.com.intershop.training.csviewer.server;

/**
 * Lists the path to the available server resources.
 */
public class RESOURCES
{
    private static final String RESOURCE_PATH = "/" + RESOURCES.class.getPackage().getName().replace(".", "/");

    /**
     * The Path to the file containing the header HTML.
     */
    public static final String HEADER = RESOURCE_PATH + "/header.template";

    /**
     * The Path to the file containing the input HTML.
     */
    public static final String INPUT = RESOURCE_PATH + "/input.template";
}
