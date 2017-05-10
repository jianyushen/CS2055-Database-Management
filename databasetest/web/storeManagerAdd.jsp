<%-- 
    Document   : storeManagerAdd
    Created on : 2016-12-6, 2:52:38
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
   <strong><em>Hello,please add products here</em></strong>
   <form action="ManagerAddPro" method="post">
       <table>
           <tr><td>ProductID*</td><td><input type="text" name="productid"/></td></tr>
           <tr><td>ProductName*</td><td><input type="text" name="productname"/></td></tr>
           <tr><td>Inventory Amount*</td><td><select name="inventory_amount"><option selected="select">--select--</option>
                                <option>1</option> 
                                <option>2</option> 
                                <option>3</option> 
                                <option>4</option> 
                                 <option>5</option> 
                                 <option>6</option> 
                                <option>7</option> 
                                <option>8</option>
                                <option>9</option>
                                <option>10</option></td></tr>
           <tr><td>Price*</td><td><input type="text" name="price"/></td></tr>
           <tr><td>Brand*</td><td><select name="brand"><option selected="select">--select--</option>
                                <option>Apple</option> 
                                <option>Samsung</option> 
                                <option>HTC</option> 
                                <option>LG</option> 
                                 <option>Huawei</option></td></tr>
           <tr><td>Product Description*</td><td><input type="text" name="description"/></td></tr>
           <tr><td></td><td><input type="submit" value="submit"/></td></tr>
           <tr><td>* is the Required fields </td><td></td></tr>
       </table>
   </form>
    </body>
</html>
