package Beans;

import Interfaces.AdminInterface;
import Interfaces.DbconnectInterface;

import  java.sql.*;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local
public class AdminBean implements AdminInterface {
    @EJB
    DbconnectInterface dbconnectInterface;

    public boolean authenticateAdmin(String email, String password) {

        String sql = "SELECT * from admin  where Email='" + email + " ' and PassWord='" + password + "'";


        try {
            ResultSet rs = dbconnectInterface.dbRead(sql);
            while (rs != null && rs.next()) {

                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }
}
