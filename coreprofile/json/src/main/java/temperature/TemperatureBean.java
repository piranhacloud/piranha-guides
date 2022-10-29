package temperature;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static temperature.Temperature.TemperatureScale.CELSIUS;
import static temperature.Temperature.TemperatureScale.FAHRENHEIT;

@RequestScoped
@Path("")
public class TemperatureBean {

    @GET
    @Produces(APPLICATION_JSON)
    @Path("/celsius/{celsius}")
    public Temperature celsius(@PathParam("celsius") double celsius) {
        Temperature temp = new Temperature();
        temp.setScale(CELSIUS);
        temp.setTemperature(celsius);
        return temp;
    }
    
    @GET
    @Produces("application/json")
    @Path("/fahrenheit/{fahrenheit}")
    public Temperature fahrenheit(@PathParam("fahrenheit") double fahrenheit) {
        Temperature temp = new Temperature();
        temp.setScale(FAHRENHEIT);
        temp.setTemperature(fahrenheit);
        return temp;
    }
}
