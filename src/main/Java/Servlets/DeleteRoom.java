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
@WebServlet(urlPatterns = "DeleteRoomMap")
public class DeleteRoom extends HttpServlet {
    @EJB
    RoomInterface roomInterface;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd  = req.getRequestDispatcher("viewRoomAdmin.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roomnumber  = req.getParameter("number");
        roomInterface.deleteRoom(roomnumber);
        resp.sendRedirect("viewroomMap");
    }
}
