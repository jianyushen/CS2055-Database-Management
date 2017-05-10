/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.yuq6;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
public class LoginCheck extends HttpServlet{
    private Connection conn;
    private ResultSet rs = null;
    private Statement st;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String loginUsername = request.getParameter("id");
        String loginPassword = request.getParameter("password");
        String loginType = request.getParameter("type");
        PreparedStatement ps = null;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/project";
            conn = DriverManager.getConnection(connectionURL,"test","test");
            switch (loginType) {
                case "Customer":
                    ps = conn.prepareStatement("SELECT * from customers where username=? and userpassword=?");
                    break;
                case "Admin":
                    ps = conn.prepareStatement("SELECT * from administrator where admin_name=? and admin_password=?");
                    break;
                case "Seller":
                    ps = conn.prepareStatement("SELECT * from salesperson where sales_username=? and sales_password=?");
                    break;
                default:
                    MessageInfoBean loginMessage = new MessageInfoBean();
                    loginMessage.setMessage("You must select one of user types.");
                    HttpSession sesson = request.getSession();
                    sesson.setAttribute("loginMessage",loginMessage);
                    ServletContext SC = getServletContext();
                    RequestDispatcher rd = SC.getRequestDispatcher("/login.jsp");
                    rd.forward(request, response);
                    break;
            }
            ps.setObject(1,loginUsername);
            ps.setObject(2,loginPassword);
            rs = ps.executeQuery();
            if (rs.next()) {
                if (loginType.equals("Admin")) {
                    ServletContext SC = getServletContext();
                    RequestDispatcher rd = SC.getRequestDispatcher("/AdminPage.jsp");
                    rd.forward(request, response);
                } if (loginType.equals("Seller")) {
                    PreparedStatement ps2 = conn.prepareStatement("SELECT * from salesperson where sales_username=?");
                    ps2.setObject(1,loginUsername);
                    rs = ps2.executeQuery();
                    rs.next();
                    String title = rs.getString("job_title");
                    
                    if(title.equals("store manager")){
                        UserInfoBean userInfo = new UserInfoBean();
                        userInfo.setUsername(loginUsername);
                        HttpSession session = request.getSession();
                        session.setAttribute("userInfo", userInfo);
                        ServletContext SC = getServletContext();

                        RequestDispatcher rd = SC.getRequestDispatcher("/storeManager.jsp");
                        rd.forward(request, response);
                    }else if(title.equals("salesman")){
                        UserInfoBean userInfo = new UserInfoBean();
                        userInfo.setUsername(loginUsername);
                        HttpSession session = request.getSession();
                        session.setAttribute("userInfo", userInfo);
                        ServletContext SC = getServletContext();

                        RequestDispatcher rd = SC.getRequestDispatcher("/seller.jsp");
                        rd.forward(request, response);
                    }else{
                        UserInfoBean userInfo = new UserInfoBean();
                        userInfo.setUsername(loginUsername);
                        HttpSession session = request.getSession();
                        session.setAttribute("userInfo", userInfo);
                        ServletContext SC = getServletContext();

                        RequestDispatcher rd = SC.getRequestDispatcher("/loginsuccess.jsp");
                        rd.forward(request, response);
                    }
                } else {
                    UserInfoBean userInfo = new UserInfoBean();
                    userInfo.setUsername(loginUsername);
                    HttpSession session = request.getSession();
                    session.setAttribute("userInfo", userInfo);
                    ServletContext SC = getServletContext();

                    RequestDispatcher rd = SC.getRequestDispatcher("/loginsuccess.jsp");
                    rd.forward(request, response);
                }
            }else{
                MessageInfoBean loginMessage = new MessageInfoBean();
                loginMessage.setMessage("Your username or password is not correct.");
                HttpSession sesson = request.getSession();
                sesson.setAttribute("loginMessage", loginMessage);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/login.jsp");
                rd.forward(request, response);

            }
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(ClassNotFoundException ex){
            Logger.getLogger(LoginCheck.class.getName()).log(Level.SEVERE,null,ex);
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