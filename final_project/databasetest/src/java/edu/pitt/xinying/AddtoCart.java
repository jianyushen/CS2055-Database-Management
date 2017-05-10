/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.xinying;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import edu.pitt.yuq6.MessageInfoBean;
import edu.pitt.yuq6.UserInfoBean;
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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pc
 */
public class AddtoCart extends HttpServlet {
    private Connection conn;
    private ResultSet rs = null;
    private Statement st;
    boolean y = false;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        UserInfoBean user = (UserInfoBean) request.getSession().getAttribute("userInfo");
        String username = user.getUsername();
        
        if(username == null){
            MessageInfoBean loginMessage = new MessageInfoBean();
            loginMessage.setMessage("Please login first.");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("loginMessage", loginMessage);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
        PreparedStatement ps = null;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/project";
            conn = DriverManager.getConnection(connectionURL,"test","test");
            
            HttpSession session = request.getSession();
            ProductInfoBean proInfo = new ProductInfoBean();
            proInfo = (ProductInfoBean) session.getAttribute("productInfo");
           
            //change productId
            String productId = proInfo.getProductId();
            String productName =proInfo.getProduct_name();            
            String img = proInfo.getImg();
            
            Double price = proInfo.getPrice();  
                    
            Date now = new Date();
            java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            st = conn.createStatement();
            String q0="select * from shoppingcart where productid='"+productId+"' and customerid='"+username+"'";
            y= st.execute(q0);
            if(y){
                st = conn.createStatement();
                String q1 = "insert into shoppingcart (productid,customerid,shopping_date,productname,quantity,price) values ('"+productId+"','"+username+"','"+df.format(now)+"','"+productName+"',"+proInfo.getInventory_amount()+","+price+")";
                boolean t = st.execute(q1);
            
                ShoppingCartBean shoppingcart =new ShoppingCartBean();
                shoppingcart.setCustomerID(username);
                shoppingcart.setProductID(productId);
                shoppingcart.setPrice(price);
                shoppingcart.setProduct_name(productName);
                shoppingcart.setShopping_date(df.format(now));
                shoppingcart.setImg(img);
                
                //buy quatity intial only 1
                shoppingcart.setQuatity(1);
                
                session.setAttribute("shoppingcart",shoppingcart);
                if(t){
                    String Message ="Add to shopping cart failed.";
                    request.setAttribute("cartMessage", Message);
                
                    ServletContext SC = getServletContext();
                    RequestDispatcher rd = SC.getRequestDispatcher("/cart.jsp");
                    rd.forward(request, response);
                }else{    
                    String Message ="Add to shopping cart successfully.";
                    request.setAttribute("cartMessage", Message);
                    ServletContext SC = getServletContext();
                    RequestDispatcher rd = SC.getRequestDispatcher("/cart.jsp");
                    rd.forward(request, response);
                }
           }
           else{                               
               out.print(y);
               out.print("Sorry,this product has already been added to the shopping cart.");
           }
               
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
            Logger.getLogger(AddtoCart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddtoCart.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddtoCart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddtoCart.class.getName()).log(Level.SEVERE, null, ex);
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
