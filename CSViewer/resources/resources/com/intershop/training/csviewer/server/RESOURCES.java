package resources.com.intershop.training.csviewer.server;

public class RESOURCES
{
    private static final String RESOURCE_PATH = "/" + RESOURCES.class.getPackage().getName().replace(".", "/");
    public static final String HEADER = RESOURCE_PATH + "/header.template";
    public static final String INPUT = RESOURCE_PATH + "/input.template";
}
