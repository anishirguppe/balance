package com.balance.hib.home;
// Generated 6 Jun, 2012 10:43:53 AM by Hibernate Tools 3.4.0.CR1



import com.balance.hib.bean.Transfer;
import com.balance.hib.bean.UserAccountDetails;
import com.balance.hib.bean.UserDetails;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.balance.hib.util.HibernateSessionFactory;
import java.util.Iterator;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Transfer.
 * @see com.balance.hib.beans.Transfer
 * @author Hibernate Tools
 */
public class TransferHome {

    private static final Log log = LogFactory.getLog(TransferHome.class);

   
    
    
    public void persist(Transfer transientInstance) {
        log.debug("persisting Transfer instance");
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
    
    public void attachDirty(Transfer instance) {
        log.debug("attaching dirty Transfer instance");
        try {
        	HibernateSessionFactory.getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Transfer instance) {
        log.debug("attaching clean Transfer instance");
        try {
        	HibernateSessionFactory.getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(Transfer persistentInstance) {
        log.debug("deleting Transfer instance");
        try {
             HibernateSessionFactory.getSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Transfer merge(Transfer detachedInstance) {
        log.debug("merging Transfer instance");
        try {
            Transfer result = (Transfer)  HibernateSessionFactory.getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Transfer findById( java.lang.Integer id) {
        System.out.println("getting Transfer instance with id: " + id);
        try {
            Transfer instance = (Transfer) HibernateSessionFactory.getSession()
                    .load(Transfer.class, id);
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
    
    public List<Transfer> findByExample(Transfer instance) {
        log.debug("finding Transfer instance by example");
        try {
            List<Transfer> results = HibernateSessionFactory.getSession()
                    .createCriteria(Transfer.class)
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
    
    
     public List<Transfer> findByAll() {
        log.debug("finding Transfer instance by All");
        try {
//             
            String qry=" from Transfer";
            Query qobj =HibernateSessionFactory.getSession().createQuery(qry);
            List<Transfer> results= qobj.list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    } 
     
     
     public List findByProperty(String propertyName, Object value) {
		log.debug("finding Transfer instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Transfer as model where model."
					+ propertyName + "= ?";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}


     public static  List getTansferList(int userid)
    {
   UserDetails user=new UserDetails();
   user.setUserId(1);

   List ls= HibernateSessionFactory.getSession().createCriteria(Transfer.class,"transfer").
              add(Restrictions.eq("userDetails",user)).createAlias("transfer.bsHead","head").list();

        for (Iterator it = ls.iterator(); it.hasNext();) {
            Transfer trn =(Transfer) it.next();
            UserDetails user2=(UserDetails)trn.getUserDetails();
            System.out.println("userid "+user2.getUserName());
            UserAccountDetails ac=(UserAccountDetails)trn.getUserAccountDetailsByTransferSaccount();
System.out.println("SAC  "+ac.getOpeningBalance());

        }


     return ls;
     }


     public static void main(String[] args) {
        getTansferList(1);
    }
}


