package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\r');
      out.write('\n');
      edu.pitt.yuq6.MessageInfoBean loginMessage = null;
      synchronized (session) {
        loginMessage = (edu.pitt.yuq6.MessageInfoBean) _jspx_page_context.getAttribute("loginMessage", PageContext.SESSION_SCOPE);
        if (loginMessage == null){
          loginMessage = new edu.pitt.yuq6.MessageInfoBean();
          _jspx_page_context.setAttribute("loginMessage", loginMessage, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\r\n");
      out.write("    <title>Log in page</title>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("    .right {text-align: right;}\r\n");
      out.write("        body{\r\n");
      out.write("            background:url('BG.png') no-repeat center center fixed;\r\n");
      out.write("            background-size: cover;\r\n");
      out.write("            -webkit-background-size: cover;\r\n");
      out.write("            -moz-background-size: cover;\r\n");
      out.write("            -o-background-size: cover;\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <center>\r\n");
      out.write("        <font color=\"red\"><b>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((edu.pitt.yuq6.MessageInfoBean)_jspx_page_context.findAttribute("loginMessage")).getMessage())));
      out.write("</b><br/></font>\r\n");
      out.write("        <form action=\"LoginCheck\" method=\"post\">\r\n");
      out.write("            <table width=\"993\" height=\"102\" border=\"0\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td width=\"251\" height=\"96\"><img src=\"head.png\" width=\"251\" height=\"88\" alt=\"Logo\" /></td>\r\n");
      out.write("                    <td width=\"726\" class=\"right\">| <a href=\"homepage.jsp\"><font color=\"black\">Home</a> |\r\n");
      out.write("\r\n");
      out.write("                        <a href=\"login.jsp\"><font color=\"black\">Login</a>\r\n");
      out.write("\r\n");
      out.write("                        <a href=\"logout.jsp\"><font color=\"black\">Logout</a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <table align=\"center\">\r\n");
      out.write("                </table>\r\n");
      out.write("            </table>\r\n");
      out.write("            <hr/>\r\n");
      out.write("            <table width=\"1\"> \r\n");
      out.write("                <tr> \r\n");
      out.write("                    <strong><em>User Login </em></strong>\r\n");
      out.write("                </Tr> \r\n");
      out.write("                <tr> \r\n");
      out.write("                    <td> Username: </td> \r\n");
      out.write("                    <td> <input type=\"text\" name=\"id\"> </td> \r\n");
      out.write("                </Tr> \r\n");
      out.write("                <tr> \r\n");
      out.write("                    <td> Password: </td> \r\n");
      out.write("                    <td> <input type=\"password\" name=\"password\"> </td> \r\n");
      out.write("                </Tr> \r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Type of Account: </td> \r\n");
      out.write("                    <td><select name=\"type\"><option selected=\"select\">--select--</option>\r\n");
      out.write("                            <option>Customer</option>\r\n");
      out.write("                            <option>Admin</option> \r\n");
      out.write("                            <option>Seller</option> \r\n");
      out.write("                        </select></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr> \r\n");
      out.write("                    <td> <input type=\"submit\" value=\"Log In\"> </td> \r\n");
      out.write("                    <td><input type=\"reset\" value=\"Clear\"></td> \r\n");
      out.write("                </Tr> \r\n");
      out.write("            </Table>\r\n");
      out.write("        </Form> \r\n");
      out.write("    </Center>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
