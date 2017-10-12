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

@WebServlet(urlPatterns = "viewUnbookMap")
public class ViewRoomCustomer extends HttpServlet {
    @EJB
    RoomInterface roomInterface;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Room> list  = roomInterface.viewbUnbookedRoom();
        req.setAttribute("viewUnbooklist",list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("viewRoomCustomer.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
