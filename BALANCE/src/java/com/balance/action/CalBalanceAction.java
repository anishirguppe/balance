/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.balance.action;

import com.balance.hib.bean.UserDetails;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author hcl
 */

public class CalBalanceAction extends Action {

    public CalBalanceAction() {
    }


    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
      HttpSession session=null;
        try {
            session = request.getSession(false);
            System.out.println("\n *****### Session" + session.toString());
            if (session.toString() == null) {
                getServlet().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
//             getServletContext().getRequestDispatcher("index.jsp").forward(request, response);
        }
        System.out.println("Inside CalBalance Action");
        UserDetails user = (UserDetails) session.getAttribute("user");
         request.setAttribute("userID",user.getUserId());


        return mapping.findForward("SUCCESS");
    }


}