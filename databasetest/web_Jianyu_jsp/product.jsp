
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>Product Detail</title>
<style type="text/css">
.right {	text-align: right;
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
  <p class="italics"><strong><center>Product details:</center></strong></p>        
<p>

<!--get the product detail from MySQL, name, description, brand....-->
</p>
 <table width="997" height="399" border="0">
  <tr>
   <td width="358" class="center1"></td>
    <td width="623" class="center1"><table width="466" height="200" border="0">
      <tr>
        <td width="179" class="center1">Product Name:</td>
        <td width="277" class="normal"><jsp:getProperty name="productInfo" property="product_name"/></td>
      </tr>
      <tr>
        <td class="center1">Brands</td>
        <td><jsp:getProperty name="productInfo" property="brand"/></td>
      </tr>
      <tr>
        <td class="center1">Product description:</td>
        <td><jsp:getProperty name="productInfo" property="product_description"/></td>      
      </tr> 
      <tr>
        <td class="center1">Quantity Available:</td>
        <td><jsp:getProperty name="productInfo" property="inventory_amount"/></td>
      </tr>
       
      <tr>
        <td class="center1">Price: </td>
        <td><jsp:getProperty name="productInfo" property="price"/></td>
      </tr>
      <tr>
     </table>
    <p>
		
        <form action="AddtoCart" method="post">
<input type="submit" name = "cart" value="ADD TO CART"></td> 
 </form>
 <!--<input type="submit" name = "cart" value="Update"></td> -->
 
</p>
</td>

  </tr>
</table>
   
</body>
</html>