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
        PreparedStatement ps = null;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/project";
            conn = DriverManager.getConnection(connectionURL,"test","test");
            
            ps = conn.prepareStatement("SELECT * from homecustomer where username=? and userpassword=?");
            ps.setObject(1,loginUsername);
            ps.setObject(2,loginPassword);
            rs = ps.executeQuery();
            if(rs.next()){
                UserInfoBean userInfo = new UserInfoBean();
                userInfo.setUsername(loginUsername);
                HttpSession session = request.getSession();
                session.setAttribute("userInfo",userInfo);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/loginsuccess.jsp");
                rd.forward(request, response);
            }else{
                request.getRequestDispatcher("/loginfail.jsp").forward(request, response);
            }
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(ClassNotFoundException ex){
            Logger.getLogger(LoginCheck.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        
    }

    
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginCheck.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginCheck.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}