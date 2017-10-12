package Servlets;

import Interfaces.CustomerInterface;

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

@WebServlet(urlPatterns = "custLoginMap")
public class CustomerLogin extends HttpServlet {
    @EJB
    CustomerInterface customerInterface;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("customerLogin.jsp");
        rd.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String custemail = req.getParameter("email");
        String password = req.getParameter("pass");

        if (customerInterface.authenticateCustomer(custemail, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("custsession", custemail);
            //String ss =   (String)session.setAttribute("custsession", custemail);
            System.out.println("saving session"+ custemail);

            resp.sendRedirect("customerPage.jsp");
        } else {
            out.println("Incorrect password");
            out.println("<html><body><p><a href=\"customerLogin.jsp\">  Try Again </a></p></body></html>");
        }
    }

}
