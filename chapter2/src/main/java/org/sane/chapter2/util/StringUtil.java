/*******************************************************************************
 *    项目名称： chapter2
 *    文件名    ： StringUtil
 *    (C) Copyright 联想(北京)有限公司 Corporation 2017 All Rights Reserved.
 * *****************************************************************************
 *    注意： 本内容仅限于联想(北京)有限公司内部使用，禁止转发
 ******************************************************************************/
package org.sane.chapter2.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @Title: StringUtil
 * @Package org.sane.chapter2.util
 * @Description: 
 * @Author muys2@lenovo.com
 * @Date 2017年2月15日 下午11:25:19
 * @Version V1.0  
 */
public final class StringUtil {

    public static boolean isEmpty(String str){
	if (str!=null) {
	    str=str.trim();
	}
	return StringUtils.isEmpty(str);
    }
    
    public static boolean isNotEmpty(String str){
	return !isEmpty(str);
    }
}
