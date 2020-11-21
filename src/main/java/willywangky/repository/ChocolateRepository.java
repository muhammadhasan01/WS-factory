package willywangky.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ChocolateRepository {
    public static final Connection conn = (new DBService()).getConnection();

    public Boolean isChocolateExist(String chocolateName){
        try {
            Statement smt = this.conn.createStatement();
            String sql = "SELECT * FROM coklat WHERE name='" + chocolateName + "'";
            ResultSet res = smt.executeQuery(sql);
            return res.next();
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public long addStock(String name){
        return 0L;
    }
}
