/*
 * Copyright 2012 Aniruddha.
 * and open the template in the editor.
 */
package com.balance.action;

import com.balance.hib.bean.*;
import com.balance.hib.home.BsHeadHome;
import com.balance.hib.home.*;
import com.balance.hib.home.UserAccountDetailsHome;
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
public class AddExpenseAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try{
        int cat=0;
         int subcat=0;
        int acc=0;
        double amt=0d;
        int relu=0;
//        DynaValidatorActionForm f=(DynaValidatorActionForm)form;
//         String category=f.get("category").toString();
//         String subcategory=f.get("subcategory").toString();
//         String relevantAccount=f.get("relevantAccount").toString();
//         String date=f.get("date").toString();
//         String amount=f.get("amount").toString();
//         String remarks=f.get("remarks").toString();
//         String hidden=f.get("v_hidden").toString();
         
      String   category=request.getParameter("bsheadgroupid").toString();
      String  subcategory=request.getParameter("bssubheadid").toString();
      String   relevantAccount=request.getParameter("relevantAccountid").toString();
         
      String relevantUserId=request.getParameter("relevantUserId").toString();
         
        String date=request.getParameter("datepicker").toString();
        String amount=request.getParameter("amount").toString();
        String remarks=request.getParameter("remarksid").toString();
        System.out.print("\nAfter  inside addincome "+category+relevantAccount+subcategory+date+amount+remarks); 
         
         if(!category.isEmpty())
         {
          cat=Integer.parseInt(category);
         }
         if(!subcategory.isEmpty())
         {
          subcat=Integer.parseInt(subcategory);
         }
         if(!relevantAccount.isEmpty())
         {
          acc=Integer.parseInt(relevantAccount);
         }
         if(!amount.isEmpty())
         {
          amt=Double.parseDouble(amount);
         }
         if(!relevantUserId.isEmpty())
         {
         relu=Integer.parseInt(relevantUserId);
         
         }
         if(cat !=0)
         {
            BsHead head=new BsHeadHome().findById(new Integer(cat));
            UserAccountDetails account=new UserAccountDetailsHome().findById(new Integer(acc));
            BsSubHead bsub=new BsSubHeadHome().findById(new Integer(subcat));
            ExpenseEntry expense=new ExpenseEntry();
            expense.setBsHead(head);
            expense.setBsSubHead(bsub);
            expense.setExpenseAmount(amt);
            expense.setExpenseRemarks(remarks);
            expense.setUserAccountDetails(account);
            expense.setRelevantUser(relu);
            expense.setExpenseDate(CommonMethods.stringTODate(date));
            UserDetails user =(UserDetails)request.getSession(false).getAttribute("user");
                    //(head,account,date,amt,remarks); 
            expense.setUserDetails(user);
            ExpenseEntryHome home=new ExpenseEntryHome();
          home.persist(expense);
            
         
         }
         
        }catch(Exception e){
            System.out.println("ERROR IN ADD EXP");
            e.printStackTrace();
            return  mapping.findForward("SUCCESS");
        }
        return null;
    }
    
    
}
