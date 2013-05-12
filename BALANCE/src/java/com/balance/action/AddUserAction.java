/*
 * Copyright 2012 Aniruddha.
 * and open the template in the editor.
 */
package com.balance.action;

import com.balance.hib.bean.UserDetails;
import com.balance.hib.home.UserDetailsHome;
import com.balance.util.CommonMethods;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorActionForm;

/**
 *
 * @author hcl
 */
public class AddUserAction extends org.apache.struts.action.Action {

    /*
     * forward name="success" path=""
     */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try{
        //DynaValidatorActionForm f=(DynaValidatorActionForm)form;
//          <form-property name="username" type="java.lang.String"/>
//        <form-property name="profilename" type="java.lang.String"/>
//        <form-property name="dob" type="java.lang.String"/>
//        <form-property name="usergender" type="java.lang.String"/>
//        <form-property name="address" type="java.lang.String"/>
//        <form-property name="child" type="java.lang.String"/>
//        <form-property name="userrelevantid" type="java.lang.Integer"/>
         //"+username+"&profilename="+profilename+"&usergender="+usergender+"&datepicker="+datepicker+
        //"&address="+address+"&marriedstatus="+marriedstatus+"&child="+child+"&userrelevantid"+userrelevantid+""
        
        
         String username=request.getParameter("username").toString();
         System.out.println("*****"+username);
         String profilename=request.getParameter("profilename").toString();
         System.out.println("*****"+username+profilename);
         Date dob=CommonMethods.stringTODate(request.getParameter("datepicker").toString().trim());
         System.out.println("*****"+username+profilename+dob);
         String usergender=request.getParameter("usergender").toString();
         String address=request.getParameter("address").toString();
         String marriedstatus=request.getParameter("marriedstatus").toString();
         String child=request.getParameter("child").toString();
System.out.println("*"+usergender+address+marriedstatus+child);
         String userrelevantid=request.getParameter("userrelevantid").toString().trim();
        
        
                      System.out.println("***userrelevantid**"+userrelevantid);
         int revid=0;
         System.out.println("***here***");
       
        
                 
                 
         
         UserDetailsHome udh=new UserDetailsHome();
         if(userrelevantid.equalsIgnoreCase("myself"))
         {
             UserDetails ud=new UserDetails();
         ud.setUserName(username);
         ud.setUserProfileName(profilename);
         ud.setUserRelevantId(revid);
         ud.setUserDob(dob);
         ud.setMarriedStatus(marriedstatus);
         ud.setNoOfChild(child);
         ud.setUserGender(usergender);
         ud.setUserAddress(address);
             //UserDetails ud=new UserDetails(username, profilename, dob, usergender, revid, address, marriedstatus, child); 
           revid=udh.persist(ud);
           ud.setUserRelevantId(new Integer(revid));
           ud.setUserId(new Integer(revid));
           udh.merge(ud);
         }
         else
         { 
             revid=Integer.parseInt(userrelevantid);
             UserDetails ud=new UserDetails();
         ud.setUserName(username);
         ud.setUserProfileName(profilename);
         ud.setUserRelevantId(revid);
         ud.setUserDob(dob);
         ud.setMarriedStatus(marriedstatus);
         ud.setNoOfChild(child);
         ud.setUserGender(usergender);
         ud.setUserAddress(address);
             //UserDetails ud=new UserDetails(username, profilename, dob, usergender, revid, address, marriedstatus, child);
              revid=udh.persist(ud); 
         
         }
         
          
         
        }catch(Exception e)
        {
        System.out.println("ERROR in add user");    
         e.printStackTrace();
        }
        return null;
    }
}
