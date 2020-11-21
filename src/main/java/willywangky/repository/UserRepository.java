package willywangky.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepository {
    private static final Connection conn = (new DBService()).getConnection();

    public UserRepository(){

    }

    public Boolean isUserExist(String username, String password) {
        try {
            Statement smt = this.conn.createStatement();
            String sql = "SELECT * FROM user WHERE username='" + username + "' and password='" + password + "'";
            ResultSet res = smt.executeQuery(sql);
            return res.next();
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
