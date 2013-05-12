package com.balance.hib.home;
// Generated 6 Jun, 2012 10:43:53 AM by Hibernate Tools 3.4.0.CR1


import com.balance.hib.bean.BsGroup;
import com.balance.hib.bean.BsHead;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import com.balance.hib.util.HibernateSessionFactory;
import java.util.Iterator;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class BsHead.
 * @see com.balance.hib.beans.BsHead
 * @author Hibernate Tools
 */
public class BsHeadHome {

    private static final Log log = LogFactory.getLog(BsHeadHome.class);

   
    
    public void persist(BsHead transientInstance) {
        log.debug("persisting BsHead instance");
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
    
    public void attachDirty(BsHead instance) {
        log.debug("attaching dirty BsHead instance");
        try {
             HibernateSessionFactory.getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(BsHead instance) {
        log.debug("attaching clean BsHead instance");
        try {
             HibernateSessionFactory.getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(BsHead persistentInstance) {
        log.debug("deleting BsHead instance");
        try {
             HibernateSessionFactory.getSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public BsHead merge(BsHead detachedInstance) {
        log.debug("merging BsHead instance");
        try {
            BsHead result = (BsHead)  HibernateSessionFactory.getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public BsHead findById( java.lang.Integer id) {
        log.debug("getting BsHead instance with id: " + id);
        try {
            BsHead instance = (BsHead)  HibernateSessionFactory.getSession()
                    .get(BsHead.class, id);
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
    
    public List<BsHead> findByExample(BsHead instance) {
        log.debug("finding BsHead instance by example");
        try {
            List<BsHead> results = HibernateSessionFactory.getSession()
                    .createCriteria(BsHead.class)
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

    public List<BsHead> findByAll() {
        log.debug("finding BsGroup instance by All");
        try {
//             
            String qry=" from BsHead ";
            Query qobj =HibernateSessionFactory.getSession().createQuery(qry);
            List<BsHead> results= qobj.list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re) {
            log.error("find by All failed", re);
            throw re;
        }
    }
    
    public String getHeadXML(int bsgroupid)
    {
        StringBuilder sb=new StringBuilder();
        try {
           BsGroup bg=new BsGroupHome().findById(bsgroupid);
           Set<BsHead> setbh=bg.getBsHeads();
            sb.append("<root>");
            
            for (Iterator<BsHead> it = setbh.iterator(); it.hasNext();) {
                BsHead bsHead = it.next();
                
          List ls =findByExample(bsHead);
          
                   
            for (Iterator it1 = ls.iterator(); it1.hasNext();) {
                BsHead bsh =(BsHead)it1.next();
                System.out.println("\n id"+bsh.getBsHeadId());
                sb.append("<node><ID>").append(bsh.getBsHeadId()).append("</ID><name><![CDATA[ ").append(bsh.getBsHeadName()).append("  ]]></name></node>");  
                
            }
            }
            sb.append("</root>");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
   
        System.out.println("xml string "+sb.toString());
    return sb.toString();
    }
    
    
    
    public List<BsHead> findByBsGroup(BsGroup bsGroup) {
        log.debug("finding BsGroup instance by All");
        try {
//             
            String qry=" from BsHead where bsGroup.bsId="+bsGroup.getBsId();
            Query qobj =HibernateSessionFactory.getSession().createQuery(qry);
            List<BsHead> results= qobj.list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re) {
            log.error("find by All failed", re);
            throw re;
        }
    }
    
    public List<BsHead> findByAccount() {
        log.debug("finding BsGroup instance by All");
        try {
//             
            
          
            List<BsHead> results =HibernateSessionFactory.getSession().getNamedQuery("getAccount").list();
               
            
            System.out.println("find by Account successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re) {
            log.error("find by All failed", re);
            throw re;
        }
    }
    
    public static void main (String ars[])
    {
     new BsHeadHome().findByAccount();
     
    }
}

