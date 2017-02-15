/*******************************************************************************
 *    项目名称： chapter2
 *    文件名    ： Listener1
 *    (C) Copyright 联想(北京)有限公司 Corporation 2017 All Rights Reserved.
 * *****************************************************************************
 *    注意： 本内容仅限于联想(北京)有限公司内部使用，禁止转发
 ******************************************************************************/
package org.sane.chapter2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Title: Listener1
 * @Package org.sane.chapter2
 * @Description: 
 * @Author muys2@lenovo.com
 * @Date 2017年2月4日 下午2:54:25
 * @Version V1.0  
 */
public class Listener1 implements ServletContextListener{

    /* (non-Javadoc)
     * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
	sce.getServletContext();
	// TODO Auto-generated method stub
	
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
	// TODO Auto-generated method stub
	
    }

}
