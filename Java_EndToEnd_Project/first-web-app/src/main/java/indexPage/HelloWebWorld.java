package indexPage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloWebWorld")
public class HelloWebWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloWebWorld() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
  // Print message on Web Page
		pw.println("<h1>Hello Web World!!</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		doGet(request, response);
	}

}
