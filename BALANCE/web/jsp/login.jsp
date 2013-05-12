
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<script src="js/DropDown.js" type="text/javascript" ></script>
<script src="js/view.js" type="text/javascript" ></script>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/structure.css">
<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>

        <html:form action="/a_login"  >

            <fieldset >
                <logic:present name="usercreation" scope="request">
                      User Created Successful.
                </logic:present>
                <logic:present name="login" scope="request">
                    <bean:define id="login" name="login" scope="request" type="java.lang.String" />
                    <p> <b style="color: #D50000">

                            The username or password you entered is incorrect


                        </b></p>

                </logic:present>
                <table style="width:25%;height:7%;" align="center">
                    <tr><td>
                            <label>Username</label></td>
                        <td>
                            <html:text property="username"  tabindex="1"   />
                            <html:errors property="username" /></td></tr><tr>
                        <!--          <input type="text" tabindex="1" placeholder="PremiumPixel" required>-->
                        <td><label> Password</label></td>
                        <td><html:password property="password" tabindex="2" />
                            <html:errors property="password" /></td>
                    </tr>
                </table>



                <label><input type="checkbox" tabindex="3">Keep me logged in</label>
                    <html:submit value="LOGIN"/>

            </fieldset>

            <html:hidden property="v_hidden" value="Login" />

        </html:form>

    </body>
</html:html>
