<%-- 
    Document   : registerHome
    Created on : Nov 23, 2016, 2:37:19 PM
    Author     : Yu Qiu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="registerMessage" class="edu.pitt.yuq6.MessageInfoBean" scope="session"/>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Register Page</title>
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
            <hr/>
            <font color="red"><b><jsp:getProperty name="registerMessage" property="message"/></b><br/></font> 
            <strong><em>Hello,please register here</em></strong>
            <form action="HomeRegister" method="post"><table><b>
                        <tr><td>Username*</td><td><input type="text" name="username"></td></tr>
                        <tr><td>Password*</td><td><input type="password" name="password"></td></tr>
                        <tr><td>First Name*</td><td><input type="text" name="firstname"></td></tr>
                        <tr><td>Last Name*</td><td><input type="text" name="lastname"></td></tr>                        
                        <tr><td>Phone Number*</td><td><input type="text" name="phone"></td></tr>
                        <tr><td>E-mail id*</td><td><input type="text" name="email"></td></tr>
                        <tr><td>Date of Birth*</td><td><input type="date" id="dob" name="dob" placeholder='yyyy-mm-dd'>
                                    <div gldp-el="dob" style="width:250px; height:160px; position:absolute; top:70px; left:100px;"></div>
                            </td></tr>
                        <tr><td>Gender*: </td> <td><input type="radio" name="gender" value="Male" >Male</input></td> </td></tr>
                        <tr>
                            <td></td>    
                            <td><input type="radio" name="gender" value="Female" id="f1" checked>Female</input></td>                 
                        </tr>
                        <tr><td>Marital Status*: </td> <td><input type="radio" name="marital" value="Married" >Married</input></td> </td></tr>
                        <tr>
                            <td></td>    
                            <td><input type="radio" name="marital" value="Unmarried" id="f1" checked>Unmarried</input>    </td>                 
                        </tr>
                        <tr><td>Address *: </td><td><input type="text" name="street"  placeholder="Street No."  /></td></tr>
                        <tr>
                            <tr><td>City*</td><td><input type="text" name="city"></td></tr>
                            <td>State*: </td> 
                            <td><select name="state"><option selected="select">--select--</option>
                                    <option>Alabama</option> 
                                    <option>Colorado</option> 
                                    <option>Florida</option> 
                                    <option>Michigan</option> 
                                    <option>New York</option> 
                                    <option>Ohio</option> 
                                    <option>Pennsylvania</option> 
                                    <option>Texas</option>                       
                                </select></td>
                        </tr>
                        <tr><td>Zip Code*: </td><td><input type="text" name="zip"/></td></tr>
                        <br>
                    </b></table><br />

                <!--put information into database-->



                <input type="submit" value="Register" />
            </form>
            <br></br>
            <tr><td> * is the Required fields </td></tr>
            <br><br>
            <hr>Have you Already Registered? To Login <a href="login.jsp">Click Here</a><hr>
        </center>
    </body>


</html>
