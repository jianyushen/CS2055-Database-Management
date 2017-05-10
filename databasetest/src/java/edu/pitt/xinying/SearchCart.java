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
public class SearchCart extends HttpServlet {

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
             ps = conn.prepareStatement("SELECT * from products where productid =?");
             ps.setObject(1,request.getParameter("file"));
             rs = ps.executeQuery();
                         
            if(rs.next()){              
                ProductInfoBean productInfo =new ProductInfoBean();
                productInfo.setProductId(request.getParameter("file")); 
                
                productInfo.setProduct_name(rs.getString(2));
                productInfo.setPrice(rs.getDouble(5));
                productInfo.setBrand(rs.getString(6));
                productInfo.setInventory_amount(rs.getInt(3));
                productInfo.setProduct_description(rs.getString(8));
              //  productInfo.setProductId(q1);
                
                HttpSession session = request.getSession();
                session.setAttribute("productInfo",productInfo);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/product.jsp");
                rd.forward(request, response);
                
            }else{
                request.getRequestDispatcher("/loginfail.jsp").forward(request, response);
            }
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(ClassNotFoundException ex){
            Logger.getLogger(SearchCart.class.getName()).log(Level.SEVERE,null,ex);
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
