<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="userInfo" class="edu.pitt.yuq6.UserInfoBean" scope="session"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Personal Hello Page</title>
<style type="text/css">
.right {text-align: right;
}

	body{
            background:url('BG.png') no-repeat center center fixed;
            background-size: cover;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
           margin: 0;
           padding: 0;
        }
</style>
</head>

    <body>
        <p> 
            <table width="993" height="102" border="0">
                <tr>
                    <td width="251" height="96"><img src="head.png" width="251" height="88" alt="Logo" /></td>
                    <td width="726" class="right">
                        <a href="homepage.jsp"><font color = 'black'>Home</a> |

                        <a href="login.jsp"><font color = 'black'>Login</a>

                        <a href="logout.jsp"><font color = 'black'>Logout</a> 
                        
                        
                    </td>
                </tr>
                <tr><td><form action="OpenProfile" method="post"><input type="submit" value="Edit Profile"></input></form></td></tr>
            </table>
            <hr />
            <br />

            <!--connect database to get the user's information here: name....-->

            <Strong><font size="12">Welcome </Strong><Strong> <b><jsp:getProperty name="userInfo" property="username"/></b> </Strong></font><Strong>,</Strong>

            <p>Click <a href="homepage.jsp
                        ">here</a> to go to the Home Page.
            </p> 
    </body>
</html>