package helloworld;

import cloud.piranha.embedded.EmbeddedPiranha;
import cloud.piranha.embedded.EmbeddedPiranhaBuilder;
import cloud.piranha.http.impl.DefaultHttpServer;
import cloud.piranha.http.webapp.HttpWebApplicationServer;

public class HelloWorldApplication {

    public static void main(String[] arguments) throws Exception {
        EmbeddedPiranha piranha = new EmbeddedPiranhaBuilder()
                .servlet("HelloWorld", HelloWorldServlet.class)
                .servletMapping("HelloWorld", "/*")
                .buildAndStart();
        
        HttpWebApplicationServer webAppServer = new HttpWebApplicationServer();
        webAppServer.addWebApplication(piranha.getWebApplication());
        DefaultHttpServer server = new DefaultHttpServer(8080, 
                webAppServer, false);
        
        server.start();
    }
}
