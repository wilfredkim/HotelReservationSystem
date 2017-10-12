package Pojo;

import javax.enterprise.context.ApplicationScoped;


public class Room {
    private String room_number;
    private String roomCategory;
    private String room_description;
    private float room_rent;

    private String room_status;
    private String cust_name;

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public String getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(String roomCategory) {
        this.roomCategory = roomCategory;
    }

    public String getRoom_description() {
        return room_description;
    }

    public void setRoom_description(String room_description) {
        this.room_description = room_description;
    }

    public float getRoom_rent() {
        return room_rent;
    }

    public void setRoom_rent(float room_rent) {
        this.room_rent = room_rent;
    }

    public String getRoom_status() {
        return room_status;
    }

    public void setRoom_status(String room_status) {
        this.room_status = room_status;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }
}
