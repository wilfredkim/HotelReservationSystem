package Interfaces;

import javax.ejb.Local;

@Local
public interface AdminInterface {

    boolean authenticateAdmin(String email, String password);
}
