/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balance.hib.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Aniruddha 
 */
public class HibernateSessionFactory  {
    
    
    private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
    private static  final ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
    private  static Configuration configuration = new Configuration();
    private static org.hibernate.SessionFactory sessionFactory;
    private static String configFile = CONFIG_FILE_LOCATION;
    
    // static block to initailize read  sessionFactory
    static 
     {
           	try {  System.out.println("\n*********inside static block *********\n");
			configuration.configure(configFile);
			sessionFactory = configuration.buildSessionFactory();
	             } catch (Exception e) 
                     {
			System.out.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		     }
        }//end static block 
    
     public static Session getSession() throws HibernateException {
        Session session = threadLocal.get();

		if (session == null || !session.isOpen()) {
			if (sessionFactory == null) {
				rebuildSessionFactory();
			}
			session = (sessionFactory != null) ? sessionFactory.openSession()
					: null;
			threadLocal.set(session);
		}

        return session;
    }

	/**
     *  Rebuild hibernate session factory
     *
     */
	public static void rebuildSessionFactory() {
		try {
			configuration.configure(configFile);
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			System.err.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		}
	}

	/**
     *  Close the single hibernate session instance.
     *
     *  @throws HibernateException
     */
    public static void closeSession() throws HibernateException {
        Session session = threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }

	/**
     *  return session factory
     *
     */
	public static org.hibernate.SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
     *  return session factory
     *
     *	session factory will be rebuilded in the next call
     */
	public static void setConfigFile(String configFile) {
		HibernateSessionFactory.configFile = configFile;
		sessionFactory = null;
	}

	/**
     *  return hibernate configuration
     *
     */
	public static Configuration getConfiguration() {
		return configuration;
	}
    
    public static  void main(String ar[]){
    
    getSession();
    
    }
}
