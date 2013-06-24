package com.balance.hib.home;
// Generated 6 Jun, 2012 10:43:53 AM by Hibernate Tools 3.4.0.CR1


import com.balance.hib.bean.UserDetails;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Transaction;

import com.balance.hib.util.HibernateSessionFactory;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class UserDetails.
 * @see com.balance.hib.beans.UserDetails
 * @author Hibernate Tools
 */
public class UserDetailsHome {

    private static final Log log = LogFactory.getLog(UserDetailsHome.class);

   
    
    public int persist(UserDetails transientInstance) {
        log.debug("persisting UserDetails instance");
        Integer id;
        try {
        	 Transaction tx= HibernateSessionFactory.getSession().beginTransaction();
        id= (Integer)HibernateSessionFactory.getSession().save(transientInstance);
             tx.commit();
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
                   throw re;
        }
        return  id.intValue();
    }
    
    public void attachDirty(UserDetails instance) {
        log.debug("attaching dirty UserDetails instance");
        try {
        	 Transaction tx= HibernateSessionFactory.getSession().beginTransaction();
             HibernateSessionFactory.getSession().saveOrUpdate(instance);
             tx.commit();
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserDetails instance) {
        log.debug("attaching clean UserDetails instance");
        try {
        	Transaction tx= HibernateSessionFactory.getSession().beginTransaction();
              
            HibernateSessionFactory.getSession().lock(instance, LockMode.NONE);
            tx.commit();
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(UserDetails persistentInstance) {
        log.debug("deleting UserDetails instance");
        try {
        	Transaction tx= HibernateSessionFactory.getSession().beginTransaction();
             HibernateSessionFactory.getSession().delete(persistentInstance);
             tx.commit();
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserDetails merge(UserDetails detachedInstance) {
        log.debug("merging UserDetails instance");
        try {
        	Transaction tx= HibernateSessionFactory.getSession().beginTransaction();
            UserDetails result = (UserDetails)  HibernateSessionFactory.getSession()
                    .merge(detachedInstance);
            tx.commit();
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            re.printStackTrace();
            throw re;
        }
    }
    
    public UserDetails findById( java.lang.Integer id) {
        log.debug("getting UserDetails instance with id: " + id);
        try {
            UserDetails instance = (UserDetails)  HibernateSessionFactory.getSession()
                    .get("com.balance.hib.bean.UserDetails", id);
            if (instance==null) {
                 log.debug("get successful, no instance found");
            }
            else {
                log.debug("get successful, instance found");
            }
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
     public List findByRelId( java.lang.Integer id) {
        log.debug("getting UserDetails instance with id: " + id);
        try {
            String queryString = "from UserDetails as model where model.userRelevantId= ? ";
		org.hibernate.Query queryObject =HibernateSessionFactory.getSession().createQuery(queryString);
			queryObject.setParameter(0, id);
			return queryObject.list();
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    public List<UserDetails> findByExample(UserDetails instance) {
        log.debug("finding UserDetails instance by example");
        try {
            List<UserDetails> results = HibernateSessionFactory.getSession()
                    .createCriteria(UserDetails.class)
                    .add( create(instance) )
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
    public List findByProperty(String propertyName, Object value) {
		      System.out.println("finding Userdetails instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UserDetails as model where model."
					+ propertyName + "= ?";
                        System.out.println("qry"+queryString);
		org.hibernate.Query queryObject =HibernateSessionFactory.getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
                        System.out.println("queryObject.list()"+queryObject.list());
			return queryObject.list();
		} catch (RuntimeException re) {
                    System.out.println("find by property name failed"+re);
			throw re;
		}
	}

    public List findForLogin(String propertyName, Object value) {
		      System.out.println("finding Userdetails instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UserDetails as model where model.userRelevantId=0 and model."
					+ propertyName + "= ?";
                        System.out.println("qry"+queryString);
		org.hibernate.Query queryObject =HibernateSessionFactory.getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
                        System.out.println("queryObject.list()"+queryObject.list());
			return queryObject.list();
		} catch (RuntimeException re) {
                    System.out.println("find by property name failed"+re);
			throw re;
		}
	}

    public int isValidProfileName(String currentProfileName) {

        System.out.println("in isValidProfileName"+currentProfileName);
        List <UserDetails>ls =findByProperty("userProfileName",currentProfileName);
        System.out.println("queryObject.list().size in isValidProfileNAMe"+ls.size());
       if(ls.isEmpty())
         return 0;
       else
        return 1;
    }
}

