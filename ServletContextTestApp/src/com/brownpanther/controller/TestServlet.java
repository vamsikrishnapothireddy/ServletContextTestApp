package com.brownpanther.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServelt
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("In TestServelt static block");

	}

	public TestServlet() {
		System.out.println("In TestServelt Constructor");

	}

	@Override
	public void init() {
		System.out.println("In TestServelt life cycle method init");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("In doGet Method of TestServlet");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html><head><title>ContextObjectDetails..</title></head>");

		out.println("<body align='center'>");
		out.println("<table border='1'");

		// Getting Servlet context
		ServletContext servletContext = getServletContext();
		servletContext.setAttribute("authtype", "clientCreds");

		Enumeration<String> initParameterNames = servletContext.getInitParameterNames();

		out.println("<tr><th>Init Pram Name</th><th>Init Pram Value</th></tr>");

		while (initParameterNames.hasMoreElements()) {
			String inintParamName = initParameterNames.nextElement();
			String initParameter = servletContext.getInitParameter(inintParamName);
			out.println("<tr><td>" + inintParamName + "</td><td>" + initParameter + "</td></tr>");

		}
		out.println("<tr><th>Attribute  Name</th><th>Attribute  Value</th></tr>");

		Enumeration<String> attributeNames = servletContext.getAttributeNames();

		while (attributeNames.hasMoreElements()) {
			String attributeName = (String)	attributeNames.nextElement();
			Object attributeValue = servletContext.getAttribute(attributeName);
			out.println("<tr><td>" + attributeName + "</td><td>" + attributeValue + "</td></tr>");

		}

		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	@Override
	public void destroy() {
		System.out.println("In TestServelt life cycle method destroy");

	}

}
