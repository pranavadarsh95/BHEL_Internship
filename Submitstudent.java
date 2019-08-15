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


@WebServlet(name = "Submitstudent", urlPatterns = {"/Submitstudent"})
public class Submitstudent extends HttpServlet {

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
        
       
       
       
        String stu_id=request.getParameter("t1");
        String password=request.getParameter("t2");
        String name=request.getParameter("t3");
        String stu_class=request.getParameter("t4");
        String father_name=request.getParameter("t5");
        String father_qul=request.getParameter("t6");
        String father_job=request.getParameter("t7");
        String father_income=request.getParameter("t8");
        String address=request.getParameter("t9");
        String fee=request.getParameter("t10");
        String fine=request.getParameter("t11");   
 
    Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","381994");
    
    
     Statement stmt = con.createStatement();  
   
 
   
     try{    
           
   
    PreparedStatement pst = con.prepareStatement("insert into student  values(?,?,?,?,?,?,?,?,?,?,?)");
 
     
  
     pst.setString(1, stu_id);
     pst.setString(2, password);
     pst.setString(3, name); 
     pst.setString(4, stu_class);
     pst.setString(5, father_name);
     pst.setString(6, father_qul);
     pst.setString(7, father_job);
     pst.setString(8, father_income);
     pst.setString(9, address);
     pst.setString(10, fee);
     pst.setString(11, fine);
     


   int status =pst.executeUpdate();


   
     
    if(status > 0)
	{
            
   out.println("<script type=\"text/javascript\">");
   out.println("alert('Student Signup Successful');");
   out.println("location='submit.html';");
   out.println("</script>");
	}
	else{
          
      out.println("<script type=\"text/javascript\">");
   out.println("alert('Error Signup Again');");
   out.println("location='student_signup.html';");
   out.println("</script>");
	    }
      out.println("aaya 5");
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
            Logger.getLogger(Submitstudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Submitstudent.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Submitstudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Submitstudent.class.getName()).log(Level.SEVERE, null, ex);
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
