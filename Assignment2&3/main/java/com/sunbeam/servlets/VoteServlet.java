/**
 * Course: Advanced Computing (DAC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Dec 3, 2024
 */

package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get selected candidate id from previous page
		String candId = req.getParameter("candidate"); // "candidate" is name of radio button in prev page
		int id = Integer.parseInt(candId);
		// increment votes of that candidate in database
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Result</title>");
		out.println("</head>");
		ServletContext app1=this.getServletContext();
		String color =app1.getInitParameter("color");
		out.printf("<body bgcolor='%s'>",color);
		
		ServletContext app=this.getServletContext();
		String appTitle =app.getInitParameter("app.title");
		out.printf("<h1>%s</h1>",appTitle);
		// get user name and role from cookie and display it
		Cookie[] arr = req.getCookies();
		String userName = "", role = "";
		if(arr != null) {
			for (Cookie c : arr) {
				if(c.getName().equals("uname"))
					userName = c.getValue();
				if(c.getName().equals("role"))
					role = c.getValue();
			}
		}
		out.printf("Hello, %s (%s)<hr/>\n", userName, role);

		out.println("<h2>Voting Status</h2>");

		HttpSession session=req.getSession(false);
		if(session == null) {
			resp.sendError(440);
			return;
		}
		User user=(User) session.getAttribute("curUser");
		if(user.getStatus()==0) {
			try(CandidateDao candDao=new CandidateDaoImpl()){
			int count =candDao.incrVote(id);
			if(count==1) {
			out.println("<h4>You have successfully casted your vote.</h4>");
			user.setStatus(1);
			try(UserDao userDao = new UserDaoImpl()){
				count=userDao.update(user);
				if(count==1)
					out.println("<h4>You are marked as voted</h4>");
			}
			}else
				out.println("<h4>Your voting failed  ");

		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		out.println("<p><a href='logout'>Sign Out</a></p>");
		out.println("</body>");
		out.println("</html>");
	}
	}
}
