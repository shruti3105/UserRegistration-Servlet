package com.bridgelabz.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(
		description = "Login Servlet Testing",
		urlPatterns = {"/LoginServlet"},
		initParams = {
				@WebInitParam(name = "user", value = "Shruti"),
				@WebInitParam(name = "password", value = "Shruti@3105")
		})
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		String validFirstName = "^[A-Z]{1}[a-z]{2,}";
		Pattern pattern = Pattern.compile(validFirstName);
		Matcher match = pattern.matcher(user);
		if(match.matches()) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
		}else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Incorrect Name , Please Enter The Correct Name</font>");
			rd.include(request, response);
		}
	}
}