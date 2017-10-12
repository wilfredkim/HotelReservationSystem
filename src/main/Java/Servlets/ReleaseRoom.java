package Servlets;

import Interfaces.RoomInterface;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "releaseMap")
public class ReleaseRoom extends HttpServlet {
    @EJB
    RoomInterface roomInterface;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd  = req.getRequestDispatcher("viewBookedRoomAdmin.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String roomnumber = req.getParameter("number");
       roomInterface.releaseRoom(roomnumber);
       roomInterface.deleteBook(roomnumber);
       resp.sendRedirect("vBRoomMap");


    }
}
