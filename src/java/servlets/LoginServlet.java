package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import classes.AccountService;
import classes.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mitchell
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          HttpSession session = request.getSession();
  
            String logout = request.getParameter("logout");
            if (logout != null) {
              session.invalidate();
              request.setAttribute("message", "You have successfully logged out.");
              getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
              return;
            }

           getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
          
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username != null && password != null && !username.isEmpty() && !password.isEmpty()) {
            AccountService accountService = new AccountService();
            User user = accountService.login(username, password);

            if(user != null) {
                HttpSession session = request.getSession();

                // store the username in a session variable
                session.setAttribute("username", username);

                // redirect to home page
                response.sendRedirect("home");
            } else {
                // authentication failed, display error message and forward to login page
                request.setAttribute("errorMessage", "Invalid username or password");
                request.setAttribute("username", username);
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
            }
    } else {
        // username or password is empty, display an error message and forward to login.jsp
        request.setAttribute("errorMessage", "Please enter username and password");
        request.setAttribute("username", username);
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
    }

       // response.sendRedirect(request.getContextPath() + "/home.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Week5Lab_MyLogin";
    }// </editor-fold>

}
