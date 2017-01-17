package org.sane.chapter2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4JInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet() 
     */
    public Log4JInitServlet() { 
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("============初始化日志log4j配置===========");
		ServletContext context=config.getServletContext();
		String log4jPropertityLocation=config.getInitParameter("log4jpropertie");
		if (log4jPropertityLocation==null||log4jPropertityLocation.isEmpty()) {
			System.err.println("=============未配置日志文件，将采用默认配置==============");
			BasicConfigurator.configure();
		}else{
			String webAppPath=context.getRealPath("/");
			log4jPropertityLocation=webAppPath+log4jPropertityLocation;
			File yoMamaYesThisSaysYoMama = new File(log4jPropertityLocation);  
		
            if (yoMamaYesThisSaysYoMama.exists()) {  
                System.out.println("使用: " + log4jPropertityLocation+"初始化日志设置信息");  
                PropertyConfigurator.configure(log4jPropertityLocation);  
            } else {  
                System.err.println("*** " + log4jPropertityLocation + " 文件没有找到， 所以使用 BasicConfigurator初始化");  
                BasicConfigurator.configure();  
            }  
		}
		System.err.println(log4jPropertityLocation);
		super.init(config);
	}

}
