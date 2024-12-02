package assignm01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	processRequest(req,resp);
}
 
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  processRequest(req,resp);
	}
private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	System.out.println("Information about profile");
	resp.setContentType("text/html");
	PrintWriter out = resp.getWriter();
	out.println("<html>");
	out.println("<head>");
	out.println("<title>Profile Information</title>");
	out.println("</head>");
	out.println("<body bgcolor='pink'>");
	out.println("<h3>First Name : Shriya</h3>");
	out.println("<h3>Last Name : Patil</h3>");
	out.println("<h3>Qualification : Post Graduate</h3>");
	out.println("<h3>University Name : Shivaji university</h3>");
	out.println("<h3>Birth Date : 02-08-2001</h3>");
	out.println("</body>");
	out.println("</html>");
	}
}
