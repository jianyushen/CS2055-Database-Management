package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class storeManagerAdd_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("<title>Register Page</title>\n");
      out.write("<style type=\"text/css\">\n");
      out.write(".right {\ttext-align: right;\n");
      out.write("}\n");
      out.write("    body{\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("        }\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write(" <center>\n");
      out.write("   <table width=\"993\" height=\"102\" border=\"0\">\n");
      out.write("     <tr>\n");
      out.write("       <td width=\"251\" height=\"96\"><img src=\"head.png\" width=\"251\" height=\"88\" alt=\"Logo\" /></td>\n");
      out.write("       <td width=\"720\" class=\"right\"> <a href=\"homepage.jsp\"><font color = \"black\">Home</a> |\n");
      out.write("\n");
      out.write("         <a href=\"login.jsp\"><font color = \"black\">Login</a>\n");
      out.write("         \n");
      out.write("         <a href=\"logout.jsp\"><font color = \"black\">Logout</a>\n");
      out.write("        </td>\n");
      out.write("     </tr>\n");
      out.write("   </table>\n");
      out.write("   <hr />\n");
      out.write("   <strong><em>Hello,please add products here</em></strong>\n");
      out.write("   <form action=\"\" method=\"post\">\n");
      out.write("       <table>\n");
      out.write("           <tr><td>ProductID*</td><td><input type=\"text\" name=\"productid\"/></td></tr>\n");
      out.write("           <tr><td>ProductName*</td><td><input type=\"text\" name=\"productname\"/></td></tr>\n");
      out.write("           <tr><td>Inventory Amount*</td><td><select name=\"inventory_amount\"><option selected=\"select\">--select--</option>\n");
      out.write("                                <option>1</option> \n");
      out.write("                                <option>2</option> \n");
      out.write("                                <option>3</option> \n");
      out.write("                                <option>4</option> \n");
      out.write("                                 <option>5</option> \n");
      out.write("                                 <option>6</option> \n");
      out.write("                                <option>7</option> \n");
      out.write("                                <option>8</option>\n");
      out.write("                                <option>9</option>\n");
      out.write("                                <option>10</option></td></tr>\n");
      out.write("           <tr><td>Price*</td><td><input type=\"text\" name=\"price\"/></td></tr>\n");
      out.write("           <tr><td>Brand*</td><td><select name=\"brand\"><option selected=\"select\">--select--</option>\n");
      out.write("                                <option>Apple</option> \n");
      out.write("                                <option>Samsung</option> \n");
      out.write("                                <option>HTC</option> \n");
      out.write("                                <option>LG</option> \n");
      out.write("                                 <option>Huawei</option></td></tr>\n");
      out.write("           <tr><td>Product Description*</td><td><input type=\"text\" name=\"description\"/></td></tr>\n");
      out.write("           <tr><td></td><td><input type=\"submit\" value=\"submit\"/></td></tr>\n");
      out.write("           <tr><td>* is the Required fields </td><td></td></tr>\n");
      out.write("       </table>\n");
      out.write("   </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
