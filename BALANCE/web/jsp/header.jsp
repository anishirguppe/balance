<%@include file="init.jsp" %>
<link rel="stylesheet" type="text/css" href="js/style.css" />
<!--<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery.dropotron-1.0.js"></script>
<script type="text/javascript" src="js/jquery.slidertron-1.1.js"></script>
<script type="text/javascript">
	$(function() {
            var $jq = jQuery.noConflict();  
		$jq('#menu > ul').dropotron({
			mode: 'fade',
			globalOffsetY: 11,
			offsetY: -15
		});
	
	});
</script>-->
	        <div id="header">
            <div id="logo">
<!--                <h1><a href="#">My Balance Sheet</a></h1>-->
            </div>
            <div id="slogan">
                <h2> </h2>
            </div>
        </div>
        <div id="menu">
            <ul>
                <logic:notPresent name="user" scope="session"> 
                    <li class="first">
                        
                        <html:link action="l_index">Login</html:link></li>
                </logic:notPresent>
                <li>
<a href="#">
    Services</a>
                    </li>
                <li><a href="#">Products</a></li>

                <li><a href="#">
                        Support</a>
                    </li>
                <li><a href="#">About</a></li>
                <logic:notPresent name="user" scope="session"> 
                    <li class="last"><a href="l_createuser.do"> New Account </a>
                    </li>
                </logic:notPresent>
               
                
                <logic:present name="user" scope="session"> 
               
                     <li class="last"> 
                                  <a href="l_logout.do" >
                          <img src="images/logout.jpg" width="20" height="20" alt="logout" />
                            logout
                        </a> 
                    </li>
                </logic:present>
                
               
            </ul>
            <br class="clearfix" />
        </div>

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        