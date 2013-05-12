package com.balance.hib.home;
/*
 * Copyright 2012 Aniruddha.
 * and open the template in the editor.
 */

import com.balance.hib.bean.ExpenseEntry;
import com.balance.hib.util.HibernateSessionFactory;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static org.hibernate.criterion.Example.create;
/**
 *
 * @author hcl
 */
public class ExpenseEntryHome {
     private static final Log log = LogFactory.getLog(ExpenseEntryHome.class);

   
    
    
    public void persist(ExpenseEntry transientInstance) {
        log.debug("persisting ExpenseEntry instance");
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
    
    public void attachDirty(ExpenseEntry instance) {
        log.debug("attaching dirty ExpenseEntry instance");
        try {
        	HibernateSessionFactory.getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ExpenseEntry instance) {
        log.debug("attaching clean ExpenseEntry instance");
        try {
        	HibernateSessionFactory.getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(ExpenseEntry persistentInstance) {
        log.debug("deleting ExpenseEntry instance");
        try {
             HibernateSessionFactory.getSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ExpenseEntry merge(ExpenseEntry detachedInstance) {
        log.debug("merging ExpenseEntry instance");
        try {
            ExpenseEntry result = (ExpenseEntry)  HibernateSessionFactory.getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public ExpenseEntry findById( java.lang.Integer id) {
        System.out.println("getting ExpenseEntry instance with id: " + id);
        try {
            ExpenseEntry instance = (ExpenseEntry) HibernateSessionFactory.getSession()
                    .load(ExpenseEntry.class, id);
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
    
    public List<ExpenseEntry> findByExample(ExpenseEntry instance) {
        log.debug("finding ExpenseEntry instance by example");
        try {
            List<ExpenseEntry> results = HibernateSessionFactory.getSession()
                    .createCriteria(ExpenseEntry.class)
                    .add(create(instance) )
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    } 
    
    
     public List<ExpenseEntry> findByAll() {
        log.debug("finding ExpenseEntry instance by All");
        try {
//             
            String qry=" from ExpenseEntry";
            Query qobj =HibernateSessionFactory.getSession().createQuery(qry);
            List<ExpenseEntry> results= qobj.list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    } 
}
