/*
 * Copyright 2012 Aniruddha.
 * and open the template in the editor.
 */
package com.balance.action;

import com.balance.hib.bean.BsGroup;
import com.balance.hib.bean.BsHead;
import com.balance.hib.bean.BsSubHead;
import com.balance.hib.home.BsGroupHome;
import com.balance.hib.home.BsHeadHome;
import com.balance.hib.home.BsSubHeadHome;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author hcl
 */
public class CheckValueAction extends DispatchAction {

  
    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction1, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward bsGroup(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        String g_value=request.getParameter("gvalue").toString().trim();
         System.out.println("in side action"+g_value);
         
         BsGroupHome bgh=new BsGroupHome();
        List <BsGroup> ls= bgh.findByAll();
        int flag=0;
        for (Iterator<BsGroup> it = ls.iterator(); it.hasNext();) {
            BsGroup bsGroup = it.next();
                if(g_value.equalsIgnoreCase(bsGroup.getBsName().toString().trim()))
                {
                flag=1;
                }
        }
         
         
        System.out.println("flag is "+flag);
         if(flag==1)
             response.getWriter().write("1");
         else
              response.getWriter().write("0");
         
         
         
        
        return null;
    }

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction2, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    
    
     public ActionForward bsHead(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        String g_value=request.getParameter("gvalue").toString().trim();
         System.out.println("in side action Head "+g_value);
         
         BsHeadHome bgh=new BsHeadHome();
        List <BsHead> ls= bgh.findByAll();
        int flag=0;
        for (Iterator<BsHead> it = ls.iterator(); it.hasNext();) {
            BsHead bsHead = it.next();
                if(g_value.equalsIgnoreCase(bsHead.getBsHeadName().toString().trim()))
                {
                flag=1;
                }
        }
         
         
        System.out.println("flag is Head "+flag);
         if(flag==1)
             response.getWriter().write("1");
         else
              response.getWriter().write("0");
         
         
         
        
        return null;
    }
     
      public ActionForward bsSubHead(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
          try {
              
          
        String g_value=request.getParameter("gvalue").toString().trim();
         System.out.println("in side action sub Head "+g_value);
         
         BsSubHeadHome bshh=new BsSubHeadHome();
         List ls_1 = bshh.findByAll();
              for (Iterator it = ls_1.iterator(); it.hasNext();) {
                 BsSubHead   object =(BsSubHead) it.next();
                  
              }
         
         BsSubHeadHome bgh=new BsSubHeadHome();
        List <BsSubHead> ls= bgh.findByAll();
        int flag=0;
        for (Iterator<BsSubHead> it = ls.iterator(); it.hasNext();) {
            BsSubHead bssubHead = it.next();
                if(g_value.equalsIgnoreCase(bssubHead.getBsSubHeadName().toString().trim()))
                {
                flag=1;
                }
        }
         
         
        System.out.println("flag is sub Head "+flag);
         if(flag==1)
             response.getWriter().write("1");
         else
              response.getWriter().write("0");
         
         } catch (Exception e) {
              System.out.println(" \n error "+e);
             
          }
         
        
        return null;
    }

}
