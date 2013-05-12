package com.balance.hib.home;
// Generated 6 Jun, 2012 10:43:53 AM by Hibernate Tools 3.4.0.CR1



import com.balance.hib.bean.IncomeEntry;
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
 * Home object for domain model class IncomeEntry.
 * @see com.balance.hib.beans.IncomeEntry
 * @author Hibernate Tools
 */
public class IncomeEntryHome {

    private static final Log log = LogFactory.getLog(IncomeEntryHome.class);

   
    
    
    public void persist(IncomeEntry transientInstance) {
        log.debug("persisting IncomeEntry instance");
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
    
    public void attachDirty(IncomeEntry instance) {
        log.debug("attaching dirty IncomeEntry instance");
        try {
        	HibernateSessionFactory.getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(IncomeEntry instance) {
        log.debug("attaching clean IncomeEntry instance");
        try {
        	HibernateSessionFactory.getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(IncomeEntry persistentInstance) {
        log.debug("deleting IncomeEntry instance");
        try {
             HibernateSessionFactory.getSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public IncomeEntry merge(IncomeEntry detachedInstance) {
        log.debug("merging IncomeEntry instance");
        try {
            IncomeEntry result = (IncomeEntry)  HibernateSessionFactory.getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public IncomeEntry findById( java.lang.Integer id) {
        System.out.println("getting IncomeEntry instance with id: " + id);
        try {
            IncomeEntry instance = (IncomeEntry) HibernateSessionFactory.getSession()
                    .load(IncomeEntry.class, id);
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
    
    public List<IncomeEntry> findByExample(IncomeEntry instance) {
        log.debug("finding IncomeEntry instance by example");
        try {
            List<IncomeEntry> results = HibernateSessionFactory.getSession()
                    .createCriteria(IncomeEntry.class)
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
    
    
     public List<IncomeEntry> findByAll() {
        log.debug("finding IncomeEntry instance by All");
        try {
//             
            String qry=" from IncomeEntry";
            Query qobj =HibernateSessionFactory.getSession().createQuery(qry);
            List<IncomeEntry> results= qobj.list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    } 
     
     
     public List findByProperty(String propertyName, Object value) {
		log.debug("finding Incomeentry instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Incomeentry as model where model."
					+ propertyName + "= ?";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

}

