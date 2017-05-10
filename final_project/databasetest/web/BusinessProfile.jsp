<%-- 
    Document   : MyProfile
    Created on : Dec 4, 2016, 9:47:01 PM
    Author     : Yu Qiu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="userInfo" class="edu.pitt.yuq6.UserInfoBean" scope="session"/>
<jsp:useBean id="cusbean" class="edu.pitt.yuq6.BusinessCustomerBean" scope="session"/>
<jsp:useBean id="editMessage" class="edu.pitt.yuq6.MessageInfoBean" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Business Customer Profile</title>
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

                    </td>
                </tr>
            </table>
        <hr/>
        <font color="red"><b><jsp:getProperty name="editMessage" property="message"/></b><br/></font> 
        <strong><em><jsp:getProperty name="userInfo" property="username"/>'s profile</em></strong>
        <form action="EditBusinessProfile"><table><b>
                    <tr><td>Username</td><td><jsp:getProperty name="cusbean" property="username"/></td></tr>
                    
                    <tr><td>Company Name*</td><td><input type="text" name="companyname" value="<jsp:getProperty name="cusbean" property="companyname"/>"></td></tr>
                    <tr><td>Phone Number*</td><td><input type="text" name="phone" value="<jsp:getProperty name="cusbean" property="phone"/>"></td></tr>
                    <tr><td>E-mail id*</td><td><input type="text" name="email" value="<jsp:getProperty name="cusbean" property="email"/>"></td></tr>
                    <tr><td>Address : </td><td><input type="text" name="street"  value="<jsp:getProperty name="cusbean" property="address"/>"/></td></tr>
                    <tr><td>Zip Code: </td><td><input type="text" name="zip" value="<jsp:getProperty name="cusbean" property="zipcode"/>"/></td></tr>
                    <tr><td>Annual Income</td><td><input type="text" name="income" value="<jsp:getProperty name="cusbean" property="income"/>"></td></tr>
                    <tr><td>Business category: </td> 
                        <td>
                            <select name="category"><option selected="select"><jsp:getProperty name="cusbean" property="businessCategory"/></option>
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
             Click <a href="homepage.jsp">Here</a> to go the home page
                <hr>
                
    </center>
    </body>
</html>
