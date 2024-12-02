package assignm01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
  ArrayList<Marks> results = new ArrayList<>();
  
  @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  for(Marks m:results) {
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<table>");
			out.println("<thead>");
			out.println("<tbody>");
			
			out.println("<tr>");
			out.printf("<td>%s<td>\r\n",m.getSubjects());
			out.printf("<td>%.2f<td>",m.getMarks());
			out.println("</tr>");
			out.println("</tbody>");
			out.println("</thead>");
			out.println("</table>");
			
		}
			}

// private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
//	
//
//	
//}
 @Override
	public void init(ServletConfig config) throws ServletException {
		super.init();
		results=new ArrayList<>();
		results.add(new Marks("Java programming",89.0));
		results.add(new Marks("Web programming",76.0));
		results.add(new Marks("Database technology",87.5));
		results.add(new Marks("Data structure",86.9));
	}
}
