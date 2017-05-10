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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pc
 */
public class RecordNum extends HttpServlet {
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
            //record num         
            String quatity = request.getParameter("type");            
            if(quatity.equals("--select--")){
                String Message ="Please select one number.";
                request.setAttribute("cartMessage", Message);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/cart.jsp");
                rd.forward(request, response);
            }else{
                int iq;
                iq = Integer.parseInt(quatity);
                HttpSession session = request.getSession();
                session.setAttribute("num", iq); 
                
                 try{
                        Class.forName("org.apache.derby.jdbc.ClientDriver");
                        String connectionURL = "jdbc:derby://localhost:1527/project";
                        conn = DriverManager.getConnection(connectionURL,"test","test");
                        
                        ProductInfoBean proInfo = new ProductInfoBean();
                        proInfo = (ProductInfoBean) session.getAttribute("productInfo");         
                        //change productId
                        String productId = proInfo.getProductId();
                        st = conn.createStatement();
                        String q1="select inventoryamount from products where productid='"+productId+"'";
                        // y= st.execute(q1);
                        rs =st.executeQuery(q1);
                        int inventory;
                        rs.next();
                        String it = rs.getString("inventoryamount");
                        inventory = Integer.parseInt(it);
                        if(iq <= inventory){
                            String Message ="Please finish following info.";
                            request.setAttribute("buyMessage", Message);
                            ServletContext SC = getServletContext();
                            RequestDispatcher rd = SC.getRequestDispatcher("/buy.jsp");
                            rd.forward(request, response);
                        }
                        else{
                            String Message ="Sorry we don't have so much products.";
                            request.setAttribute("cartMessage", Message);
                            ServletContext SC = getServletContext();
                            RequestDispatcher rd = SC.getRequestDispatcher("/cart.jsp");
                            rd.forward(request, response);
                        }
                 }
                 catch(SQLException se){
                      se.printStackTrace();
                 }
                 catch(ClassNotFoundException ex){
                      Logger.getLogger(RecordNum.class.getName()).log(Level.SEVERE,null,ex);
                 }
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
