/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.balance.action;

import com.balance.hib.bean.BsHead;
import com.balance.hib.bean.Transfer;
import com.balance.hib.bean.UserAccountDetails;
import com.balance.hib.bean.UserDetails;
import com.balance.hib.home.BsHeadHome;
import com.balance.hib.home.TransferHome;
import com.balance.hib.home.UserAccountDetailsHome;
import com.balance.hib.util.BalanceCalUtil;
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
public class AddTransferAction extends org.apache.struts.action.Action {
     @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
try{
    System.out.print("\n inside addincome");
    int cat = 0;
        int subcat=0;
        int sacc = 0,dacc=0;
        double amt = 0d;

        /*DynaValidatorActionForm f = (DynaValidatorActionForm) form;

        String category = f.get("category").toString();
        String relevantAccount = f.get("relevantAccount").toString();
        String subcategory=f.get("subcategory").toString();
         System.out.print("\n 2nd  inside addincome");
        String date = f.get("date").toString();
        String amount = f.get("amount").toString();
        String remarks = f.get("remarks").toString();
        String hidden = f.get("v_hidden").toString();
         System.out.print("\n 3nd  inside addincome"+remarks);
*/
//        bsheadgroupid="+bsheadgroupid+"&bssubheadid="+bssubheadid+"&relevantAccountid="+relevantAccountid+"&datepicker=
//        "+datepicker+"&amount="+amount+"&remarksid="+remarksid+"",
//

        String category=request.getParameter("bsheadgroupid").toString();
        //subcategory=request.getParameter("bssubheadid").toString();
        String srelevantAccount=request.getParameter("srelevantAccountid").toString();
        String drelevantAccount=request.getParameter("drelevantAccountid").toString();
        String date=request.getParameter("datepicker").toString();
       String  amount=request.getParameter("amount").toString();
       String  remarks=request.getParameter("remarksid").toString();
        System.out.print("\nAfter  inside addincome "+category+srelevantAccount+date+amount+remarks);

        if (!category.isEmpty()) {
            cat = Integer.parseInt(category);
        }
       
        if (!srelevantAccount.isEmpty()) {
            sacc = Integer.parseInt(srelevantAccount);
        }
        if (!drelevantAccount.isEmpty()) {
            dacc = Integer.parseInt(drelevantAccount);
        }
        else
        {
            dacc = 0;
        }
        if (!amount.isEmpty()) {
            amt = Double.parseDouble(amount);
        }

        if (cat != 0) {
            
            BsHead head = new BsHeadHome().findById(new Integer(cat));
            UserAccountDetails saccount = new UserAccountDetailsHome().findById(new Integer(sacc));
           
            UserDetails user = (UserDetails) request.getSession(false).getAttribute("user");

            if(cat==44)
            {
              dacc= BalanceCalUtil.getAcIdForCash(user.getUserId());
            }
             UserAccountDetails daccount = new UserAccountDetailsHome().findById(new Integer(dacc));
            Transfer transfer = new Transfer();
            //(head,account,date,amt,remarks);
            transfer.setBsHead(head);
             
            transfer.setTransferAmount(amt);
            transfer.setUserDetails(user);
            transfer.setTransferRemarks(remarks);
            transfer.setTransferDate(CommonMethods.stringTODate(date));
            transfer.setUserAccountDetailsByTransferDaccount(daccount);
            transfer.setUserAccountDetailsByTransferSaccount(saccount);

            TransferHome home = new TransferHome();

            home.persist(transfer);


        }

}catch(Exception e){
e.printStackTrace();}
       // return mapping.findForward("SUCCESS");
        return null;
    }

}
