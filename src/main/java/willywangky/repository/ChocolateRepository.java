package willywangky.repository;

import willywangky.model.Bahan;
import willywangky.model.Chocolate;
import willywangky.model.Resep;

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
            String sql = "SELECT * FROM coklat WHERE nama='" + chocolateName + "'";
            ResultSet res = smt.executeQuery(sql);
            return res.next();
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public String addChocolate(Resep resep) throws SQLException {
        String chocolateName = resep.getChocolateName();
        List<Bahan> bahans = resep.getBahan();
        ResultSet rs = this.conn.createStatement()
                .executeQuery("SELECT * FROM coklat where nama='" + chocolateName + "'");

        if (rs.next()){
            return "Coklat sudah ada";
        } else {
            this.conn.createStatement()
                    .executeUpdate("INSERT INTO coklat(nama, jumlah) values('" + chocolateName + "',0)");
            rs = this.conn.createStatement()
                    .executeQuery("SELECT count(*) FROM coklat");
            rs.next();
            Long id = rs.getLong(1);
            for (Bahan b : bahans) {
                this.conn.createStatement()
                        .executeUpdate("INSERT INTO resep(id_coklat, nama_bahan, jumlah) values(" +
                                id + ",'" + b.getName() + "'," + b.getAmount() + ")");
            }
            return "Add success";
        }
    }

    public String chocolateProduction(String chocolateName, Long amountToProduce) throws SQLException {
        ResepBahanRepository resepBahanRepository = new ResepBahanRepository();
        Resep resep = resepBahanRepository.getResepFromName(chocolateName).get(0);
        List<Bahan> listBahan = resepBahanRepository.getAllBahan();
        for (Bahan b: resep.getBahan()) {
            for (Bahan bSimpanan: listBahan) {
                if (b.getName().equals(bSimpanan.getName()) && b.getAmount() * amountToProduce > bSimpanan.getAmount()) {
                    return "bahan tidak cukup";
                }
            }
        }
        List<Bahan> listBahanIndividual = resepBahanRepository.getAllBahanIndividually();
        for (Bahan b: resep.getBahan()) {
            Long bahanToBeConsumed = b.getAmount() * amountToProduce;            
            for (Bahan bSimpanan: listBahanIndividual) {
                if (!b.getName().equals(bSimpanan.getName())) continue;
                Long bSimpananAmount = bSimpanan.getAmount();
                long before = bSimpananAmount;
                long mini = Math.min(bahanToBeConsumed, bSimpananAmount);
                bahanToBeConsumed -= mini;
                bSimpananAmount -= mini;
                this.conn.createStatement()
                        .executeUpdate("UPDATE bahan SET jumlah="
                        + bSimpananAmount
                        + " WHERE nama='"
                        + b.getName()
                        + "' AND jumlah="
                        + before
                        + " AND kedaluarsa > CURDATE() LIMIT 1");
                if (bahanToBeConsumed == 0L) {
                    break;
                }
            }
        }
        this.conn.createStatement()
                .executeUpdate("UPDATE coklat SET jumlah=jumlah+" + String.valueOf(amountToProduce) + " where nama='" + chocolateName + "'");
        return "success";
    }
}
