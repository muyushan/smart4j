package org.sane.chapter2.service;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.sane.chapter2.model.Customer;
import org.sane.chapter2.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerService {

    private static Logger logger=LoggerFactory.getLogger(CustomerService.class);
    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;
    static{
	Properties conf=PropsUtil.loadProps("config.properties");
	DRIVER=PropsUtil.getString(conf, "jdbc.driver");
	URL=PropsUtil.getString(conf, "jdbc.url");
	USERNAME=PropsUtil.getString(conf, "jdbc.username");
	PASSWORD=PropsUtil.getString(conf, "jdbc.password");
	try {
	    Class.forName(DRIVER);
	} catch (ClassNotFoundException e) {
	    logger.error("can not load jdbc driver", e);
	}
    }
	public List<Customer> getCustomerList(String keyword){
		return null;
	}
	
	public Customer getCustomer(int id){
		return null;
	}
	
	public boolean createCustomer(Map<String, Object> fieldMap){
		return false;
	}
	
	public boolean updateCustomer(int id,Map<String, Object> fieldMap){
		return false;
	}
	
	public boolean deleteCustomer(int id){
		return false;
	}
}
