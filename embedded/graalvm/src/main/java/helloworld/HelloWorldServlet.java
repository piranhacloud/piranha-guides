package helloworld;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * The 'Hello World!' servlet.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class HelloWorldServlet extends HttpServlet {
    
    /**
     * Constructor.
     * 
     * <p>
     *  Note the constructor is needed here to make it so we can generate the
     *  GraalVM binary. See META-INF/native-image for more information.
     * </p>
     */
    public HelloWorldServlet() {
    }
    
    /**
     * Handle the GET requests.
     *
     * @param request the request.
     * @param response the response.
     * @throws IOException when an I/O error occurs.
     * @throws ServletException when a Servlet error occurs.
     */
    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) throws IOException, ServletException {
        try (PrintWriter writer = response.getWriter()) {
            writer.println("Hello World!");
            writer.flush();
        }
    }
}
