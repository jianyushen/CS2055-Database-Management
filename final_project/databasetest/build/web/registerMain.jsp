<%-- 
    Document   : registerMain
    Created on : Nov 23, 2016, 2:26:44 PM
    Author     : Yu Qiu
--%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Register Main Page</title>
        <style type="text/css">
            .right {text-align: right;}
            body{
                background:url('BG.png') no-repeat center center fixed;
                background-size: cover;
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                margin: 0;
                padding: 0;
                }
            a.button {
                -webkit-appearance: button;
                -moz-appearance: button;
                appearance: button;
                text-decoration: none;
                color: initial;
                }
        </style>
    </head>

<body>
 <center>
   <table width="993" height="102" border="0">
     <tr>
       <td width="251" height="96"><img src="head.png" width="251" height="88" alt="Logo" /></td>
       <td width="720" class="right"> <a href="homepage.jsp"><font color = "black">Home</a> |

         <a href="login.jsp"><font color = "black">Login</a>
         
         <a href="logout.jsp"><font color = "black">Logout</a>
        </td>
     </tr>
   </table>
   <hr />

   <br/>
   <strong><em>Would you like to register as </em></strong>
   <br/>
   <br/>
   <a href ="registerHome.jsp" class="button">Home Account</a>
   <br/>
   <br/>
   <a href ="registerBusiness.jsp" class="button">Business Account</a>
   <br></br>
                     
    <br></br>		     
    
                    <!--connect database to check whether the name is unique-->
            <br><hr>
             Have you Already Registered? To Login <a href="login.jsp">Click Here</a>
                <hr>
                
    </center>
</body>
</html>