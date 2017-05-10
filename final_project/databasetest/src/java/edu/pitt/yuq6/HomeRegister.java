/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.yuq6;

/**
 *
 * @author Yu Qiu
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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


public class HomeRegister extends HttpServlet{
    private Connection conn;
    private ResultSet rs = null;
    private Statement st;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException{
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String marriagestatus = request.getParameter("marital");
        String gender = request.getParameter("gender");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
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

        for (int i = 0; i < username.length(); i++) {
            char temp = username.charAt(i);
            if (set.contains(temp)) {
                MessageInfoBean registerMessage = new MessageInfoBean();
                registerMessage.setMessage("You include illegal input in Username(eg: [;:,#&\'\".!?]). Please check.");
                HttpSession sesson = request.getSession();
                sesson.setAttribute("registerMessage", registerMessage);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/registerHome.jsp");
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
                RequestDispatcher rd = SC.getRequestDispatcher("/registerHome.jsp");
                rd.forward(request, response);
            }
        }
        
        for (int i = 0; i < firstname.length(); i++) {
            char temp = firstname.charAt(i);
            if ((temp < 'A') || (temp > 'Z' && temp < 'a') || (temp > 'z')) {
                MessageInfoBean registerMessage = new MessageInfoBean();
                registerMessage.setMessage("Your lastname input is illegal. Please check.");
                HttpSession sesson = request.getSession();
                sesson.setAttribute("registerMessage", registerMessage);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/registerHome.jsp");
                rd.forward(request, response);
            }
        }
        
        
        for (int i = 0; i < lastname.length(); i++) {
            char temp = lastname.charAt(i);
            if ((temp < 'A') || (temp > 'Z' && temp < 'a') || (temp > 'z')) {
                MessageInfoBean registerMessage = new MessageInfoBean();
                registerMessage.setMessage("Your lastname input is illegal. Please check.");
                HttpSession sesson = request.getSession();
                sesson.setAttribute("registerMessage", registerMessage);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/registerHome.jsp");
                rd.forward(request, response);
            }
        }
        
        if(firstname.length() <= 0 || lastname.length() <= 0 || username.length() <= 0 || password.length() <= 0 || email.length() <= 0 || street.length() <= 0 || city.length() <= 0){
            MessageInfoBean registerMessage = new MessageInfoBean();
            registerMessage.setMessage("You cannot leave required fields blank. Please check.");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("registerMessage", registerMessage);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/registerHome.jsp");
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
            RequestDispatcher rd = SC.getRequestDispatcher("/registerHome.jsp");
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
            RequestDispatcher rd = SC.getRequestDispatcher("/registerHome.jsp");
            rd.forward(request, response);
        }
        
        if(zipcode.length() != 5){
            MessageInfoBean registerMessage = new MessageInfoBean();
            registerMessage.setMessage("Zipcode is invalid. Please enter again.");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("registerMessage", registerMessage);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/registerHome.jsp");
            rd.forward(request, response);
        }
        
        java.sql.Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
        boolean valid = birthday.after(timeNow);
        if (valid) {
            MessageInfoBean registerMessage = new MessageInfoBean();
            registerMessage.setMessage("Date of Birgh is invalid. Please enter again.");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("registerMessage", registerMessage);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/registerHome.jsp");
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
                RequestDispatcher rd = SC.getRequestDispatcher("/registerHome.jsp");
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
            PreparedStatement ps = conn.prepareStatement("INSERT into homecustomer(username, firstname, lastname, marriage_status, gender, birth_date, address, zipcode, phone, email) values (?,?,?,?,?,?,?,?,?,?)");
            ps.setObject(1, username);           
            ps.setObject(2, firstname);
            ps.setObject(3, lastname);
            ps.setObject(4, marriagestatus);
            ps.setObject(5, gender);
            ps.setObject(6, birthday);
            ps.setObject(7, street);            
            ps.setObject(8, zipcode);
            ps.setObject(9, phone);
            ps.setObject(10, email);           
            ps.executeUpdate();
            
            PreparedStatement ps2 = conn.prepareStatement("INSERT INTO customers values(?,?,?)");
            String custype = "home";
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
            RequestDispatcher rd = SC.getRequestDispatcher("/login.jsp");
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
