package com.sunbeam.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

@WebServlet("/Cregister")
public class AddCandidateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String party=req.getParameter("party");
		
		try(CandidateDao candDao=new CandidateDaoImpl()){
			
			Candidate c=new Candidate(0,name,party,0);
			int count=candDao.save(c);
			
			if(count==1) {
				PrintWriter out =resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Registration</title>");
				out.println("</head>");
				ServletContext app1=this.getServletContext();
				String color =app1.getInitParameter("color");
				out.printf("<body bgcolor='%s'>",color);
				
				out.println("<h1>Candidate Registration successful...</h1>");
				out.println("<a href='result'>Login page</a>");
				out.println("</body>");
				out.println("</html>");
			}
			else {
				PrintWriter out =resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Registration</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1>Candidate Registration Failed...</h1>");
				out.println("<a href='result'>Login page</a>");
				out.println("</body>");
				out.println("</html>");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}