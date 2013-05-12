<%@page import="com.balance.hib.bean.UserDetails"%>
<%@include file="init.jsp" %>

<link rel="stylesheet" type="text/css" media="screen" href="js/validation/screen.css" />
<script src="js/validation/jquery.js" type="text/javascript"></script>
<script src="js/validation/jquery.validate.js" type="text/javascript"></script>
<script type='text/javascript'>  
  
  var $jq = jQuery.noConflict();  
  
</script>  
<script type="text/javascript">
$(document).ready(function() {
     $("#submit").click(function()
     {
   
       if($jq("#newuser").validate().form())
           {
                var username=$('#username').val();
                var profilename=$('#profilename').val();
                var usergender=$('#usergender').val();
                var address=$('#address').val();
                var marriedstatus=$('#marriedstatus').val();
                var child= $('#child:checked').val() ;
                var datepicker =$('#datepicker').val() ;
                var userrelevantid=$("#userrelevantid").val();
                
                
                
               
              alert("hi true"+username+profilename+usergender+address+datepicker+"marriedstatus"+marriedstatus+"**child **"+child+userrelevantid); 
              $.ajax({
                 
                  url:"adduser.do?username="+username+"&profilename="+profilename+"&usergender="+usergender+"&datepicker="+datepicker+"&address="+address+"&marriedstatus="+marriedstatus+"&child="+child+"&userrelevantid="+userrelevantid+"",
                  success:function(data){//alert("Added successful");
                                           //$("#success").css("visibility", "visible");
                                           $("#success").show('slow');
                       //$("#error").css("visibility", "hidden");
                        $("#error").hide('slow');
                      $('#newuser').each (function(){this.reset();});
                      
                      
                      
                  },
                  error:function(){alert("error");
              
              //$("#success").css("visibility", "hidden");
               $("#success").hide('slow');
              //$("#error").css("visibility", "visible");
              $("#error").show('slow');
              }
                  
              })
             return false;
           }
        else {
                  //alert("hi false"+$jq("#addincome").validate().form());
            }
    });
    
});
</script>
  

    <style>
        input.text{
            
            width: 172px;
            background: url(images/textbox.png) repeat scroll 0% 0% transparent;
            border: 0px none;
            height: 30px;        
        }
    </style>
    
 

   
    <script type="text/javascript">
        //$(document).ready(function(){alert("i m ready");});
        
        
$(function() {
  $(  "#datepicker"  ).datepicker({ autoSize: true ,
changeMonth: true,
changeYear: true
});
 //getter
var autoSize = $(  "#datepicker"  ).datepicker( "option", "autoSize" );
//setter
$(  "#datepicker"  ).datepicker( "option", "autoSize", true );
            
  $( "#datepicker" ).datepicker({ dateFormat: "yy-mm-dd" });
  
 //getter
var dateFormat = $( "#datepicker" ).datepicker( "option", "dateFormat" );
//setter
$( "#datepicker" ).datepicker( "option", "dateFormat", "yy-mm-dd" );


$( "#datepicker" ).datepicker( "option", "showAnim", "slideDown" );
 //setter
        $( "#datepicker" ).datepicker( "option", "dateFormat", "yy-mm-dd" );


        $( "#datepicker" ).datepicker( "option", "showAnim", "slideDown" );

        $("#datepicker"  ).datepicker({ yearRange: "1900:2100" });

        //getter
        var yearRange = $("#datepicker"  ).datepicker( "option", "yearRange" );
        //setter
        $("#datepicker"  ).datepicker( "option", "yearRange", "1900:2100" );

	});
	</script>




<html:html>
    <head>
       
        
        
        <title>New User</title>
       <%-- <html:javascript formName="adduser" dynamicJavascript="true" staticJavascript="true" />--%>
       
       
   
    </head>
    <body>
           <div id="success" style=" color:#0066cc; display:none;"> <h4>Added Successfully.</h4> </div>
                <div id="error" style="color: red ;display: none;"><h4>Error in Update</h4> </div>
        <html:form action="/adduser"  styleId="newuser">
            <html:hidden property="v_hidden" value="User" />
        <h1>New User</h1>
        <table>
                       <tbody>
                <tr>
                    <td>Name</td>
                    <td><html:text property="username" styleId="username" styleClass="required" />
                    
                    </td>
                </tr>
                <tr>
                    <td>Profile Name</td>
                    <td> <html:text property="profilename" styleId="profilename" styleClass="required" /></td>
                </tr>
                  <tr>
                    <td>Date of Birth</td>
                    <td> <html:text property="dob" styleId="datepicker" styleClass="required"  /></td>
                    
                </tr>
                 <tr>
                    <td>Gender </td>
                    <td> 
                       <div style="width: 158px; height: 31px; float: left;">
                     <div style="width: 35px; height: 31px; float: left;">
                     <img style="cursor: pointer;" onclick="javascript:changegender(1);" src="images/male-select.gif" id="tick_img_gender_male">
                     </div>
                 <div style="width: 35px; height: 10px; margin-top: 5px; float: left;">
                  Male
                  </div>
                 <div style="width: 10px; height: 10px; margin-top: 5px; float: left;">
                  </div>
                 <div style="width: 35px; height: 31px; float: left;">
                 <img style="cursor: pointer;" onclick="javascript:changegender(2);" src="images/female.gif" id="tick_img_gender_female">
                  </div>
                  <div style="width: 35px; height: 31px; margin-top: 5px; float: left;">
                   Female
                  </div>
                 </div>
                        <html:hidden property="usergender" styleId="usergender" value="male" />

                    </td>
                    
                </tr>
                <tr>
                    <td>Address</td>
                    <td> <%UserDetails us= (UserDetails)session.getAttribute("user");
                       String add=us.getUserAddress();
                                          %><html:textarea property="address" value="<%=add%>" styleId="address" rows="4" cols="30%" styleClass="required" /></td>
                </tr>
                 <tr>
                    <td>Are you married? </td>
                    <td> 
                        <div style="width: 158px; height: 31px; float: left;">
                        <div style="width: 35px; height: 31px; float: left;">
                        <img style="cursor: pointer;" onclick="javascript:changestatus(1);" src="images/married-yes.gif" id="radio5">
                        </div>
                        <div style="width: 35px; height: 10px; margin-top: 5px; float: left;">
                        Yes
                        </div>
                        <div style="width: 10px; height: 10px; margin-top: 5px; float: left;">
                        </div>
                        <div style="width: 35px; height: 31px; float: left;">
                        <img style="cursor: pointer;" onclick="javascript:changestatus(2);" src="images/married-no-select.gif" id="radio">
                        </div>
                        <div style="width: 35px; height: 31px; margin-top: 5px; float: left;">
                        No
                        </div>
                        </div>
                      <html:hidden property="marriedstatus" styleId="marriedstatus" value="no" />
                    </td>
                </tr>
                <tr><td>
                        Do you have childrens ?  
                    </td><td>
                        <html:radio property="child"  styleId="child" value="yes" styleClass="required" > Yes</html:radio>
                        <html:radio property="child" styleId="child" value="no" styleClass="required" >No </html:radio>
                    </td>
                    
                </tr>
                <tr><td>
                         Relevant User
                    </td><td>
                        <html:select property="userrelevantid" styleId="userrelevantid" styleClass="required" >
                            <html:option value="">--select--</html:option>
                            <html:optionsCollection name="USER"  value="userId" label="userProfileName"/> 
                        </html:select>
                    </td>
                    
                </tr>
                <tr><td colspan="2"  style="text-align:center;padding-right:100px;  ">
                    <html:submit styleId="submit" />&nbsp;&nbsp;<html:reset onclick="  $('#error').hide('slow'), $('#success').hide('slow')"/>
                    
                    </td>
                    
                </tr>  
            </tbody>
        </table>
        </html:form>
    </body>
</html:html>
