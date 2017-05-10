<%-- 
    Document   : AdminPage
    Created on : Dec 4, 2016, 3:50:00 PM
    Author     : Yu Qiu
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="storeInfo" class="edu.pitt.yuq6.StoreInfoBean" scope="session"/>
<jsp:useBean id="storeMessage" class="edu.pitt.yuq6.MessageInfoBean" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>Administrator Page</title>
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
            margin: 0;
            padding: 0;
        }


</style>
</head>
    <body>
        <center>
            <Strong><font size="12">Hi, Administrator</font></Strong>
            <br/>
            <font color="red"><b><jsp:getProperty name="storeMessage" property="message"/></b><br/></font>
            <br/>

<h1>Create new stores</h1>  
            <form action="StoreInsert" method="post">
                <table border = "0" align = "center">
                    <tbody>
                        <tr><td>Store ID</td><td><input type="text" name="storeID"></td></tr>
                        <tr><td>Address</td><td><input type="text" name="address"></td></tr>
                        <tr><td>Store Manager</td><td><input type="text" name="manager"></td></tr>
                        <tr><td>Number of salesmen</td><td><input type="text" name="numofsales"></td></tr>
                        <tr>
                            <td>Region: </td> 
                            <td><select name="region"><option selected="select">--select--</option>
                                    <option>r1</option> 
                                    <option>r2</option> 
                                    <option>r3</option>                      
                                </select></td>
                        </tr>
                        <tr>
                            <td>
                                <input type = "submit" name="store_insert" value = "Create"/>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>

            <br/>
            <br/>
            <h1>Update stores</h1>   
            <form action="StoreUpdateReq" method="post">
                <table border = "0" align = "center">
                    <tbody>
                        <tr>
                            <td>Enter store ID to update:</td>
                            <td>
                                <input type = "text" name = "storeID" placeholder="store ID" />
                            </td>
                            <td>
                                <input type = "submit" name="store_updatereq" value = "submit"/>
                            </td>
                        </tr>

                    </tbody>
                </table>
            </form>

            <br/>
            
            <form action="StoreUpdate" method="post">
                <table border = "0" align = "center">
                    <tbody>
                        
                        <tr><td>Store ID</td><td><input type="text" name="storeID" value= <jsp:getProperty name="storeInfo" property="storeID"/>></td></tr>
                        <tr><td>Address</td><td><input type="text" name="address" value= <jsp:getProperty name="storeInfo" property="address"/>></td></tr>
                        <tr><td>Manager</td><td><input type="text" name="manager" value= <jsp:getProperty name="storeInfo" property="manager"/>></td></tr>
                        <tr><td>Number of salesmen</td><td><input type="text" name="numofsales" value= <jsp:getProperty name="storeInfo" property="numofsales"/>></td></tr>
                        <tr>
                            <td>Region: </td> 
                            <td><select name="region"><option selected="select"><jsp:getProperty name="storeInfo" property="region"/></option>
                                    <option>r1</option> 
                                    <option>r2</option> 
                                    <option>r3</option>                      
                                </select></td>
                        </tr>
                        <tr>
                            <td>
                                <input type = "submit" name="store_update" value = "Confirm Update"/>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>

            <br/>
            <br/>
            <h1>Delete stores</h1>
            <form action="StoreDelete" method="post">
                <table border = "0" align = "center">
                    <tbody>
                        <tr>
                            <td>Enter store ID to delete:</td>
                            <td>
                                <input type = "text" name = "storeID" placeholder ="store ID" />
                            </td>
                            <td>
                                <input type = "submit" name="store_delete" value = "Delete"/>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>

        </center>
    </body>
    </html>

