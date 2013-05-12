/*
 * Copyright 2012 Aniruddha.
 * and open the template in the editor.
 */
package com.balance.action;

import com.balance.hib.bean.BsHead;
import com.balance.hib.bean.BsSubHead;
import com.balance.hib.home.BsHeadHome;
import com.balance.hib.home.BsSubHeadHome;
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
public class AddBasicSubHead extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
           try {
            
                      DynaValidatorActionForm f=(DynaValidatorActionForm)form;
                      System.out.println("f.get(bssubheadid).toString()"+f.get("bssubheadid").toString());
                      int id=Integer.parseInt(f.get("bssubheadid").toString().trim());
                      String subheadname=f.get("bssubheadname").toString();
                      String bssubheadinitial=f.get("bssubheadinitial").toString();
                      String hidden=f.get("v_hidden").toString();
                      BsSubHead bsh=new BsSubHead(new BsHeadHome().findById(new Integer(id)),subheadname,bssubheadinitial);
                      BsSubHeadHome bshh=new BsSubHeadHome();
                      bshh.persist(bsh);
                      System.out.println("save successfully");
                      request.setAttribute("v_hidden",hidden);
                 } catch (Exception e) {
                           e.printStackTrace();
               }
        return mapping.findForward("SUCCESS");
    }
    
    
}
