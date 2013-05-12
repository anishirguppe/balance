/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balance.action;

import com.balance.hib.bean.BsGroup;
import com.balance.hib.bean.UserDetails;
import com.balance.hib.home.BsGroupHome;
import com.balance.hib.home.UserDetailsHome;
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
public class AddBasicGroup extends org.apache.struts.action.Action {

    /*
     * forward name="success" path=""
     */
    

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
        String name=f.get("bsgroupname").toString();
        String hidden=f.get("v_hidden").toString();
        String initial= f.get("bsgroupinitial").toString();
        if(!name.isEmpty())
        {
                BsGroup bsg=new BsGroup();
                bsg.setBsName(name);
                bsg.setBsInitial(initial);
                BsGroupHome bsgh=new BsGroupHome();
                bsgh.persist(bsg);
        }       
        System.out.println("name is "+name+hidden);
        
        request.setAttribute("v_hidden",hidden);
        
        return mapping.findForward("SUCCESS");
    }
}
