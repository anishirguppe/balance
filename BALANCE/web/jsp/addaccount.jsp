<%@include file="init.jsp" %>
<link rel="stylesheet" type="text/css" media="screen" href="js/validation/screen.css" />

<script src="js/validation/jquery.js" type="text/javascript"></script>
<script src="js/validation/jquery.validate.js" type="text/javascript"></script>
<script type='text/javascript'>

    var $jq = jQuery.noConflict();

</script>
<script type="text/javascript">
    $(document).ready(function() {
        $("#accounttype").change(function(){
        var accounttype=$('#accounttype option:selected').val() ;
//alert(accounttype);
   if(accounttype=='8')
    {
     $("#subaccount").show('slow');

    }//end if
    else{$("#subaccount").hide();}

        });//end change drop down

        $("#submit").click(function(){

            if($jq ("#addaccount").validate().form())
            {

                var openingbalance= $('#openingbalance').val() ;
                var accounttype=$('#accounttype option:selected').val() ;
                 
                var accountsubtype=0;
                 if(accounttype=='8')
                 {
                accountsubtype=$('#bssubheadid option:selected').val() ;
                 }
                 else
                     {
                          accountsubtype=0;

                     }
                var accountname=$('#accountname').val() ;
                var accountno =$('#accountno').val() ;
                var branchname=$("#branchname").val();
                var bankname=$("#bankname").val();
               

//alert("a_addaccount.do?openingbalance="+openingbalance+"&accounttype="+accounttype+"&accountsubtype="+accountsubtype+"&accountname="+accountname+"&accountno="+accountno+"&branchname="+branchname+"&bankname="+bankname+"");
                   //alert("sub head"+accountsubtype +"bsheadgroupid="+bsheadgroupid+"&bssubheadid="+bssubheadid+"&relevantAccountid="+relevantAccountid+"&datepicker="+datepicker+"&amount="+amount+"&remarksid="+remarksid+"");
                $.ajax({
                   url:"a_addaccount.do?openingbalance="+openingbalance+"&accounttype="+accounttype+"&accountsubtype="+accountsubtype+"&accountname="+accountname+"&accountno="+accountno+"&branchname="+branchname+"&bankname="+bankname+"",
                    success:function(data){//alert("Added successful");
                        $("#success").show('slow');
                        $("#error").hide('slow');
                        $('#addaccount').each (function(){this.reset();});



                    },
                    error:function(){alert("error");

                        $("#success").hide('slow');
                        $("#error").show('slow');
                    }

                })
                return false;
            }
            else {
                //alert("hi false"+$jq("#addincome").validate().form());
            }
            return false;
        });

    });
</script>

<html:html>
    <head>


        <style>
            input.text{

                width: 172px;
                background: url(images/textbox.png) repeat scroll 0% 0% transparent;
                border: 0px none;
                height: 30px;
                padding:10px;
            }
        </style>
    </head>
    <body>
        <%
                    String u = "dropdownajax.do";
        %>
        <script type="text/javascript">
                    var v='<%=u%>';
                   
        </script>
        <div id="success" style=" color:#209D9D;  display: none;"> <h3>Added Successfully.</h3> </div>
        <div id="error" style="color: red ;display: none;"><h3>Error in Update</h3> </div>
        <h2>Add New Account</h2>
        <html:form action="a_addaccount"  method="post" styleId="addaccount" >

            <table style="height:100px ">
                <tbody>
                    <tr>
                        <td>Account Type</td>
                        <td>
                            <html:select property="accounttype" styleId="accounttype" styleClass="required" 
                                 onchange="changeDropDown('bsheadid','bssubheadid','bsSubHead',v,this,'addaccount')" >

                                <html:option value="" >--SELETE--</html:option>

                                <html:optionsCollection name="ACCOUNT" value="bsHeadId" label="bsHeadName"/>

                            </html:select>
                            <img id="loading1" src="images/loading.gif" title="Loading" style="display: none;" />
                        </td>
                    </tr>
                    <tr style="display: none;" id="subaccount" >   <td>     Account Sub-Type  </td>
                                         <td><html:select property="bssubheadid" styleId="bssubheadid"  styleClass="required drpdwn" >
                                                 <html:option disabled="true" value="">--SELETE--</html:option>

                                             </html:select>
                                                <html:errors property="bssubheadid" /></td>
                                        </tr>
                    <tr>
                        <td>Account Name</td>
                        <td><html:text property="accountname" styleId="accountname" styleClass="required" />
                            <html:errors property="accountname" /></td>
                    </tr>
                    <tr>
                        <td>Bank Name</td>
                        <td><html:text property="bankname" styleId="bankname"  />
                            <html:errors property="bankname" /></td>
                    </tr>
                    <tr>
                        <td>Branch Name</td>
                        <td> <html:text property="branchname" styleId="branchname" />
                            <html:errors property="branchname" /></td>
                    </tr>

                    <tr>
                        <td>Account No.</td>
                        <td>  <html:text property="accountno" styleId="accountno" />
                            <html:errors property="accountno" /></td>
                    </tr>


                    <tr>
                        <td>Opening Balance </td>
                        <td>  <html:text property="openingbalance" styleId="openingbalance" styleClass="required number" />
                            <html:errors property="openingbalance" /></td>
                    </tr>


                    <tr>

                        <td colspan="2" style="text-align: center" >
                            <html:submit styleId="submit"/>&nbsp;&nbsp;&nbsp;<html:reset  onclick="  $('#error').hide('slow'), $('#success').hide('slow')"/>
                        </td>

                    </tr>

                </tbody>
            </table>




















        </html:form>


    </body>
</html:html>
