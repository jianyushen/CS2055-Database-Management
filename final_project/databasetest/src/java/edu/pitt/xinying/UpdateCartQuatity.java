/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.xinying;

import edu.pitt.yuq6.UserInfoBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
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
public class UpdateCartQuatity extends HttpServlet {

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
            
            HttpSession session = request.getSession();
            ShoppingCartBean shoppingcart = new ShoppingCartBean();
            shoppingcart = (ShoppingCartBean) session.getAttribute("shoppingcart");
            
            UserInfoBean user = (UserInfoBean) request.getSession().getAttribute("userInfo");
            String custmerid = user.getUsername();
            String productId = shoppingcart.getProductID();                       
            String orderid =shoppingcart.getShopping_date();       
            String num = session.getAttribute("num").toString();
            
            
            String name= request.getParameter("name");
            String address = request.getParameter("address");
            String shipmethod = request.getParameter("shipmethod");
            String card = request.getParameter("card");
            HashSet<Character> set = new HashSet<Character>();
            set.add(';');
            set.add(':');
            set.add(',');
            set.add('#');
            set.add('&');
            set.add('\'');
            set.add('\"');
            set.add('.');
            set.add('!');
            set.add('?');
            set.add('[');
            set.add(']');

        for (int i = 0; i < name.length(); i++) {
            char temp = name.charAt(i);
            if (set.contains(temp)) {
                String Message ="You include illegal input in Username(eg: [;:,#&\\'\\\".!?]). Please check.";
                request.setAttribute("buyMessage", Message);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/buy.jsp");
                rd.forward(request, response);
            }
        }  
        for (int i = 0; i < address.length(); i++) {
            char temp = address.charAt(i);
            if (set.contains(temp)) {
                String Message ="You include illegal input in Username(eg: [;:,#&\\'\\\".!?]). Please check.";
                request.setAttribute("buyMessage", Message);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/buy.jsp");
                rd.forward(request, response);
            }
        }  
        for (int i = 0; i < shipmethod.length(); i++) {
            char temp = shipmethod.charAt(i);
            if (set.contains(temp)) {
                String Message ="You include illegal input in Username(eg: [;:,#&\\'\\\".!?]). Please check.";
                request.setAttribute("buyMessage", Message);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/buy.jsp");
                rd.forward(request, response);
            }
        }
        for (int i = 0; i < card.length(); i++) {
            char temp = card.charAt(i);
            if (set.contains(temp)) {
                String Message ="You include illegal input in Username(eg: [;:,#&\\'\\\".!?]). Please check.";
                request.setAttribute("buyMessage", Message);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/buy.jsp");
                rd.forward(request, response);
            }
        }
        if(name.length() <= 0 || address.length() <= 0 || shipmethod.length() <= 0 || card.length() <= 0){
            String Message ="You cannot leave required fields blank. Please check.";
            request.setAttribute("buyMessage", Message);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/buy.jsp");
            rd.forward(request, response);
        }
            
            
            int iq = Integer.parseInt(num);
           /* String quatity = request.getParameter("type");
            iq = Integer.parseInt(quatity);*/
            
            //insert into transaction
            st = conn.createStatement();
            String q1 = "insert into ptransaction(orderid,productid,customerid,quantity) values('"+orderid+"','"+productId+"','"+custmerid+"',"+iq+")";
            int t = st.executeUpdate(q1);
            
            //clear shoppingcart
            ps = conn.prepareStatement("delete from shoppingcart where productid=? and customerid=?");
            ps.setObject(1, productId);
            ps.setObject(2, custmerid);
            ps.execute();
            
            st = conn.createStatement();
            String q2 ="update products set saleamount= saleamount+"+iq+", inventoryamount=inventoryamount-"+iq+" where productid='"+productId+"'";
            st.executeUpdate(q2);
            
            if (t>0){
                    String Message ="Hi, "+request.getParameter("name")+", we will soon ship to "+request.getParameter("address");
                    request.setAttribute("buyMessage", Message);
                    ServletContext SC = getServletContext();
                    RequestDispatcher rd = SC.getRequestDispatcher("/buy.jsp");
                    rd.forward(request, response);
            }else{
                out.println("That's something wrong in here.");
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
            Logger.getLogger(UpdateCartQuatity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateCartQuatity.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UpdateCartQuatity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateCartQuatity.class.getName()).log(Level.SEVERE, null, ex);
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
