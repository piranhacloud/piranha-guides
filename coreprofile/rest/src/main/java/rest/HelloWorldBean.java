package rest;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@RequestScoped
@Path("/helloworld")
public class HelloWorldBean {

    @GET
    public String helloWorld() {
        return "Hello World!";
    }
}
