/* 
 * Copyright 2012 Aniruddha.
 * and open the template in the editor.
 */


        function changegender(id) {
            if (id == 1) {
                document.getElementById("tick_img_gender_male").src = "images/male-select.gif";
                document.getElementById("tick_img_gender_female").src = "images/female.gif";
                 document.getElementById("usergender").value="male";
                 //alert(document.getElementById("usergender").value);

            }
            else {
                document.getElementById("tick_img_gender_male").src = "images/male.gif";
                document.getElementById("tick_img_gender_female").src = "images/female-select.gif";
                document.getElementById("usergender").value="female";
                //alert(document.getElementById("usergender").value);

            }
        }
        function chagnesmoke(id) {
            if (id == 1) {
                document.getElementById("tick_img_radio").src = "images/smoke-no-select.gif";
                document.getElementById("tick_img_radio2").src = "images/smoke-yes.gif";

            }
            else {
                document.getElementById("tick_img_radio").src = "images/smoke-yes.gif";
                document.getElementById("tick_img_radio2").src = "images/smoke-no-select.gif";
            }
        }
 function changestatus(id) {
            if (id == 1) {
                document.getElementById("radio5").src = "images/married-yes-select.gif";
                document.getElementById("radio").src = "images/married-no.gif";
                 document.getElementById("marriedstatus").value="yes";

            }
            else {
                document.getElementById("radio5").src = "images/married-yes.gif";
                document.getElementById("radio").src = "images/married-no-select.gif";
                document.getElementById("marriedstatus").value="no";
            }
        }