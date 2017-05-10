package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class homepage_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\r\n");
      out.write("<title>Homepage</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".right {\ttext-align: right;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("    body{   background:url('BG.png') no-repeat center center fixed;\r\n");
      out.write("            background-size: cover;\r\n");
      out.write("            -webkit-background-size: cover;\r\n");
      out.write("            -moz-background-size: cover;\r\n");
      out.write("            -o-background-size: cover;\r\n");
      out.write("             margin: 0;\r\n");
      out.write("             padding: 0;\r\n");
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
      out.write("        <a href=\"orders.jsp\"><font color=\"black\">Orders |</a> <a href=\"cart.jsp\"><font color=\"black\">Cart |</font></a><a href=\"logout.jsp\"><font color=\"black\">Log out </a> \r\n");
      out.write("       \r\n");
      out.write("        \r\n");
      out.write("    </tr></table>\r\n");
      out.write("    <table align=\"center\">\r\n");
      out.write("        <td><form action=\"LikeSearch\">          \r\n");
      out.write("        <input name=\"search\" type=\"text\" id=\"search\" size=\"60\"  placeholder=\"* Please search by brand/name or descript the product *\"  />\r\n");
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
      out.write("   <table>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td><table width=\"251\" height=\"200\" border=\"0\" align=\"right\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td height=\"184\"><table width=\"242\" height=\"20\" border=\"0\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td class=\"normal\"><font size=\"3\"><Strong>Electronics Brand Quick Search</font></Strong></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          </table>\r\n");
      out.write("          <table>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td>\r\n");
      out.write("                <a href=\"BrandSearch?search=Apple\"><font color='black'>Apple</font></a></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td>\r\n");
      out.write("                <a href=\"BrandSearch?search=Samsung\"><font color = 'black' size=\"4\">Samsung</a>\r\n");
      out.write("            </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td>\r\n");
      out.write("                <a href=\"BrandSearch?search=HTC\"><font color='black'>HTC</font></a>\r\n");
      out.write("           </td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td>\r\n");
      out.write("              <a href=\"BrandSearch?search=LG\"><font color='black'>LG</font></a>\r\n");
      out.write("            </td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td>\r\n");
      out.write("              <a href=\"BrandSearch?search=Huawei\"><font color='black'>Huawei</font></a>\r\n");
      out.write("          </td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("            \r\n");
      out.write("  <table>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td><table width=\"251\" height=\"200\" border=\"0\" align=\"right\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td height=\"184\"><table width=\"242\" height=\"20\" border=\"0\">\r\n");
      out.write("          <tr class=\"normal\"><font size = \"3\"><strong>Best Selling Electronics</font></strong></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("\t</table>        \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
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
