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
 * Servlet implementation class CoockiesServlets
 */
@WebServlet("/set")
public class SetCoockies  extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetCoockies () {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<style> h1{background-color:blue; color:white; width:500px; height:50px; padding-top:10px;}</style>");
		String s1 = request.getParameter("book1");
		String s2 = request.getParameter("book2");
		String s3 = request.getParameter("book3");
		if(s1!=null) {
			Cookie c1 = new Cookie("book1", s1);
			response.addCookie(c1);
		}
		if(s2!=null) {
			Cookie c2 = new Cookie("book2", s2);
			response.addCookie(c2);
		}
		if(s3!=null) {
			Cookie c3 = new Cookie("book3", s3);
			response.addCookie(c3);
		}
		if(s1!=null || s3!=null ||s2!=null) {
			pw.println("<html><body><center> <h1> ");
			pw.println("Books are added ");
			pw.println("</br> ");
			pw.println("</h1><a href=get>Next</a>");
			pw.println("</center></body></html> ");
		}
		else {
			pw.println("<html><body><center> <h1> ");
			pw.println(" Empty! No books Selected");
			s1=null;
			s2=null;
			s3=null; 
			pw.println("</h1> <a href=cookies.html>Next</a>");
			pw.println("</center></body></html> ");
		}
	}

}
