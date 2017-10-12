package Beans;

import Interfaces.DbconnectInterface;
import Interfaces.RoomInterface;
import Pojo.Room;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
@Stateless
@Local
public class RoomBean implements RoomInterface {
@EJB
    DbconnectInterface dbconnectInterface;

    public boolean addRoom(Room room) {
        String sql = "INSERT into room(RoomNumber,RoomCategory,RoomDescription,RoomRent,RoomStatus) values(?,?,?,?,?)";

        if (dbconnectInterface != null ) {

            try {
                PreparedStatement pst = dbconnectInterface.createprepareStatement(sql);
                pst.setString(1, room.getRoom_number());
                pst.setString(2, room.getRoomCategory());
                pst.setString(3, room.getRoom_description());
                pst.setFloat(4, room.getRoom_rent());
                pst.setString(5,  room.getRoom_status());

                 return dbconnectInterface.dbWrite(pst);



            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }

        }
        return false;
    }

    public ArrayList<Room> viewAllRoom() {
        ArrayList<Room> allRoomList= new ArrayList<Room>();

        String sql = "SELECT * from room";
        try {
            ResultSet rs = dbconnectInterface.dbRead(sql);
            while (rs != null&&rs.next()  ) {
                Room room = new Room();
                room.setRoom_number(rs.getString("RoomNumber"));
                room.setRoomCategory(rs.getString("RoomCategory"));
                room.setRoom_description(rs.getString("RoomDescription"));
                room.setRoom_rent(rs.getFloat("RoomRent"));
                room.setRoom_status(rs.getString("RoomStatus"));

                allRoomList.add(room);


            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return allRoomList;
    }

    public ArrayList<Room> viewbUnbookedRoom()

    {
        ArrayList<Room> allRoomList= new ArrayList<Room>( );
        //RoomCategory roomCategory =null;
        String status ="UNBOOKED";
        String sql = "SELECT * from room where RoomStatus='"+status+"' ";
        try {
            ResultSet rs = dbconnectInterface.dbRead(sql);
            while (rs.next() && rs != null) {
                Room room = new Room();
                room.setRoom_number(rs.getString("RoomNumber"));
                room.setRoomCategory(rs.getString("RoomCategory"));
                room.setRoom_description(rs.getString("RoomDescription"));
                room.setRoom_rent(rs.getFloat("RoomRent"));
                room.setRoom_status(rs.getString("RoomStatus"));

                allRoomList.add(room);


            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return allRoomList;
    }

    public boolean updateRoom(Room room)

    {
        String sql = "UPDATE room set RoomNumber=?,RoomCategory=?,RoomDescription=?,RoomRent=?,RoomStatus=?, where RoomNumber=?";

        if (dbconnectInterface != null ) {
            try {
                PreparedStatement pst = dbconnectInterface.createprepareStatement(sql);
                pst.setString(1,room.getRoom_number());
                pst.setString(2, room.getRoomCategory());
                pst.setString(3, room.getRoom_description());
                pst.setFloat(4, room.getRoom_rent());
                pst.setString(5, room.getRoom_status());
                dbconnectInterface.dbWrite(pst);

                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public boolean deleteRoom(String roomnumber)
    {
        String sql = "DELETE from room where RoomNumber=?";

        if (dbconnectInterface != null) {
            try {
                PreparedStatement pst = dbconnectInterface.createprepareStatement(sql);
                pst.setString(1, roomnumber);

                dbconnectInterface.dbWrite(pst);

                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }


        }
        return false;
    }

    public boolean issueRoom(String roomnumber)
    {
       String status ="BOOKED" ;

        String sql = "UPDATE room set RoomStatus='"+status+"' where RoomNumber='"+roomnumber+"' ";
        PreparedStatement pst = dbconnectInterface.createprepareStatement(sql);
        if (dbconnectInterface != null && pst != null) {
            dbconnectInterface.dbWrite(pst);

            return true;
        }
        return false;
    }

    public boolean releaseRoom(String roomnumber)
    {
        String status ="UNBOOKED" ;

        String sql = "UPDATE room set RoomStatus='"+status+"' where RoomNumber='"+roomnumber+"' ";
        PreparedStatement pst = dbconnectInterface.createprepareStatement(sql);
        if (dbconnectInterface != null && pst != null) {
            dbconnectInterface.dbWrite(pst);

           return true;
        }
        return false;
    }
    public Room selectByNumber(String number) {


        String sql = "SELECT RoomNumber,RoomCategory,RoomDescription,RoomRent from room where RoomNumber='" + number + "'";
        ResultSet rs = dbconnectInterface.dbRead(sql);
        Room room = new Room();
        try {
            while (rs!=null&&rs.next() ) {

                room.setRoom_number(rs.getString("RoomNumber"));
                room.setRoomCategory(rs.getString("RoomCategory"));
                room.setRoom_description(rs.getString("RoomDescription"));
                room.setRoom_rent(rs.getFloat("RoomRent"));



            }
            //dbConnect.dbClose();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }

    public boolean addBookRoom(Room room) {
        String sql = "INSERT into book(CustName,RoomNumber,RoomCategory,RoomDescription,RoomRent) values(?,?,?,?,?)";
        PreparedStatement pst = dbconnectInterface.createprepareStatement(sql);
        if (dbconnectInterface != null ) {

            try {
                pst.setString(1, room.getCust_name());
                pst.setString(2, room.getRoom_number());
                pst.setString(3, room.getRoomCategory());
                pst.setString(4, room.getRoom_description());
                pst.setFloat(5, room.getRoom_rent());


                dbconnectInterface.dbWrite(pst);

                return true;

            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }

        }
        return false;
    }

    public ArrayList<Room> viewBookCustomer(String user) {
        ArrayList<Room> allRoomList= new ArrayList<Room>( );

        String sql = "SELECT * from book where CustName='"+user+"'  ";
        try {
            ResultSet rs = dbconnectInterface.dbRead(sql);
            while (rs.next() && rs != null) {

                Room room = new Room();
                room.setCust_name(rs.getString("CustName"));
                room.setRoom_number(rs.getString("RoomNumber"));
                room.setRoomCategory(rs.getString("RoomCategory"));
                room.setRoom_description(rs.getString("RoomDescription"));
                room.setRoom_rent(( rs.getFloat("RoomRent")));


                allRoomList.add(room);


            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return allRoomList;
    }

    public boolean deleteBook(String room_number) {
        String sql = "DELETE from book where RoomNumber=?";

        if (dbconnectInterface != null ) {
            try {
                PreparedStatement pst = dbconnectInterface.createprepareStatement(sql);
                pst.setString(1, room_number);

                dbconnectInterface.dbWrite(pst);

                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }


        }
        return false;
    }

    public ArrayList<Room> viewBookAdmin() {
        ArrayList<Room> allRoomList= new ArrayList<Room>( );

        String sql = "SELECT * from book  ";
        try {
            ResultSet rs = dbconnectInterface.dbRead(sql);
            while (rs!=null&&rs.next()) {
             Room room = new Room();
                room.setCust_name(rs.getString("CustName"));
                room.setRoom_number(rs.getString("RoomNumber"));
                room.setRoomCategory(rs.getString("RoomCategory"));
                room.setRoom_description(rs.getString("RoomDescription"));
                room.setRoom_rent(rs.getFloat("RoomRent"));


                allRoomList.add(room);


            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return allRoomList;
    }
}
