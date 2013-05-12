/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.balance.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        System.out.println("Inside CalBalance Action");
        
         


        return mapping.findForward("SUCCESS");
    }


}