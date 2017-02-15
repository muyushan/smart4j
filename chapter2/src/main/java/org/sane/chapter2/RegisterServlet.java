/*******************************************************************************
 *    ��Ŀ��ƣ� chapter2
 *    �ļ���    �� RegisterServlet
 *    (C) Copyright ����(����)���޹�˾ Corporation 2017 All Rights Reserved.
 * *****************************************************************************
 *    ע�⣺ �����ݽ���������(����)���޹�˾�ڲ�ʹ�ã���ֹת��
 ******************************************************************************/
package org.sane.chapter2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.apache.bcel.classfile.Field;

/**
 * 
 * @Title: RegisterServlet
 * @Package org.sane.chapter2
 * @Description: 
 * @Author muys2@lenovo.com
 * @Date 2017年1月23日 下午3:21:39
 * @Version V1.0
 */
@WebServlet(urlPatterns="/regist.do")
public class RegisterServlet extends HttpServlet {

    private static final String SUCCESS_VIEW="success.view";
    private static final String ERROR_VIEW="error.view";
    private static final String USERS="D:/Users";
    /* (non-Javadoc)
     * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        super.init(config);
    }
    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
	String userName=req.getParameter("username");
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	String confirmpassword=req.getParameter("confirmedpassword");
	List<String>errors=new  ArrayList<>();
	if (isinValidUserName(userName)) {
	    errors.add("用户名为空,或已经存在");
	}
	if (isInvalidEmail(email)) {
	    errors.add("未填写邮件和格式不正确");
	}
	if (isInvalidPassword(password, confirmpassword)) {
	    errors.add("请确认密码符合格式并在此确认密码");
	}
    
	if (errors.isEmpty()) {
	    createUserData(email, userName, password);
	   req.getRequestDispatcher(SUCCESS_VIEW).forward(req, resp);
	}else {
	    req.setAttribute("errors", errors);
	    req.getRequestDispatcher(ERROR_VIEW).forward(req, resp);
	}
    }
    private boolean isInvalidEmail(String email){
	return (email ==null ||!email.matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")) ;
    }
    private boolean isinValidUserName(String userName){
	for(String file:new File(USERS).list()){
	    if (file.equals(userName)) {
		return true;
	    }
	    
	}
	return false;
    }
    
    public boolean isInvalidPassword(String password,String confirmedPassword){
	
	return password==null||password.length()<6||password.length()>16||!password.equals(confirmedPassword);
    }
    private void createUserData(String email,String userName,String password) throws IOException{
	File userHome = new File(USERS+"/"+userName);
	Boolean createResult=userHome.mkdirs();
	BufferedWriter writer=new BufferedWriter(new FileWriter(userHome+"/profile"));
	writer.write(email+"\t"+password);
	writer.close();
    }
    
    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
	req.getRequestDispatcher("regist.jsp").forward(req, resp);
    }
}
