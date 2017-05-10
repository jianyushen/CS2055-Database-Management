/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.yuq6;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
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
public class EditHomeProfile  extends HttpServlet{
    private Connection conn;
    private ResultSet rs = null;
    private Statement st;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException{
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        HomeCustomerBean cus = (HomeCustomerBean) request.getSession().getAttribute("cusbean");
        String username = cus.getUsername();
    
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String marriagestatus = request.getParameter("marital");
        String gender = request.getParameter("gender");
        String street = request.getParameter("street");

        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String birth = request.getParameter("dob");
        Date birthday = java.sql.Date.valueOf(birth);
        String zipcode = request.getParameter("zip");
        
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

        
        
        for (int i = 0; i < firstname.length(); i++) {
            char temp = firstname.charAt(i);
            if ((temp < 'A') || (temp > 'Z' && temp < 'a') || (temp > 'z')) {
                MessageInfoBean editMeesage = new MessageInfoBean();
                editMeesage.setMessage("Your lastname input is illegal. Please check.");
                HttpSession sesson = request.getSession();
                sesson.setAttribute("editMeesage", editMeesage);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/HomeProfile.jsp");
                rd.forward(request, response);
            }
        }
        
        
        for (int i = 0; i < lastname.length(); i++) {
            char temp = lastname.charAt(i);
            if ((temp < 'A') || (temp > 'Z' && temp < 'a') || (temp > 'z')) {
                MessageInfoBean editMeesage = new MessageInfoBean();
                editMeesage.setMessage("Your lastname input is illegal. Please check.");
                HttpSession sesson = request.getSession();
                sesson.setAttribute("editMeesage", editMeesage);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/HomeProfile.jsp");
                rd.forward(request, response);
            }
        }
        
        if(firstname.length() <= 0 || lastname.length() <= 0 ||  email.length() <= 0 || street.length() <= 0 ){
            MessageInfoBean editMeesage = new MessageInfoBean();
            editMeesage.setMessage("You cannot leave required fields blank. Please check.");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("editMeesage", editMeesage);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/HomeProfile.jsp");
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
            MessageInfoBean editMeesage = new MessageInfoBean();
            editMeesage.setMessage("Phone number is invalid. Please enter again.");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("editMeesage", editMeesage);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/HomeProfile.jsp");
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
            RequestDispatcher rd = SC.getRequestDispatcher("/HomeProfile.jsp");
            rd.forward(request, response);
        }
        
        if(zipcode.length() != 5){
            MessageInfoBean editMeesage = new MessageInfoBean();
            editMeesage.setMessage("Zipcode is invalid. Please enter again.");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("editMeesage", editMeesage);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/HomeProfile.jsp");
            rd.forward(request, response);
        }
        
        java.sql.Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
        boolean valid = birthday.after(timeNow);
        if (valid) {
            MessageInfoBean editMeesage = new MessageInfoBean();
            editMeesage.setMessage("Date of Birgh is invalid. Please enter again.");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("editMeesage", editMeesage);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/HomeProfile.jsp");
            rd.forward(request, response);
        }
        
       
        
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/project";
            conn = DriverManager.getConnection(connectionURL,"test","test");
            PreparedStatement ps = conn.prepareStatement("Update homecustomer set firstname=?, lastname=?, marriage_status=?, gender=?, birth_date=?, address=?, zipcode=?, phone=?, email=? where username=?");
                       
            ps.setObject(1, firstname);
            ps.setObject(2, lastname);
            ps.setObject(3, marriagestatus);
            ps.setObject(4, gender);
            ps.setObject(5, birthday);
            ps.setObject(6, street);            
            ps.setObject(7, zipcode);
            ps.setObject(8, phone);
            ps.setObject(9, email);    
            ps.setObject(10, username);
            ps.executeUpdate();
            
            
            MessageInfoBean editMessage = new MessageInfoBean();
            editMessage.setMessage("You have updated your profile successfully!");
            HttpSession session = request.getSession();
            session.setAttribute("editMessage",editMessage);
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
