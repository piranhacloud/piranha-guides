package rest;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@RequestScoped
@Path("/hellorest")
public class HelloRestBean {

    @GET
    public String hello() {
        return "Hello REST!";
    }
}
