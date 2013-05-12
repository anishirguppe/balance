/*
 * Copyright 2012 Aniruddha.
 * and open the template in the editor.
 */
package com.balance.util;

import com.balance.hib.bean.ExpenseEntry;
import com.balance.hib.bean.IncomeEntry;
import com.balance.hib.bean.UserAccountDetails;
import com.balance.hib.bean.UserDetails;
import com.balance.hib.home.UserAccountDetailsHome;
import com.balance.hib.home.UserDetailsHome;
import com.balance.hib.util.HibernateSessionFactory;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;

/**
 *
 * @author hcl
 */
public class CommonMethods {

    public static List<ExpenseEntry> getUserExpenseByUserId(Integer userId) {
        Query queryObject=null;
        List<ExpenseEntry> ls =new ArrayList<ExpenseEntry>();
        try {
            
        String queryString = "from ExpenseEntry where userDetails.userId="+userId+" order by expenseDate desc";
            System.out.println("qury "+queryString);
     queryObject=HibernateSessionFactory.getSession().createQuery(queryString);
       ls= queryObject.list();
            System.out.println("qury "+ls.size());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
               
	return queryObject.list(); 
    }

    public static List getAccountDetailsByUser(UserDetails user) {
        List<UserAccountDetails> lsusracc = new ArrayList<UserAccountDetails>();
        try {


            System.out.println("user id" + user.getUserId());
            lsusracc = new UserAccountDetailsHome().findAccountByUser(user);
            System.out.println("list size" + lsusracc.size());
            //System.out.println("user id"+lsusracc.get(1).getUserAccountId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsusracc;
    }

    public static List getUserDetailsByRelUserId(UserDetails user) {
        List<UserDetails> lsusracc = new ArrayList<UserDetails>();
        try {


            System.out.println("user id" + user.getUserId());
            lsusracc = new UserDetailsHome().findByRelId(user.getUserId());
            System.out.println("list size" + lsusracc.size());
            //System.out.println("user id"+lsusracc.get(1).getUserAccountId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsusracc;
    }
    
    public static java.sql.Date stringTOSqlDate(String strdate) {
        java.sql.Date sqlDate = null;
        try {
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            java.util.Date date = format.parse(strdate);
            sqlDate = new java.sql.Date(date.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sqlDate;
    }

    public static java.util.Date stringTODate(String strdate) {
        java.util.Date date = null;
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            date = format.parse(strdate);

        } catch (Exception e) {

            e.printStackTrace();

        }
        return date;
    }

    
    public static List getUserIncomeByUserId(Integer userid)
    {
        Query queryObject=null;
        List<IncomeEntry> ls =new ArrayList<IncomeEntry>();
        try {
            
        String queryString = "from IncomeEntry where userDetails.userId="+userid+" order by incomeDate desc";
            System.out.println("qury "+queryString);
     queryObject=HibernateSessionFactory.getSession().createQuery(queryString);
       ls= queryObject.list();
            System.out.println("qury "+ls.size());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
               
	return queryObject.list(); 
    }
    public static void main(String arg[]) {
        java.sql.Date sqldate = CommonMethods.stringTOSqlDate("35/12/2500");
        System.out.println("sql date" + sqldate.toString());
getUserIncomeByUserId(1);


    }
}
