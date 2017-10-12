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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "viewBookMap")
public class ViewBookedRoom extends HttpServlet {
@EJB
    RoomInterface roomInterface;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
         //String sessName = String.valueOf(session.getAttribute("custsession"));
        String sessName="wilfredkim5@gmail.com";
        ArrayList<Room> list  = roomInterface.viewBookCustomer(sessName);
        req.setAttribute("viewBroomlist",list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("viewBookRoom.jsp");
        dispatcher.forward(req,resp);
    }
}
