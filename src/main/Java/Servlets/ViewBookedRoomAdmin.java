package Servlets;

import Interfaces.RoomInterface;
import Pojo.Room;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
@WebServlet(urlPatterns = "vBRoomMap")
public class ViewBookedRoomAdmin extends HttpServlet {
    @EJB
    RoomInterface roomInterface;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Room> list = roomInterface.viewBookAdmin();
        req.setAttribute("viewroomlist",list);
        RequestDispatcher rd = req.getRequestDispatcher("viewBookedRoomAdmin.jsp");
        rd.forward(req,resp);

    }
}
