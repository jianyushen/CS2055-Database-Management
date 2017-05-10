<%-- 
    Document   : HomeProfile
    Created on : Dec 4, 2016, 9:54:07 PM
    Author     : Yu Qiu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="userInfo" class="edu.pitt.yuq6.UserInfoBean" scope="session"/>
<jsp:useBean id="cusbean" class="edu.pitt.yuq6.HomeCustomerBean" scope="session"/>
<jsp:useBean id="editMessage" class="edu.pitt.yuq6.MessageInfoBean" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Customer Profile</title>
        <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
        <style type="text/css">
            .right {text-align: right;}
            body{
                background:url('BG.png') no-repeat center center fixed;
                background-size: cover;
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                margin: 0;
                padding: 0;}
        </style>
        <script>            
                $( function() {
                    $("#dob").datepicker({
                        dateFormat: "yy-mm-dd"
                    });
                });

         </script>
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
            
            <font color="red"><b><jsp:getProperty name="editMessage" property="message"/></b><br/></font> 
            <strong><em><jsp:getProperty name="userInfo" property="username"/>'s profile</em></strong>
            <form action="EditHomeProfile" method="post"><table><b>
                        <tr><td>Username*</td><td><jsp:getProperty name="cusbean" property="username"/></td></tr>
                        <tr><td>First Name*</td><td><input type="text" name="firstname" value="<jsp:getProperty name="cusbean" property="firstname"/>"></td></tr>
                        <tr><td>Last Name*</td><td><input type="text" name="lastname" value="<jsp:getProperty name="cusbean" property="lastname"/>"></td></tr>                        
                        <tr><td>Phone Number*</td><td><input type="text" name="phone" value="<jsp:getProperty name="cusbean" property="phone"/>"></td></tr>
                        <tr><td>E-mail id*</td><td><input type="text" name="email" value="<jsp:getProperty name="cusbean" property="email"/>"></td></tr>
                        <tr><td>Date of Birth*</td><td><input type="date" id="dob" name="dob" value="<jsp:getProperty name="cusbean" property="birthdate"/>">
                                    <div gldp-el="dob" style="width:250px; height:160px; position:absolute; top:70px; left:100px;"></div>
                            </td></tr>
                        <tr><td>Gender*: </td> <td><input type="radio" name="gender" value="<jsp:getProperty name="cusbean" property="phone"/>" checked ><jsp:getProperty name="cusbean" property="gender"/></input></td></tr>
                        <tr>
                            <td></td>    
                            <td><input type="radio" name="gender" value="Male" >Male</input></td>               
                        </tr>
                        <tr>
                            <td></td>    
                            <td><input type="radio" name="gender" value="Female" id="f1" >Female</input></td>                 
                        </tr>
                        <tr><td>Marital Status*: </td> 
                            <td><input type="radio" name="marital" value="<jsp:getProperty name="cusbean" property="marriage"/>" id="f1" checked><jsp:getProperty name="cusbean" property="marriage"/></input></td>                 
                        <tr>
                            <td></td> 
                            <td><input type="radio" name="marital" value="Married" >Married</input></td> 
                        </tr>
                        <tr>
                            <td></td>    
                            <td><input type="radio" name="marital" value="Unmarried" id="f1">Unmarried</input>    </td>                 
                        </tr>
                        <tr><td>Address *: </td><td><input type="text" name="street"  value="<jsp:getProperty name="cusbean" property="address"/>"/></td></tr>
                        
                            
                        <tr><td>Zip Code*: </td><td><input type="text" name="zip" value="<jsp:getProperty name="cusbean" property="zipcode"/>"/></td></tr>
                        <br>
                    </b></table><br />

                <!--put information into database-->



                <input type="submit" value="Submit" />
            </form>
            <br></br>
            <tr><td> * is the Required fields </td></tr>
            <br><br>
            
        </center>
    </body>
</html>
