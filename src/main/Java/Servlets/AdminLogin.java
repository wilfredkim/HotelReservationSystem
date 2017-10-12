package Servlets;

import Interfaces.AdminInterface;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "loginadminMap")
public class AdminLogin  extends HttpServlet{
    @EJB
    AdminInterface adminInterface;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("adminLogin.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out  = resp.getWriter();
        String mail = req.getParameter("email");
        String password = req.getParameter("pass");
        if(adminInterface.authenticateAdmin(mail,password)){
            HttpSession session = req.getSession();
            session.setAttribute("ses", mail);
            resp.sendRedirect("adminPage.jsp");
        } else{
            out.println("Incorrect password");
            out.println("<html><body><p><a href=\"loginAdmin.jsp\">  Try Again </a></p></body></html>");
        }
    }
}
