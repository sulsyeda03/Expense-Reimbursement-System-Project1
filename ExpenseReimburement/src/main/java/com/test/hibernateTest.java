package com.test;

import com.entities.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


//testing set up to ensure link
//public class hibernateTest {
//	
//	public static void main( String[] args )
//    {
//        System.out.println( "My Project has started.... This is cool" );
//        
//        //this is the formation of a configuration object  
//        //take note when importing there are 3 different options to import
//        //select the one with hibernate in the path string
//        Configuration cfg = new Configuration();
//        
//        //reading the configuration and loading it into the object
//        cfg.configure("hibernate.cfg.xml");
//        
//        //this is the creation of the factory that makes everything
//        SessionFactory factory = cfg.buildSessionFactory();
//        //this opens the session (look at the name of the method)
//        Session session = factory.openSession();
//        //the transaction now begins
//        Transaction t = session.beginTransaction();
//        
//
//        String tableName = "from Employee";
//        Query query = session.createQuery(tableName);
//        List<Employee> list = query.list();
//        
//        
//        
//        //commit the transaction
//        t.commit();
//        //close the session
//        session.close();
//        
//        System.out.println(list);
//    
//    }
//}
