
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>Order Checkout</title>
<style type="text/css">
.right {	text-align: right;
}

    body
        {
            background:url('BG.png') no-repeat center center fixed;
            background-size: cover;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            margin:  0;
            padding: 0;
        }


</style>
</head>

<body>
  <table width="993" height="102" border="0">
    <tr>
      <td width="251" height="96"><img src="head.png" width="251" height="88" alt="Logo" /></td>
      <td width="726" class="right">| <a href="homepage.jsp"><font color="black">Home</a> |
        
        <a href="login.jsp"><font color="black">Login</a>
        
        <a href="logout.jsp"><font color="black">Logout</a>
        </td>
    </tr>   
  </table>
  <hr />    
  

 <table align="center">
 <strong ><em><center>Order Checkout</center></em></strong>
   <form action="UpdateCartQuatity" method="post"><b>
           <tr><td>Name</td><td><input type="text" name="name"></td></tr>
           <tr><td>Shipping Address1</td><td><input type="text" name="address"></td></tr>
           <tr><td>Shipping Method</td><td><input type="text" name="shipmethod"></td></tr>
            <tr><td>Card details</td><td><input type="text" name="card"></td></tr>
            
            </b><tr><td></td><td><input type="submit" value="Submit" /></td></tr>
            </table>
            </form>
        
   <!--put purchase information in MySQL-->


    	 <p>Click <a href="homepage.jsp">here</a> to go to the Home Page to continue shopping!
    	   </p> 
 
</body>
</html>