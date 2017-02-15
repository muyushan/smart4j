/*******************************************************************************
 *    项目名称： chapter2
 *    文件名    ： EncodingFilter
 *    (C) Copyright 联想(北京)有限公司 Corporation 2017 All Rights Reserved.
 * *****************************************************************************
 *    注意： 本内容仅限于联想(北京)有限公司内部使用，禁止转发
 ******************************************************************************/
package org.sane.chapter2;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @Title: EncodingFilter
 * @Package org.sane.chapter2
 * @Description: 
 * @Author muys2@lenovo.com
 * @Date 2017年2月6日 下午2:57:09
 * @Version V1.0  
 */
public class EncodingFilter implements Filter{

    /* (non-Javadoc)
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    FilterConfig filterConfig;
    private String encoding;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
	// TODO Auto-generated method stub
	this.filterConfig=filterConfig;
	encoding=filterConfig.getInitParameter("ENCODING");
    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	    throws IOException, ServletException {
	HttpServletRequest req=(HttpServletRequest)request;
	if (req.getMethod().equals("GET")) {
	    req=new EncodingWrapper(req, encoding);
	    
	}else {
	    req.setCharacterEncoding(encoding);
	}
	chain.doFilter(req, response);
    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
	// TODO Auto-generated method stub
	
    }

}
