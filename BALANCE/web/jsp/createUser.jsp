


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

            if($jq("#createUser").validate().form())
            {
                
            }
            else {
                //alert("false"+$jq("#createUser").validate().form());
                return false;
            }
           
        });

        $("#profilename").blur(function(){

            var ajaxRequest;  // The variable that makes Ajax possible!

            $('#loading1').show();
	
            try{
                //         // Opera 8.0+, Firefox, Safari
                //         alert("url"+path);
                ajaxRequest = new XMLHttpRequest();

            } catch (e){
                // Internet Explorer Browsers
                try{
                    ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e) {
                    try{
                        ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
                    } catch (e){
                        // Something went wrong
                        alert("Your browser broke!");
                        return false;
                    }
                }
            }
            url="dropdownajax.do?method=checkUserProfileName&g_value="+$("#profilename").val();
            ajaxRequest.onreadystatechange=change;
            ajaxRequest.open("POST",url, true);
            ajaxRequest.send(null);
            function change()
            {
                if(ajaxRequest.readyState >3){
                    //  alert(ajaxRequest.readyState);
                    if(ajaxRequest.readyState == 4){
                        // alert(ajaxRequest.status);
                        if(ajaxRequest.status==200)
                        {
                            //alert("text --"+ajaxRequest.responseText.toString());
                            var valid=ajaxRequest.responseText.toString();
                            if(valid==0)
                            { }
                            else
                            {
                                alert("\""+$("#profilename").val()+"\" Profile Name is not Available ");
                                $("#profilename").val("");
                                $("#profilename").focus();}
                        }//end if ajaxRequest.status
                    }//end of ajaxRequest.readyState
                }
                $('#loading1').hide();
            }// end of function
            // alert(obj.value);

            // alert(""+$("#profilename").val());
            
           

        });//end blur

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

        $("#datepicker"  ).datepicker({ yearRange: "1900:2100" });

        //getter
        var yearRange = $("#datepicker"  ).datepicker( "option", "yearRange" );
        //setter
        $("#datepicker"  ).datepicker( "option", "yearRange", "1900:2100" );

        $("#datepicker").watermark('YYYY-MM-DD');
        $("#fname").watermark('First Name');
        $("#lname").watermark('Last Name');


    });
        
        
        
</script>


<html:html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User Account </title>


    </head>

    <body>
        <div style="padding:5px;  ">
            <h1> Create a new User Account</h1>
        </div>
        <html:form action="a_createuser" method="post" styleId="createUser" styleClass="box createuser">

            <table width="648" height="450">

                <tbody>
                    <tr>
                        <td>Name</td>
                        <td><html:text property="fname" styleId="fname" styleClass="required" style="placeholder=fname;"  />
                            <html:text property="lname" styleId="lname" styleClass="required" />
                        </td>
                    </tr>
                    <tr>
                        <td>Mobile Number <br></td>
                        <td> <html:text property="mobileno" styleId="mobileno"   styleClass="required number"  /></td>
                    </tr>
                    <tr>
                        <td>Mail Id <br></td>
                        <td> <html:text property="mail" styleId="mail"  styleClass="required email"  /></td>
                    </tr>
                    <tr>
                        <td>Date of Birth</td>
                        <td> <html:text property="dob" styleId="datepicker"   styleClass="required date"  /></td>

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
                        <td> <html:textarea property="address" styleId="address" rows="7" styleClass="required" cols="40" /></td>
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
                            <html:radio property="child" value="yes" > Yes</html:radio>
                            <html:radio property="child" value="no" >No </html:radio>
                        </td>

                    </tr>
            </table>
            <div style="width:600">
                <hr>
            </div>
            <table width="444" height="137">
                <tr>
                    <td>Profile Name / User Name&nbsp; <br></td>
                    <td> <html:text property="profilename" styleId="profilename"  styleClass="required"/> <img id="loading1" src="images/loading.gif" title="Loading" style="display: none;" /></td>
                </tr>
                <tr><td>
                        Password
                    </td><td><html:password property="userpassword" styleId="userpassword" styleClass="required"  maxlength="12"></html:password><br></td>

                </tr>
                <tr><td valign="top">Re-enter Password<br></td><td valign="top">
                        <html:password styleClass='required equalTo["#userpassword"]'  styleId="repassword" property="repassword"  maxlength="12">

                        </html:password><br></td></tr><tr>
                    <td colspan="2" style="text-align:center;padding-right:100px;  ">
                        <html:submit styleId="submit" value="Create User"></html:submit>
                        <html:reset/>

                        <br></td>

                </tr>  
            </tbody>
        </table>
    </html:form>
</body>
</html:html>
