<%@include file="init.jsp" %>

<script  type="text/javascript">

    $(document).ready(function(){
        //alert("mi  ahe");
       $("#reluser").hide();
        $("#category").change(function(){
            
          if($("#category").val()=='45')
              {
                 $("#reluser").show();
              }
          else
              {
                  $("#reluser").hide();
                  $('#drelevantAccountid').val('');
              }


        } );

    

    } );

</script>

<script type="text/javascript">
  $(document).ready(function(){
      $("#drelevantAccountid,#srelevantAccountid").change(function(){
//alert("");
          if($("#drelevantAccountid").val()==$("#srelevantAccountid").val())
              {
                  $("#drelevantAccountid").val('');
                 alert("Source and Destination A/C Should be Different ");
              }
          else
              {
                  
                  
              }


        } );
  });
</script>


<link rel="stylesheet" type="text/css" media="screen" href="js/validation/screen.css" />

<script src="js/validation/jquery.js" type="text/javascript"></script>
<script src="js/validation/jquery.validate.js" type="text/javascript"></script>
<script type='text/javascript'>

    var $jq = jQuery.noConflict();

</script>
 <script type="text/javascript">
       $(document).ready(function() {
        $("#submit").click(function(){

            if($jq ("#transfer").validate().form())
            {

                var bsheadgroupid= $('#category option:selected').val() ;
                var srelevantAccountid=$('#srelevantAccountid option:selected').val() ;
                var drelevantAccountid=$('#drelevantAccountid option:selected').val() ;
                var datepicker =$('#datepicker').val() ;
                var amount=$("#amount").val();
                var remarksid=$("#remarksid").val();
              alert("a_transfer.do?bsheadgroupid="+bsheadgroupid+"&srelevantAccountid="+srelevantAccountid+"&drelevantAccountid="+drelevantAccountid+"&datepicker="+datepicker+"&amount="+amount+"&remarksid="+remarksid);

                //   alert("bsheadgroupid="+bsheadgroupid+"&bssubheadid="+bssubheadid+"&relevantAccountid="+relevantAccountid+"&datepicker="+datepicker+"&amount="+amount+"&remarksid="+remarksid+"");
                $.ajax({

                    url:"a_transfer.do?bsheadgroupid="+bsheadgroupid+"&srelevantAccountid="+srelevantAccountid+"&drelevantAccountid="+drelevantAccountid+"&datepicker="+datepicker+"&amount="+amount+"&remarksid="+remarksid+"",
                    success:function(data){//alert("Added successful");
                        $("#success").show('slow');
                        $("#error").hide('slow');
                        $('#transfer').each (function(){this.reset();});



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

    });
</script>

<!DOCTYPE html>
<html:html >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transfer</title>
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
            <html:form action="a_transfer" styleId="transfer">
                <h1>Transfer</h1>
                <table>
                    <tr><td>
                             Category
                        </td>                    <td>
                            <html:select property="category" styleId="category" styleClass="required" >
                                <html:option value=""> --Select --</html:option>
                                 <html:optionsCollection  name="CATEGORY" label="bsHeadName" value="bsHeadId"/>
                              

                            </html:select>
                            <img id="loading1" src="images/loading.gif" title="Loading" style="display: none;" />
                        </td>
                    </tr>
                    <tr><td>
                            Source A/C
                        </td>                    <td>
                            <html:select property="srelevantAccount" styleId="srelevantAccountid">
                                   <html:option value=""> --Select --</html:option>
                                <html:optionsCollection  name="ACCOUNT" label="userAccountName" value="userAccountId"/>
                            </html:select>
                        </td>
                    </tr>
                    <tr id="reluser"><td>
                           Destination A/C
                        </td>
                        <td>  <html:select property="drelevantAccount" styleClass="required" styleId="drelevantAccountid">
                                   <html:option value=""> --Select --</html:option>
                                <html:optionsCollection  name="ACCOUNT" label="userAccountName" value="userAccountId"/>
                            </html:select>
                        
                          
                        </td>
                    </tr>
                    <tr><td>
                            Date
                        </td>                    <td>
                            <html:text property="date" styleId="datepicker"  styleClass="required"/></td>
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

                    <input type="submit" value="Submit" id="submit" />
                    <html:reset onclick="  $('#error').hide('slow'), $('#success').hide('slow')"/>
                </td>
            </tr>
        </table>
    </html:form>

</div>
</body>




</html:html>
