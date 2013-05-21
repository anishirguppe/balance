/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balance.hib.util;

import com.balance.hib.bean.UserAccountDetails;
import com.balance.hib.bean.UserDetails;
import com.balance.hib.home.UserAccountDetailsHome;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author hcl
 */
public class BalanceCalUtil {

    public static Map calLiabilites(int userid) {
        Map<Integer, Double> liaMap = new HashMap<Integer, Double>();
        SessionFactory sf = HibernateSessionFactory.getSessionFactory();
        Session se = sf.openSession();
        List assetLS = se.getNamedQuery("getLiabilites").setInteger("USERID", userid).list();
        for (Iterator it = assetLS.iterator(); it.hasNext();) {
            Object object[] = (Object[]) it.next();
            System.out.println("" + object[0] + " " + object[1] + " ");
            liaMap.put(Integer.parseInt(object[0].toString()), Double.parseDouble(object[1].toString()));
        }
        return liaMap;
    }

    public static Map calAsset(int userid) {
        Map<Integer, Double> assetMap = new HashMap<Integer, Double>();
        SessionFactory sf = HibernateSessionFactory.getSessionFactory();
        Session se = sf.openSession();
        List assetLS = se.getNamedQuery("getAsset").setInteger("USERID", userid).list();
        for (Iterator it = assetLS.iterator(); it.hasNext();) {
            Object object[] = (Object[]) it.next();
            System.out.println("" + object[0] + " " + object[1] + " ");
            assetMap.put(Integer.parseInt(object[0].toString()), Double.parseDouble(object[1].toString()));
        }
        return assetMap;
    }

    public static Map calCurrentAsset(int userid) {
        Map<Integer, Double> currentassetMap = new HashMap<Integer, Double>();
        SessionFactory sf = HibernateSessionFactory.getSessionFactory();
        Session se = sf.openSession();
        List currentAssetLS = se.getNamedQuery("getCurrentAsset").setInteger("USERID", userid).list();
        for (Iterator it = currentAssetLS.iterator(); it.hasNext();) {
            Object object[] = (Object[]) it.next();
            System.out.println("" + object[0] + " " + object[1] + " " + " " + object[2]);
            currentassetMap.put(Integer.parseInt(object[0].toString()), Double.parseDouble(object[1].toString()));
        }

        return currentassetMap;
    }

    public static Map calCurrentLiabilities(int userid) {
        Map<Integer, Double> currentLi = new HashMap<Integer, Double>();
        SessionFactory sf = HibernateSessionFactory.getSessionFactory();
        Session se = sf.openSession();
        List currentLiabilitiesLS = se.getNamedQuery("getCurrentLiabilities").setInteger("USERID", userid).list();
        for (Iterator it = currentLiabilitiesLS.iterator(); it.hasNext();) {
            Object object[] = (Object[]) it.next();
            System.out.println("" + object[0] + " " + object[1] + " " + " " + object[2]);
            currentLi.put(Integer.parseInt(object[0].toString()), Double.parseDouble(object[1].toString()));
        }

        return currentLi;
    }

    public static List calCARByAC(int userid) {
        SessionFactory sf = HibernateSessionFactory.getSessionFactory();
        Session se = sf.openSession();
        List incomeACWise = se.getNamedQuery("getIncomeACwise").setInteger("USERID", userid).list();
        for (Iterator it = incomeACWise.iterator(); it.hasNext();) {
            Object object[] = (Object[]) it.next();
            System.out.println("" + object[0] + " " + object[1] + " " + "Heading  " + object[2]);
        }

        return incomeACWise;
    }

    public static Map getList2Map(List ls) {
        Map map = new HashMap();

        for (Iterator it = ls.iterator(); it.hasNext();) {
            Object object[] = (Object[]) it.next();
            String key = object[0].toString();
            map.put(key, object[1]);
        }
        return map;
    }

    public static void printMap(Map map1) {
        try {
            DecimalFormat myFormatter = new DecimalFormat("###,####.###");
            //myFormatter.format(value);
            TreeMap map = new TreeMap(map1);
            Set ketSet = map.keySet();
            for (Iterator it = ketSet.iterator(); it.hasNext();) {
                Integer key = Integer.parseInt(it.next().toString());
                Double value = Double.parseDouble(map.get(key).toString());
                System.out.println("KEY=" + key + " Values " + myFormatter.format(value));



            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Map changeInCAR(Map<Integer, Double> currentAsset, List car, int userid) {
        try {
            Double sum = 0d;
            for (Iterator it = car.iterator(); it.hasNext();) {
                Object IncomeDetails[] = (Object[]) it.next();
                Integer IncomeAC = (Integer) IncomeDetails[0];
                Double IncomeAmount = (Double) IncomeDetails[1]; // Income amount
                Integer head = (Integer) IncomeDetails[2];

                sum = sum + IncomeAmount;
                System.out.println("Income a/C " + IncomeAC + "  Income amount --> " + IncomeAmount + "  HEAD --> " + head);
                Double crntAstOB = 0d;
                Set s = currentAsset.keySet();

                if (s.contains(IncomeAC)) {
                    try {
                        String key = Integer.toString(IncomeAC);
                        crntAstOB = Double.parseDouble(currentAsset.get(IncomeAC).toString());
                        //  System.out.println("\n c as" + crntAstOB);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }



                    // opening bal or pervious opening balance
                }

                if (head == 6) // for Payable
                {
                    UserDetails ud = new UserDetails();
                    ud.setUserId(userid);
                    List<UserAccountDetails> usels = UserAccountDetailsHome.findPayableAccountByUser(ud);
                    UserAccountDetails useds = usels.get(0);
                    Integer accountid = useds.getUserAccountId();
                     Double expenseAmount1=0.0d;
                    for (Iterator it1 = car.iterator(); it1.hasNext();) {
                        Object IncomeDetails1[] = (Object[]) it1.next();
                        Integer expenseAC1 = (Integer) IncomeDetails[0];
                        if (expenseAC1 == accountid) {
                       expenseAmount1  = (Double) IncomeDetails[1]; // Income amount
                            Integer cat1 = (Integer) IncomeDetails[2];
                            break;
                        }
                    }

                    crntAstOB = expenseAmount1 + IncomeAmount;
                    // currentAsset.remove(4);
                    currentAsset.put(accountid, crntAstOB);
                    System.out.println(" cyrrenst asset st" + currentAsset.entrySet());
                }


                crntAstOB = crntAstOB + IncomeAmount;
                //System.out.println("\n c as" + crntAstOB);
                currentAsset.remove(IncomeAC);
                currentAsset.put(IncomeAC, crntAstOB);


            }//end for loop

            System.out.println("\n ---*****Total Income***----- " + sum);
        } catch (Exception e) {
            e.printStackTrace();

        }



        return currentAsset;

    }

    public static Map changeInExpense(Map<Integer, Double> currentAsset, List expense, int userid) {
        try {
            Double sum = 0d;

            System.out.println(" cyrrenst asset st" + currentAsset.entrySet());

            for (Iterator it = expense.iterator(); it.hasNext();) {
                Object IncomeDetails[] = (Object[]) it.next();
                Integer expenseAC = (Integer) IncomeDetails[0];
                Double expenseAmount = (Double) IncomeDetails[1]; // Income amount
                Integer cat = (Integer) IncomeDetails[2];

                sum = sum + expenseAmount;
                System.out.println("Expense a/C " + expenseAC + "  Expnese amount --> " + expenseAmount + "  \t Category " + cat);
                Double crntAstOB = 0d;
                Set s = currentAsset.keySet();

                
                if (s.contains(expenseAC)) {
                    try {
                        String key = Integer.toString(expenseAC);
                        crntAstOB = Double.parseDouble(currentAsset.get(expenseAC).toString());
                        System.out.println("\n key  as" + key + " \t amount" + crntAstOB);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                   // opening bal or pervious opening balance
                }
                if (cat == 4) { // for  Receivable
                    UserDetails ud = new UserDetails();
                    ud.setUserId(userid);
                    List<UserAccountDetails> usels = UserAccountDetailsHome.findReceviableAccountByUser(ud);
                    UserAccountDetails useds = usels.get(0);
                    Integer accountid = useds.getUserAccountId();
                    Double expenseAmount1=0.0d;
                    for (Iterator it1 = expense.iterator(); it1.hasNext();) {
                        Object IncomeDetails1[] = (Object[]) it1.next();
                        Integer expenseAC1 = (Integer) IncomeDetails[0];
                        if (expenseAC1 == accountid) {
                       expenseAmount1  = (Double) IncomeDetails[1]; // Income amount
                            Integer cat1 = (Integer) IncomeDetails[2];
                            break;
                        }
                    }
                    crntAstOB = expenseAmount1 + expenseAmount;
                    // currentAsset.remove(4);
                    currentAsset.put(accountid, crntAstOB);
                    System.out.println(" cyrrenst asset st" + currentAsset.entrySet());
                }
                else {
                    crntAstOB = crntAstOB - expenseAmount;
                }

                //System.out.println("\n c as" + crntAstOB);
                currentAsset.remove(expenseAC);
                currentAsset.put(expenseAC, crntAstOB);


            }//end for loop
            System.out.println("---*********Total Exp**********-----" + sum);

            System.out.println(" cyrrenst asset st" + currentAsset.entrySet());
        } catch (Exception e) {
            e.printStackTrace();

        }



        return currentAsset;

    }

    public static List calExpenseByAC(int userid) {
        SessionFactory sf = HibernateSessionFactory.getSessionFactory();
        Session se = sf.openSession();
        List expenseACWise = se.getNamedQuery("getExpenseACwise").setInteger("USERID", userid).list();
        for (Iterator it = expenseACWise.iterator(); it.hasNext();) {
            Object object[] = (Object[]) it.next();
            System.out.println("In side cal ExpBYAC " + object[0] + " " + object[1] + " " + " " + object[2]);
        }

        return expenseACWise;
    }

    public static List calTransfer(int userid) {

        List transferLS = new ArrayList();
        try {


            SessionFactory sf = HibernateSessionFactory.getSessionFactory();
            Session se = sf.openSession();
            transferLS = se.getNamedQuery("getTransfer").setInteger("USERID", userid).list();
            for (Iterator it = transferLS.iterator(); it.hasNext();) {
                Object object[] = (Object[]) it.next();
                System.out.println("cat  " + object[0] + " s ac  " + object[1]
                        + "D AC   " + object[2] + "  Amouint " + object[3]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transferLS;

    }

    public static Integer getAcIdForCash(int userid) {
        SessionFactory sf = HibernateSessionFactory.getSessionFactory();
        Session se = sf.openSession();
        List cashACLS = se.getNamedQuery("getAcIdForCash").setInteger("USERID", userid).list();
        Integer object = (Integer) cashACLS.get(0);
        System.out.println("" + object);
        return object;
    }

    public static Map<Integer, Double> changeInTransfer(Map<Integer, Double> allasset, int userid) {


        try {
            UserAccountDetailsHome userAccountDetailsHome=new UserAccountDetailsHome();
            UserAccountDetails userAccountDetails;
            Integer cashInHand = getAcIdForCash(userid);
            List transferLS = calTransfer(userid);
            printMap(allasset);
            for (Iterator it = transferLS.iterator(); it.hasNext();) {//for loop start
                Object trans[] = (Object[]) it.next();

                Integer cat = (Integer) trans[0];
                Integer sourceAC = (Integer) trans[1];
                Integer destinationAC = ((BigInteger) trans[2]).intValue();
//                ((BigInteger) result[1]).intValue()
                Double amount = (Double) trans[3];

                System.out.println("cat" + cat + "\t sac " + sourceAC + "\t DAC" + destinationAC + "\t Amount " + amount);
                if (cat.equals(44)) {
                    System.out.println("inside cat 44 with ac CIH" + cashInHand);
                    //for add cash in hand
                    Object key = cashInHand;
                    Double cashInHandAmount = Double.parseDouble(allasset.get(cashInHand).toString());
                    System.out.println("cash In hand " + cashInHandAmount);
                    cashInHandAmount = cashInHandAmount + amount;
                    //allasset.remove(cashInHand.toString() );
                    allasset.put(cashInHand, cashInHandAmount);

                    // for deduct amount from source ac
                    Double sourceACAmount = Double.parseDouble(allasset.get(sourceAC).toString());
                    sourceACAmount = sourceACAmount - amount;
                    //allasset.remove(sourceAC.toString());
                    allasset.put(sourceAC, sourceACAmount);

                    System.out.println("cash in hand " + cashInHandAmount + "\t ac amount " + sourceACAmount);

                }//end if
                else if (cat.equals(45)) {

                    if(userAccountDetailsHome.isReceivableAC(sourceAC))
                    {

                    }
                    System.out.println("inside cat 45");
                    //for add  in destination ac
                    Double destinationAmount = Double.parseDouble(allasset.get(destinationAC).toString());

                    destinationAmount = destinationAmount + amount;
                    // allasset.remove(destinationAC.toString());
                    allasset.put(destinationAC, destinationAmount);

                    // for deduct amount from source ac
                    Double sourceACAmount = Double.parseDouble(allasset.get(sourceAC).toString());

                    sourceACAmount = sourceACAmount - amount;
                    // allasset.remove(sourceAC.toString());
                    allasset.put(sourceAC, sourceACAmount);
                    System.out.println("Source ac bala " + allasset.get(sourceAC).toString() + "\t Destination  ac amount " + allasset.get(destinationAC).toString());
                }




            }//end for loop

            System.out.println("-----all Asset map after transfer");

            printMap(allasset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allasset;
    }

    public static void main(String[] args) {
        Map<String, Map> bfrct_account = finalBalanceSheet(3);

        Map<Integer, Double> cLai = bfrct_account.get("Current Liabilites");// cLia
        Map<Integer, Double> cAsset = bfrct_account.get("Current Assets");// cAsset;
        Map<Integer, Double> basset = bfrct_account.get("Assets"); //, asset);
        Map<Integer, Double> liabc = bfrct_account.get("Liabilites"); //, asset);

        System.out.println("\n---- Liabilites-------\n");
        printMapByAcName(liabc);

        System.out.println("\n----Current Liabilities-------\n");
        printMapByAcName(cLai);
        System.out.println("\n----Current Assets-------\n");
        printMapByAcName(cAsset);
        System.out.println("\n----Assets-------\n");
        printMapByAcName(basset);



//Income+exp= 329377.78
// 830,401.78

    }

    public static Map bfrct_Account(Map<Integer, Double> allaccount, Map<Integer, Double> asset, Map<Integer, Double> cAsset, Map<Integer, Double> cLia, Map<Integer, Double> lia, int userid) {
        Set assetKey = asset.keySet();
        Set cassetKey = cAsset.keySet();
        Set cliatKey = cLia.keySet();
        Set liatKey = lia.keySet();

        //liabilites
        for (Iterator it = liatKey.iterator(); it.hasNext();) {
            Integer key = Integer.parseInt(it.next().toString());
            Double value = Double.parseDouble(allaccount.get(key).toString());
            lia.put(key, value);
        }
        //current liab
        for (Iterator it = cliatKey.iterator(); it.hasNext();) {
            Integer key = Integer.parseInt(it.next().toString());
            Double value = Double.parseDouble(allaccount.get(key).toString());
            cLia.put(key, value);
        }
        //current asset
        for (Iterator it = cassetKey.iterator(); it.hasNext();) {
            Integer key = Integer.parseInt(it.next().toString());
            Double value = Double.parseDouble(allaccount.get(key).toString());

            cAsset.put(key, value);
            System.out.println(" cyrrenst " + cAsset.entrySet());
        }

        //Asset
        for (Iterator it = assetKey.iterator(); it.hasNext();) {
            Integer key = Integer.parseInt(it.next().toString());
            Double value = Double.parseDouble(allaccount.get(key).toString());
            asset.put(key, value);

        }

        Map<String, Map> bfrct_account = new HashMap<String, Map>();
        bfrct_account.put("Current Liabilites", cLia);
        bfrct_account.put("Current Assets", cAsset);
        bfrct_account.put("Assets", asset);
        bfrct_account.put("Liabilites", lia);


        return bfrct_account;
    }

    public static void printMapByAcName(Map<Integer, Double> map) {


        UserAccountDetailsHome useracdao = new UserAccountDetailsHome();
        TreeMap<Integer, Double> d = new TreeMap<Integer, Double>();
        d.putAll(map);
        Set key = d.keySet();
        Double sum = 0d;
        DecimalFormat myFormatter = new DecimalFormat("###,###,###.###");
        for (Iterator it = key.iterator(); it.hasNext();) {
            Integer objectKEY = Integer.parseInt(it.next().toString());
            System.out.println("" + useracdao.findById(objectKEY).getUserAccountName() + "\t" + myFormatter.format(d.get(objectKEY)));
            sum = sum + Double.parseDouble(d.get(objectKEY).toString());
        }

        System.out.println("Total sum " + myFormatter.format(sum));

    }

    public static List calReceivable(int userid) {
        SessionFactory sf = HibernateSessionFactory.getSessionFactory();
        Session se = sf.openSession();
        List receviable = se.getNamedQuery("getReceivable").setInteger("USERID", userid).list();
        for (Iterator it = receviable.iterator(); it.hasNext();) {
            Object object[] = (Object[]) it.next();
            System.out.println("In side receviable" + object[0] + " " + object[1]);
        }

        return receviable;
    }

    public static Map<String, Map> finalBalanceSheet(int userid) {


        // getAcIdForCash(userid);
        Map<Integer, Double> asset = calAsset(userid);
        Map<Integer, Double> currentasset = calCurrentAsset(userid);
        Map<Integer, Double> currentLiab = calCurrentLiabilities(userid);
        Map<Integer, Double> liab = calLiabilites(userid);
        calReceivable(userid);
        Map<Integer, Double> allasset = new HashMap();
        allasset.putAll(currentasset);
        allasset.putAll(asset);
        allasset.putAll(currentLiab);
        allasset.putAll(liab);

        printMap(allasset);
        List car = calCARByAC(userid);
        // printMap(currentasset);
        Map<Integer, Double> ch_Aft_Inc_All_asset = changeInCAR(allasset, car, userid);
//        System.out.println("---------INCOME -------------- ");
//        // printMap(changeCasset);
//        System.out.println("---------END--INCOME -------------- ");

        //changeInTransfer(Map currentAsset ,Map asset,int userid)

        Map<Integer, Double> ch_Aft_tran_All_Asset = changeInTransfer(ch_Aft_Inc_All_asset, userid);


        List exp = calExpenseByAC(userid);

        Map ch_Aft_Exp_All_asset = changeInExpense(ch_Aft_tran_All_Asset, exp, userid);
        System.out.println("---------AFTER expense -------------- ");
        printMapByAcName(ch_Aft_Exp_All_asset);


        //public static Map bfrct_Account(Map<Integer, Double> allaccount,Map<Integer, Double> asset ,Map<Integer, Double> cAsset,Map<Integer, Double> cLia,int userid)

        Map<String, Map> bfrct_account = bfrct_Account(allasset, asset, currentasset, currentLiab, liab, userid);
        Map<Integer, Double> cLai = bfrct_account.get("Current Liabilites");// cLia
        Map<Integer, Double> cAsset = bfrct_account.get("Current Assets");// cAsset;
        Map<Integer, Double> basset = bfrct_account.get("Assets"); //, asset);
        Map<Integer, Double> liabc = bfrct_account.get("Liabilites"); //, lia);

        System.out.println("\n---- Liabilites-------\n");
        printMapByAcName(liabc);

        System.out.println("\n----Current Liabilities-------\n");
        printMapByAcName(cLai);
        System.out.println("\n----Current Assets-------\n");
        printMapByAcName(cAsset);
        System.out.println("\n----Assets-------\n");
        printMapByAcName(asset);



        return bfrct_account;

    }//end finalBalancesheet

    public static String printMapByAcNameInHtml(Map<Integer, Double> map) {

        StringBuilder content = new StringBuilder();
        content.append("<table border='0.5'>");
        UserAccountDetailsHome useracdao = new UserAccountDetailsHome();
        TreeMap<Integer, Double> d = new TreeMap<Integer, Double>();
        d.putAll(map);
        Set key = d.keySet();
        Double sum = 0d;
        DecimalFormat myFormatter = new DecimalFormat("###,###,###.###");
        for (Iterator it = key.iterator(); it.hasNext();) {
            Integer objectKEY = Integer.parseInt(it.next().toString());
            System.out.println("" + useracdao.findById(objectKEY).getUserAccountName() + "\t" + myFormatter.format(d.get(objectKEY)));
            content.append("<tr><td>" + useracdao.findById(objectKEY).getUserAccountName() + "</td><td>" + myFormatter.format(d.get(objectKEY)) + "</td></tr>");
            sum = sum + Double.parseDouble(d.get(objectKEY).toString());

        }
        content.append("<tr ><td style='border-top-style:dotted'>Total</td><td style='border-top-style:dotted'>" + myFormatter.format(sum) + "</td></tr>");
        content.append("</table>");


        System.out.println("Total sum " + myFormatter.format(sum));

        return content.toString();
    }

    public static String calCAR(int userid) {
        SessionFactory sf = HibernateSessionFactory.getSessionFactory();
        Session se = sf.openSession();
        DecimalFormat myFormatter = new DecimalFormat("###,###,###.###");
        double sum = 0d;
        StringBuilder content = new StringBuilder();
        content.append("<table>");
        List incomeACWise = se.getNamedQuery("getCAR").setInteger("USERID", userid).list();
        for (Iterator it = incomeACWise.iterator(); it.hasNext();) {
            Object object[] = (Object[]) it.next();
            System.out.println("" + object[0] + " " + object[1] + "");
            Double val = Double.parseDouble(object[1].toString());
            //currentLi.put(Integer.parseInt(object[0].toString()), Double.parseDouble(object[1].toString()));
            content.append("<tr> <td>" + object[0].toString().toUpperCase() + "</td> <td>" + myFormatter.format(val) + "</td> </tr>");
            sum = sum + val;
        }
        content.append("<tr ><td style='border-top-style:dotted'>Total</td><td style='border-top-style:dotted'>" + myFormatter.format(sum) + "</td></tr>");
        content.append("</table>");
        return content.toString();
    }

    public static String calEXP(int userid) {
        SessionFactory sf = HibernateSessionFactory.getSessionFactory();
        Session se = sf.openSession();
        DecimalFormat myFormatter = new DecimalFormat("###,###,###.###");
        double sum = 0d;
        StringBuilder content = new StringBuilder();
        content.append("<table>");
        List expWise = se.getNamedQuery("getEXP").setInteger("USERID", userid).list();
        for (Iterator it = expWise.iterator(); it.hasNext();) {
            Object object[] = (Object[]) it.next();
            System.out.println("" + object[0] + " " + object[1] + "");
            Double val = Double.parseDouble(object[1].toString());
            //currentLi.put(Integer.parseInt(object[0].toString()), Double.parseDouble(object[1].toString()));
            content.append("<tr> <td>" + object[0].toString().toUpperCase() + "</td> <td>" + myFormatter.format(val) + "</td> </tr>");
            sum = sum + val;
        }
        content.append("<tr ><td style='border-top-style:dotted'>Total</td><td style='border-top-style:dotted'>" + myFormatter.format(sum) + "</td></tr>");
        content.append("</table>");
        return content.toString();
    }
}
