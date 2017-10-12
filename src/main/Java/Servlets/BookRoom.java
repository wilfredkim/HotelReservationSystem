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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "bookRoomMap")
public class BookRoom extends HttpServlet {
    @EJB
    RoomInterface roomInterface;




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd = req.getRequestDispatcher("viewRoomCustomer.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Room room = new Room();
        resp.setContentType("text/html");
        PrintWriter pr = resp.getWriter();
        System.out.println("getting session");
        HttpSession session = req.getSession(false);
        String sessName = (String) session.getAttribute("custsession");
        System.out.println("getting session"+sessName);









        //String sessName="wilfredkim5@gmail.com";
        String[] rooms = req.getParameterValues("chB");
        for (int i = 0; i < rooms.length; i++) {


    //select room number,category,cost and description from room db where roomnumber is equal to one checked
            room = roomInterface.selectByNumber(rooms[i]);
            String number = room.getRoom_number();
            String category = room.getRoomCategory();
            float rent = room.getRoom_rent();
            String descr = room.getRoom_description();

            //inserting into book database
            room.setCust_name(sessName);
            room.setRoom_number(number);
            room.setRoomCategory(category);
            room.setRoom_rent(rent);
            room.setRoom_description(descr);
            if (roomInterface.addBookRoom(room)) {
                resp.sendRedirect("viewBookMap");

            } else {
                pr.println("could not book");
                pr.println("<html><body><p><a href=\"viewRoomCustomer.jsp\">  Try Again </a></p></body></html>");
            }
        }


    }
}
