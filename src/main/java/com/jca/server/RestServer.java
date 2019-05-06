package com.jca.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class RestServer {

	public static void main(String[] args) {
		Weld weld = new Weld();
		Server server = new Server(8080);

		ServletContextHandler ctx = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);

		ctx.setContextPath("/");
		server.setHandler(ctx);

		ServletHolder serHol = ctx.addServlet(ServletContainer.class, "/api/*");
		serHol.setInitOrder(0);
		serHol.setInitParameter("jersey.config.server.provider.packages", "com.jca.server");
		try {
			WeldContainer container = weld.initialize();
            server.start();
            server.join();
			
		}catch(final Exception e) {
			e.printStackTrace();
		}finally {
			weld.shutdown();
			server.destroy();
		}

	}

}
