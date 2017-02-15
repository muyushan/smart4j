/*******************************************************************************
 *    项目名称： chapter2
 *    文件名    ： EncodingWrapper
 *    (C) Copyright 联想(北京)有限公司 Corporation 2017 All Rights Reserved.
 * *****************************************************************************
 *    注意： 本内容仅限于联想(北京)有限公司内部使用，禁止转发
 ******************************************************************************/
package org.sane.chapter2;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.validation.annotation.Validated;

/**
 * @Title: EncodingWrapper
 * @Package org.sane.chapter2
 * @Description:
 * @Author muys2@lenovo.com
 * @Date 2017年2月6日 下午2:47:42
 * @Version V1.0
 */
public class EncodingWrapper extends HttpServletRequestWrapper {

    private String ENCODING;

    /**
     * @param request
     */
    public EncodingWrapper(HttpServletRequest request, String encoding) {
	super(request);
	if (ENCODING==null||ENCODING.isEmpty()) {
	    ENCODING="UTF-8";
	}else {
	    this.ENCODING = encoding;
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.ServletRequestWrapper#getParameter(java.lang.String)
     */
    @Override
    public String getParameter(String name) {
	String value = getRequest().getParameter(name);
	if (value != null) {
	    try {
		byte[] b = value.getBytes("ISO-8859-1");
		value = new String(b, ENCODING);
	    } catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	return value;
    }

}
