package willywangky.repository;

import willywangky.dto.BahanWithDate;
import willywangky.model.Bahan;
import willywangky.model.Resep;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResepBahanRepository {
    private static final Connection conn = DBService.getDbService().getConnection();

    public List<Bahan> getAllBahan() throws SQLException {
        List<Bahan> bahan = new ArrayList<>();
        ResultSet rs = this.conn.createStatement()
                .executeQuery("SELECT nama, sum(jumlah) as jumlah FROM bahan WHERE kedaluarsa > CURDATE() GROUP BY nama");
        while(rs.next()){
            Bahan b = new Bahan();
            b.setName(rs.getString("nama"));
            b.setAmount(rs.getLong("jumlah"));
            bahan.add(b);
        }
        return bahan;
    }

    public List<Bahan> getAllBahanIndividually() throws SQLException {
        List<Bahan> bahan = new ArrayList<>();
        ResultSet rs = this.conn.createStatement()
                .executeQuery("SELECT nama, jumlah FROM bahan WHERE kedaluarsa > CURDATE()");
        while(rs.next()){
            Bahan b = new Bahan();
            b.setName(rs.getString("nama"));
            b.setAmount(rs.getLong("jumlah"));
            bahan.add(b);
        }
        return bahan;
    }

    public List<Resep> getAllResep() throws SQLException {
        List<Resep> resep = new ArrayList<>();
        ResultSet rs = this.conn.prepareStatement("select nama,nama_bahan, resep.jumlah from coklat inner join resep on coklat.id=resep.id_coklat order by nama asc",
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery();

        while(rs.next()){
            Resep r = new Resep();
            List<Bahan> bahan = new ArrayList<>();
            r.setChocolateName(rs.getNString("nama"));

            Bahan b = new Bahan();
            b.setName(rs.getString("nama_bahan"));
            b.setAmount(rs.getLong("jumlah"));
            bahan.add(b);
            while (rs.next() && rs.getString("nama").equals(r.getChocolateName())) {
                b = new Bahan();
                b.setName(rs.getString("nama_bahan"));
                b.setAmount(rs.getLong("jumlah"));
                bahan.add(b);
            }
            rs.previous();
            r.setBahan(bahan);
            resep.add(r);
        }
        return resep;
    }

    public List<Resep> getResepFromName(String chocolateName) throws SQLException {
        List<Resep> resep = new ArrayList<>();
        ResultSet rs = this.conn.prepareStatement("select nama,nama_bahan, resep.jumlah from coklat inner join resep on coklat.id=resep.id_coklat where nama=" + chocolateName + " order by nama asc",
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery();

        while(rs.next()){
            Resep r = new Resep();
            List<Bahan> bahan = new ArrayList<>();
            r.setChocolateName(rs.getNString("nama"));

            Bahan b = new Bahan();
            b.setName(rs.getString("nama_bahan"));
            b.setAmount(rs.getLong("jumlah"));
            bahan.add(b);
            while (rs.next() && rs.getString("nama").equals(r.getChocolateName())) {
                b = new Bahan();
                b.setName(rs.getString("nama_bahan"));
                b.setAmount(rs.getLong("jumlah"));
                bahan.add(b);
            }
            rs.previous();
            r.setBahan(bahan);
            resep.add(r);
        }
        return resep;
    }

    public void saveBahan(BahanWithDate bahan) throws SQLException {
        this.conn.createStatement()
                .executeUpdate("INSERT INTO bahan(nama, jumlah, kedaluarsa) values('" +
                        bahan.getName() + "'," + bahan.getAmount() +",'"  + bahan.getDate() + "')");
    }
}
