package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class buy_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\r\n");
      out.write("<title>Order Checkout</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".right {\ttext-align: right;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("    body\r\n");
      out.write("        {\r\n");
      out.write("            background:url('BG.png') no-repeat center center fixed;\r\n");
      out.write("            background-size: cover;\r\n");
      out.write("            -webkit-background-size: cover;\r\n");
      out.write("            -moz-background-size: cover;\r\n");
      out.write("            -o-background-size: cover;\r\n");
      out.write("            margin:  0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
 String message=(String) request.getAttribute("buyMessage"); 
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write(" <center><font color=\"red\"><b>");
 out.print(message);
      out.write("</b><br/></font></center>\r\n");
      out.write("  <table width=\"993\" height=\"102\" border=\"0\">\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td width=\"251\" height=\"96\"><img src=\"head.png\" width=\"251\" height=\"88\" alt=\"Logo\" /></td>\r\n");
      out.write("      <td width=\"726\" class=\"right\">| <a href=\"homepage.jsp\"><font color=\"black\">Home</a> |\r\n");
      out.write("        \r\n");
      out.write("        <a href=\"login.jsp\"><font color=\"black\">Login</a>\r\n");
      out.write("        \r\n");
      out.write("        <a href=\"logout.jsp\"><font color=\"black\">Logout</a>\r\n");
      out.write("        </td>\r\n");
      out.write("    </tr>   \r\n");
      out.write("  </table>\r\n");
      out.write("  <hr />    \r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write(" <table align=\"center\">\r\n");
      out.write(" <strong ><em><center>Order Checkout</center></em></strong>\r\n");
      out.write("   <form action=\"UpdateCartQuatity\" method=\"post\"><b>\r\n");
      out.write("           <tr><td>Name</td><td><input type=\"text\" name=\"name\"></td></tr>\r\n");
      out.write("           <tr><td>Shipping Address1</td><td><input type=\"text\" name=\"address\"></td></tr>\r\n");
      out.write("           <tr><td>Shipping Method</td><td><input type=\"text\" name=\"shipmethod\"></td></tr>\r\n");
      out.write("            <tr><td>Card details</td><td><input type=\"text\" name=\"card\"></td></tr>\r\n");
      out.write("            \r\n");
      out.write("            </b><tr><td></td><td><input type=\"submit\" value=\"Submit\" /></td></tr>\r\n");
      out.write("            </table>\r\n");
      out.write("            </form>\r\n");
      out.write("        \r\n");
      out.write("   <!--put purchase information in MySQL-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \t <p>Click <a href=\"homepage.jsp\">here</a> to go to the Home Page to continue shopping!\r\n");
      out.write("    \t   </p> \r\n");
      out.write(" \r\n");
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
