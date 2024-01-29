package sogyo.wesley.ipsportdata.app;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import sogyo.wesley.ipsportdata.App2;
import sogyo.wesley.ipsportdata.persistence.IRepository;
import sogyo.wesley.ipsportdata.app.controllers.IPController;
import sogy

public class App {
    private static final int PORT = 8080;


    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new App2().getGreeting());
        Server server = createServer(PORT);
        server.start();
        server.join();
    }

    private static Server createServer(int port2) {
        var server= new Server(port2);
        ServletContextHandler context = createStatefulContext(server);
        registerServlets(context);
        return server;
    }

    private static ServletContextHandler createStatefulContext(Server server) {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        return context;
    }

    private static void registerServlets(ServletContextHandler context) {
        context.addServlet(new ServletHolder(new ServletContainer(createResources())), "/*");
    }

    private static ResourceConfig createResources() {
        IFacory factory;
        IRepository repository;
        Controller IPcontroller;
        return new ResourceConfig().register(IPcontroller);
    }
}
