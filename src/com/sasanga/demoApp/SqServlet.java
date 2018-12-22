package com.sasanga.demoApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




public class SqServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
//		int k = (int) req.getAttribute("k");
//		int k = Integer.parseInt(req.getParameter("k"));
		HttpSession session = req.getSession();
		int k = (int) session.getAttribute("k");
		
		
		// get cookie value
//		String k = "";
//		Cookie[] cookies = req.getCookies();
//		for(Cookie c : cookies)
//		{
//			if(c.getName().equals("k"))
//				k = c.getValue();
//		}
//		
//		String test = cookies[0].getValue();
		
		PrintWriter out = res.getWriter();
		out.println("Hello from SQ servlet <br/>");
		out.println("k = " + k);
		out.println("<br/>");
		session.removeAttribute("k");

		// servlet context 
		ServletContext ctx = getServletContext();
		String name = ctx.getInitParameter("myName");
		out.println("<h3>" + name + "</h3>");
		
		// servlet config
		ServletConfig cnf = getServletConfig();
		out.println(cnf.getInitParameter("myPhone"));
		out.println("<br />");
		
	}

}
