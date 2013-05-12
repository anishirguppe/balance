<%-- 
    Document   : newjsp
    Created on : 7 Jun, 2012, 10:31:49 AM
    Author     : Aniruddha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<script src="js/DropDown.js" type="text/javascript" ></script>
<!DOCTYPE html>
<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <html:javascript formName="n_basicgroup" dynamicJavascript="true" staticJavascript="true" />

    </head>
    <body>
        <h1>Hello World! basic group</h1>
   <font color="blue"><html:errors /></font><br/>
        <html:form action="/a_basicgroup"  method="post" 
                   onsubmit="return validateN_basicgroup(this);"                 >
            <html:hidden property="v_hidden" value="Basic Group" />
            <table><tr><td>
                    Basic Group Name  </td>
                    <td>  <html:text property="bsgroupname"  onblur="checkbsgroup(this,'bsGroup')" />
                            <img id="loading1" src="images/loading.gif" title="Loading" style="display: none;" />
                    <html:errors property="bsgroupname" />
                    
                    </td>
                    </tr>
                    <tr>   <td>      Basic Group Initial </td><td><html:text property="bsgroupinitial" />
                            <html:errors property="bsgroupinitial" /></td>
                    </tr><tr><td colspan="2" style="text-align: center;">           <html:submit/><html:reset/></td></tr>
            </table>
            
        </html:form>
    </body>
</html:html>
