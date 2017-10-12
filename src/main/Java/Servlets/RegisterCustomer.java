package Servlets;

import Interfaces.CustomerInterface;
import Pojo.Customer;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "registerCustMap")
public class RegisterCustomer extends HttpServlet {
    @EJB
    CustomerInterface customerInterface;
    //poor design

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher  rd  = req.getRequestDispatcher("registerCustomer.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = new Customer();
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String cust_name = req.getParameter("name");
        String mail = req.getParameter("email");
        String password = req.getParameter("pass");
        String conpassword = req.getParameter("conpass");
        String idnumber  = req.getParameter("idnum");
        String phoneNum = req.getParameter("phone");
        if (password.equals(conpassword)) {
            customer.setPerson_name(cust_name);
            customer.setPerson_email(mail);
            customer.setPerson_password(password);
            customer.setPerson_idNumber(idnumber);
            customer.setPerson_phoneNumber(phoneNum);

            if (customerInterface.register(customer)) {
                resp.sendRedirect("custLoginMap");
            } else {
                out.println("Could not register");
                out.println("<html><body><p><a href=\"registerCustomer.jsp\">  Try Again </a></p></body></html>");
            }

        } else {


            out.println("PassWord does not match");
            out.println("<html><body><p><a href=\"addCustomer.jsp\">  Try Again </a></p></body></html>");

        }
    }
}
