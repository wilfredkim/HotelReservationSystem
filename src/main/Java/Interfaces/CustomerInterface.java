package Interfaces;

import Pojo.Customer;

import javax.ejb.Local;
import java.util.ArrayList;
@Local
public interface CustomerInterface {
    public  boolean register(Customer customer);
    public ArrayList<Customer> viewCustomer();
    public  boolean updateCustomer();
    public  boolean deleteCustomer();
    public  boolean authenticateCustomer(String email,String password);
}

