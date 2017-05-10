<%-- 
    Document   : adminCheck
    Created on : Nov 27, 2016, 5:02:41 PM
    Author     : shenj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
        <form action="ManagerOrder" method="post">
            <table border = "0" align = "center">
                <tbody>
                   
                        <tr>
                            <td align = "left"><h2><font size="4">Order Browsing</font></h2></td>
                        </tr>
                        <tr>
                           <!-- <td>Please enter order ID:</td>-->
                            <td>
                            <!--    <input type = "text" name = "order_brows" placeholder ="orderID" />-->
                            </td>
                            <td>
                                <input type = "submit" name="order_submit" value = "search"/>
                            <!--    <input type = "reset" value = "clear"/> -->
                            </td>
                        </tr>
                        
                </tbody>
            </table>
        </form>  
        <form action="ProductShows" method="post">
            <table border = "0" align = "center">
                <tbody>
                        <tr>
                            <td align = "left"><h2><font size="4">Product Browsing</font></h2></td>
                        </tr>
                        <tr>
                            <td>Please enter product ID:</td>
                            <td>
                                <input type = "text" name = "product_brows" placeholder ="productID" />
                            </td>
                            <td>
                                <input type = "submit" name="product_submit" value = "search"/>
                                <input type = "reset" value = "clear"/>
                            </td>
                        </tr>
                </tbody>
            </table>
        </form>        
       
        
        <form action="ProductProfits">
            <table border = "0" align = "center">
                <tbody>
                  
                        <tr>
                            <td align = "left"><h2>Data Aggregation</h2></td>
                        </tr>
                        <tr>
                            <td>Total sales and profit of products:
                            </td>
                            <td>
                                <input type = "submit" name="productaggre_submit" value = "check"/>
                            </td>
                        </tr>
                    </form>
                        <tr>
                            <td>Top
                            
                                <select name="topThings" size="1">
                                    <option value="1">brand</option>
                                </select>
                                
                                according to sales:
                            </td>
                            <td>
                                <form action="TopBrand" method="post"><input type = "submit" name="topaggre_submit" value = "check"/></form>
                            </td>
                        </tr>
                        <tr></tr><tr></tr>
                        <tr>
                            <td>
                           <!--     <input type="submit" name="region_submit" value="Show total products sold in each region"/>-->
                            </td>
                            <td>
                                <input type="submit" name="date_submit" value="Number of products by date"/>
                            </td>
                        </tr>
                        <tr></tr><tr></tr>
                        <tr>
                            <td>
                             <!--   <input type="submit" name="salesmanprofit_submit" value="Show total sales in each region"/>-->
                            </td>
                            <td>
                             <!--   <input type="submit" name="salesman_submit" value="Business vs products"/> -->
                            </td>
                        </tr>
                        <tr></tr><tr></tr>
                        <tr>
                            <td>
                              <!--  <input type="submit" name="salesmanprofit_submit1" value="Show profit made by each salesman"/> -->
                            </td>
                        </tr>
                </tbody>
            </table>
        </form>      
    </body>
    </html>



