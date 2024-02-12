package sogyo.wesley.ipsportdata.app;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import sogyo.wesley.ipsportdata.app.controllers.IPController;
import sogyo.wesley.ipsportdata.domain.AnalysisFactory;
import sogyo.wesley.ipsportdata.domain.IFactory;
import sogyo.wesley.ipsportdata.persistence.IRepository;
import sogyo.wesley.ipsportdata.persistence.Repository;


public class App {
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
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
        IFactory factory = new AnalysisFactory();
        IRepository repository = new Repository();
        IPController ipController = new IPController(factory, repository);
        return new ResourceConfig().register(ipController);
    }
} 
