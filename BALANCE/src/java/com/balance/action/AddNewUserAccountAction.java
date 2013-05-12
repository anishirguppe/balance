/*
 * Copyright 2012 Aniruddha.
 * and open the template in the editor.
 */
package com.balance.action;

import com.balance.hib.bean.UserDetails;
import com.balance.hib.home.UserDetailsHome;
import com.balance.util.CommonMethods;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorActionForm;

/**
 *
 * @author hcl
 */
public class AddNewUserAccountAction extends Action{
//<form-property name="fname" type="java.lang.String"/>
//            <form-property name="lname" type="java.lang.String"/>
//            <form-property name="mobileno" type="java.lang.String"/>
//            <form-property name="mail" type="java.lang.String"/>
//            <form-property name="profilename" type="java.lang.String"/>
//            <form-property name="dob" type="java.lang.String"/>
//            <form-property name="usergender" type="java.lang.String"/>
//            <form-property name="address" type="java.lang.String"/>
//            <form-property name="marriedstatus" type="java.lang.String"/>
//            <form-property name="child" type="java.lang.String"/>
//            <form-property name="userpassword" type="java.lang.String"/>
//            <form-property name="repassword" type="java.lang.String"/>
//            <form-property name="v_hidden" type="java.lang.String"/>
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    try{
        System.out.println("inside Add NEw User account");
            DynaValidatorActionForm f = (DynaValidatorActionForm) form;
            String fname = f.get("fname").toString();
            String lname = f.get("lname").toString();
            String mobileString =f.get("mobileno").toString();
            String mail=f.get("mail").toString();
            String profilename=f.get("profilename").toString();
            String dobString=f.get("dob").toString();
            String usergender=f.get("usergender").toString();
            String address=f.get("address").toString();
            String marriedstatus=f.get("marriedstatus").toString();
            String child=f.get("child").toString();
            String userpassword=f.get("userpassword").toString();
            String repassword=f.get("repassword").toString();
            String hidden=f.get("v_hidden").toString();
            
            UserDetailsHome udh=new UserDetailsHome();
        UserDetails ud=new UserDetails();
         ud.setUserName(fname+" "+lname);
         ud.setUserProfileName(profilename);
         ud.setMarriedStatus(marriedstatus);
         ud.setNoOfChild(child);
         ud.setUserGender(usergender);
         ud.setUserAddress(address);
         //ud.setMobileNo(mobileString);
         ud.setUserDob(CommonMethods.stringTODate(dobString));
         ud.setMailId(mail);
         ud.setPassword(userpassword);
        ud.setUserRelevantId(0);

        UserDetailsHome h=new UserDetailsHome();
        int valid=h.isValidProfileName(profilename);
        int userid=0;
        if(valid==0)
         userid= udh.persist(ud);
        else
         System.out.println("ERROR IN user creation  is profile name repeated "+userid);
         
         System.out.println("user created is "+userid);
         
            
                      
            
    }catch(Exception e)
    {
    e.printStackTrace();
    }
        
        
       request.setAttribute("usercreation","SUCCESS");
        return mapping.findForward("SUCCESS");
    }
    



 

    
}
