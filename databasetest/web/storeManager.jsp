<%-- 
    Document   : storeManager
    Created on : 2016-12-6, 2:48:13
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>Log in</title>
<style type="text/css">
.right {	text-align: right;
}
body
        {   background:url('BG.png') no-repeat center center fixed;
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
  <table width="993" height="102" border="0">
    <tr>
      <td width="251" height="96"><img src="head.png" width="251" height="88" alt="Logo" /></td>
      <td width="726" class="right"><a href="homepage.jsp"><font color="black">Home</a> |
       
        <a href="login.jsp"><font color="black">Login</a>
        
			
        <a href="logout.jsp"><font color="black">Logout</a>
       </td>
    </tr>
    
  </table>
    <center>
    <table>
        <tr><td><form action="storeManagerAdd.jsp" method="post"><input type="submit" value="addProduct"/></form></td></tr>
        <tr><td><form action="ManagerPUShow" method="post"><input type="submit" value="updateProduct"/></form></td></tr>
        <tr><td><form action="ManagerProductShow" method="post"><input type="submit" value="deleteProduct"/></form></td></tr>
        <tr><td><form action="adminCheck.jsp" method="post"><input type="submit" value="checkProcessingOrder"/></form></td></tr>
    </table>
    </center>
</body>
</html>
