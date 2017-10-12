package Interfaces;

import javax.ejb.Local;
import java.sql.*;



@Local
public interface DbconnectInterface {
    boolean connect();
    boolean dbWrite(String sql);
    boolean dbWrite(PreparedStatement pst);
    PreparedStatement createprepareStatement(String sql);
    ResultSet dbRead(String sql);
    void dbClose();

}
