<%-- 
    Document   : basicsubhead
    Created on : 7 Jun, 2012, 5:16:16 PM
    Author     : Aniruddha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
  <script src="js/DropDown.js" type="text/javascript" ></script>
<!DOCTYPE html>
<style type="text/css" >
.txtfields
{
	width:180px;
       
	background:#f4f2f2;
	border:1px solid #d5d3d3;
	padding:3px;
}
.txtfieldsmall
{
	width:100px;
	background:#f4f2f2;
	border:1px solid #d5d3d3;
	padding:3px;
}
.drpdwn
{
	width:70px;
	background:#f4f2f2;
	border:1px solid #d5d3d3;
	padding:3px;
}


</style>
<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
           
           <html:javascript formName="n_basicsubhead" dynamicJavascript="true" staticJavascript="true" />   
    </head>
    <body>
        <h1>Basic Head</h1>
        <html:form action="/a_basicsubhead" method="post" styleId="basicsubhead"  onsubmit="return validateN_basicsubhead(this);" >
            <html:hidden property="v_hidden" value="Basic Sub Head"/>
            <table>
                <tr>   <td>      Basic Group Name </td>
                    <%
                    String u="dropdownajax.do";
                      %>
                <script type="text/javascript">
                    var v='<%=u%>';
                   
                </script>
                <td><html:select property="bsheadgroupid" styleId="bsheadgroupid" styleClass="drpdwn" 
                           onchange="changeDropDown('bsheadgroupid','bssubheadid','bsHead',v,this,'basicsubhead')">
                             <html:option disabled="true" value="">--SELETE--</html:option>
                             <html:optionsCollection
                                 name="BSGROUP"
                                 value="bsId"
                                 label="bsName" />
                                                         
                         </html:select>
                            <html:errors property="bsheadgroupid" />
                              <img id="loading1" src="images/loading.gif" title="Loading" style="display: none;" />
                </td>
                  
                 
                    </tr>
                 <tr>   <td>      Basic Head Name </td>
                     <td><html:select property="bssubheadid" styleId="bssubheadid" styleClass="drpdwn" >
                             <html:option disabled="true" value="">--SELETE--</html:option>
                              <html:optionsCollection
                                 name="BSSUBHEAD"
                                 value="bsHeadId"
                                 label="bsHeadName" />
                             
                         </html:select>
                            <html:errors property="bssubheadid" /></td>
                    </tr>
                <tr><td>
                    Basic Sub-Head Name  </td>
                    <td>  <html:text property="bssubheadname" styleId="bssubheadname"
                               onblur="checkbsgroup(this,'bsSubHead')"
                               styleClass="txtfields"/>
                        <img id="loading" src="images/loading.gif" title="Loading" style="display: none;" />
                    <html:errors property="bssubheadname" /></td>
                    </tr>
                    
                    <tr>   <td>      Basic Sub-Head Initial </td>
                        <td><html:text property="bssubheadinitial" styleId="bssubheadinitial"  styleClass="txtfields" />
                            <html:errors property="bssubheadinitial" /></td>
                    </tr><tr><td colspan="2" style="text-align: center">          
                            <html:submit  /><html:reset/></td></tr>
            </table>
            
        </html:form>
        
    </body>
    
</html:html>

