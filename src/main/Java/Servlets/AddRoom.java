package Servlets;

import Interfaces.RoomInterface;
import Pojo.Room;

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

@WebServlet(urlPatterns = "addroomMap")
public class AddRoom extends HttpServlet {
    @EJB
    RoomInterface roomInterface;



    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("addRoom.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Room room = new Room();
        resp.setContentType("text/html");
        PrintWriter pr = resp.getWriter();
        String room_number = req.getParameter("roomnumber");
        String roomCategory = req.getParameter("category");
        String room_descr = req.getParameter("descr");
        float room_rent = Float.parseFloat((req.getParameter("rent")));
        String room_status = req.getParameter("status");
        room.setRoom_number(room_number);
        room.setRoomCategory(roomCategory);
        room.setRoom_description(room_descr);
        room.setRoom_rent(room_rent);
        room.setRoom_status(room_status);

        if (roomInterface.addRoom(room)) {
            resp.sendRedirect("viewroomMap");

        } else {
            pr.println("could not add room");
            pr.println("<html><body><p><a href=\"addRoom.jsp\">  Try Again </a></p></body></html>");
        }
    }
}
