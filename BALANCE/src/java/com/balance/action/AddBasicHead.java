/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balance.action;

import com.balance.hib.bean.BsGroup;
import com.balance.hib.bean.BsHead;
import com.balance.hib.home.BsGroupHome;
import com.balance.hib.home.BsHeadHome;
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
public class AddBasicHead extends org.apache.struts.action.Action {

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
          DynaValidatorActionForm f=(DynaValidatorActionForm)form;
          int id=Integer.parseInt(f.get("bsheadgroupid").toString());
        String name=f.get("bsheadname").toString();
        String hidden=f.get("v_hidden").toString();
        String initial= f.get("bsheadinitial").toString();
                BsHead bsh=new BsHead();
                BsGroup bg=new BsGroup();
                bg.setBsId(id);
                bsh.setBsGroup(bg);
                bsh.setBsHeadName(name);
                bsh.setBsHeadInitial(initial);
                bsh.setBsHeadId(id);
                BsHeadHome bshh=new BsHeadHome();
                
                bshh.persist(bsh);
                
        System.out.println("name is "+name+hidden);
        request.setAttribute("v_hidden",hidden);
        return mapping.findForward("SUCCESS");
    }
}
