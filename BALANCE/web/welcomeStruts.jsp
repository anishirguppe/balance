

<%@include file="jsp/init.jsp" %>
<link rel="stylesheet" type="text/css" href="js/style.css" />
<link type="text/css" href="css/jquery-ui-1.8.22.custom.css" rel="stylesheet" />

<script src="js/jquery-1.7.2.js"> </script>
<script src="js/jquery.bgiframe-2.1.2.js"></script>
<script src="js/jquery.ui.core.js"></script>

<script src="js/jquery.ui.widget.js"></script>
<script src="js/jquery.ui.dialog.js"></script>
<script src="js/jquery.ui.mouse.js"></script>
<script src="js/jquery.ui.draggable.js"></script>
<script src="js/jquery.ui.position.js"></script>
<script src="js/jquery.ui.resizable.js"></script>
<script src="js/jquery.effects.core.js"></script>
<script src="js/jquery.effects.blind.js"></script>
<script src="js/jquery.effects.explode.js"></script>
<!--<script type="text/javascript" >
  
$(document).ready(function() {
		$("#viewuser").click(function(){
                    $.ajax({
                           url:"dropdownajax.do?method=myView&g_value=income",
                            success : function(data) {
				
				$("#dialogview").append(data);
			        } 
                            
                        })
                        
                        
                        
		});
	});  
   
        
        
    
    
    
</script>    -->
        
  
<script type="text/javascript">
    
    // view  increase the default animation speed to exaggerate the effect
    $.fx.speeds._default = 100;
    $(function() {
       $( "#dialogview,#dialog" ). dialog({
            autoOpen: false,
            show: "blind",
            hide: "slide"
            
        });
        //width
        $( "#dialogview,#dialog" ).dialog({
            autoOpen: false,
            show: "blind",
            hide: "slide",
            width: 760,
            height: 760
        
              });
        var width = $( "#dialogview,#dialog" ).dialog( "option", "width" );
        $( "#dialogview,#dialog" ).dialog( "option", "width", 760 );

  
        $( "#viewuser" ).click(function() {
            $( "#dialogview" ).dialog( "open" );
            return false;
        });
        $("#opener").click(function() {
         $( "#dialog" ).dialog( "open" );
            return false;
        });
    });
</script>

   <<script type="text/javascript">
   
   //open 
   
   
    $(function() {
        $( "#addexpensedioalog" ).dialog({
            autoOpen: false,
            show: "blind",
            hide: "slide"
        });
        //width
        $( "#addexpensedioalog" ).dialog({
            autoOpen: false,
            title : 'Add Expense',
            show: "blind",
            hide: "slide",
            width: 460 });
        var width = $( "#addexpensedioalog" ).dialog( "option", "width" );
        $( "#addexpensedioalog" ).dialog( "option", "width", 460 );
  
        $( "#addexpense" ).click(function() {
                    
            $( "#addexpensedioalog" ).dialog( "open" );
            return false;
        });

    });
</script>
<script type="text/javascript">

function showUrlInDialog(url, options){
   // alert(url);
  options = options || {};
  var tag = $("<div></div>");//.css({height:"350px", overflow:"auto" }); //This tag will the hold the dialog content.
  $.ajax({
    url: url,
    type: (options.type || 'GET'),
    beforeSend: options.beforeSend,
    error: options.error,
    complete: options.complete,
    success: function(data, textStatus, jqXHR) {
       
      if(typeof data == "object" && data.html)
        { //response is assumed to be JSON
           // alert(data.toString());
            tag.html(data.html).dialog({modal: options.modal, title:options.title,show: "blind",
            hide: "slide",
            width: 'auto' }).dialog('open');
        } 
      else 
       { //response is assumed to be HTML
          // alert("else"+data.toString());
        tag.html(data).dialog({modal: options.modal, title: options.title,show: "blind",
            hide: "slide",
            width: 'auto' }).dialog('open');
        //alert("after open tag");
       }
      $.isFunction(options.success) && (options.success)(data, textStatus, jqXHR);
    }
  });
}
</script>
<style>

    #div1 hr {
        border: 0;
        color: #9E9E9E;
        background-color: #9E9E9E;
        height: 5px;
        width: 100%;
        text-align: left;
    }

    #note{

        font-size: 15px;
    }

</style>

<body>


    <div id="wrapper">

        <div>
            <jsp:include page="jsp/header.jsp" flush="true"/>
        </div>

        <p>
        <h1> Prepare your Balance Sheet </h1>
    
            <p><html:link page="/l_basicgroup.do">ADD BASIC GROUP</html:link></p>
            <p><html:link page="/l_basichead.do?sub=0">ADD BASIC HEAD</html:link></p>
            <p><html:link page="/l_basichead.do?sub=1">ADD BASIC SUB HEAD</html:link></p>


    <div class="demo">

<%--        <div id="dialog" title="Add Income">
            <p>
                <jsp:include page="/l_addincome.do" flush="true"/>
            </p>
        </div>
      
 <div id="dialogview" title="View Income">
            <p>                
                <jsp:include flush="true" page="/l_viewincome.do" />
            </p>
        </div> --%>
       
   

    </div>
 
           

    <div id="div1" align="center">
        <table  width="90%" align="center">
            <tr>
            <td colspan="4">
                <hr/>
                </tr>
            <tr align="center">
            <td>One Time basis </td>
            <td> 
<!--                /l_newuser.do-->
             <%-- <html:link page="/l_newuser.do" >--%>
                  <div style="padding-left:10px;">
                        <img src="images/user_add.png" width="48" height="48" alt="Add User" />
                    </div>
                    New User
                <%--</html:link>--%>
              <p>
                     <a href="#" onclick="showUrlInDialog('l_newuser.do', {error: function() { alert('Could not load form') }, title: 'New User' }); return false;">Add </a>
                     &nbsp;&nbsp;
                     <a href="#" onclick="showUrlInDialog('dropdownajax.do?method=myView&g_value=user', {error: function() { alert('Could not load form') }, title: 'Users' }); return false;">View </a>
                </p>    
                <div id="note"> (Add new user of your Family <br/> member, or partner as sub-User like Mr.Sachin)</div>
            </td>
            <td>
                <img src="images/right-arrow.gif" width="48" height="48" />

            </td>
            <td> 
<!--                /l_addaccount.do-->
<%--                <html:link page="/l_addaccount.do" >--%><div style="padding-left:10px;">
                        <img src="images/user_add.png" width="48" height="48" alt="Add User" /></div>

                    New User Account
               <%-- </html:link> --%><p>
                    <a href="#" onclick="showUrlInDialog('l_addaccount.do', {error: function() { alert('Could not load form') }, title: 'New User Account' }); return false;">Add </a>
                    &nbsp;&nbsp;
                     <a href="#" onclick="showUrlInDialog('dropdownajax.do?method=myView&g_value=bankaccount', {error: function() { alert('Could not load form') }, title: 'Account' }); return false;">View </a>
               </p> 
                <div id="note"> (You can add new user Account like Bank A/C ,<br/>  Mr.Sachin Axis bank Saving A/C  etc )</div>
                
            </td>

            </tr>
            <tr>
            <td colspan="4">
                <hr/>
                </tr>

            <tr align="center">
            <td colspan="4">
                <img src="images/down-arrow.png" width="48" height="48" />
                </tr>
            <tr>
            <td colspan="4">
                <hr/>
                </tr>
            <tr align="center">
            <td>Daily basis </td>
            <td> 
                <%--<html:link page="/l_addincome.do" > --%>
                    <div style="padding-left:10px;">
                        <img src="images/calculator.png" width="48" height="48" alt="Add Income" /></div>
                     Income
                <%--</html:link> --%>
                <p>
                     <a href="#" onclick="showUrlInDialog('l_addincome.do', {error: function() { alert('Could not load form') }, title: 'Add Income' }); return false;">Add </a>
                     &nbsp;&nbsp;
                     <a href="#" onclick="showUrlInDialog('dropdownajax.do?method=myView&g_value=income', {error: function() { alert('Could not load form') }, title: 'Income' }); return false;">View </a>
                </p>  
                <div id="note"> (You can add Your Daily or Monthly income)</div>
            </td>
            <td>
                <img src="images/right-arrow.gif" width="48" height="48" />

            </td>
            <td> 
                <%--  <html:link page="/l_addexpense.do" > --%>
                    <div style="padding-left:10px;">
                        <img src="images/calculator.png" width="48" height="48" alt="Add Expense" /></div>

                    Expense
                <%--</html:link> --%>
                <p>
                     <a href="#" onclick="showUrlInDialog('l_addexpense.do', {error: function() { alert('Could not load form') }, title: 'Add Expense' }); return false;">Add </a>
                     &nbsp;&nbsp;
                     <a href="#" onclick="showUrlInDialog('dropdownajax.do?method=myView&g_value=expense', {error: function() { alert('Could not load form') }, title: 'Expense' }); return false;">View </a>
                </p>
                    <div id="addexpense" >ADD</div> 
                <div id="note"> (You can add Your Daily or Monthly Expenses)</div>
            </td>

            </tr>
            <tr>
            <td colspan="4">
                <hr/>
                </tr>
            <tr align="center">
            <td colspan="4">
                <img src="images/down-arrow.png" width="48" height="48" />
            </td>
                </tr>
            <tr>
            <td colspan="4">
                <hr/>
                </tr>
            <tr align="center">
            <td>frequently  basis </td>
            <td colspan="3"> <div style="padding-left:10px;">
                        <img src="images/transfer.jpg" width="80" height="80" alt="Transfer" />
                        <p><a href="#" onclick="showUrlInDialog('l_transfer.do', {error: function() { alert('Could not load form') }, title: 'Transfer' }); return false;">Transfer </a></p>
                        <p><a href="#" onclick="showUrlInDialog('dropdownajax.do?method=myView&g_value=transfer', {error: function() { alert('Could not load form') }, title: 'Transfer' }); return false;">Transfer View </a></p>


                    </div>
                
                
                <div id="note"> (Do your cash withdrawal and A/C to A/C transfer)</div>
            </td>
        
            </tr>
            
                <tr align="center">
            <td colspan="4">
            <hr/>
            </td>
                </tr>
        
            
            <tr align="center">
            <td colspan="4">
                <img src="images/down-arrow.png" width="48" height="48" />
                </tr>
            <tr>
            <td colspan="4">
                <hr/>
                </tr> 
            <tr align="center">
            <td>Monthly basis </td>
            <td colspan="3"> <html:link page="/l_calBalance.do" ><div style="padding-left:10px;">
                        <img src="images/balance.jpeg" width="60" height="60" alt="Add Income" /></div>
                    Prepare Balance sheet 
                </html:link> 
                <div id="note"> (Create your monthly balance sheet)</div>
            </td>

            </tr>  
            <tr>
            <td colspan="4">
                <hr/>
                </tr> 
        </table>

    </div>

    </div>



    <logic:notPresent  name="v_hidden" scope="request">

    </logic:notPresent>
    <%--<logic:present name="v_hidden" scope="request">
        <bean:define id="v_hid" name="v_hidden" scope="request" type="java.lang.String" />
        <p> <b> <bean:write name="v_hid" /> 
                Added Successfully ! </b></p>

        </logic:present> --%>
    <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
        <div  style="color: red">
            ERROR:  Application resources not loaded -- check servlet container
            logs for error messages.
        </div>
    </logic:notPresent>   


  
</body>

