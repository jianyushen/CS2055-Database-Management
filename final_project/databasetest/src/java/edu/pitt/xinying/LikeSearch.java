/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.xinying;

import edu.pitt.yuq6.MessageInfoBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pc
 */
@WebServlet(name = "LikeSearch", urlPatterns = {"/LikeSearch"})
public class LikeSearch extends HttpServlet {
    private Connection conn;
    private ResultSet rs = null;
    private Statement st;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/project";
            conn = DriverManager.getConnection(connectionURL,"test","test");
            
            String ls = request.getParameter("search");
            st = conn.createStatement();
            String q1 = "select * from products where brand like '%"+ls+"%' or productname like '%"+ls+"%' or product_description like '%"+ls+"%'";
            rs =  st.executeQuery(q1);                    
        }catch(SQLException se){
            se.printStackTrace();
        }catch(ClassNotFoundException ex){
            Logger.getLogger(Orders.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        out.println("<ol>");
        try{
           if(rs.next())
           {
              out.print("We find some electronic same like what you search.");
              out.print("<hr/>");
              out.println("<li><a href=\"productDetail?file="+
                 rs.getString(1)+
                 "\">"+"Name:  "+rs.getString(2)+" Description: "+rs.getString(8)+"image:"+rs.getString("imagelocation")+"</a><img width=\"250\" height=\"300\" src=\""+rs.getString("imagelocation")+"\"></li>");
             
             //out.println("<li><a href=\"productDetail?productId='001' \">"+"nihao"+"</a></li>");
           }else{
            MessageInfoBean loginMessage = new MessageInfoBean();
            loginMessage.setMessage("Sorry we don't have that thing.");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("loginMessage", loginMessage);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/homepage.jsp");
            rd.forward(request, response);
           }
        }
        catch(SQLException sqle)
            {
            sqle.printStackTrace();  
         }
        out.println("</ol>");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
