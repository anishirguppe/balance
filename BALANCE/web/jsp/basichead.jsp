<%-- 
    Document   : basichead
    Created on : 7 Jun, 2012, 11:30:38 AM
    Author     : hcl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<script src="js/DropDown.js" type="text/javascript" ></script>
<!DOCTYPE html>
<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <html:javascript formName="n_basichead" dynamicJavascript="true" staticJavascript="true" />
    </head>
    <body>
        <h1>Basic Head</h1>
        <html:form action="/a_basichead" method="post" onsubmit="return validateN_basichead(this);">
            <html:hidden property="v_hidden" value="Basic Head"/>
            <table>
                 <tr>   <td>      Basic Group Name </td>
                     <td><html:select property="bsheadgroupid">
                             <html:option disabled="true" value="">--SELETE--</html:option>
                             <html:optionsCollection
                                 name="BSGROUP"
                                 value="bsId"
                                 label="bsName"/>
                            
                             
                         </html:select>
                            <html:errors property="bsheadgroupid" /></td>
                    </tr>
                <tr><td>
                    Basic Head Name  </td>
                    <td>  <html:text property="bsheadname" onblur="checkbsgroup(this,'bsHead')" />
                         <img id="loading1" src="images/loading.gif" title="Loading" style="display: none;" />
                    <html:errors property="bsheadname" /></td>
                    </tr>
                    
                    <tr>   <td>      Basic Head Initial </td><td><html:text property="bsheadinitial" />
                            <html:errors property="bsheadinitial" /></td>
                    </tr><tr><td colspan="2" style="text-align: center;">           <html:submit/>
                                   <html:reset/>
                                   </td>
                    </tr>
            </table>
            
        </html:form>
        
    </body>
</html:html>
