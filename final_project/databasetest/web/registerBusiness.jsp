<%-- 
    Document   : registerBusiness
    Created on : Nov 23, 2016, 2:37:06 PM
    Author     : Yu Qiu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="registerMessage" class="edu.pitt.yuq6.MessageInfoBean" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Business Register</title>
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
        <form action="BusinessRegister"><table><b>
                    <tr><td>Username*</td><td><input type="text" name="username"></td></tr>
                    <tr><td>Password*</td><td><input type="password" name="password"></td></tr>
                    <tr><td>Company Name*</td><td><input type="text" name="companyname"></td></tr>
                    <tr><td>Phone Number*</td><td><input type="text" name="phone"></td></tr>
                    <tr><td>E-mail id*</td><td><input type="text" name="email"></td></tr>
                    <tr><td>Address : </td><td><input type="text" name="street"  placeholder="Street No."  /></td></tr>
                    <tr><td>City</td><td><input type="text" name="city"></td></tr>
                    <tr><td>State: </td> 
                        <td>
                            <select name="state"><option selected="select">--select--</option>
                                <option>Alabama</option> 
                                <option>Colorado</option> 
                                <option>Florida</option> 
                                <option>Michigan</option> 
                                <option>New York</option> 
                                <option>Ohio</option> 
                                <option>Pennsylvania</option> 
                                <option>Texas</option>                       
                            </select>
                        </td>
                    </tr>
                    <tr><td>Zip Code: </td><td><input type="text" name="zip"/></td></tr>
                    <tr><td>Annual Income</td><td><input type="text" name="income"></td></tr>
                    <tr><td>Business category: </td> 
                        <td>
                            <select name="category"><option selected="select">--select--</option>
                                <option>Automotive</option> 
                                <option>Construction</option> 
                                <option>Financial Services</option> 
                                <option>Health Care</option> 
                                <option>Oil and Gas Industry</option> 
                                <option>Telecommunications and Media</option> 
                                <option>Transportation</option> 
                            </select>
                        </td>
                    </tr>
                    <br>
                </b></table><br />
            <input type="submit" value="Submit" />
        </form>
            <br><hr>
             Click <a href="login.jsp">Here</a> to go the home page
                <hr>
                
    </center>
    </body>
</html>
