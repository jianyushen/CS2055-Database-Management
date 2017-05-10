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
public class StoreUpdateReq extends HttpServlet{
    private Connection conn;
    private ResultSet rs = null;
    private Statement st;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException{
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        String storeID = request.getParameter("storeID");
        
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/project";
            conn = DriverManager.getConnection(connectionURL,"test","test");
            PreparedStatement ps1 = conn.prepareStatement("Select * from store where storeID=?");
            ps1.setObject(1,storeID);
            rs = ps1.executeQuery();
            if(!rs.next()){
                MessageInfoBean storeMessage = new MessageInfoBean();                
                storeMessage.setMessage("StoreID doesn't exsit. Please try another one.");
                HttpSession sesson = request.getSession();
                sesson.setAttribute("storeMessage",storeMessage);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/AdminPage.jsp");
                rd.forward(request, response);
            }
        }catch(ClassNotFoundException ex){
            Logger.getLogger(StoreUpdateReq.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/project";
            conn = DriverManager.getConnection(connectionURL, "test", "test");
            PreparedStatement ps = conn.prepareStatement("Select * from store where storeID=?");
            ps.setObject(1, storeID);
            rs = ps.executeQuery();
            rs.next();
            StoreInfoBean storeInfo = new StoreInfoBean();
            storeInfo.setStoreID(storeID);
            storeInfo.setAddress(rs.getString(2));
            storeInfo.setManager(rs.getString(3));
            storeInfo.setNumofsales(rs.getInt(4));
            storeInfo.setRegion(rs.getString(5));
            HttpSession sesson = request.getSession();
            sesson.setAttribute("storeInfo", storeInfo);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/AdminPage.jsp");
            rd.forward(request, response);
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StoreUpdateReq.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StoreUpdateReq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StoreUpdateReq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
