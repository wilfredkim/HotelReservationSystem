package Interfaces;

import Pojo.Room;

import javax.ejb.Local;
import java.util.ArrayList;

@Local
public interface RoomInterface {
    boolean addRoom(Room room);

    ArrayList<Room> viewAllRoom();

    ArrayList<Room> viewbUnbookedRoom();

    boolean updateRoom(Room room);

    boolean deleteRoom(String roomnumber);

    boolean issueRoom(String roomnumber);

    boolean releaseRoom(String roomnumber);

    Room selectByNumber(String number);

    boolean addBookRoom(Room room);

    ArrayList<Room> viewBookCustomer(String user);

    boolean deleteBook(String room_number);

    ArrayList<Room> viewBookAdmin();
}
