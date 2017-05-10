
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Business Register</title>
<style type="text/css">
.right {	text-align: right;
}
    body{												margin: 0;
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
   <strong><em>Please enter your business details</em></strong>
   <form action="businesstodb.jsp"><table><b>
            <tr><td>Username</td><td><input type="text" name="username"></td></tr>
            <tr><td>Company Name</td><td><input type="text" name="name"></td></tr>
	    <tr><td>Address : </td><td><input type="text" name="address1"  placeholder="Street No."  /></td></tr>
              <tr>
              <tr><td>City</td><td><input type="text" name="city"></td></tr>
                        <td>State: </td> 
                        <td><select name="state"><option selected="select">--select--</option>
                                <option>Alabama</option> 
                                <option>Colorado</option> 
                                <option>Florida</option> 
                                <option>Michigan</option> 
                                 <option>New York</option> 
                                 <option>Ohio</option> 
                                <option>Pennsylvania</option> 
                                <option>Texas</option>                       
                            </select></td>
                    </tr>
                            <tr><td>Zip Code: </td><td><input type="text" name="zip"/></td></tr>
              <tr><td>Income</td><td><input type="text" name="income"></td></tr>
                        <td>Business category: </td> 
                        <td><select name="category"><option selected="select">--select--</option>
                                <option>Automotive</option> 
                                <option>Construction</option> 
                                <option>Financial Services</option> 
                                <option>Health Care</option> 
                                <option>Oil and Gas Industry</option> 
                                <option>Telecommunications and Media</option> 
                                <option>Transportation</option> 
                            </select></td>
                    </tr>
                <br>
                </b></table><br />
     <input type="submit" value="Submit" />
                    </form>
            <br><hr>
             Click <a href="login.jsp">Here</a> to go the home page
                <hr>
                
    </center>
</body>
</html>