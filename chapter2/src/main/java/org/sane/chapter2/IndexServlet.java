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

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
@WebServlet(urlPatterns = "/index.do")
public class IndexServlet extends HttpServlet {

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

	processRequst(req, resp);
    }

//    private boolean checkLoginIn(String userName, String password) throws IOException {
//	for (String file : new File(USERS).list()) {
//	    if (file.equals(userName)) {
//		BufferedReader reader = new BufferedReader(new FileReader(USERS + "/" + file + "/profile"));
//		String pass = reader.readLine().split("\t")[1];
//		if (password.equals(pass)) {
//		    return true;
//		}
//	    }
//	}
//	return false;
//    }


    
    private void processRequst(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
	Cookie[]cookies=request.getCookies();
	if (cookies!=null) {
	    for(Cookie cookie:cookies){
		String name=cookie.getName();
		String value=cookie.getValue();
		if ("user".equals(name)&& "sanemu".equals(value)) {
		    request.setAttribute("username", value);
		    request.getRequestDispatcher("user.view").forward(request, response);
		    return;
		}
	    }
	}
	
	response.sendRedirect("login.jsp");
    }
    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.
     * HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	processRequst(req, resp);
    }
}
