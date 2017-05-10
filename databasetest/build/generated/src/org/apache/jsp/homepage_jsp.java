package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class homepage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      edu.pitt.yuq6.UserInfoBean userInfo = null;
      synchronized (session) {
        userInfo = (edu.pitt.yuq6.UserInfoBean) _jspx_page_context.getAttribute("userInfo", PageContext.SESSION_SCOPE);
        if (userInfo == null){
          userInfo = new edu.pitt.yuq6.UserInfoBean();
          _jspx_page_context.setAttribute("userInfo", userInfo, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\r\n");
      out.write("<title>Log in</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".right {\ttext-align: right;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("    body{\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("        }\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("  <table width=\"993\" height=\"102\" border=\"0\">\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td width=\"251\" height=\"96\"><img src=\"head.png\" width=\"251\" height=\"88\" alt=\"Logo\" /></td>\r\n");
      out.write("      <td width=\"726\" class=\"right\"> Home</a> | <a href=\"contact.jsp\"><font color = \"black\">Contact Us</a> |\r\n");
      out.write("       \r\n");
      out.write("        <a href=\"login.jsp\"><font color=\"black\">Login</a> | <a href=\"register.jsp\"><font color=\"black\">Register</a></td>\r\n");
      out.write("        \r\n");
      out.write("        <a href=\"Orders\"><font color=\"black\">Orders |</a> <a href=\"cart.jsp\"><font color=\"black\">Cart |</font></a><a href=\"logout.jsp\"><font color=\"black\">Log out </a> \r\n");
      out.write("       \r\n");
      out.write("        \r\n");
      out.write("    </tr></table>\r\n");
      out.write("    <table align=\"center\">\r\n");
      out.write("        <td><form action=\"Search.jsp\">          \r\n");
      out.write("        <input name=\"search\" type=\"text\" id=\"search\" size=\"60\" />\r\n");
      out.write("          <label>\r\n");
      out.write("            <input type=\"submit\" name=\"submit\" id=\"button\" value=\"Search\" />\r\n");
      out.write("            <input type=\"hidden\" name=\"val\" value=\"0\">\r\n");
      out.write("          </label>\r\n");
      out.write("        </form></td>\r\n");
      out.write("      </table>\r\n");
      out.write("  <hr />\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  <!--Select top 10 popular product-->\r\n");
      out.write("  <td><table width=\"725\" height=\"684\" border=\"0\">\r\n");
      out.write("      <tr class=\"normal\">\r\n");
      out.write("        <td height=\"30\"><strong>Best Selling Electronics</strong></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("          <tr><a> <td>Product Name</td> <td>{pro}</td> </a></tr>\r\n");
      out.write("          \r\n");
      out.write("          \r\n");
      out.write("\t</table> \r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
