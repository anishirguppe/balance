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
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author hcl
 */
public class GetDropDownBSGH extends Action{

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    
        BsHeadHome bsh=new BsHeadHome();
        BsSubHeadHome bshh=new BsSubHeadHome();
        request.setAttribute("BSHEAD",bsh.findByAll());
        request.setAttribute("BSSUBHEAD",bshh.findByAll() );
        
     return mapping.findForward("success");   
    }
    
    
    
}
