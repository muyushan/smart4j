/*******************************************************************************
 *    项目名称： chapter2
 *    文件名    ： EscapeWrapper
 *    (C) Copyright 联想(北京)有限公司 Corporation 2017 All Rights Reserved.
 * *****************************************************************************
 *    注意： 本内容仅限于联想(北京)有限公司内部使用，禁止转发
 ******************************************************************************/
package org.sane.chapter2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @Title: EscapeWrapper
 * @Package org.sane.chapter2
 * @Description: 
 * @Author muys2@lenovo.com
 * @Date 2017年2月6日 下午2:29:20
 * @Version V1.0  
 */
public class EscapeWrapper extends HttpServletRequestWrapper{

    /**
     * @param request
     */
    public EscapeWrapper(HttpServletRequest request) {
	super(request);
	// TODO Auto-generated constructor stub
    }
    
    /* (non-Javadoc)
     * @see javax.servlet.ServletRequestWrapper#getParameter(java.lang.String)
     */
    @Override
    public String getParameter(String name) {
        // TODO Auto-generated method stub
	String value=getRequest().getParameter(name);
	value=value+"after";
	return value;
    }

}
