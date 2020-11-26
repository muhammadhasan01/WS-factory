package willywangky.repository;

import willywangky.model.Chocolate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ChocolateRepository {
    public static final Connection conn = DBService.getDbService().getConnection();

    public List<Chocolate> getAllChocolate() throws SQLException {
        List<Chocolate> chocolates = new ArrayList<>();
        String sql = "SELECT * FROM coklat";
        ResultSet rs = this.conn.createStatement().executeQuery(sql);
        while (rs.next()){
            Chocolate c = new Chocolate();
            c.setId(rs.getLong("id"));
            c.setName(rs.getString("nama"));
            c.setAmount(rs.getLong("jumlah"));
            chocolates.add(c);
        }
        return chocolates;
    }

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

}
