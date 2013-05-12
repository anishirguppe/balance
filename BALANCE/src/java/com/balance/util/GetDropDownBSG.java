/*
 * Copyright 2012 Aniruddha.
 * and open the template in the editor.
 */
package com.balance.util;

import com.balance.hib.home.BsGroupHome;
import com.balance.hib.home.BsHeadHome;
import com.balance.hib.home.BsSubHeadHome;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author hcl
 */
public class GetDropDownBSG extends org.apache.struts.action.Action {

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
        BsGroupHome bsgh=new BsGroupHome();
        BsHeadHome bshh=new BsHeadHome();
        request.setAttribute("BSSUBHEAD",bshh.findByAll() );
       request.setAttribute("BSGROUP",bsgh.findByAll());
       String sub=request.getParameter("sub").toString();
       if(sub.equalsIgnoreCase("0"))
        return mapping.findForward("headsuccess");
       else
           return mapping.findForward("subsuccess");
    }
}
