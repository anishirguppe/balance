
<%@include file="init.jsp" %>

    <style>
        input.text{
            
            width: 172px;
            background: url(images/textbox.png) repeat scroll 0% 0% transparent;
            border: 0px none;
            height: 30px;        
        }
    </style>
<script  type="text/javascript">
    
    $(document).ready(function(){
       $("#expense").find("#reluser").hide();
        $("#expense").find("#bsheadgroupid").change(function(){
            //alert("mi  ahe");
          if($("#expense").find("#bsheadgroupid").val()=='27' || $("#expense").find("#bsheadgroupid").val()=='36')
              {
                 $("#expense").find("#reluser").show(); 
              }
          else
              {
                  $("#expense").find("#reluser").hide();
                  $('#relevantUserId').val()='0';
              }
            
            
        } );
        
        
    } );
    
</script>
  <script type="text/javascript">
$(function() {
  $("#expense").find("#datepicker").datepicker({ autoSize: true ,
changeMonth: true,
changeYear: true
});
 //getter
var autoSize = $("#expense").find(  "#datepicker"  ).datepicker( "option", "autoSize" );
//setter
$("#expense").find(  "#datepicker"  ).datepicker( "option", "autoSize", true );
            
 $("#expense").find( "#datepicker" ).datepicker({ dateFormat: "yy-mm-dd" });
  
 //getter
var dateFormat = $("#expense").find( "#datepicker" ).datepicker( "option", "dateFormat" );
//setter
$("#expense").find( "#datepicker" ).datepicker( "option", "dateFormat", "yy-mm-dd" );


$("#expense").find( "#datepicker" ).datepicker( "option", "showAnim", "slideDown" );
 //setter
        $("#expense").find( "#datepicker" ).datepicker( "option", "dateFormat", "yy-mm-dd" );


        $("#expense").find( "#datepicker" ).datepicker( "option", "showAnim", "slideDown" );

        $("#expense").find("#datepicker"  ).datepicker({ yearRange: "1900:2100" });

        //getter
        var yearRange = $("#expense").find("#datepicker"  ).datepicker( "option", "yearRange" );
        //setter
        $("#expense").find("#datepicker"  ).datepicker( "option", "yearRange", "1900:2100" );

	});
	</script>
          
    <link rel="stylesheet" type="text/css" media="screen" href="js/validation/screen.css" />

<script src="js/validation/jquery.js" type="text/javascript"></script>
<script src="js/validation/jquery.validate.js" type="text/javascript"></script>
<script type='text/javascript'>  
  
 var $jq1 = jQuery.noConflict();  
  
</script> 

<script type="text/javascript">
$(document).ready(function() {
     $("#submit").click(function(){
         //alert($jq1("#expense").find("#addexpense").validate().form());
       if($jq1("#expense").find("#addexpense").validate().form())
           {
               //alert("inform ");
                var bsheadgroupid= $('#bsheadgroupid option:selected').val() ;
                var bssubheadid=$('#bssubheadid option:selected').val() ;
                var relevantAccountid=$('#relevantAccountId option:selected').val() ;
               
                var relevantUserId=$('#relevantUserId option:selected').val() ;
                 if(bsheadgroupid =='27' || bsheadgroupid =='36')
                    {
     
                    //     alert("reaccountid----"+relevantUserId);
                    }
                    else 
                       {
                           
                           relevantUserId='0';
                  //          alert("reaccountid----"+relevantUserId);
                       } 
                
                var datepicker =$('#datepicker').val() ;
                var amount=$("#amount").val();
                var remarksid=$("#remarksid").val();
                
                 
                //alert("hi true"+bsheadgroupid+bssubheadid+"--account Id"+relevantAccountid+"userid "+relevantUserId+remarksid+datepicker+amount); 
              $.ajax({
                 
                  url:"a_addexpense.do?bsheadgroupid="+bsheadgroupid+"&bssubheadid="+bssubheadid+"&relevantAccountid="+relevantAccountid+"&relevantUserId="+relevantUserId+"&datepicker="+datepicker+"&amount="+amount+"&remarksid="+remarksid+"",
                  success:function(data){//alert("Added successful");
                                          $("#success").show('slow');
                       $("#error").hide('slow');
                       $jq1("#expense").find('#addexpense').each (function(){this.reset();});
                      
                     
                   return false;
                  },
                  error:function(){ //alert("error");
              
              $("#success").hide('slow');
              $("#error").show('slow');
              return false;
              }
                  
              })
             return false;
           }
        else {
                  //alert("hi false");
                   return false;
            }
    });
    
});
</script>
<script type="text/javascript">
$jq1("#expense").find(document).ready(function() {
    $jq1("#expense").find("#addexpense").validate({
        
        rules:{
            bsheadgroupid:"required needsSelection"
            
        }
    }

 );
    
});
</script>

<style  type="text/css">
.myDropDown
{
   height: 50px;
   overflow:scroll;

}
</style>

<div id="expense"  >
      	

        <%
                    String u="dropdownajax.do";
                      %>
                <script type="text/javascript">
                    var v='<%=u%>';
                   
                </script>
                 <div id="success" style=" color:#0066cc; display: none"> <h4>Added Successfully.</h4> </div>
                <div id="error" style="color: red ;display: none"><h4>Error in Update</h4> </div>
                  <h1>Add Expense</h1>
                  <html:form  action="a_addexpense" styleId="addexpense" onsubmit="return false" >
             <table>
                  <tr><td>
                     Category
                    </td>                    <td>
                        <html:select  property="category" styleClass="required" styleId="bsheadgroupid" onchange="changeDropDown('bsheadgroupid','bssubheadid','subCategory',v,this,'addexpense')" >
                            <html:option  value=""  >--Select--</html:option>
                            <html:optionsCollection   name="CATEGORY" label="bsHeadName" value="bsHeadId"/>
                        </html:select>
                          <img id="loading1" src="images/loading.gif" title="Loading" style="display: none;" />
                        </td>
                </tr>
                <tr><td>&nbsp;</td><td></td></tr>
                <tr><td>
                     Sub Category
                    </td>                    <td>
                        <html:select property="subcategory1" styleId="bssubheadid" styleClass="required">
                            <html:option value="" >--Select--</html:option>
                        </html:select>
                        </td>
                </tr>
                <tr><td>&nbsp;</td><td></td></tr>
                <tr id="reluser" ><td>
                        Relevant User
                    </td>                    <td>
                        <html:select property="relevantUser" styleId="relevantUserId" styleClass="required">
                            <html:option value="" >--Select--</html:option>
                            <html:optionsCollection  name="RELUSER" label="userProfileName" value="userId"/>
                        </html:select>
                        </td>
                </tr>
                <tr><td>&nbsp;</td><td></td></tr>
                <tr><td>
                        Relevant Account
                    </td>                    <td>
                        <html:select property="relevantAccount" styleId="relevantAccountId" styleClass="required">
                            <html:option value="" >--Select--</html:option>
                            <html:optionsCollection  name="ACCOUNT" label="userAccountName" value="userAccountId"/>
                        </html:select>
                        </td>
                </tr>
                <tr><td>&nbsp;</td><td></td></tr>
                <tr><td>
                      Date
                    </td>                    <td>
                        <html:text property="date" styleClass="required date" styleId="datepicker"/></td>
                </tr>
                <tr><td>&nbsp;</td><td></td></tr>
                <tr><td>
                     Amount (INR)
                    </td>                    <td>
                        <html:text property="amount"  styleClass="required number" styleId="amount"/></td>
                </tr>
                <tr><td>&nbsp;</td><td></td></tr>
                                <tr><td>
                     Remarks
                    </td>                    <td>
                        <html:textarea property="remarks" styleId="remarksid" styleClass="required"  rows="5" cols="30"/></td>
                </tr>
                <tr><td>&nbsp;</td><td></td></tr>
                  <tr><td colspan="2" style="text-align: center;">           
                          <input type="submit" value="SUbmit" id="submit"  />
                        <html:reset onclick="  $('#error').hide('slow'), $('#success').hide('slow')"/>
                                   </td>
                    </tr>
                    <tr><td>&nbsp;</td><td></td></tr>
            </table>
        </html:form>
        </div>
                    
  
