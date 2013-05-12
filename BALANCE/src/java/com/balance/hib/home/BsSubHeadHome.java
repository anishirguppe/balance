package com.balance.hib.home;
// Generated 6 Jun, 2012 10:43:53 AM by Hibernate Tools 3.4.0.CR1


import com.balance.hib.bean.BsGroup;
import com.balance.hib.bean.BsHead;
import com.balance.hib.bean.BsSubHead;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import com.balance.hib.util.HibernateSessionFactory;
import java.io.Writer;
import java.util.Iterator;
import java.util.Set;
import org.dom4j.Element;

import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.hibernate.*;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class BsSubHead.
 * @see com.balance.hib.beans.BsSubHead
 * @author Hibernate Tools
 */
public class BsSubHeadHome {

    private static final Log log = LogFactory.getLog(BsSubHeadHome.class);

   
    public void persist(BsSubHead transientInstance) {
        log.debug("persisting BsSubHead instance");
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
    
    public void attachDirty(BsSubHead instance) {
        log.debug("attaching dirty BsSubHead instance");
        try {
             HibernateSessionFactory.getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(BsSubHead instance) {
        log.debug("attaching clean BsSubHead instance");
        try {
             HibernateSessionFactory.getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(BsSubHead persistentInstance) {
        log.debug("deleting BsSubHead instance");
        try {
             HibernateSessionFactory.getSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public BsSubHead merge(BsSubHead detachedInstance) {
        log.debug("merging BsSubHead instance");
        try {
            BsSubHead result = (BsSubHead)  HibernateSessionFactory.getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public BsSubHead findById( java.lang.Integer id) {
        log.debug("getting BsSubHead instance with id: " + id);
        try {
            BsSubHead instance = (BsSubHead)  HibernateSessionFactory.getSession()
                    .get(BsSubHead.class, id);
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
    
    public List<BsSubHead> findByExample(BsSubHead instance) {
        log.debug("finding BsSubHead instance by example");
        try {
            List<BsSubHead> results = HibernateSessionFactory.getSession()
                    .createCriteria(BsSubHead.class)
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

    public List<BsSubHead> findByAll() {
        log.debug("finding BsSubHEad instance by All");
        try {
//             
            String qry="from BsSubHead";
            Query qobj =HibernateSessionFactory.getSession().createQuery(qry);
            List<BsSubHead> results= qobj.list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
    
      public String getSubHeadXML(int bsheadid)
    {
        StringBuilder sb=new StringBuilder();
        try {
           BsHead bh=new BsHeadHome().findById(bsheadid);
           
           Set<BsSubHead> setbh=bh.getBsSubHeads();
            sb.append("<root>");
            
            for (Iterator<BsSubHead> it = setbh.iterator(); it.hasNext();) {
                BsSubHead bsSubHead = it.next();
                
          List ls =findByExample(bsSubHead);
          
                   
            for (Iterator it1 = ls.iterator(); it1.hasNext();) {
                BsSubHead bsh =(BsSubHead)it1.next();
                System.out.println("\n id"+bsh.getBsSubHeadId());
                sb.append("<node><ID>").append(bsh.getBsSubHeadId()).append("</ID><name><![CDATA[ ").append(bsh.getBsSubHeadName()).append("  ]]></name></node>");  
                
            }
            }
            sb.append("</root>");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
   
        System.out.println("xml string "+sb.toString());
    return sb.toString();
    }
    
}

