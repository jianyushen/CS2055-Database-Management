/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.yuq6;

/**
 *
 * @author Yu Qiu
 */
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


public class HomeRegister extends HttpServlet{
    private Connection conn;
    private ResultSet rs = null;
    private Statement st;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstname = request.getParameter("name");
        String lastname = request.getParameter("name1");
        String marriagestatus = request.getParameter("marital");
        String gender = request.getParameter("gender");
        String street = request.getParameter("address1");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        PreparedStatement ps = null;
        boolean valid = false;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/project";
            conn = DriverManager.getConnection(connectionURL,"test","test");
            st = conn.createStatement();
            //ps = conn.prepareStatement
            String query = ("Insert into homecustomer(username, userpassword, firstname, lastname, "
                    + "street, city, state, marriage_status, gender) values ('" + username + "','" + password + "','" + firstname
                    + "','" + lastname + "','" + street + "','" + city + "','" + state + "','" + marriagestatus + "','" + gender + "')");
            //ps.setObject(1,username);
            //ps.setObject(2,password);            
            //rs = ps.executeQuery();
            st.execute(query);
            valid = true;
            
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(ClassNotFoundException ex){
            Logger.getLogger(HomeRegister.class.getName()).log(Level.SEVERE,null,ex);
        }
        if(valid){
                UserInfoBean userInfo = new UserInfoBean();
                userInfo.setUsername(username);
                HttpSession session = request.getSession();
                session.setAttribute("userInfo",userInfo);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/homepage.jsp");
                rd.forward(request, response);
            }else{
                request.getRequestDispatcher("/HomeRegister.jsp").forward(request, response);
            }
        
    }

    
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HomeRegister.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HomeRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HomeRegister.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HomeRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
