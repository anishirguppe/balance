/*
 * Copyright 2012 Aniruddha.
 * and open the template in the editor.
 */
package com.balance.action;

import com.balance.hib.bean.BsHead;
import com.balance.hib.bean.UserAccountDetails;
import com.balance.hib.bean.UserDetails;
import com.balance.hib.home.UserAccountDetailsHome;
import com.balance.hib.home.UserDetailsHome;
import com.balance.util.CommonMethods;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorActionForm;

/**
 *
 * @author hcl
 */
public class LoginAction extends org.apache.struts.action.Action {

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
        String username = "";
        String password = "";
        try {
            System.out.println("inside Login");
            DynaValidatorActionForm f = (DynaValidatorActionForm) form;
            username = f.get("username").toString();
            password = f.get("password").toString();
            String hidden = f.get("v_hidden").toString();
            request.setAttribute("v_hidden", hidden);
            System.out.println("get user details  successfully inside Login");


        } catch (Exception e) {
            System.out.print("ERROR Login" + e);
        }
        UserDetailsHome udh = new UserDetailsHome();

        List ls = udh.findByProperty("userProfileName", username);

        System.out.println(" User size ls size" + ls.size());
        for (Iterator it = ls.iterator(); it.hasNext();) {
            UserDetails userobj = (UserDetails) it.next();
            if (userobj.getPassword().equals(password)) {
                HttpSession httpsession = request.getSession(true);
                httpsession.setAttribute("user", userobj);
                
               
                return mapping.findForward("SUCCESS");
            } else {
                request.setAttribute("login", "fail");
                return mapping.findForward("ERROR");
            }


        }
        request.setAttribute("login", "fail");
        return mapping.findForward("ERROR");
//        if(username.equals("ani")&& password.equals("ani"))
//        { 
//            HttpSession httpsession=request.getSession(true);
//            httpsession.setAttribute("user",new UserDetailsHome().findById(new Integer(1)));       
//            
//            return mapping.findForward("SUCCESS"); }
//        if(username.equals("abhi")&& password.equals("abhi"))
//        { 
//            HttpSession httpsession=request.getSession(true);
//            httpsession.setAttribute("user",new UserDetailsHome().findById(new Integer(2)));       
//            
//            return mapping.findForward("SUCCESS"); }
//        

    }
}
