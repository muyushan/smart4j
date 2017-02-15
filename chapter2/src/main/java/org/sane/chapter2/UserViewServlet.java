/*******************************************************************************
 *    ��Ŀ��ƣ� chapter2
 *    �ļ���    �� RegisterServlet
 *    (C) Copyright ����(����)���޹�˾ Corporation 2017 All Rights Reserved.
 * *****************************************************************************
 *    ע�⣺ �����ݽ���������(����)���޹�˾�ڲ�ʹ�ã���ֹת��
 ******************************************************************************/
package org.sane.chapter2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebParam;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.apache.bcel.classfile.Field;

/**
 * 
 * @Title: LoginServlet
 * @Package org.sane.chapter2
 * @Description:
 * @Author muys2@lenovo.com
 * @Date 2017年1月24日 下午1:44:35
 * @Version V1.0
 */
@WebServlet(urlPatterns = "/user.view",initParams={@WebInitParam(name="param1",value="value1")})
public class UserViewServlet extends HttpServlet {

    private static final String SUCCESS_VIEW = "member.view";
    private static final String ERROR_VIEW = "error.view";
    private static final String USERS = "D:/Users";

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
	// TODO Auto-generated method stub
	super.init(config);
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
     * HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession();
	if (session.getAttribute("login") == null) {
	    resp.sendRedirect("login.jsp");
	    return;
	}
	String userName = (String) session.getAttribute("login");
	resp.setCharacterEncoding("utf-8");
	PrintWriter writer = resp.getWriter();
	writer.println("<html>");
	writer.println("<head>");
	writer.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />");
	writer.println("<title>会员：" + userName + "</title>");
	writer.println("</head>");
	writer.println("<body>");
	writer.println("<h1>会员：" + userName + "你好</h1>");
	writer.print("</body>");
	writer.print("</html>");

    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.
     * HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	doPost(req, resp);
    }
}
