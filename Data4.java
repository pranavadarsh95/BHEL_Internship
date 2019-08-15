package SignupLogin;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "Data4", urlPatterns = {"/Data4"})
public class Data4 extends HttpServlet {
       public void doGet(HttpServletRequest request, HttpServletResponse response)
                     throws ServletException, IOException {
              response.setContentType("text/html;charset=UTF-8");
              PrintWriter out = response.getWriter();        
              String id=request.getParameter("t6");
              String password=request.getParameter("t7");
              
          
                      
              try{
                     Class.forName("com.mysql.jdbc.Driver");
                     Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","381994");           
                     PreparedStatement ps=con.prepareStatement("select * from staff where id=? and password=?");
                     ps.setString(1,id);                   
                     ps.setString(2,password);
                     out.print("<center><table width=25% border=1>");
                     out.print("<center><h1>STAFF INFORMATION:</h1></center>");
                     ResultSet rs=ps.executeQuery();                
                     
                     ResultSetMetaData rsmd=rs.getMetaData();
                     
                     while(rs.next())
                        {
                     out.print("<tr>");
                     out.print("<td>"+rsmd.getColumnName(1)+"</td>");
                        out.print("<td>"+rs.getString(1)+"</td></tr>");
                        out.print("<tr><td>"+rsmd.getColumnName(2)+"</td>");
                        out.print("<td>"+rs.getString(2)+"</td></tr>");
                        out.print("<tr bgcolor=cyan><td>"+rsmd.getColumnName(3)+"</td>");
                        out.print("<td>"+rs.getString(3)+"</td></tr>");
                        out.print("<tr><td>"+rsmd.getColumnName(4)+"</td>");
                        out.print("<td>"+rs.getString(4)+"</td></tr>");
                        out.print("<tr><td>"+rsmd.getColumnName(5)+"</td>");
                        out.print("<td>"+rs.getString(5)+"</td></tr>");
                        out.print("<tr><td>"+rsmd.getColumnName(6)+"</td>");
                        out.print("<td>"+rs.getString(6)+"</td></tr>");
                        out.print("<tr><td>"+rsmd.getColumnName(7)+"</td>");
                        out.print("<td>"+rs.getString(7)+"</td></tr>");
                        }
                     out.print("</table><center>");
                     out.print("<br><br><br><br><br><br><br><br>");
                     out.print("<font color=\"yellow\"><marquee direction=\"left\" style=\"background:black\">IF YOU DON'T FIND ANY  DATA PLEASE CHECK YOUR INPUT OTHERWISE CONTACT MANAGEMENT OF YOUR COLLEGE</marquee></font>");
              }catch (Exception e2)
                {
                    e2.printStackTrace();
                }
 
              finally{out.close();
                }
       }
 
} 