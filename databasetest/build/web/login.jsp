<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="loginMessage" class="edu.pitt.yuq6.MessageInfoBean" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Log in page</title>
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
        <font color="red"><b><jsp:getProperty name="loginMessage" property="message"/></b><br/></font>
        <form action="LoginCheck" method="post">
            <table width="993" height="102" border="0">
                <tr>
                    <td width="251" height="96"><img src="head.png" width="251" height="88" alt="Logo" /></td>
                    <td width="726" class="right">| <a href="homepage.jsp"><font color="black">Home</a> |

                        <a href="login.jsp"><font color="black">Login</a>

                        <a href="logout.jsp"><font color="black">Logout</a>
                    </td>
                </tr>
                <table align="center">
                </table>
            </table>
            <hr/>
            <table width="1"> 
                <tr> 
                    <strong><em>User Login </em></strong>
                </Tr> 
                <tr> 
                    <td> Username: </td> 
                    <td> <input type="text" name="id"> </td> 
                </Tr> 
                <tr> 
                    <td> Password: </td> 
                    <td> <input type="password" name="password"> </td> 
                </Tr> 
                <tr>
                    <td>Type of Account: </td> 
                    <td><select name="type"><option selected="select">--select--</option>
                            <option>Customer</option>
                            <option>Admin</option> 
                            <option>Seller</option> 
                        </select></td>
                </tr>
                <tr> 
                    <td> <input type="submit" value="Log In"> </td> 
                    <td><input type="reset" value="Clear"></td> 
                </Tr> 
            </Table>
        </Form> 
    </Center>
</body>
</html>