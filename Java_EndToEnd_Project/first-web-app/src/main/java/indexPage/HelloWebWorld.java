package indexPage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Define a servlet mapped to the URL pattern "/HelloWebWorld"
@WebServlet("/HelloWebWorld")
public class HelloWebWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Constructor for the servlet
	public HelloWebWorld() {
		super();
	}

	// Handles HTTP GET requests
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Set the content type of the response to HTML
		response.setContentType("text/html");

		// Get the PrintWriter to write the HTML response
		PrintWriter pw = response.getWriter();

		// Send a simple HTML response to the client
		pw.println("<h1>Hello Web World!!</h1>");
	}

	// Handles HTTP POST requests by delegating to doGet()
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		doGet(request, response);
	}

}
