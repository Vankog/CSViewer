package training.daniel.server;

import org.eclipse.jetty.server.Server;

public class CVSServer
{

    public CVSServer() throws Exception
    {
        Server server = new Server(8081);
        server.setHandler(new HelloHandler("Ciao!", "How are you?"));
        server.start();
        server.join();
    }
}
