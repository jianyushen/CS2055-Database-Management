
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login Fail</title>
<style type="text/css">
.right {text-align: right;
}

 body  {
           margin: 0;
           padding: 0;
        }

</style>
</head>

<body>
<table width="993" height="102" border="0">
  <tr>
    <td width="251" height="96"><img src="head.png" width="251" height="88" alt="Logo" /></td>
    <td width="726" class="right"> <a href="homepage.jsp"><font color="black">Home</a> |
      
      <a href="login.jsp"><font color="black">Login</a>
     
      <a href="logout.jsp"><font color="black">Logout</a>
     </td>
  </tr>
</table>
<hr />
<tr><td><strong>Username or Password Incorrect.</strong> Please try again or Click <a href="register.jsp">
					<strong><font color = 'black'>here</font></strong></a> to register.</td></tr>
<center> 
<form action="logintodb.jsp" method="post">
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
                                <option>Personal User</option>
		            <option>Business User</option> 
                            </select></td>
                    </tr>
<tr> 
<td> <input type="submit" value="Log In"> </td> 
<td><input type="reset" value="Clear"> </td> 
</Tr> 

</Table>
  
</Form> 

</Center></p>
</body>
</html>