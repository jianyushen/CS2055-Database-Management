/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.yuq6;

import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Yu Qiu
 */
public class OpenProfile extends HttpServlet{
    private Connection conn;
    private ResultSet rs = null;
    private Statement st;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException{
        
        
        UserInfoBean user = (UserInfoBean) request.getSession().getAttribute("userInfo");
        String username = user.getUsername();
        
        if(username == null){
            MessageInfoBean loginMessage = new MessageInfoBean();
            loginMessage.setMessage("Please login first.");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("loginMessage", loginMessage);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
        PreparedStatement ps = null;
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/project";
            conn = DriverManager.getConnection(connectionURL, "test", "test");
            ps = conn.prepareStatement("SELECT customertype from customers where username=?");
            ps.setObject(1,username);           
            rs = ps.executeQuery();
            rs.next();
            String type = rs.getString(1);
            if(type.equals("home")){
                
                PreparedStatement ps1 = conn.prepareStatement("SELECT * from homecustomer where username=?");
                ps1.setObject(1,username); 
                rs = ps1.executeQuery();
                rs.next();
                String firstname = rs.getString(2);
                String lastname = rs.getString(3);
                String marriage = rs.getString(4);
                String gender = rs.getString(5);
                Date birthdate = rs.getDate(6);
                String address = rs.getString(7);
                String zipcode = rs.getString(8);
                String phone = rs.getString(9);
                String email = rs.getString(10);
                
                HomeCustomerBean cusbean = new HomeCustomerBean();
                cusbean.setUsername(username);
                cusbean.setFirstname(firstname);
                cusbean.setLastname(lastname);
                cusbean.setMarriage(marriage);
                cusbean.setGender(gender);
                cusbean.setBirthdate(birthdate);
                cusbean.setAddress(address);
                cusbean.setZipcode(zipcode);
                cusbean.setPhone(phone);
                cusbean.setEmail(email);
                
                HttpSession session = request.getSession();
                session.setAttribute("cusbean", cusbean);               
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/HomeProfile.jsp");
                rd.forward(request, response);
            
                
            }else{
                PreparedStatement ps1 = conn.prepareStatement("SELECT * from businesscustomer where username=?");
                ps1.setObject(1,username); 
                rs = ps1.executeQuery();
                rs.next();
                String companyname = rs.getString(2);
                String phone = rs.getString(3);
                String email = rs.getString(4);
                String address = rs.getString(5);
                String zipcode = rs.getString(6);
                int income = rs.getInt(7);
                String businesscategory = rs.getString(8);
                
                BusinessCustomerBean cusbean = new BusinessCustomerBean();
                cusbean.setUsername(username);
                cusbean.setCompanyname(companyname);
                cusbean.setPhone(phone);
                cusbean.setEmail(email);
                cusbean.setAddress(address);
                cusbean.setZipcode(zipcode);
                cusbean.setIncome(income);
                cusbean.setBusinessCategory(businesscategory);
                
                HttpSession session = request.getSession();
                session.setAttribute("cusbean", cusbean);
                
                ServletContext SC = getServletContext();

                RequestDispatcher rd = SC.getRequestDispatcher("/BusinessProfile.jsp");
                rd.forward(request, response);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
        
        
        
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginCheck.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginCheck.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
