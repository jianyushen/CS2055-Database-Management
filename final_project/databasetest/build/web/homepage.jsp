
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="userInfo" class="edu.pitt.yuq6.UserInfoBean" scope="session"/>
<jsp:useBean id="editMessage" class="edu.pitt.yuq6.MessageInfoBean" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>Homepage</title>
<style type="text/css">
.right {	text-align: right;
}

    body{   background:url('BG.png') no-repeat center center fixed;
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
      <td width="726" class="right"> Home</a> | <a href="contact.jsp"><font color = "black">Contact Us</a> |
       
        <a href="login.jsp"><font color="black">Login</a> | <a href="register.jsp"><font color="black">Register</a></td>
        
        <a href="orders.jsp"><font color="black">Orders |</a> <a href="cart.jsp"><font color="black">Cart |</font></a><a href="logout.jsp"><font color="black">Log out </a> 
       
        
    </tr></table>
    <table align="center">
        <td><form action="LikeSearch">          
        <input name="search" type="text" id="search" size="60"  placeholder="* Please search by brand/name or descript the product *"  />
          <label>
            <input type="submit" name="submit" id="button" value="Search" />
            <input type="hidden" name="val" value="0">
          </label>
        </form></td>
      </table>
  <hr />
  
   <h2><font><b><jsp:getProperty name="editMessage" property="message"/></b><br/></font></h2> 
  <!--Select top 10 popular product-->
   <table>
  <tr>
    <td><table width="251" height="200" border="0" align="right">
      <tr>
        <td height="184"><table width="242" height="20" border="0">
          <tr>
            <td class="normal"><font size="3"><Strong>Electronics Brand Quick Search</font></Strong></td>
          </tr>
          </table>
          <table>
          <tr>
            <td>
                <a href="BrandSearch?search=Apple"><font color='black'>Apple</font></a></td>
          </tr>
          <tr>
            <td>
                <a href="BrandSearch?search=Samsung"><font color = 'black' size="4">Samsung</a>
            </td>
            </tr>
          <tr>
            <td>
                <a href="BrandSearch?search=HTC"><font color='black'>HTC</font></a>
           </td>
          </tr>
          <tr>
            <td>
              <a href="BrandSearch?search=LG"><font color='black'>LG</font></a>
            </td>
          </tr>
          <tr>
            <td>
              <a href="BrandSearch?search=Huawei"><font color='black'>Huawei</font></a>
          </td>
          </tr>
        </table>
            
  <!--Select top 10 popular product-->
  <table>
  <tr>
    <td><table width="251" height="200" border="0" align="right">
      <tr>
        <td height="184"><table width="242" height="20" border="0">
        <!--  <tr class="normal"><font size = "3"><strong>Best Selling Electronics</font></strong></td>-->
        <form action="TopBrand" method="post"><input type="submit" value="Best Selling Electronics" /></form>
          
    </tr>
	</table>        
  
  
</body>
</html>
