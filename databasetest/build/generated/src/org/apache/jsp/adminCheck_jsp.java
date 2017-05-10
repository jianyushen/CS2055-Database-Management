package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminCheck_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n");
      out.write("<title>Log in</title>\n");
      out.write("<style type=\"text/css\">\n");
      out.write(".right {\ttext-align: right;\n");
      out.write("}\n");
      out.write("\n");
      out.write("    body\n");
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
      out.write("    <body>\n");
      out.write("        <form action=\"ManagerOrder\" method=\"post\">\n");
      out.write("            <table border = \"0\" align = \"center\">\n");
      out.write("                <tbody>\n");
      out.write("                   \n");
      out.write("                        <tr>\n");
      out.write("                            <td align = \"left\"><h2><font size=\"4\">Order Browsing</font></h2></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                           <!-- <td>Please enter order ID:</td>-->\n");
      out.write("                            <td>\n");
      out.write("                            <!--    <input type = \"text\" name = \"order_brows\" placeholder =\"orderID\" />-->\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <input type = \"submit\" name=\"order_submit\" value = \"search\"/>\n");
      out.write("                            <!--    <input type = \"reset\" value = \"clear\"/> -->\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        \n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </form>  \n");
      out.write("        <form action=\"ProductShows\" method=\"post\">\n");
      out.write("            <table border = \"0\" align = \"center\">\n");
      out.write("                <tbody>\n");
      out.write("                        <tr>\n");
      out.write("                            <td align = \"left\"><h2><font size=\"4\">Product Browsing</font></h2></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Please enter product ID:</td>\n");
      out.write("                            <td>\n");
      out.write("                                <input type = \"text\" name = \"product_brows\" placeholder =\"productID\" />\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <input type = \"submit\" name=\"product_submit\" value = \"search\"/>\n");
      out.write("                                <input type = \"reset\" value = \"clear\"/>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </form>        \n");
      out.write("       \n");
      out.write("        \n");
      out.write("        <form action=\"ProductProfits\">\n");
      out.write("            <table border = \"0\" align = \"center\">\n");
      out.write("                <tbody>\n");
      out.write("                  \n");
      out.write("                        <tr>\n");
      out.write("                            <td align = \"left\"><h2>Data Aggregation</h2></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Total sales and profit of products:\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <input type = \"submit\" name=\"productaggre_submit\" value = \"check\"/>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </form>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Top\n");
      out.write("                            \n");
      out.write("                                <select name=\"topThings\" size=\"1\">\n");
      out.write("                                    <option value=\"1\">brand</option>\n");
      out.write("                                </select>\n");
      out.write("                                \n");
      out.write("                                according to sales:\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <form action=\"TopBrand\" method=\"post\"><input type = \"submit\" name=\"topaggre_submit\" value = \"check\"/></form>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr></tr><tr></tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                           <!--     <input type=\"submit\" name=\"region_submit\" value=\"Show total products sold in each region\"/>-->\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <input type=\"submit\" name=\"date_submit\" value=\"Number of products by date\"/>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr></tr><tr></tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                             <!--   <input type=\"submit\" name=\"salesmanprofit_submit\" value=\"Show total sales in each region\"/>-->\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                             <!--   <input type=\"submit\" name=\"salesman_submit\" value=\"Business vs products\"/> -->\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr></tr><tr></tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                              <!--  <input type=\"submit\" name=\"salesmanprofit_submit1\" value=\"Show profit made by each salesman\"/> -->\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </form>      \n");
      out.write("    </body>\n");
      out.write("    </html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
