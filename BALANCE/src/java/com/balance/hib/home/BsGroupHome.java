package com.balance.hib.home;
// Generated 6 Jun, 2012 10:43:53 AM by Hibernate Tools 3.4.0.CR1


import com.balance.hib.bean.BsGroup;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.balance.hib.util.HibernateSessionFactory;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class BsGroup.
 * @see com.balance.hib.beans.BsGroup
 * @author Hibernate Tools
 */
public class BsGroupHome {

    private static final Log log = LogFactory.getLog(BsGroupHome.class);

   
    
    
    public void persist(BsGroup transientInstance) {
        log.debug("persisting BsGroup instance");
        try {
        	Session session=HibernateSessionFactory.getSession();
        	Transaction tx=session.beginTransaction();
           session.save(transientInstance);
            tx.commit();
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(BsGroup instance) {
        log.debug("attaching dirty BsGroup instance");
        try {
        	HibernateSessionFactory.getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(BsGroup instance) {
        log.debug("attaching clean BsGroup instance");
        try {
        	HibernateSessionFactory.getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(BsGroup persistentInstance) {
        log.debug("deleting BsGroup instance");
        try {
             HibernateSessionFactory.getSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public BsGroup merge(BsGroup detachedInstance) {
        log.debug("merging BsGroup instance");
        try {
            BsGroup result = (BsGroup)  HibernateSessionFactory.getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public BsGroup findById( java.lang.Integer id) {
        System.out.println("getting BsGroup instance with id: " + id);
        try {
            BsGroup instance = (BsGroup) HibernateSessionFactory.getSession()
                    .load(BsGroup.class, id);
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
    
    public List<BsGroup> findByExample(BsGroup instance) {
        log.debug("finding BsGroup instance by example");
        try {
            List<BsGroup> results = HibernateSessionFactory.getSession()
                    .createCriteria("com.balance.hib.beans.BsGroup")
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
    
    
     public List<BsGroup> findByAll() {
        log.debug("finding BsGroup instance by All");
        try {
//             
            String qry=" from BsGroup";
            Query qobj =HibernateSessionFactory.getSession().createQuery(qry);
            List<BsGroup> results= qobj.list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    } 
}

