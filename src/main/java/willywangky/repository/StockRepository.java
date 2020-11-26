package willywangky.repository;

import willywangky.model.Chocolate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StockRepository {
    public static final Connection conn = DBService.getDbService().getConnection();

    public long addStock(String name, Long amount){
        try {
            Statement smt = this.conn.createStatement();
//            String sql = "insert into request_add_stock(id_coklat, jumlah) values((select id from coklat where nama='" +
//                    name + "')," + String.valueOf(amount) + ")";
//            ResultSet res = smt.executeQuery(sql);
            ResultSet rs = smt.executeQuery("SELECT count(*) from request_add_stock");
            rs.next();
            return rs.getLong(1);
        } catch (Exception e){
            e.printStackTrace();
            return -1L;
        }
    }

    public String approveStock(Long idStock) throws SQLException {
        ResultSet rs = this.conn.createStatement()
                .executeQuery("SELECT * from request_add_stock where id=" + idStock);
        rs.next();
        Long reqAmount = rs.getLong("jumlah");
        Long idChocolate = rs.getLong("id_coklat");
        ResultSet rs2 = this.conn.createStatement()
                .executeQuery("SELECT jumlah from coklat where id=" + idChocolate);
        rs2.next();
        Long chocolateAmount = rs2.getLong("jumlah");
        System.out.println(reqAmount);
        System.out.println(idChocolate);
        System.out.println(chocolateAmount);
        if (chocolateAmount < reqAmount){
            return "Coklat tidak tersedia";
        } else {
            Long newChocolateAmount = chocolateAmount - reqAmount;
            // ubah status
            this.conn.createStatement()
                    .executeUpdate("UPDATE request_add_stock " +
                            "SET status='APPROVED'" +
                            "WHERE id=" + idStock);
            // update chocolate amount
            this.conn.createStatement()
                    .executeUpdate("UPDATE coklat" +
                            " SET jumlah=" + newChocolateAmount +
                            " WHERE id=" + idChocolate);
            return "Penambahan coklat sukses";
        }
    }
}
