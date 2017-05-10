<%-- 
    Document   : storeManagerUp
    Created on : 2016-12-6, 4:33:53
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Register Page</title>
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
   <hr />
   <strong><em>Hello,please update products here</em></strong>
   <form action="ManagerUpdatePro" method="post">
       <table>
           <tr><td>ProductID</td><td><input type="text" name="productid" value="${sessionScope.pId}" /></td></tr>
           <tr><td>ProductName</td><td><input type="text" name="productname" value="${requestScope.productname}"/></td></tr>
           <tr><td>Inventory Amount</td><td><input type="text" name="inventory_amount" value="${requestScope.inventoryamount}"/></td></tr>
           <tr><td>Price</td><td><input type="text" name="price" value="${requestScope.price}"/></td></tr>
           <tr><td>Brand</td><td><input type="text" name="brand" value="${requestScope.brand}"/></td></tr>
           <tr><td>Product Description</td><td><input type="text" name="description" value="${requestScope.description}"/></td></tr>
           <tr><td></td><td><input type="submit" value="Update"/></td></tr>
       </table>
   </form>
    </body>
</html>

