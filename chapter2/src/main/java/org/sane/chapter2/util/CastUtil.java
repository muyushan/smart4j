/*******************************************************************************
 *    项目名称： chapter2
 *    文件名    ： CastUtil
 *    (C) Copyright 联想(北京)有限公司 Corporation 2017 All Rights Reserved.
 * *****************************************************************************
 *    注意： 本内容仅限于联想(北京)有限公司内部使用，禁止转发
 ******************************************************************************/
package org.sane.chapter2.util;

/**
 * @Title: CastUtil
 * @Package org.sane.chapter2.util
 * @Description: 
 * @Author muys2@lenovo.com
 * @Date 2017年2月15日 下午10:42:46
 * @Version V1.0  
 */
public final class CastUtil {

    public static String castString(Object obj){
	return CastUtil.castString(obj, "");
    }
    
    public static String castString(Object object,String defaultValue){
	return object!=null?String.valueOf(object):defaultValue;
    }
    
    public static double castDouble(Object obj){
	return CastUtil.castDouble(obj,0);
    }
    
    public static double castDouble(Object obj,double defaultValue){
	double doubleValue=defaultValue;
	if (obj!=null) {
	    String strValue=castString(obj);
	    if (StringUtil.isNotEmpty(strValue)) {
		try {
		    doubleValue=Double.parseDouble(strValue);
		} catch (NumberFormatException e) {
		    // TODO: handle exception
		    doubleValue=defaultValue;
		}
	    }
	}
	return doubleValue;
	
    }
    
    public static long castLong(Object obj){
	return castLong(obj, 0);
	
    }
    
    public static long castLong(Object obj,long defaultValue){
	long longValue=defaultValue;
	if (obj!=null) {
	    String strValue=castString(obj);
	    if (StringUtil.isNotEmpty(strValue)) {
		try {
		    longValue=Long.parseLong(strValue);
		} catch (Exception e) {
		    // TODO: handle exception
		    longValue=defaultValue;
		}
	    }
	}
	return longValue;
    }
    
    public static int castInt(Object obj){
	return castInt(obj,0);
    }
    public static int castInt(Object obj,int defaultValue){
	int intValue=defaultValue;
	if (obj!=null) {
	    String strValue=castString(obj);
	    if (StringUtil.isNotEmpty(strValue)) {
		try {
		    intValue=Integer.parseInt(strValue);
		} catch (Exception e) {
		    // TODO: handle exception
		    intValue=defaultValue;
		}
	    }
	}
	return defaultValue;
    }
    
    public static boolean castBoolean(Object obj){
	return castBoolean(obj);
    }
    
    public static boolean castBoolean(Object obj,boolean defaultValue){
	boolean booleanValue=defaultValue;
	if (obj!=null) {
	    booleanValue=Boolean.parseBoolean(castString(obj));
	}
	return booleanValue;
    }
}
