/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.xinying;

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
public class ManagerUpdatePro extends HttpServlet {
 private Connection conn;
    private ResultSet rs = null;
    private Statement st;
    int r;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        PreparedStatement ps = null;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/project";
            conn = DriverManager.getConnection(connectionURL,"test","test");
            
            HttpSession session = request.getSession();
            String productId = session.getAttribute("pId").toString();
            
            ps = conn.prepareStatement("update products set productid=?,productname=?,inventoryamount=?,price=?,brand=?,product_description=? where productid=?");
            ps.setObject(1, request.getParameter("productid"));
            ps.setObject(2, request.getParameter("productname"));
            ps.setObject(3, request.getParameter("inventory_amount"));
            ps.setObject(4, request.getParameter("price"));
            ps.setObject(5, request.getParameter("brand"));
            ps.setObject(6, request.getParameter("description"));
            ps.setObject(7, productId);
            r = ps.executeUpdate();
            
            /*String q1 ="delete from products where productid='"+productId+"'";
            st = conn.createStatement();
            r = st.execute(q1);*/
            
            if(r<=0){
                out.println("nothing to delete, we appreciate your wait"+productId);
                                
            }else{                
                out.println("Successfully delete, we appreciate your effort");
            }
            
            conn.close();
             }catch(SQLException se){
            se.printStackTrace();
        }catch(ClassNotFoundException ex){
            Logger.getLogger(DeleteSC.class.getName()).log(Level.SEVERE,null,ex);
        }
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
     try {
         processRequest(request, response);
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(ManagerUpdatePro.class.getName()).log(Level.SEVERE, null, ex);
     } catch (SQLException ex) {
         Logger.getLogger(ManagerUpdatePro.class.getName()).log(Level.SEVERE, null, ex);
     }
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
     try {
         processRequest(request, response);
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(ManagerUpdatePro.class.getName()).log(Level.SEVERE, null, ex);
     } catch (SQLException ex) {
         Logger.getLogger(ManagerUpdatePro.class.getName()).log(Level.SEVERE, null, ex);
     }
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
