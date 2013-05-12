/*
 * Copyright 2012 Aniruddha.
 * and open the template in the editor.
 */
package com.balance.action;

import com.balance.hib.bean.*;
import com.balance.hib.home.BsHeadHome;
import com.balance.hib.home.BsSubHeadHome;
import com.balance.hib.home.IncomeEntryHome;
import com.balance.hib.home.UserAccountDetailsHome;
import com.balance.util.CommonMethods;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorActionForm;

/**
 *
 * @author hcl
 */
public class AddIncomeAction extends org.apache.struts.action.Action {

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
    System.out.print("\n inside addincome");          
    int cat = 0;
        int subcat=0;
        int acc = 0;
        double amt = 0d;
        
        DynaValidatorActionForm f = (DynaValidatorActionForm) form;
                    
        String category = f.get("category").toString();
        String relevantAccount = f.get("relevantAccount").toString();
        String subcategory=f.get("subcategory").toString();
         System.out.print("\n 2nd  inside addincome"); 
        String date = f.get("date").toString();
        String amount = f.get("amount").toString();
        String remarks = f.get("remarks").toString();
        String hidden = f.get("v_hidden").toString();
         System.out.print("\n 3nd  inside addincome"+remarks); 
        
//        bsheadgroupid="+bsheadgroupid+"&bssubheadid="+bssubheadid+"&relevantAccountid="+relevantAccountid+"&datepicker=
//        "+datepicker+"&amount="+amount+"&remarksid="+remarksid+"",
//      
         
        category=request.getParameter("bsheadgroupid").toString();
        subcategory=request.getParameter("bssubheadid").toString();
        relevantAccount=request.getParameter("relevantAccountid").toString();
        date=request.getParameter("datepicker").toString();
        amount=request.getParameter("amount").toString();
        remarks=request.getParameter("remarksid").toString();
        System.out.print("\nAfter  inside addincome "+category+relevantAccount+subcategory+date+amount+remarks+hidden); 
        
        if (!category.isEmpty()) {
            cat = Integer.parseInt(category);
        }
        if(!subcategory.isEmpty())
         {
          subcat=Integer.parseInt(subcategory);
         }
        if (!relevantAccount.isEmpty()) {
            acc = Integer.parseInt(relevantAccount);
        }
        if (!amount.isEmpty()) {
            amt = Double.parseDouble(amount);
        }

        if (cat != 0) {
            BsHead head = new BsHeadHome().findById(new Integer(cat));
            UserAccountDetails account = new UserAccountDetailsHome().findById(new Integer(acc));
            UserDetails user = (UserDetails) request.getSession(false).getAttribute("user");
            BsSubHead bsub=new BsSubHeadHome().findById(new Integer(subcat));
            IncomeEntry income = new IncomeEntry();
            //(head,account,date,amt,remarks); 
            income.setBsHead(head);
             income.setBsSubHead(bsub);
            income.setIncomeAmount(amt);
            income.setUserDetails(user);
            income.setIncomeRemarks(remarks);
            income.setIncomeDate(CommonMethods.stringTODate(date));
            income.setUserAccountDetails(account);

            IncomeEntryHome home = new IncomeEntryHome();

            home.persist(income);


        }

}catch(Exception e){
e.printStackTrace();}
       // return mapping.findForward("SUCCESS");
        return null;
    }
}
