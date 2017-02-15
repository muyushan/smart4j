/*******************************************************************************
 *    项目名称： chapter2
 *    文件名    ： CollectionUtil
 *    (C) Copyright 联想(北京)有限公司 Corporation 2017 All Rights Reserved.
 * *****************************************************************************
 *    注意： 本内容仅限于联想(北京)有限公司内部使用，禁止转发
 ******************************************************************************/
package org.sane.chapter2.util;

import java.util.Collection;
import java.util.Map;

import org.springframework.util.CollectionUtils;

/**
 * @Title: CollectionUtil
 * @Package org.sane.chapter2.util
 * @Description: 
 * @Author muys2@lenovo.com
 * @Date 2017年2月15日 下午11:51:18
 * @Version V1.0  
 */
public final class CollectionUtil {

    public static boolean isEmpty(Collection<?> collection){
	return CollectionUtils.isEmpty(collection);
    }
    public static boolean isNotEmpty(Collection<?> collection){
	return !isEmpty(collection);
    }
    
    public static boolean isEmpty(Map<?, ?> map){
	return CollectionUtils.isEmpty(map);
    }
    public static boolean isNotEmpty(Map<?, ?> map){
   	return !CollectionUtils.isEmpty(map);
       }
}
