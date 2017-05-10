
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Register Page</title>
<style type="text/css">
.right {	text-align: right;
}
    body{
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
   <strong><em>Hello,please register here</em></strong>
   <form action="regtodb.jsp"><table><b>
           <tr><td>First Name*</td><td><input type="text" name="name"></td></tr>
           <tr><td>Last Name*</td><td><input type="text" name="name1"></td></tr>
            <tr><td>Username*</td><td><input type="text" name="username"></td></tr>
	    <tr><td>Password*</td><td><input type="password" name="password"></td></tr>
            <tr><td>Phone Number*</td><td><input type="text" name="phone"></td></tr>
            <tr><td>E-mail id*</td><td><input type="text" name="email"></td></tr>
            <tr><td>Date of Birth*</td><td><input type="text" name="dob" placeholder='yyyy-mm-dd'></td></tr>
            <tr><td>Gender*: </td> <td><input type="radio" name="gender" value="Male" >Male</input></td> </td></tr>
             <tr>
            <td></td>    
            <td><input type="radio" name="gender" value="Female" id="f1" checked>Female</input></td>                 
            </tr>
            <tr><td>Marital Status*: </td> <td><input type="radio" name="marital" value="Married" >Married</input></td> </td></tr>
            <tr>
            <td></td>    
            <td><input type="radio" name="marital" value="Unmarried" id="f1" checked>Unmarried</input>    </td>                 
            </tr>
           <tr><td>Address *: </td><td><input type="text" name="address1"  placeholder="Street No."  /></td></tr>
              <tr>
              <tr><td>City*</td><td><input type="text" name="city"></td></tr>
                        <td>State*: </td> 
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
                            <tr><td>Zip Code*: </td><td><input type="text" name="zip"/></td></tr>
                            <td>Kind*: </td> 
                        <td><select name="kind"><option selected="select">--select--</option>
                                <option>Business</option> 
                                <option>Home</option>            
                            </select></td>
                <br>
                </b></table><br />
                
					<!--put information into database-->
					
     
     
     <input type="submit" value="Register" />
                    </form><br></br>
                     <tr><td> * is the Required fields </td></tr>
    <br></br>		     
    <br><input type="submit" name = "cart" value="Check Duplication"></td></br>
                    <!--connect database to check whether the name is unique-->
            <br><hr>
             Have you Already Registered? To Login <a href="login.jsp">Click Here</a>
                <hr>
                
    </center>
</body>
</html>