/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.yuq6;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Long.parseLong;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
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
public class BusinessRegister extends HttpServlet{
    private Connection conn;
    private ResultSet rs = null;
    private Statement st;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException{
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String companyname = request.getParameter("companyname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipcode = request.getParameter("zip");
        long income = 0;
        String annualIncome = request.getParameter("income");        
        String category = request.getParameter("category");
        
        try{
            income = parseLong(annualIncome);
        }catch(NumberFormatException e){
            MessageInfoBean registerMessage = new MessageInfoBean();
            registerMessage.setMessage("You input of Annual Income is illeage. Please check.");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("registerMessage", registerMessage);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/registerBusiness.jsp");
            rd.forward(request, response);
        }
        if(income < 0){
            MessageInfoBean registerMessage = new MessageInfoBean();
            registerMessage.setMessage("You input of Annual Income is illeage. Please check.");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("registerMessage", registerMessage);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/registerBusiness.jsp");
            rd.forward(request, response);
        }
        
        
        HashSet<Character> set = new HashSet<Character>();
        set.add(';');
        set.add(':');
        set.add(',');
        set.add('#');
        set.add('&');
        set.add('\'');
        set.add('\"');
        set.add('.');
        set.add('!');
        set.add('?');
        set.add('[');
        set.add(']');

        for (int i = 0; i < username.length(); i++) {
            char temp = username.charAt(i);
            if (set.contains(temp)) {
                MessageInfoBean registerMessage = new MessageInfoBean();
                registerMessage.setMessage("You include illegal input in Username(eg: [;:,#&\'\".!?]). Please check.");
                HttpSession sesson = request.getSession();
                sesson.setAttribute("registerMessage", registerMessage);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/registerBusiness.jsp");
                rd.forward(request, response);
            }
        }
        
        for (int i = 0; i < password.length(); i++) {
            char temp = password.charAt(i);
            if (set.contains(temp)) {
                MessageInfoBean registerMessage = new MessageInfoBean();
                registerMessage.setMessage("You include illegal input in Password(eg: [;:,#&\'\".!?]). Please check.");
                HttpSession sesson = request.getSession();
                sesson.setAttribute("registerMessage", registerMessage);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/registerBusiness.jsp");
                rd.forward(request, response);
            }
        }
        
        for (int i = 0; i < companyname.length(); i++) {
            char temp = companyname.charAt(i);
            if (set.contains(temp)) {
                MessageInfoBean registerMessage = new MessageInfoBean();
                registerMessage.setMessage("You include illegal input in Company Name(eg: [;:,#&\'\".!?]). Please check.");
                HttpSession sesson = request.getSession();
                sesson.setAttribute("registerMessage", registerMessage);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/registerBusiness.jsp");
                rd.forward(request, response);
            }
        }
        
        if(companyname.length() <= 0 || username.length() <= 0 || password.length() <= 0 || email.length() <= 0 || street.length() <= 0 || city.length() <= 0){
            MessageInfoBean registerMessage = new MessageInfoBean();
            registerMessage.setMessage("You cannot leave required fields blank. Please check.");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("registerMessage", registerMessage);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/registerBusiness.jsp");
            rd.forward(request, response);
        }
        
        boolean phoneCheck = true;
        if(phone.length() != 10) phoneCheck = false;
        else{
            for(int i = 0; i < phone.length(); i++){
                if(phone.charAt(i) < '0' || phone.charAt(i) > '9'){
                    phoneCheck = false;
                    break;
                }
            }
        }
        if(phoneCheck == false){
            MessageInfoBean registerMessage = new MessageInfoBean();
            registerMessage.setMessage("Phone number is invalid. Please enter again.");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("registerMessage", registerMessage);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/registerBusiness.jsp");
            rd.forward(request, response);
        }
        
        boolean emailCheck = false;
        for(int i = 0; i < email.length(); i++){
            if(email.charAt(i) == '@'){
                if(emailCheck == false) emailCheck = true;
                else emailCheck = false;
            }
        }
        if(emailCheck == false){
            MessageInfoBean registerMessage = new MessageInfoBean();
            registerMessage.setMessage("Email address is invalid. Please enter again.");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("registerMessage", registerMessage);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/registerBusiness.jsp");
            rd.forward(request, response);
        }
                
        if(zipcode.length() != 5){
            MessageInfoBean registerMessage = new MessageInfoBean();
            registerMessage.setMessage("Zipcode is invalid. Please enter again.");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("registerMessage", registerMessage);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/registerBusiness.jsp");
            rd.forward(request, response);
        }
                
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/project";
            conn = DriverManager.getConnection(connectionURL,"test","test");
            PreparedStatement ps1 = conn.prepareStatement("Select * from customers where username=?");
            ps1.setObject(1,username);
            rs = ps1.executeQuery();
            if(rs.next()){
                MessageInfoBean registerMessage = new MessageInfoBean();
                registerMessage.setMessage("Username has been used. Please try another one.");
                HttpSession sesson = request.getSession();
                sesson.setAttribute("registerMessage",registerMessage);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/registerBusiness.jsp");
                rd.forward(request, response);
            }
        }catch(ClassNotFoundException ex){
            Logger.getLogger(HomeRegister.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        boolean zipcodeCheck = false;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/project";
            conn = DriverManager.getConnection(connectionURL,"test","test");
            PreparedStatement ps1 = conn.prepareStatement("Select * from addressmapping where zipcode=?");
            ps1.setObject(1,zipcode);
            rs = ps1.executeQuery();
            if(rs.next()){
                zipcodeCheck = true;
            }
        }catch(ClassNotFoundException ex){
            Logger.getLogger(HomeRegister.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/project";
            conn = DriverManager.getConnection(connectionURL,"test","test");
            PreparedStatement ps = conn.prepareStatement("INSERT into businesscustomer(username, company_name, phone, email, address, zipcode, company_income, business_category) values (?,?,?,?,?,?,?,?)");
            ps.setObject(1, username);
            ps.setObject(2, companyname);
            ps.setObject(3, phone);
            ps.setObject(4, email);
            ps.setObject(5, street);
            ps.setObject(6, zipcode);
            ps.setObject(7, income);
            ps.setObject(8, category);          
            ps.executeUpdate();
            
            PreparedStatement ps2 = conn.prepareStatement("INSERT INTO customers values(?,?,?)");
            String custype = "business";
            ps2.setObject(1, username);
            ps2.setObject(2, password);
            ps2.setObject(3, custype);
            ps2.executeUpdate();
            
            
            if(zipcodeCheck == false){
                PreparedStatement ps3 = conn.prepareStatement("INSERT INTO addressmapping values(?,?,?,?)");
            
                ps3.setObject(1, zipcode);
                ps3.setObject(2, street);
                ps3.setObject(3, city);
                ps3.setObject(4, state);
                ps3.executeUpdate();
            }
            
            UserInfoBean userInfo = new UserInfoBean();
            userInfo.setUsername(username);
            HttpSession session = request.getSession();
            session.setAttribute("userInfo",userInfo);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/homepage.jsp");
            rd.forward(request, response);
            
              
            conn.close();
        }catch(ClassNotFoundException ex){
            Logger.getLogger(HomeRegister.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HomeRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HomeRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    
}
