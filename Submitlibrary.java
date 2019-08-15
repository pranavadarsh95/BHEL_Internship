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


@WebServlet(name = "Submitlibrary", urlPatterns = {"/Submitlibrary"})
public class Submitlibrary extends HttpServlet {

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
        
        String book_id=request.getParameter("t1");
        String book_name=request.getParameter("t2");
        String book_author=request.getParameter("t3");
        String book_avail=request.getParameter("t4");
        String book_price=request.getParameter("t5");
        
    Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","381994");
    
    
     Statement stmt = con.createStatement();  
   
 
   
     try{    
           
   
    PreparedStatement pst = con.prepareStatement("insert into book  values(?,?,?,?,?)");
 
     
  
     pst.setString(1, book_id);
     pst.setString(2, book_name);
     pst.setString(3, book_author); 
     pst.setString(4, book_avail);
     pst.setString(5, book_price);
     


   int status =pst.executeUpdate();

   
     
    if(status > 0)
	{
   out.println("<script type=\"text/javascript\">");
   out.println("alert('Library Signup Successful');");
   out.println("location='submit.html';");
   out.println("</script>");
	}
	else{
      out.println("<script type=\"text/javascript\">");
   out.println("alert('Error Signup Again');");
   out.println("location='library_signup.html';");
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
            Logger.getLogger(Submitlibrary.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Submitlibrary.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Submitlibrary.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Submitlibrary.class.getName()).log(Level.SEVERE, null, ex);
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
