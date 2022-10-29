package arquillian;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/helloarquillian")
@RequestScoped
public class HelloArquillianBean {

    @GET
    public String helloArquillian() {
        return "Hello Arquillian!";
    }
}
