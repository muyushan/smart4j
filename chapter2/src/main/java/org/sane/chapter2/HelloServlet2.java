package org.sane.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class HelloServlet
 */
@MultipartConfig
@WebServlet(urlPatterns="/hello2",asyncSupported=true)
public class HelloServlet2 extends HttpServlet {
  Logger logger=  Logger.getLogger(Log4JInitServlet.class);
	private static final long serialVersionUID = 1L; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		   request.setCharacterEncoding("UTF-8");  
		    response.setCharacterEncoding("GBK");  
		PrintWriter writer=response.getWriter();
		AsyncContext context=request.startAsync();
		
		writer.write("BBBBBBBBBBBBBBBBBBBBBBBBBBB"); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
