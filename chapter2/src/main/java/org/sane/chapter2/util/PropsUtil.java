/*******************************************************************************
 *    项目名称： chapter2
 *    文件名    ： PropsUtil
 *    (C) Copyright 联想(北京)有限公司 Corporation 2017 All Rights Reserved.
 * *****************************************************************************
 *    注意： 本内容仅限于联想(北京)有限公司内部使用，禁止转发
 ******************************************************************************/
package org.sane.chapter2.util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.Log4jLoggerFactory;

/**
 * @Title: PropsUtil
 * @Package org.sane.chapter2.util
 * @Description:
 * @Author muys2@lenovo.com
 * @Date 2017年2月15日 下午10:09:40
 * @Version V1.0
 */
public class PropsUtil {
    private static final Logger logger = LoggerFactory.getLogger(PropsUtil.class);

    public static Properties loadProps(String fileName) {
	Properties properties = null;
	InputStream iStream = null;
	try {
	    iStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);

	    if (iStream == null) {
		throw new FileNotFoundException(fileName + "files is not found");
	    }
	    logger.info("读取properties 文件："+fileName);
	    properties = new Properties();
	    properties.load(iStream);
	} catch (Exception e) {
	    logger.error("load properties file failure", e);
	} finally {
	    if (iStream != null) {
		try {
		    iStream.close();
		} catch (Exception e2) {
		    logger.error("close input stream failure", e2);
		}
	    }
	}
	return properties;

    }
    
    public static String getString(Properties properties,String key){
	return properties.getProperty(key, "");
    }
    
    public static int getInt(Properties properties,String key){
 	return getInt(properties, key,0);
     }
    
    public static boolean getBoolean(Properties properties,String key){
	return getBoolean(properties, key, false);
    }
    
    public static boolean getBoolean(Properties properties,String key,Boolean defaultValue){
	boolean value=defaultValue;
	if (properties.containsKey(key)) {
	    value=CastUtil.castBoolean(properties.getProperty(key));
	}
	return value;
    }
    public static int getInt(Properties properties,String key,int defaultValue){
	int value=defaultValue;
	if (properties.contains(key)) {
	    value=CastUtil.castInt(properties.getProperty(key));
	}
	return value;
    }
    
    public static String getString(Properties properties,String key,String defaultValue){
	String value=defaultValue;
	if (properties.contains(key)) {
	    value=properties.getProperty(key);
	}
	return value;
    }

}
