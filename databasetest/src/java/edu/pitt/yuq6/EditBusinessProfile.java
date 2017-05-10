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
public class EditBusinessProfile extends HttpServlet{
    private Connection conn;
    private ResultSet rs = null;
    private Statement st;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException{
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        BusinessCustomerBean cus = (BusinessCustomerBean) request.getSession().getAttribute("cusbean");
        String username = cus.getUsername();

        String companyname = request.getParameter("companyname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        
        String street = request.getParameter("street");
        String zipcode = request.getParameter("zip");
        long income = 0;
        String annualIncome = request.getParameter("income");        
        String category = request.getParameter("category");
        
        try{
            income = parseLong(annualIncome);
        }catch(NumberFormatException e){
            MessageInfoBean editMessage = new MessageInfoBean();
            editMessage.setMessage("You input of Annual Income is illeage. Please check.");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("editMessage", editMessage);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/BusinessProfile.jsp");
            rd.forward(request, response);
        }
        if(income < 0){
            MessageInfoBean editMessage = new MessageInfoBean();
            editMessage.setMessage("You input of Annual Income is illeage. Please check.");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("editMessage", editMessage);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/BusinessProfile.jsp");
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

        
        
        for (int i = 0; i < companyname.length(); i++) {
            char temp = companyname.charAt(i);
            if (set.contains(temp)) {
                MessageInfoBean editMessage = new MessageInfoBean();
                editMessage.setMessage("You include illegal input in Company Name(eg: [;:,#&\'\".!?]). Please check.");
                HttpSession sesson = request.getSession();
                sesson.setAttribute("editMessage", editMessage);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/BusinessProfile.jsp");
                rd.forward(request, response);
            }
        }
        
        if(companyname.length() <= 0 ||  email.length() <= 0 || street.length() <= 0 ){
            MessageInfoBean editMessage = new MessageInfoBean();
            editMessage.setMessage("You cannot leave required fields blank. Please check.");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("editMessage", editMessage);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/BusinessProfile.jsp");
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
            MessageInfoBean editMessage = new MessageInfoBean();
            editMessage.setMessage("Phone number is invalid. Please enter again.");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("editMessage", editMessage);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/BusinessProfile.jsp");
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
            MessageInfoBean editMessage = new MessageInfoBean();
            editMessage.setMessage("Email address is invalid. Please enter again.");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("editMessage", editMessage);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/BusinessProfile.jsp");
            rd.forward(request, response);
        }
                
        if(zipcode.length() != 5){
            MessageInfoBean editMessage = new MessageInfoBean();
            editMessage.setMessage("Zipcode is invalid. Please enter again.");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("editMessage", editMessage);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/BusinessProfile.jsp");
            rd.forward(request, response);
        }
                
        
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/project";
            conn = DriverManager.getConnection(connectionURL,"test","test");
            PreparedStatement ps = conn.prepareStatement("Update businesscustomer set company_name=?, phone=?, email=?, address=?, zipcode=?, company_income=?, business_category=? where username=?");
            
            ps.setObject(1, companyname);
            ps.setObject(2, phone);
            ps.setObject(3, email);
            ps.setObject(4, street);
            ps.setObject(5, zipcode);
            ps.setObject(6, income);
            ps.setObject(7, category);   
            ps.setObject(8, username); 
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
