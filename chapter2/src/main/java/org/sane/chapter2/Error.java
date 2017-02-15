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
import java.io.PrintWriter;
import java.io.Writer;
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
 * @Title: Error
 * @Package org.sane.chapter2
 * @Description: 
 * @Author muys2@lenovo.com
 * @Date 2017年1月23日 下午5:58:30
 * @Version V1.0
 */
@WebServlet(urlPatterns="/error.view")
public class Error extends HttpServlet {

    
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
    doGet(req, resp);
    }
  
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
	resp.setCharacterEncoding("utf-8");
	PrintWriter writer=resp.getWriter();
	
	writer.println("<html>");
	writer.println("<head>");
	writer.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />");
	writer.println("<title>新增会员失败</title>");
	writer.println("</head>");
	writer.println("<body>");
	writer.println("<h1>新增会员失败</h1>");
	writer.println("<ul>");
	List<String> errors=(List<String>)req.getAttribute("errors");
	for (String string : errors) {
	    writer.println("<li>"+string+"</li>");
	}
	writer.println("</ul>");
	writer.println("<a href='regist.do'>返回注册页面</a>");
	writer.print("</body>");
	writer.print("</html>");
	writer.close();
	
	


    }
}
