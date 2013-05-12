/* 
 * Copyright 2012 Aniruddha.
 * and open the template in the editor.
 */
function initCap(str) {
 /* First letter as uppercase, rest lower */
 var str = str.substring(0,1).toUpperCase() + str.substring(1,str.length).toLowerCase();
//alert(str);
 return str;
} 
function checkbsgroup(obj,table)
{
    //alert(obj.value);
   if(obj.value == null || obj.value=='')
      {
          return false;
      } 
      var loadingdiv = document.getElementById('loading');
	loadingdiv.style.display = "block";
    var ajaxRequest;  // The variable that makes Ajax possible!

     try{
         // Opera 8.0+, Firefox, Safari
         
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
}var path='/checkvalue.do';
     url='checkvalue.do?method='+table+'&gvalue='+obj.value;
    // alert("after ---  "+url);
     
     
   try{ 
      // alert(window.XMLHttpRequest);
       if (window.XMLHttpRequest) {	        
            req = new XMLHttpRequest();
            req.onreadystatechange = check;
            req.open("GET", url, true);
            req.send(null);
        }
   }
    catch(e){
     try{
         if (window.ActiveXObject) {
            req = new ActiveXObject("Microsoft.XMLHTTP");
            if (req) {
                req.onreadystatechange = check;
                req.open("GET", url, true);
                req.send();
            }
        }
     } catch(e)
     {
        alert("Your browser broke! FFF");
     return false; 
         
     }
    }

     
     
     function check()
     {
     if(req.readyState>3){
         if(req.readyState == 4){
           //  alert(req.status);
             if(req.status==200)
                 {
         
                       var bc=req.responseText.toString();
                       //alert(bc);
                        if(bc=='0')
                	   {
                	 //  alert("Basic group OK ");
                	   
                	   }
                   else if(bc=='1'){
                       if(table=='bsGroup')
                           {
                	   alert("Basic Group Name already Exists");
                           }
                        if(table=='bsHead')
                           {
                	   alert("Basic Head Name already Exists");
                           } 
                        if(table=='bsSubHead') 
                           {
                             alert("Basic Sub Head Name already Exists");  
                           } 
                	   obj.value='';
                	   } 
           
            loadingdiv.style.display = "none";

                     
                    
                 }//end if ajaxRequest.status
             }//end of ajaxRequest.readyState
         }// end of function
        }
	// alert(obj.value);
	
}


 function changeDropDown(obj_seleted,obj_dest,table,path,obj,formname)
{
    
 
	 var ajaxRequest;  // The variable that makes Ajax possible!
          var loadingdiv = document.getElementById('loading1');
	loadingdiv.style.display = "block";

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
     
   
     
//     dropdownajax.do?method=bsHead bsHead
//     url=path+'?method='+table+'&g_value='+obj.value;
     url=path+'?method='+table+'&g_value='+obj.value;
     //alert(url);
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
                     // alert(ajaxRequest.responseText);
//                     var v=document.getElementById("subBCode");
                     var response=ajaxRequest.responseXML.documentElement;
//                     //v.value=ajaxRequest.responseXML.getElementsByTagName();
//                     //v.value=ajaxRequest.responseXML.getElementsByTagName();
 var dataTags = ajaxRequest.responseXML.getElementsByTagName('node');
 var form=document.forms[formname];
 //alert(form);
                 resetData(form.bssubheadid);                    
                 var i;
                     for(i=0;i<dataTags.length;i++)
                     {
                         value=response.getElementsByTagName("ID")[i].childNodes[0].nodeValue;
                         //alert(value);
                         display=response.getElementsByTagName("name")[i].childNodes[0].nodeValue;
                         form.bssubheadid.options[i+1]= new Option(display,value);
                         //alert(display , value);
                     }
                   loadingdiv.style.display = "none";  
                 }//end if ajaxRequest.status
             }//end of ajaxRequest.readyState
          }
         }// end of function
	// alert(obj.value);
	
	}//end of change

function resetData(elem) {
    var i;
    for(i=elem.length ; i>0; i--)
        elem.remove(i);
}