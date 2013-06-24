/*
 * Copyright 2012 Aniruddha.
 * and open the template in the editor.
 */
package com.action.actionservlet;

import com.balance.hib.bean.BsGroup;
import com.balance.hib.bean.BsHead;
import com.balance.hib.bean.UserDetails;
import com.balance.hib.home.*;
import com.balance.hib.util.HibernateSessionFactory;
import com.balance.util.CommonMethods;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionServlet;

/**
 *
 * @author hcl
 */
public class AniActionServlet extends ActionServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String strutspath = request.getRequestURI();
        HttpSession session = null;
        
        try {
            session = request.getSession(false);
            System.out.println("\n *****### Session" + session.toString());
            if (session.toString() == null) {
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
//             getServletContext().getRequestDispatcher("index.jsp").forward(request, response);
        }
       
        
          if(strutspath.contains("l_viewincome"))
          {
           System.out.println("\n ******#### inslide l_viewincome.do ");
           try {
                UserDetails user = (UserDetails) session.getAttribute("user");
                List ls =CommonMethods.getUserIncomeByUserId(user.getUserId());
                request.setAttribute("VIEWINCOME", ls);
                
            } catch (Exception e) {
                e.printStackTrace();
            } 
          System.out.println("\n ******####END  inslide l_viewincome.do ");
       }
          
          
       if(strutspath.contains("a_login"))
       {
           System.out.println("\n ****** inslide a_login ");
           try {
                BsHeadHome bhome = new BsHeadHome();
                BsGroup bg = new BsGroupHome().findById(new Integer(5));
                List ls1 = bhome.findByBsGroup(bg);
                request.setAttribute("CATEGORY", ls1);
                UserDetails user = (UserDetails) session.getAttribute("user");
                List ls = new CommonMethods().getAccountDetailsByUser(user);
                request.setAttribute("ACCOUNT", ls);
                List ls3=new UserDetailsHome().findByProperty("userRelevantId",user.getUserId() );
                request.setAttribute("RELUSER", ls3);
            } catch (NullPointerException e) {
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            } 
       
       }
         

        if (strutspath.contains("l_logout")) {
            System.out.print("in side L_logout" + servletMapping + "\n internal name" + internalName + "\n servlet name" + servletName + "\n Path " + request.getRequestURI());

            try {

                session.removeAttribute("user");
                session.invalidate();
                 getServletContext().getRequestDispatcher("/Myindex.jsp").forward(request, response);

            } catch (NullPointerException e) {
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }

        }

        if (strutspath.contains("l_addaccount")) {
            System.out.print("in side Action PSOT" + servletMapping + "\n internal name" + internalName + "\n servlet name" + servletName + "\n Path " + request.getRequestURI());
            request.setAttribute("ACCOUNT", new BsHeadHome().findByAccount());
        }

        if (strutspath.contains("l_newuser")) {
            System.out.print("in side L_NEWUSER" + servletMapping + "\n internal name" + internalName + "\n servlet name" + servletName + "\n Path " + request.getRequestURI());

            try {
                UserDetails user = (UserDetails) session.getAttribute("user");
                List ls = new UserDetailsHome().findByExample(user);
                request.setAttribute("USER", ls);
            } catch (NullPointerException e) {
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }

        if (strutspath.contains("l_addincome")) {
            System.out.print("in side L_NEWUSER" + servletMapping + "\n internal name" + internalName + "\n servlet name" + servletName + "\n Path " + request.getRequestURI());

            try {
                BsHeadHome bhome = new BsHeadHome();
                BsGroup bg = new BsGroupHome().findById(new Integer(5));
                List ls1 = bhome.findByBsGroup(bg);
                ls1.add(bhome.findById(6));
                request.setAttribute("CATEGORY", ls1);
                UserDetails user = (UserDetails) session.getAttribute("user");
                List ls = new CommonMethods().getAccountDetailsByUser(user);
                request.setAttribute("ACCOUNT", ls);
                List ls3=new UserDetailsHome().findByProperty("userRelevantId",user.getUserId() );
                request.setAttribute("RELUSER", ls3);
            } catch (NullPointerException e) {
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }
        if (strutspath.contains("l_addexpense")) {
            System.out.print("in side L_NEWUSER" + servletMapping + "\n internal name" + internalName + "\n servlet name" + servletName + "\n Path " + request.getRequestURI());
            BsHeadHome bhome = new BsHeadHome();
            BsGroup bg = new BsGroupHome().findById(new Integer(6));
            BsGroup bgLia = new BsGroupHome().findById(new Integer(3));
            List ls1 = bhome.findByBsGroup(bg);
            List ls2 = bhome.findByBsGroup(bgLia);

            List ls4=new ArrayList();
            ls4.addAll(ls1);
            ls4.addAll(ls2);
            ls4.add(bhome.findById(4));
            request.setAttribute("CATEGORY", ls4);
            UserDetails user = (UserDetails) session.getAttribute("user");
            List ls = new CommonMethods().getAccountDetailsByUser(user);
            request.setAttribute("ACCOUNT", ls);
            List ls3=new UserDetailsHome().findByProperty("userRelevantId",new Integer(user.getUserId()) );
                request.setAttribute("RELUSER", ls3);

        }
         if (strutspath.contains("l_transfer")) {
            System.out.print("in side L_transfer" + servletMapping + "\n internal name" + internalName + "\n servlet name" + servletName + "\n Path " + request.getRequestURI());

            try {
                BsHeadHome bhome = new BsHeadHome();
                BsGroup bg = new BsGroupHome().findById(new Integer(7));
                List ls1 = bhome.findByBsGroup(bg);
                request.setAttribute("CATEGORY", ls1);
                UserDetails user = (UserDetails) session.getAttribute("user");
                List ls = new CommonMethods().getAccountDetailsByUser(user);
                request.setAttribute("ACCOUNT", ls);

                //List ls3=new UserDetailsHome().findByProperty("userRelevantId",user.getUserId() );
                //request.setAttribute("RELUSER", ls3);
            } catch (NullPointerException e) {
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }

System.out.println("\n *****### before call super.getSession" + session.toString());
        super.doGet(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String strutspath = request.getRequestURI();

        doGet(request, response);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        HibernateSessionFactory.getSession();
    }


}
