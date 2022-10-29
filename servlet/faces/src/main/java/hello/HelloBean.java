package hello;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named(value = "helloBean")
@RequestScoped
public class HelloBean {

    private String hello = "Hello from Jakarta Faces!";

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
