package SignupLogin;

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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Submitteacher", urlPatterns = {"/Submitteacher"})
public class Submitteacher extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       Class.forName("com.mysql.jdbc.Driver");
        
        String tea_id=request.getParameter("t1");
        String password=request.getParameter("t2");
        String name=request.getParameter("t3");
        String gender=request.getParameter("t4");
        String address=request.getParameter("t5");
        String class_teacher=request.getParameter("t6");
        String salary=request.getParameter("t7");   
 
    Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","381994");
    
    
     Statement stmt = con.createStatement();  
   
 
   
     try{    
           
   
    PreparedStatement pst = con.prepareStatement("insert into teacher  values(?,?,?,?,?,?,?)");
 
     
  
     pst.setString(1, tea_id);
     pst.setString(2, password);
     pst.setString(3, name); 
     pst.setString(4, gender);
     pst.setString(5, address);
     pst.setString(6, class_teacher);
     pst.setString(7, salary);
     


   int status =pst.executeUpdate();

   
     
    if(status > 0)
	{
   out.println("<script type=\"text/javascript\">");
   out.println("alert('Teacher Signup Successful');");
   out.println("location='submit.html';");
   out.println("</script>");
	}
	else{
      out.println("<script type=\"text/javascript\">");
   out.println("alert('Error Signup Again');");
   out.println("location='teacher_signup.html';");
   out.println("</script>");
	    }
     }
     
     
       finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
            Logger.getLogger(Submitteacher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Submitteacher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
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
            Logger.getLogger(Submitteacher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Submitteacher.class.getName()).log(Level.SEVERE, null, ex);
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
