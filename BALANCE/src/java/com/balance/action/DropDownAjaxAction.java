/*
 * Copyright 2012 Aniruddha.
 * and open the template in the editor.
 */
package com.balance.action;

import com.balance.hib.bean.ExpenseEntry;
import com.balance.hib.bean.IncomeEntry;
import com.balance.hib.bean.Transfer;
import com.balance.hib.bean.UserAccountDetails;
import com.balance.hib.bean.UserDetails;
import com.balance.hib.home.BsHeadHome;
import com.balance.hib.home.BsSubHeadHome;
import com.balance.hib.home.UserAccountDetailsHome;
import com.balance.hib.home.UserDetailsHome;
import com.balance.util.CommonMethods;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author hcl
 */
public class DropDownAjaxAction extends DispatchAction {

    /*
     * forward name="success" path=""
     */
    private final static String SUCCESS = "success";

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction1, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward bsHead(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("in action ");


        response.setContentType("text/xml");
        response.setHeader("CACHE-CONTROL", "NO-CACHE");
        response.setHeader("EXPIRES", "Mon, 29 SEP 2012 11:12:01 GMT");
        response.setHeader("PRAGMA", "NO-CACHE");
        BsHeadHome s = new BsHeadHome();
        int bsgroupid = Integer.parseInt(request.getParameter("g_value").toString());

        response.getWriter().write(s.getHeadXML(bsgroupid));
        return null;
    }

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction2, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward bsSubHead(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("in action ");


        response.setContentType("text/xml");
        response.setHeader("CACHE-CONTROL", "NO-CACHE");
        response.setHeader("EXPIRES", "Mon, 29 SEP 2012 11:12:01 GMT");
        response.setHeader("PRAGMA", "NO-CACHE");
        BsSubHeadHome s = new BsSubHeadHome();
        int bsheadid = Integer.parseInt(request.getParameter("g_value").toString());

        response.getWriter().write(s.getSubHeadXML(bsheadid));

        return null;
    }

    public ActionForward subCategory(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("in action subcategory ");


        response.setContentType("text/xml");
        response.setHeader("CACHE-CONTROL", "NO-CACHE");
        response.setHeader("EXPIRES", "Mon, 29 SEP 2012 11:12:01 GMT");
        response.setHeader("PRAGMA", "NO-CACHE");
        BsSubHeadHome subhead = new BsSubHeadHome();
        int categoryid = Integer.parseInt(request.getParameter("g_value").toString());


        response.getWriter().write(subhead.getSubHeadXML(categoryid));

        return null;
    }

    public ActionForward myView(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            System.out.println("in Myajax action ");

            String opt = request.getParameter("g_value").toString();
            System.out.println("\n--OPT--"+opt);

              if (opt.equalsIgnoreCase("transfer") || opt == "transfer") {
                 System.out.println("in user ");
                String str = "<style type='text/css'>"
                        + "table.altrowstable {"
                        + "	font-family: verdana,arial,sans-serif;"
                        + "	font-size:11px;"
                        + "	color:#333333;"
                        + "	border-width:0px;"
                        + "	border-color: #a9c6c9;"
                        + "	border-collapse: collapse;"
                        + "	"
                        + "}"
                        + "table.altrowstable th {"
                        + "	border-width: 1px;"
                        + "	padding: 4px;"
                        + "	border-style: solid;"
                        + "	border-color: #a9c6c9;"
                        + "}"
                        + "table.altrowstable td {"
                        + "	border-width: 1px;"
                        + "	padding: 4px;"
                        + "	border-style: solid;"
                        + "	border-color: #a9c6c9;"
                        + "}"
                        + ".oddrowcolor{"
                        + "<!--	background-color:#d4e3e5;-->"
                        + "}"
                        + ".evenrowcolor{"
                        + "<!--	background-color:#c3dde0;-->"
                        + "}"
                        + "</style>";
                StringBuilder output = new StringBuilder();
                HttpSession session = request.getSession(false);
                UserDetails userobj = (UserDetails) session.getAttribute("user");
                List<Transfer> ls1 = CommonMethods.getTransferByUserId(userobj);
                //         getUserIncomeByUserId(userobj.getUserId());
                output.append("<table border='1' class='altrowstable'  id='t1'  align='center'>");
                output.append("<thead> <tr><th> Transfer Date</th> <th>Source A/C</th>  <th>Destination A/C </th><th>Amount </th></tr>  </thead>");
                for (Iterator it = ls1.iterator(); it.hasNext();) {
                    Transfer transfer = (Transfer) it.next();
                    output.append("<tr><td>");
                    output.append(transfer.getTransferDate()).append("</td><td>");
                    output.append(transfer.getUserAccountDetailsByTransferSaccount().getUserAccountName()).append("</td><td>");
                 
                    String destinationAC= transfer.getUserAccountDetailsByTransferDaccount()==null
                          ? "-" :
                      transfer.getUserAccountDetailsByTransferDaccount().getUserAccountName() ;
                    output.append(destinationAC).append("</td><td>");
                    output.append(transfer.getTransferAmount() ).append("</td>");
                    output.append("</tr>");

                }

                output.append("</table>");
                response.getWriter().write(output.toString());

            }


            if (opt.equalsIgnoreCase("bankaccount") || opt == "bankaccount") {
                 System.out.println("in user ");
                String str = "<style type='text/css'>"
                        + "table.altrowstable {"
                        + "	font-family: verdana,arial,sans-serif;"
                        + "	font-size:11px;"
                        + "	color:#333333;"
                        + "	border-width:0px;"
                        + "	border-color: #a9c6c9;"
                        + "	border-collapse: collapse;"
                        + "	"
                        + "}"
                        + "table.altrowstable th {"
                        + "	border-width: 1px;"
                        + "	padding: 4px;"
                        + "	border-style: solid;"
                        + "	border-color: #a9c6c9;"
                        + "}"
                        + "table.altrowstable td {"
                        + "	border-width: 1px;"
                        + "	padding: 4px;"
                        + "	border-style: solid;"
                        + "	border-color: #a9c6c9;"
                        + "}"
                        + ".oddrowcolor{"
                        + "<!--	background-color:#d4e3e5;-->"
                        + "}"
                        + ".evenrowcolor{"
                        + "<!--	background-color:#c3dde0;-->"
                        + "}"
                        + "</style>";
                StringBuilder output = new StringBuilder();
                HttpSession session = request.getSession(false);
                UserDetails userobj = (UserDetails) session.getAttribute("user");
                List<UserAccountDetails> ls1 = CommonMethods.getAccountDetailsByUser(userobj);
                //         getUserIncomeByUserId(userobj.getUserId());
                output.append("<table border='1' class='altrowstable'  id='t1'  align='center'>");
                output.append("<thead> <tr><th> Account Name</th>"
                        + " <th>Bank Name</th>  <th>Branch Name </th><th>Account No. </th><th>Opening Balance </th></tr>  </thead>");
                for (Iterator it = ls1.iterator(); it.hasNext();) {
                    UserAccountDetails user = (UserAccountDetails) it.next();
                    output.append("<tr><td>");
                    output.append(user.getUserAccountName()).append("</td><td>");
                    output.append(user.getUserAccountBankName()).append("</td><td>");
                    output.append(user.getUserAccountBankBranch() ).append("</td><td>");
                    output.append(user.getUserAccountNo()).append("</td><td>");
                    output.append(user.getOpeningBalance()).append("</td>");
                    output.append("</tr>");

                }

                output.append("</table>");
                response.getWriter().write(output.toString());

            }


            if (opt.equalsIgnoreCase("income") || opt == "income") {
                 System.out.println("in Income ");
                String str = "<style type='text/css'>"
                        + "table.altrowstable {"
                        + "	font-family: verdana,arial,sans-serif;"
                        + "	font-size:11px;"
                        + "	color:#333333;"
                        + "	border-width:0px;"
                        + "	border-color: #a9c6c9;"
                        + "	border-collapse: collapse;"
                        + "	"
                        + "}"
                        + "table.altrowstable th {"
                        + "	border-width: 1px;"
                        + "	padding: 4px;"
                        + "	border-style: solid;"
                        + "	border-color: #a9c6c9;"
                        + "}"
                        + "table.altrowstable td {"
                        + "	border-width: 1px;"
                        + "	padding: 4px;"
                        + "	border-style: solid;"
                        + "	border-color: #a9c6c9;"
                        + "}"
                        + ".oddrowcolor{"
                        + "<!--	background-color:#d4e3e5;-->"
                        + "}"
                        + ".evenrowcolor{"
                        + "<!--	background-color:#c3dde0;-->"
                        + "}"
                        + "</style>";
                StringBuilder output = new StringBuilder();
                HttpSession session = request.getSession(false);
                UserDetails userobj = (UserDetails) session.getAttribute("user");
                List<IncomeEntry> ls1 = CommonMethods.getUserIncomeByUserId(userobj.getUserId());
                output.append("<table border='1' class='altrowstable'  id='t1'  align='center'>");
                output.append("<thead> <tr><th> Income Date </th> <th>Income Category</th>  <th>Income Sub-Category</th>    <th>Income Account </th>      <th>Income Amount </th>      <th>Income Remarks </th> </tr>  </thead>");
                for (Iterator it = ls1.iterator(); it.hasNext();) {
                    IncomeEntry income = (IncomeEntry) it.next();
                    output.append("<tr><td>");
                    output.append(income.getIncomeDate() + "</td><td>");
                    output.append(income.getBsHead().getBsHeadName() + "</td><td>");
                    output.append(income.getBsSubHead().getBsSubHeadName() + "</td><td>");
                    output.append(income.getUserAccountDetails().getUserAccountName() + "</td><td>");
                    output.append(income.getIncomeAmount() + "</td><td>");
                    output.append(income.getIncomeRemarks() + "</td>");
                    output.append("</tr>");

                }
                
                output.append("</table>");
                response.getWriter().write(output.toString());

            }
            if (opt.equalsIgnoreCase("expense") || opt == "expense") {
                System.out.println("Inside Expense ");
                String str = "<style type='text/css'>"
                        + "table.altrowstable {"
                        + "	font-family: verdana,arial,sans-serif;"
                        + "	font-size:11px;"
                        + "	color:#333333;"
                        + "	border-width:0px;"
                        + "	border-color: #a9c6c9;"
                        + "	border-collapse: collapse;"
                        + "	"
                        + "}"
                        + "table.altrowstable th {"
                        + "	border-width: 1px;"
                        + "	padding: 4px;"
                        + "	border-style: solid;"
                        + "	border-color: #a9c6c9;"
                        + "}"
                        + "table.altrowstable td {"
                        + "	border-width: 1px;"
                        + "	padding: 4px;"
                        + "	border-style: solid;"
                        + "	border-color: #a9c6c9;"
                        + "}"
                        + ".oddrowcolor{"
                        + "<!--	background-color:#d4e3e5;-->"
                        + "}"
                        + ".evenrowcolor{"
                        + "<!--	background-color:#c3dde0;-->"
                        + "}"
                        + "</style>";
                StringBuilder output = new StringBuilder();
                HttpSession session = request.getSession(false);
                UserDetails userobj = (UserDetails) session.getAttribute("user");
                List<ExpenseEntry> ls1 = CommonMethods.getUserExpenseByUserId(userobj.getUserId());
                output.append("<table border='1' class='altrowstable'  id='t1'  align='center'>");
                output.append("<thead> <tr><th> Expense Date </th> <th>Income Category</th>  <th>Income Sub-Category</th>    <th>Income Account </th>      <th>Income Amount </th>      <th>Income Remarks </th> </tr>  </thead>");
                for (Iterator it = ls1.iterator(); it.hasNext();) {
                   ExpenseEntry expense = (ExpenseEntry) it.next();
                    output.append("<tr><td>");
                    output.append(expense.getExpenseDate() + "</td><td>");
                    output.append(expense.getBsHead().getBsHeadName() + "</td><td>");
                    output.append(expense.getBsSubHead().getBsSubHeadName() + "</td><td>");
                    output.append(expense.getUserAccountDetails().getUserAccountName() + "</td><td>");
                    output.append(expense.getExpenseAmount() + "</td><td>");
                    output.append(expense.getExpenseRemarks() + "</td>");
                    output.append("</tr>");

                }
                
                output.append("</table>");
                response.getWriter().write(output.toString());

            }
            
            if (opt.equalsIgnoreCase("user") || opt == "user") {
                 System.out.println("in user ");
                String str = "<style type='text/css'>"
                        + "table.altrowstable {"
                        + "	font-family: verdana,arial,sans-serif;"
                        + "	font-size:11px;"
                        + "	color:#333333;"
                        + "	border-width:0px;"
                        + "	border-color: #a9c6c9;"
                        + "	border-collapse: collapse;"
                        + "	"
                        + "}"
                        + "table.altrowstable th {"
                        + "	border-width: 1px;"
                        + "	padding: 4px;"
                        + "	border-style: solid;"
                        + "	border-color: #a9c6c9;"
                        + "}"
                        + "table.altrowstable td {"
                        + "	border-width: 1px;"
                        + "	padding: 4px;"
                        + "	border-style: solid;"
                        + "	border-color: #a9c6c9;"
                        + "}"
                        + ".oddrowcolor{"
                        + "<!--	background-color:#d4e3e5;-->"
                        + "}"
                        + ".evenrowcolor{"
                        + "<!--	background-color:#c3dde0;-->"
                        + "}"
                        + "</style>";
                StringBuilder output = new StringBuilder();
                HttpSession session = request.getSession(false);
                UserDetails userobj = (UserDetails) session.getAttribute("user");
                List<IncomeEntry> ls1 = CommonMethods.getUserDetailsByRelUserId(userobj);
                //         getUserIncomeByUserId(userobj.getUserId());
                output.append("<table border='1' class='altrowstable'  id='t1'  align='center'>");
                output.append("<thead> <tr><th> User Name</th> <th>User Profile Name</th>  <th>Relevant User </th></tr>  </thead>");
                for (Iterator it = ls1.iterator(); it.hasNext();) {
                    UserDetails user = (UserDetails) it.next();
                    output.append("<tr><td>");
                    output.append(user.getUserName()).append("</td><td>");
                    output.append(user.getUserProfileName()).append("</td><td>");
                    output.append(userobj.getUserName() ).append("</td>");
                    output.append("</tr>");

                }
                
                output.append("</table>");
                response.getWriter().write(output.toString());

            }


            if (opt.equalsIgnoreCase("bankaccount") || opt == "bankaccount") {
                 System.out.println("in user ");
                String str = "<style type='text/css'>"
                        + "table.altrowstable {"
                        + "	font-family: verdana,arial,sans-serif;"
                        + "	font-size:11px;"
                        + "	color:#333333;"
                        + "	border-width:0px;"
                        + "	border-color: #a9c6c9;"
                        + "	border-collapse: collapse;"
                        + "	"
                        + "}"
                        + "table.altrowstable th {"
                        + "	border-width: 1px;"
                        + "	padding: 4px;"
                        + "	border-style: solid;"
                        + "	border-color: #a9c6c9;"
                        + "}"
                        + "table.altrowstable td {"
                        + "	border-width: 1px;"
                        + "	padding: 4px;"
                        + "	border-style: solid;"
                        + "	border-color: #a9c6c9;"
                        + "}"
                        + ".oddrowcolor{"
                        + "<!--	background-color:#d4e3e5;-->"
                        + "}"
                        + ".evenrowcolor{"
                        + "<!--	background-color:#c3dde0;-->"
                        + "}"
                        + "</style>";
                StringBuilder output = new StringBuilder();
                HttpSession session = request.getSession(false);
                UserDetails userobj = (UserDetails) session.getAttribute("user");
                List<UserAccountDetails> ls1 = CommonMethods.getAccountDetailsByUser(userobj);
                //         getUserIncomeByUserId(userobj.getUserId());
                output.append("<table border='1' class='altrowstable'  id='t1'  align='center'>");
                output.append("<thead> <tr><th> Account Name</th>"
                        + " <th>Bank Name</th>  <th>Branch Name </th><th>Account No. </th><th>Opening Balance </th></tr>  </thead>");
                for (Iterator it = ls1.iterator(); it.hasNext();) {
                    UserAccountDetails user = (UserAccountDetails) it.next();
                    output.append("<tr><td>");
                    output.append(user.getUserAccountName()).append("</td><td>");
                    output.append(user.getUserAccountBankName()).append("</td><td>");
                    output.append(user.getUserAccountBankBranch() ).append("</td><td>");
                    output.append(user.getUserAccountNo()).append("</td><td>");
                    output.append(user.getOpeningBalance()).append("</td>");
                    output.append("</tr>");

                }

                output.append("</table>");
                response.getWriter().write(output.toString());

            }
            
            System.out.println("inAfter responce  Myajax action ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ActionForward checkUserProfileName(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("in action check User Profile NAme ");


        response.setContentType("text/xml");
        response.setHeader("CACHE-CONTROL", "NO-CACHE");
        response.setHeader("PRAGMA", "NO-CACHE");
      String  currentProfileName =request.getParameter("g_value").toString();
        UserDetailsHome userh = new UserDetailsHome();
    
int va=userh.isValidProfileName(currentProfileName);
        System.out.println("values is "+va);
//0 = valid  1 =INvalid
        response.getWriter().write(""+va);

        return null;
    }

}
