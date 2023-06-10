package hello;

import cloud.piranha.http.virtual.VirtualHttpServer;
import cloud.piranha.spring.starter.embedded.EmbeddedPiranhaServletWebServerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelloApplication {

    @Bean
    public ServletWebServerFactory factory() {
        return new EmbeddedPiranhaServletWebServerFactory();
    }

    @Bean
    public WebServerFactoryCustomizer<EmbeddedPiranhaServletWebServerFactory> customizer() {
        return new WebServerFactoryCustomizer<EmbeddedPiranhaServletWebServerFactory>() {
            @Override
            public void customize(EmbeddedPiranhaServletWebServerFactory factory) {
                factory.setHttpServer(new VirtualHttpServer());
                factory.setPort(8080);
            }
        };
    }

    public static void main(String[] arguments) {
        SpringApplication.run(HelloApplication.class, arguments);
    }
}
