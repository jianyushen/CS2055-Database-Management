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

/**
 *
 * @author pc
 */
public class OrderShows extends HttpServlet {
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
            
                   
             PreparedStatement ps = null;
           // String id = request.getParameter("productId");
            //String q1 = "SELECT * from products where productid="+ request.getParameter("file");
             ps = conn.prepareStatement("select * from homecustomer c, products p, ptransaction pt where c.USERNAME = pt.CUSTOMERID and pt.PRODUCTID = p.PRODUCTID and pt.orderid= ?");
             ps.setObject(1,request.getParameter("order_brows"));
             rs = ps.executeQuery();
             
            if(rs.next()){    
                out.print("<img width=\"200\" height=\"200\" src=\""+rs.getString("imagelocation")+"\"");
                out.print("<br/>");
                out.print("<br/>");
                out.print("<br/>");
                out.print("Product Name:");
                out.print(rs.getString("productname"));
                out.print("<br/>");
                out.print("Inventory amount:");
                out.print(rs.getString("inventoryamount"));
                out.print("<br/>");
                out.print("saleamount:");
                out.print(rs.getString("saleamount"));
                out.print("<br/>");
                out.print("Price:");
                out.print(rs.getString("price"));
                out.print("<br/>");
                out.print("Brand:");
                out.print(rs.getString("brand"));
                out.print("<br/>");
                out.print("Product Description:");
                out.print(rs.getString("product_description"));
                out.print("<br/>");
                out.print("Name:");
                out.print(rs.getString("firstname"));
                out.print("<br/>");
                out.print("Street:");
                out.print(rs.getString("street"));
                out.print(" ");
                out.print("City:");
                out.print(rs.getString("city"));
                out.print(" ");
                out.print("State:");
                out.print(rs.getString("state"));
                out.print(" ");
                out.print("Zipcode:");
                out.print(rs.getString("zipcode"));
                
            }else{
               out.print("Sorry, we don't have this product.");
            }
            conn.close();
                      
        }catch(SQLException se){
            se.printStackTrace();
        }catch(ClassNotFoundException ex){
            Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE,null,ex);
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
