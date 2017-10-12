package Servlets;

import Interfaces.DbconnectInterface;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(urlPatterns = "custLogoutMap")
public class CustomerLogout extends HttpServlet {
    @EJB
    DbconnectInterface dbconnectInterface;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session ==null){
            resp.sendRedirect("custLoginMap");

        } else {dbconnectInterface.dbClose();
            session.invalidate();
            resp.sendRedirect("custLoginMap");
        }
    }
}
