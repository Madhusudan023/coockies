package coockies;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCookies
 */
@WebServlet("/get")
public class GetCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();
		
		Cookie [] c = request.getCookies();
		boolean found = false;
		pw.println("<html> <body> <center> <h1> <table>");

        if (c != null && c.length > 0) {
            pw.println("<table border=black>");
            pw.println("<tr><th>Cookie Name</th><th>Cookie Value</th></tr>");
            for (Cookie c2 : c) {
               
                if (!"JSESSIONID".equals(c2.getName())) {
                    pw.println("<tr>");
                    pw.println("<td>" + c2.getName() + "</td>");
                    pw.println("<td>" + c2.getValue() + "</td>");
                    pw.println("</tr>");
                }
            }
            pw.println("</table>");
        } else {
            pw.println("<h3>No cookies found!</h3>");
        }
        pw.println(" <h4><a href=cookies.html> Return to Home </a></h4>");
		pw.println("</h1></center> </body>  </html> ");
	}

}
