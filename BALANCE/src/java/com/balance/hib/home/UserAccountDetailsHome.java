package com.balance.hib.home;
// Generated 6 Jun, 2012 10:43:53 AM by Hibernate Tools 3.4.0.CR1


import com.balance.hib.bean.UserAccountDetails;
import com.balance.hib.bean.UserDetails;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import com.balance.hib.util.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class UserAccountDetails.
 * @see com.balance.hib.beans.UserAccountDetails
 * @author Hibernate Tools
 */
public class UserAccountDetailsHome {

    private static final Log log = LogFactory.getLog(UserAccountDetailsHome.class);

    
    
    public void persist(UserAccountDetails transientInstance) {
        System.out.println("persisting UserAccountDetails instance");
        try {
            
             Session session=HibernateSessionFactory.getSession();
             session.beginTransaction();
             session.save(transientInstance);
             session.getTransaction().commit();
            System.out.println("persist successful");
        }
        catch (RuntimeException re) {
            System.out.println("persist failed"+re);
            
            throw re;
        }
        catch(Exception e)
        {
            System.out.println("persist failed"+e);
         
        }
    }
    
    public void attachDirty(UserAccountDetails instance) {
        log.debug("attaching dirty UserAccountDetails instance");
        try {
             HibernateSessionFactory.getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserAccountDetails instance) {
        log.debug("attaching clean UserAccountDetails instance");
        try {
             HibernateSessionFactory.getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(UserAccountDetails persistentInstance) {
        log.debug("deleting UserAccountDetails instance");
        try {
             HibernateSessionFactory.getSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserAccountDetails merge(UserAccountDetails detachedInstance) {
        log.debug("merging UserAccountDetails instance");
        try {
            UserAccountDetails result = (UserAccountDetails)  HibernateSessionFactory.getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public UserAccountDetails findById( int id) {
        log.debug("getting UserAccountDetails instance with id: " + id);
        try {
            UserAccountDetails instance = (UserAccountDetails)  HibernateSessionFactory.getSession()
                    .get(UserAccountDetails.class, id);
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
    
    public List<UserAccountDetails> findByExample(UserAccountDetails instance) {
        log.debug("finding UserAccountDetails instance by example");
        try {
            List<UserAccountDetails> results = HibernateSessionFactory.getSession()
                    .createCriteria(UserAccountDetails.class)
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
    
     public List<UserAccountDetails> findAccountByUser(UserDetails instance) {
        log.debug("finding UserAccountDetails instance by example");
        try {
            
            String q= "from UserAccountDetails u where u.userDetails="+instance.getUserId().toString();
            List<UserAccountDetails> results = HibernateSessionFactory.getSession().createQuery(q).list();
            log.debug("find by /user successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
     static public List<UserAccountDetails> findReceviableAccountByUser(UserDetails instance) {
        log.debug("finding UserAccountDetails instance by example");
        try {
                      
            String q= "from UserAccountDetails u where u.bsHead=4 and  u.userDetails="+instance.getUserId().toString();
            List<UserAccountDetails> results = HibernateSessionFactory.getSession().createQuery(q).list();
            log.debug("find by /user successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
}

