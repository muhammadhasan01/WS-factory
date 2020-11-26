package willywangky.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaldoRepository {
    public static final Connection conn = DBService.getDbService().getConnection();

    public Long getSaldo() throws SQLException {
        ResultSet rs = this.conn.createStatement()
                .executeQuery("SELECT * FROM saldo");
        rs.next();
        System.out.println(rs.getLong("amount"));
        return (rs.getLong("amount"));
    }

    public int addSaldo(Long amount) throws SQLException {
        return  this.conn.createStatement()
                .executeUpdate("UPDATE saldo SET amount = amount +" + amount);
    }
}
