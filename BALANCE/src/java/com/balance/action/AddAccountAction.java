/*
 * Copyright 2012 Aniruddha.
 * and open the template in the editor.
 */
package com.balance.action;

import com.balance.hib.bean.BsHead;
import com.balance.hib.bean.BsSubHead;
import com.balance.hib.bean.UserAccountDetails;
import com.balance.hib.bean.UserDetails;
import com.balance.hib.home.UserAccountDetailsHome;
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
public class AddAccountAction extends org.apache.struts.action.Action {

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
        try {
            System.out.println("inside Add account");
//            DynaValidatorActionForm f = (DynaValidatorActionForm) form;
//            String actype = f.get("accounttype").toString();
//            String acname = f.get("accountname").toString();
//            String bankname = f.get("bankname").toString();
//            String hidden = f.get("v_hidden").toString();
//            String brname = f.get("branchname").toString();
//            String accno = f.get("accountno").toString();
//              var openingbalance= $('#openingbalance').val() ;
//                var accounttype=$('#accounttype option:selected').val() ;
//                var accountname=$('#accountname').val() ;
//                var accountno =$('#accountno').val() ;
//                var branchname=$("#branchname").val();
//                var bankname=$("#bankname").val();

                 String   actype=request.getParameter("accounttype").toString();
                 String   acsubtype=request.getParameter("accountsubtype").toString();
                String acname = request.getParameter("accountname").toString();
           String      bankname = request.getParameter("bankname").toString();
          //  String hidden = request.getParameter("v_hidden").toString();
             String brname = request.getParameter("branchname").toString();
             String accno = request.getParameter("accountno").toString();
            long openingbalance = 0;
            if (!request.getParameter("openingbalance").toString().isEmpty()) {
                openingbalance = Long.parseLong(request.getParameter("openingbalance").toString());
            }


            HttpSession httpSession = request.getSession(false);
            UserDetails user = (UserDetails) httpSession.getAttribute("user");

            BsHead bsh = new BsHead();
            BsSubHead bssh=new BsSubHead();
            if (!actype.isEmpty()) {
                bsh.setBsHeadId(Integer.parseInt(actype));
            }
            if (!acsubtype.isEmpty()) {
                bssh.setBsSubHeadId(Integer.parseInt(acsubtype));
            }

            UserAccountDetails account = new UserAccountDetails();
            account.setBsHead(bsh);
            account.setBsSubHead(bssh);
            account.setUserDetails(user);
            account.setUserAccountBankName(bankname);
            account.setUserAccountBankBranch(brname);
            account.setUserAccountName(acname);
            account.setUserAccountNo(accno);
            account.setOpeningBalance(openingbalance);

            //        (bsh,user,acname,bankname,brname,accno,openingbalance);             
            UserAccountDetailsHome uac= new UserAccountDetailsHome();
            uac.persist(account);
            //request.setAttribute("v_hidden", hidden);
            System.out.println("After successfully inside Add account");
        } catch (Exception e) {
            System.out.print("ERROR IN ADDA ACCONUT" + e);
            request.getRequestDispatcher("welcomeStruts.jsp").forward(request, response);
        }

        return null;

    }
}
