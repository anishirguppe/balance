
<%@include file="init.jsp" %>


<link rel="stylesheet" type="text/css" media="screen" href="js/validation/screen.css" />

<script src="js/validation/jquery.js" type="text/javascript"></script>
<script src="js/validation/jquery.validate.js" type="text/javascript"></script>
<script type='text/javascript'>  
  
    var $jq = jQuery.noConflict();
  
</script>  
<script type="text/javascript">
       $(document).ready(function() {
        $("#submit").click(function(){
       
            if($jq ("#addincome").validate().form())
            {
                
                var bsheadgroupid= $('#bsheadgroupid option:selected').val() ;
                var bssubheadid=$('#bssubheadid option:selected').val() ;
                var relevantAccountid=$('#relevantAccountid option:selected').val() ;
                var datepicker =$('#datepicker').val() ;
                var amount=$("#amount").val();
                var remarksid=$("#remarksid").val();
                if(bsheadgroupid=="select")
                {
                    alert('Please select an option for Category');
                    return false;
                        
                }
                if(bssubheadid=="select")
                {
                    alert('Please select an option for Sub-Category');
                    return false;
                }
               
                //   alert("bsheadgroupid="+bsheadgroupid+"&bssubheadid="+bssubheadid+"&relevantAccountid="+relevantAccountid+"&datepicker="+datepicker+"&amount="+amount+"&remarksid="+remarksid+"");
                $.ajax({
                 
                    url:"a_addincome.do?bsheadgroupid="+bsheadgroupid+"&bssubheadid="+bssubheadid+"&relevantAccountid="+relevantAccountid+"&datepicker="+datepicker+"&amount="+amount+"&remarksid="+remarksid+"",
                    success:function(data){//alert("Added successful");
                        $("#success").show('slow');
                        $("#error").hide('slow');
                        $('#addincome').each (function(){this.reset();});
                      
                      
                      
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
        $("#datepicker").watermark('YYYY-MM-DD');
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

<!DOCTYPE html>
<html:html >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Income</title>
        <style>
            input.text{

                width: 172px;
                background: url(images/textbox.png) repeat scroll 0% 0% transparent;
                border: 0px none;
                height: 30px;
            }

            #b{

                font-size: 15px;
            }
        </style>

    </head>
    <body id="b">
        <div id="addincomediv">

            <%
                        String u = "dropdownajax.do";
            %>
            <script type="text/javascript">
                    var v='<%=u%>';
                   
            </script>
            <div id="success" style=" color:#209D9D;  display: none;"> <h3>Added Successfully.</h3> </div>
            <div id="error" style="color: red ;display: none;"><h3>Error in Update</h3> </div>
            <html:form action="a_addincome" styleId="addincome">
                <h1>Add Income</h1>
                <table>
                    <tr><td>
                            Category
                        </td>                    <td>
                            <html:select property="category" styleId="bsheadgroupid"
                                         styleClass="required"
                                         onchange="changeDropDown('bsheadgroupid','bssubheadid','subCategory',v,this,'addincome')">
                                <html:option value="" >--Select--</html:option>
                                <html:optionsCollection  name="CATEGORY" label="bsHeadName" value="bsHeadId"/>
                            </html:select>
                            <img id="loading1" src="images/loading.gif" title="Loading" style="display: none;" />
                        </td>
                    </tr>
                    <tr><td>
                            Sub Category
                        </td>                    <td>
                            <html:select property="subcategory" styleId="bssubheadid" styleClass="required">
                                <html:option value=""   >--Select--</html:option>
                            </html:select>
                        </td>
                    </tr>
                    <tr><td>
                            Relevant Account
                        </td>                    <td>
                            <html:select property="relevantAccount" styleId="relevantAccountid" styleClass="required">
                                <html:option value=""   >--Select--</html:option>
                                <html:optionsCollection  name="ACCOUNT" label="userAccountName" value="userAccountId"/>
                            </html:select>
                        </td>
                    </tr>
                    <tr><td>
                            Date
                        </td>                    <td>
                            <html:text property="date" styleId="datepicker"  styleClass="required date"/></td>
                    </tr>
                    <tr><td>
                            Amount (INR)
                        </td>                    <td>
                            <html:text property="amount" styleId="amount"  styleClass="required number"/></td>
                    </tr>
                   
                    <tr><td>
                            Remarks
                        </td>                    <td>
                            <html:textarea property="remarks"  styleId="remarksid" styleClass="required" rows="5" cols="30"/></td>
                    </tr>
                <tr><td colspan="2" style="text-align: center;">

                    <input type="submit" value="SUbmit" id="submit" />
                    <html:reset onclick="  $('#error').hide('slow'), $('#success').hide('slow')"/>
                </td>
            </tr>
        </table>
    </html:form>

</div>
</body>




</html:html>
