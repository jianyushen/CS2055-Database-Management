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
public class StoreInsert extends HttpServlet{
    private Connection conn;
    private ResultSet rs = null;
    private Statement st;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException{
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        String storeID = request.getParameter("storeID");
        String address = request.getParameter("address");
        String manager = request.getParameter("manager");
        int numofsales = 0;
        String num = request.getParameter("numofsales");
        String region = request.getParameter("region");
        
        try{
            numofsales = Integer.parseInt(num);
        }catch(NumberFormatException e){
            MessageInfoBean storeMessage = new MessageInfoBean();
            storeMessage.setMessage("You input of number of salesmen is illeage. Please check.");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("storeMessage", storeMessage);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/AdminPage.jsp");
            rd.forward(request, response);
        }
        
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/project";
            conn = DriverManager.getConnection(connectionURL,"test","test");
            PreparedStatement ps1 = conn.prepareStatement("Select * from store where storeID=?");
            ps1.setObject(1,storeID);
            rs = ps1.executeQuery();
            if(rs.next()){
                MessageInfoBean storeMessage = new MessageInfoBean();
                storeMessage.setMessage("StoreID has been used. Please try another one.");
                HttpSession sesson = request.getSession();
                sesson.setAttribute("storeMessage",storeMessage);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/AdminPage.jsp");
                rd.forward(request, response);
            }
        }catch(ClassNotFoundException ex){
            Logger.getLogger(StoreInsert.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/project";
            conn = DriverManager.getConnection(connectionURL,"test","test");
            PreparedStatement ps1 = conn.prepareStatement("Select * from salesperson where sales_username=?");
            ps1.setObject(1,manager);
            rs = ps1.executeQuery();
            rs.next();
            String title = rs.getString("job_title");
            if(!title.equals("store manager")){
                MessageInfoBean storeMessage = new MessageInfoBean();
                storeMessage.setMessage("Store manager is illegal. Please try another one.");
                HttpSession sesson = request.getSession();
                sesson.setAttribute("storeMessage",storeMessage);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/AdminPage.jsp");
                rd.forward(request, response);
            }
        }catch(ClassNotFoundException ex){
            Logger.getLogger(StoreInsert.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/project";
            conn = DriverManager.getConnection(connectionURL,"test","test");
            PreparedStatement ps1 = conn.prepareStatement("Select * from region where regionID=?");
            ps1.setObject(1,region);
            rs = ps1.executeQuery();
            if(!rs.next()){
                MessageInfoBean storeMessage = new MessageInfoBean();
                storeMessage.setMessage("Region is illegal. Please try another one.");
                HttpSession sesson = request.getSession();
                sesson.setAttribute("storeMessage",storeMessage);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/AdminPage.jsp");
                rd.forward(request, response);
            }
        }catch(ClassNotFoundException ex){
            Logger.getLogger(StoreInsert.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        
        
        if(numofsales < 0){
            MessageInfoBean storeMessage = new MessageInfoBean();
            storeMessage.setMessage("You input of number of salesmen is illeage. Please check.");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("storeMessage", storeMessage);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/AdminPage.jsp");
            rd.forward(request, response);
        }
        
        
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/project";
            conn = DriverManager.getConnection(connectionURL,"test","test");
            PreparedStatement ps1 = conn.prepareStatement("Select * from salesperson where sales_username=? and job_title=?");
            String jobTitle = "store manager";
            ps1.setObject(1, manager);
            ps1.setObject(2, jobTitle);
            rs = ps1.executeQuery();
            if(!rs.next()){
                MessageInfoBean storeMessage = new MessageInfoBean();
                storeMessage.setMessage("Manager is illegal. Please try another one.");
                HttpSession sesson = request.getSession();
                sesson.setAttribute("storeMessage",storeMessage);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/AdminPage.jsp");
                rd.forward(request, response);
            }
        }catch(ClassNotFoundException ex){
            Logger.getLogger(StoreInsert.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/project";
            conn = DriverManager.getConnection(connectionURL,"test","test");
            PreparedStatement ps = conn.prepareStatement("INSERT into store values (?,?,?,?,?)");
            ps.setObject(1, storeID);           
            ps.setObject(2, address);
            ps.setObject(3, manager);
            ps.setObject(4, numofsales);
            ps.setObject(5, region);
            ps.executeUpdate();
            
            MessageInfoBean storeMessage = new MessageInfoBean();
            storeMessage.setMessage("The store " + storeID +" has been created successfully");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("storeMessage", storeMessage);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/AdminPage.jsp");
            rd.forward(request, response);
            
              
            conn.close();
        }catch(ClassNotFoundException ex){
            Logger.getLogger(StoreInsert.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StoreInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StoreInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
