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
import java.util.Date;
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
public class ManagerAddPro extends HttpServlet {

private Connection conn;
    private ResultSet rs = null;
    private Statement st;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        PreparedStatement ps = null;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/project";
            conn = DriverManager.getConnection(connectionURL,"test","test");
            
            
            /*HttpSession session = request.getSession();
            ProductInfoBean proInfo = new ProductInfoBean();
            proInfo = (ProductInfoBean) session.getAttribute("productInfo");*/
            String productid = request.getParameter("productid");
            String productName = request.getParameter("productname");
            int inventory_amount;
            String i = request.getParameter("inventory_amount");
            inventory_amount= Integer.parseInt(i);
            double price;
            String p =request.getParameter("price");
            price = Double.valueOf(p);
            String brand = request.getParameter("brand");
            String product_description = request.getParameter("description");
            
            st = conn.createStatement();           
            //String q1 = "insert into shoppingcart (productid,customerid,shopping_date,productname,quantity,price) values ('"+productId+"','"+custmerid+"','"+df.format(now)+"','"+productName+"',"+proInfo.getInventory_amount()+","+price+")";
            String q1 ="insert into products(productid,productname,inventoryamount,price,brand,product_description) values('"+productid+"','"+productName+"',"+inventory_amount+","+price+",'"+brand+"','"+product_description+"')";
            boolean t = st.execute(q1);
            if(t){
                out.print("Fail!");
            }else{               
                out.print("Successful create products!");
            }                   
           /* ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/cart.jsp");
            rd.forward(request, response);*/
           
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(ClassNotFoundException ex){
            Logger.getLogger(AddtoCart.class.getName()).log(Level.SEVERE,null,ex);
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
        Logger.getLogger(ManagerAddPro.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(ManagerAddPro.class.getName()).log(Level.SEVERE, null, ex);
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
        Logger.getLogger(ManagerAddPro.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(ManagerAddPro.class.getName()).log(Level.SEVERE, null, ex);
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
