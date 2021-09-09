package com.factory;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionFactory {
    private static SessionFactory factory = null;
    private static Session session;
    
    public ConnectionFactory(){
    } 
       
    public static SessionFactory getSessionFactory() throws SQLException {
    	if(factory == null ) {
    		Configuration cfg = new Configuration();
    		cfg.configure("hibernate.cfg.xml");
    		factory = cfg.buildSessionFactory();
    		
    	}
        return factory;
    }
    
    public static Session getSession() {
    	if(session == null) {
		session = factory.openSession();
    	}
    	return session;
	}
    
    public static void close() {
    	//factory.close();
    	session.close();
    	session = null;
    }
}