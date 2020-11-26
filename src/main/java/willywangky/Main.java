package willywangky;

import willywangky.repository.ChocolateRepository;
import willywangky.repository.SaldoRepository;
import willywangky.service.ChocolateService;
import willywangky.service.Hello;
import willywangky.service.LoginService;
import willywangky.service.StockService;

import javax.xml.ws.Endpoint;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws SQLException {
        Endpoint.publish("http://localhost:8081/api/hello", new Hello());
        Endpoint.publish("http://localhost:8081/api/login", new LoginService());
        Endpoint.publish("http://localhost:8081/api/stock", new StockService());
        Endpoint.publish("http://localhost:8081/api/chocolate", new ChocolateService());

        SaldoRepository s = new SaldoRepository();
        s.getSaldo();
        if (s.addSaldo(10000L) > 0){
            System.out.println("add saldo success");
        }
        // test
//        if (new UserRepository().isUserExist("ww", "ww")){
//            System.out.println("Username exist");
//        } else {
//            System.out.println("Username not exist");
//        }
    }
}
