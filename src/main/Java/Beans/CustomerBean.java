package Beans;

import Interfaces.CustomerInterface;
import Interfaces.DbconnectInterface;
import Pojo.Customer;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.sql.*;
import java.util.ArrayList;
@Stateless
@Local
public class CustomerBean implements CustomerInterface {
    @EJB
    DbconnectInterface dbconnectInterface;


    public boolean register(Customer customer) {
        String sql = "INSERT into customer(Name,Email,PassWord,IDNumber,PhoneNumber) values(?,?,?,?,?)";

        if (dbconnectInterface != null) {

            try {
                PreparedStatement pst = dbconnectInterface.createprepareStatement(sql);
                pst.setString(1,customer.getPerson_name());
                pst.setString(2, customer.getPerson_email());
                pst.setString(3, customer.getPerson_password());
                pst.setString(4, customer.getPerson_idNumber());
                pst.setString(5, customer.getPerson_phoneNumber());
                 return  dbconnectInterface.dbWrite(pst);



            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }

        }
        return false;
    }

    public ArrayList<Customer> viewCustomer() {
        ArrayList<Customer> customerList= new ArrayList<Customer>();

        String sql = "SELECT * from customer";
        try {
            ResultSet rs = dbconnectInterface.dbRead(sql);
            while (rs != null&&rs.next()  ) {
             Customer customer = new Customer();
                customer.setPerson_idNumber(rs.getString("IDNumber"));
                customer.setPerson_name(rs.getString("Name"));
                customer.setPerson_email(rs.getString("Email"));
                customer.setPerson_phoneNumber(rs.getString("PhoneNumber"));

                customerList.add(customer);


            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customerList;
    }

    public boolean updateCustomer() {
        String sql = "UPDATE customer set Name=?,Email=?,PassWord=?,PhoneNumber=?,IDNumber=? where IDNumber=?";

        if (dbconnectInterface != null ) {
            try {
                PreparedStatement pst = dbconnectInterface.createprepareStatement(sql);
                Customer customer = new Customer();
                pst.setString(1,customer.getPerson_name());
                pst.setString(2, customer.getPerson_email());
                pst.setString(3, customer.getPerson_password());
                pst.setString(4, customer.getPerson_phoneNumber());
                pst.setString(5, customer.getPerson_idNumber());
               return dbconnectInterface.dbWrite(pst);


            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public boolean deleteCustomer() {
        String sql = "DELETE from customer where IDNumber=?";

        if (dbconnectInterface != null ) {
            try {
                PreparedStatement pst = dbconnectInterface.createprepareStatement(sql);
                Customer customer = new Customer();
                pst.setString(1, customer.getPerson_idNumber());

                dbconnectInterface.dbWrite(pst);

                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }


        }
        return false;
    }

    public boolean authenticateCustomer(String email, String password) {
        String sql = "SELECT * from customer  where Email='" + email + " ' and PassWord='" + password + "'";


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
