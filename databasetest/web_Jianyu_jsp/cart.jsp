
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>Shopping cart review</title>
<style type="text/css">
.right {	text-align: right;
}

    body {
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
  <hr />     </td>
  </tr>
     
	 <!--add mySQL to display the products in shopping cart-->
<TABLE BORDER="1" align = "center">
 <br>
 <strong><Center>Products in cart</Center></strong></br>
            <TR>
                <TH>Image</TH>
                <TH>Product</TH>
                <TH>Quantity Added</TH>
                <TH>Delete</TH>               
            </TR>         
            <TR>
                <td></td>    
		        <TD><jsp:getProperty name="shoppingcart" property="product_name"/> </TD>
                        <form action="RecordNum" method="post">        
                            <TD><select name="type"><option selected="select">--select--</option>
                                <option>1</option> 
                                <option>2</option> 
                                <option>3</option> 
                                </select></TD>                        
                <TD><a href="DeleteSC">DELETE</a> </TD>
                <TD> </TD>           
            </TR>

</TABLE>
<br></br>
<!--<center>To Checkout click <a href="Buy?p_id=<% %>&buy=1"><font color="black">here</font></a></center>-->
<!--<center>To Checkout click <a href="SearchCart"><font color="black">here</font></a></center> -->
<center><input type="submit" value="Checkout"/> </center>
 </form> 
<br></br>
<br></br>
</body>
</html>