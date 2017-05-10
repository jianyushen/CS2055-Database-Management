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
  <hr />     </td>
 
	<center><strong><% out.println("Product List");%></strong> </center> 
  
<center><strong>Please select the brand to see product detail:</strong></center>
<center><a href="BrandSearch?search=Apple"><font color='black'>Apple</font></a></center>
<center><a href="BrandSearch?search=Samsung"><font color='black'>Samsung</font></a></center>
<center><a href="BrandSearch?search=HTC"><font color='black'>HTC</font></a></center>
<center><a href="BrandSearch?search=LG"><font color='black'>LG</font></a></center>
<center><a href="BrandSearch?search=Huawei"><font color='black'>Huawei</font></a></center>

 <hr />     </td>
 
<center><a href="ManagerOrder"><font size="4"><font color='black'>Inventory Check</font></font></a></center>

</body>
</html>
