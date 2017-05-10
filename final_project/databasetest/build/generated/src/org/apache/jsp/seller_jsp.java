package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class seller_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n");
      out.write("<title>Log in</title>\n");
      out.write("<style type=\"text/css\">\n");
      out.write(".right {\ttext-align: right;\n");
      out.write("}\n");
      out.write("body\n");
      out.write("        {   background:url('BG.png') no-repeat center center fixed;\n");
      out.write("            background-size: cover;\n");
      out.write("            -webkit-background-size: cover;\n");
      out.write("            -moz-background-size: cover;\n");
      out.write("            -o-background-size: cover;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("  <table width=\"993\" height=\"102\" border=\"0\">\n");
      out.write("    <tr>\n");
      out.write("      <td width=\"251\" height=\"96\"><img src=\"head.png\" width=\"251\" height=\"88\" alt=\"Logo\" /></td>\n");
      out.write("      <td width=\"726\" class=\"right\"><a href=\"homepage.jsp\"><font color=\"black\">Home</a> |\n");
      out.write("       \n");
      out.write("        <a href=\"login.jsp\"><font color=\"black\">Login</a>\n");
      out.write("        \n");
      out.write("\t\t\t\n");
      out.write("        <a href=\"logout.jsp\"><font color=\"black\">Logout</a>\n");
      out.write("       </td>\n");
      out.write("    </tr>\n");
      out.write("    \n");
      out.write("  </table>\n");
      out.write("  <hr />     </td>\n");
      out.write(" \n");
      out.write("\t<center><strong>");
 out.println("Product List");
      out.write("</strong> </center> \n");
      out.write("  \n");
      out.write("<center><strong>Please select the brand to see product detail:</strong></center>\n");
      out.write("<center><a href=\"BrandSearch?search=Apple\"><font color='black'>Apple</font></a></center>\n");
      out.write("<center><a href=\"BrandSearch?search=Samsung\"><font color='black'>Samsung</font></a></center>\n");
      out.write("<center><a href=\"BrandSearch?search=HTC\"><font color='black'>HTC</font></a></center>\n");
      out.write("<center><a href=\"BrandSearch?search=LG\"><font color='black'>LG</font></a></center>\n");
      out.write("<center><a href=\"BrandSearch?search=Huawei\"><font color='black'>Huawei</font></a></center>\n");
      out.write("\n");
      out.write(" <hr />     </td>\n");
      out.write(" \n");
      out.write("<center><a href=\"ManagerOrder\"><font size=\"4\"><font color='black'>Inventory Check</font></font></a></center>\n");
      out.write("\n");
      out.write("</body>\n");
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
