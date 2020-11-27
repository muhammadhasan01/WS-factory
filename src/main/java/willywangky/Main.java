package willywangky;

import willywangky.service.*;

import javax.xml.ws.Endpoint;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws SQLException {
        Endpoint.publish("http://localhost:8081/api/hello", new Hello());
        Endpoint.publish("http://localhost:8081/api/login", new LoginService());
        Endpoint.publish("http://localhost:8081/api/stock", new StockService());
        Endpoint.publish("http://localhost:8081/api/chocolate", new ChocolateService());
        Endpoint.publish("http://localhost:8081/api/resep-bahan", new ResepBahanService());
        Endpoint.publish("http://localhost:8081/api/saldo", new SaldoService());

    }
}
