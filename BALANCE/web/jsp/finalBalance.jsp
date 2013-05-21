<%-- 
    Document   : finalBalance
    Created on : 23 Jan, 2013, 5:27:49 PM
    Author     : AniRuddha
--%>

<%@page import="java.util.Map"%>
<%@page import="com.balance.hib.util.BalanceCalUtil"%>
<%@include file="init.jsp" %>

<div id="wrapper">

        <div>
            <jsp:include page="header.jsp" flush="true"/>
        </div>

<%
int userID=0;
        if(request.getAttribute("userID")!=null)
             {
          userID =Integer.parseInt(request.getAttribute("userID").toString());
              }

Map <String,Map> bfrct_account=BalanceCalUtil.finalBalanceSheet(userID);

        Map<Integer,Double> cLai=   bfrct_account.get("Current Liabilites");// cLia
        Map<Integer,Double> cAsset=bfrct_account.get("Current Assets");// cAsset;
         Map<Integer,Double> basset=bfrct_account.get("Assets"); //, asset);
         Map<Integer,Double> liabc=bfrct_account.get("Liabilites"); //, asset);

System.out.println("\n---- Liabilites-------\n");
//BalanceCalUtil.printMapByAcNameInHtml(liabc);

System.out.println("\n----Current Liabilities-------\n");
//BalanceCalUtil.printMapByAcNameInHtml(cLai);
System.out.println("\n----Current Assets-------\n");
//BalanceCalUtil.printMapByAcNameInHtml(cAsset);
System.out.println("\n----Assets-------\n");
//BalanceCalUtil.printMapByAcNameInHtml(basset);

%>
<table border="1" align="left" width="100%" style="vertical-align:text-top; ">
     <tbody>
         <tr style="background-color: wheat" >
             <td style="vertical-align: text-top;">
                Capital Account Receipt

                       
                
                

            </td>
            <td>
                    Asset
          

            </td>
        </tr>
        <tr>
            <td>
            

                        <%=BalanceCalUtil.calCAR(userID)%>



            </td>
            <td style="vertical-align: text-top;">
                   
             <%=BalanceCalUtil.printMapByAcNameInHtml(basset)%>

            </td>
        </tr>
        <tr style="background-color: wheat">
            <td>Expenditure Items </td>
    <td > Current Assets
                

            </td>
        </tr>
        <tr>
            <td style="vertical-align: text-top; " > <%=BalanceCalUtil.calEXP(userID)%></td>
            <td style="vertical-align: text-top;" > <%=BalanceCalUtil.printMapByAcNameInHtml(cAsset)%></td>

        </tr>

        <tr style="background-color: wheat">
            <td> Liabilites 
           

            </td>
            <td> </td>
        </tr>
        <tr><td><%=BalanceCalUtil.printMapByAcNameInHtml(liabc) %></td>
        </tr>
        <tr style="background-color: wheat">
            <td>
             Current Liabilites

                
                


            </td>
                <td></td>
        </tr>
        <tr><td><%=BalanceCalUtil.printMapByAcNameInHtml(cLai)%></td></tr>
    </tbody>
</table>
</div>
